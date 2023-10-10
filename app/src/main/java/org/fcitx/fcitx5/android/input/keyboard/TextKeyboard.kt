package org.fcitx.fcitx5.android.input.keyboard

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.annotation.Keep
import androidx.core.view.allViews
import org.fcitx.fcitx5.android.R
import org.fcitx.fcitx5.android.core.InputMethodEntry
import org.fcitx.fcitx5.android.data.prefs.AppPrefs
import org.fcitx.fcitx5.android.data.prefs.ManagedPreference
import org.fcitx.fcitx5.android.data.theme.Theme
import org.fcitx.fcitx5.android.input.popup.PopupAction
import splitties.views.imageResource

@SuppressLint("ViewConstructor")
class TextKeyboard(
    context: Context,
    theme: Theme
) : BaseKeyboard(context, theme, Layout) {

    enum class CapsState { None, Once, Lock }

    companion object {
        const val Name = "Text"

        val Layout: List<List<KeyDef>> = listOf(
            listOf(
                AlphabetKey("Q", "手", "1"),
                AlphabetKey("W", "田", "2"),
                AlphabetKey("E", "水", "3"),
                AlphabetKey("R", "口", "4"),
                AlphabetKey("T", "廿", "5"),
                AlphabetKey("Y", "卜", "6"),
                AlphabetKey("U", "山", "7"),
                AlphabetKey("I", "戈", "8"),
                AlphabetKey("O", "人", "9"),
                AlphabetKey("P", "心", "0")
            ),
            listOf(
                AlphabetKey("A", "日", "@"),
                AlphabetKey("S", "尸", "*"),
                AlphabetKey("D", "木", "+"),
                AlphabetKey("F", "火", "-"),
                AlphabetKey("G", "土", "="),
                AlphabetKey("H", "的", "/"),
                AlphabetKey("J", "十", "#"),
                AlphabetKey("K", "大", "("),
                AlphabetKey("L", "中", ")")
            ),
            listOf(
                CapsKey(),
                AlphabetKey("Z", "重", "'"),
                AlphabetKey("X", "止", ":"),
                AlphabetKey("C", "金", "\""),
                AlphabetKey("V", "女", "?"),
                AlphabetKey("B", "月", "!"),
                AlphabetKey("N", "弓", "~"),
                AlphabetKey("M", "一", "\\"),
                BackspaceKey()
            ),
            listOf(
                LayoutSwitchKey("?123", ""),
                CommaKey(0.1f, KeyDef.Appearance.Variant.Alternative),
                LanguageKey(),
                SpaceKey(),
                SymbolKey(".", 0.1f, KeyDef.Appearance.Variant.Alternative),
                ReturnKey()
            )
        )
    }

    val caps: ImageKeyView by lazy { findViewById(R.id.button_caps) }
    val backspace: ImageKeyView by lazy { findViewById(R.id.button_backspace) }
    val quickphrase: ImageKeyView by lazy { findViewById(R.id.button_quickphrase) }
    val lang: ImageKeyView by lazy { findViewById(R.id.button_lang) }
    val space: TextKeyView by lazy { findViewById(R.id.button_space) }
    val `return`: ImageKeyView by lazy { findViewById(R.id.button_return) }

    private val showLangSwitchKey = AppPrefs.getInstance().keyboard.showLangSwitchKey

    @Keep
    private val showLangSwitchKeyListener = ManagedPreference.OnChangeListener<Boolean> { _, v ->
        updateLangSwitchKey(v)
    }

    private val keepLettersUppercase by AppPrefs.getInstance().keyboard.keepLettersUppercase

    init {
        updateLangSwitchKey(showLangSwitchKey.getValue())
        showLangSwitchKey.registerOnChangeListener(showLangSwitchKeyListener)
    }

    private val textKeys: List<TextKeyView> by lazy {
        allViews.filterIsInstance(TextKeyView::class.java).toList()
    }

    private var capsState: CapsState = CapsState.None

    private fun transformAlphabet(c: String): String {
        return when (capsState) {
            CapsState.None -> c.lowercase()
            else -> c.uppercase()
        }
    }

    private var punctuationMapping: Map<String, String> = mapOf()
    private fun transformPunctuation(p: String) = punctuationMapping.getOrDefault(p, p)

    private fun transformInputString(c: String): String {
        if (c.length != 1) return c
        if (c[0].isLetter()) return transformAlphabet(c)
        return transformPunctuation(c)
    }

    override fun onAction(action: KeyAction, source: KeyActionListener.Source) {
        when (action) {
            is KeyAction.FcitxKeyAction -> if (source == KeyActionListener.Source.Keyboard) {
                transformKeyAction(action)
            }
            is KeyAction.CapsAction -> switchCapsState(action.lock)
            else -> {}
        }
        super.onAction(action, source)
    }

    private fun transformKeyAction(action: KeyAction.FcitxKeyAction) {
        if (action.act.length > 1) {
            return
        }
        action.act = transformAlphabet(action.act)
        if (capsState == CapsState.Once) switchCapsState()
    }

    override fun onAttach() {
        capsState = CapsState.None
        updateCapsButtonIcon()
        updateAlphabetKeys()
    }

    override fun onReturnDrawableUpdate(returnDrawable: Int) {
        `return`.img.imageResource = returnDrawable
    }

    override fun onPunctuationUpdate(mapping: Map<String, String>) {
        punctuationMapping = mapping
        updatePunctuationKeys()
    }
    private var curLanguageCode: String = "en"
    override fun onInputMethodUpdate(ime: InputMethodEntry) {
        curLanguageCode = ime.languageCode
        space.mainText.text = buildString {
            append(ime.displayName)
            ime.subMode.run { label.ifEmpty { name.ifEmpty { null } } }?.let { append(" ($it)") }
        }
        updateAlphabetKeys()
    }

    override fun onPopupAction(action: PopupAction) {
        val newAction = when (action) {
            is PopupAction.PreviewAction -> {
                var popLabel = action.labelContent
                if (capsState != CapsState.None || curLanguageCode == "en") {
                    popLabel = transformInputString(action.content)
                }
                action.copy(content = popLabel)
            }
            is PopupAction.PreviewUpdateAction -> {
                var popLabel = action.labelContent
                if (capsState != CapsState.None || curLanguageCode == "en") {
                    popLabel = transformInputString(action.content)
                }
                action.copy(content = popLabel)
            }
            is PopupAction.ShowKeyboardAction -> {
                val label = action.keyboard.label
                if (label.length == 1 && label[0].isLetter())
                    action.copy(keyboard = KeyDef.Popup.Keyboard(transformAlphabet(label)))
                else action
            }
            else -> action
        }
        super.onPopupAction(newAction)
    }

    private fun switchCapsState(lock: Boolean = false) {
        capsState = if (lock) when (capsState) {
            CapsState.Lock -> CapsState.None
            else -> CapsState.Lock
        } else when (capsState) {
            CapsState.None -> CapsState.Once
            else -> CapsState.None
        }
        updateCapsButtonIcon()
        updateAlphabetKeys()
    }

    private fun updateCapsButtonIcon() {
        caps.img.apply {
            imageResource = when (capsState) {
                CapsState.None -> R.drawable.ic_capslock_none
                CapsState.Once -> R.drawable.ic_capslock_once
                CapsState.Lock -> R.drawable.ic_capslock_lock
            }
        }
    }

    private fun updateLangSwitchKey(visible: Boolean) {
        lang.visibility = if (visible) View.VISIBLE else View.GONE
    }

    private fun updateAlphabetKeys() {
        textKeys.forEach {
            if (it.def !is KeyDef.Appearance.AltText) return
            if (capsState != CapsState.None || curLanguageCode == "en") {
                it.mainText.text = it.def.keyCodeString.let { str ->
                    if (str.length != 1 || !str[0].isLetter()) return@forEach
                    if (keepLettersUppercase) str.uppercase() else transformAlphabet(str)
                }
            } else {
                it.mainText.text = it.def.displayText
            }
        }
    }

    private fun updatePunctuationKeys() {
        textKeys.forEach {
            if (it is AltTextKeyView) {
                it.def as KeyDef.Appearance.AltText
                it.altText.text = transformPunctuation(it.def.altText)
            } else {
                it.def as KeyDef.Appearance.Text
                it.mainText.text = it.def.displayText.let { str ->
                    if (str[0].run { isLetter() || isWhitespace() }) return@forEach
                    transformPunctuation(str)
                }
            }
        }
    }

}
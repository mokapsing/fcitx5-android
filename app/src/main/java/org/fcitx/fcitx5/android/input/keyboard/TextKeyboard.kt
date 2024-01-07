/*
 * SPDX-License-Identifier: LGPL-2.1-or-later
 * SPDX-FileCopyrightText: Copyright 2021-2023 Fcitx5 for Android Contributors
 */
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
import timber.log.Timber

@SuppressLint("ViewConstructor")
class TextKeyboard(
    context: Context,
    theme: Theme
) : BaseKeyboard(context, theme, Layout) {

    enum class CapsState { None, Once, Lock }

    companion object {
        const val Name = "Text"

        val Layout: List<List<KeyDef>> = listOf(
            // 日木尸女火金廿大口水
            //  月卜人弓十心的一戈
            //   重田手土止山中
            /*
             日木尸廿水 山大弓戈田
              月女人中火 十的一口
               重土手卜止 金心
            */
            listOf(
                AlphabetKey("Q", "日", "1"),
                AlphabetKey("W", "木", "2"),
                AlphabetKey("E", "尸", "3"),
                AlphabetKey("R", "廿", "4"),
                AlphabetKey("T", "水", "5"),
                AlphabetKey("Y", "山", "6"),
                AlphabetKey("U", "大", "7"),
                AlphabetKey("I", "弓", "8"),
                AlphabetKey("O", "戈", "9"),
                AlphabetKey("P", "田", "0")
            ),
            listOf(
                AlphabetKey("A", "月", "@"),
                AlphabetKey("S", "女", "*"),
                AlphabetKey("D", "人", "+"),
                AlphabetKey("F", "中", "-"),
                AlphabetKey("G", "火", "="),
                AlphabetKey("H", "十", "/"),
                AlphabetKey("J", "的", "#"),
                AlphabetKey("K", "一", "("),
                AlphabetKey("L", "口", ")")
            ),
            listOf(
                CapsKey(),
                AlphabetKey("Z", "重", "'"),
                AlphabetKey("X", "土", ":"),
                AlphabetKey("C", "手", "\""),
                AlphabetKey("V", "卜", "?"),
                AlphabetKey("B", "止", "!"),
                AlphabetKey("N", "金", "~"),
                AlphabetKey("M", "心", "\\"),
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
    private val labelNeedIme: String = "中州韵 (魔仓)"
    private var curImeName: String = "English"
    override fun onInputMethodUpdate(ime: InputMethodEntry) {
        val spaceLable = buildString {
            append(ime.displayName)
            ime.subMode.run { name.ifEmpty { label.ifEmpty { null } } }?.let { append(" ($it)") }
        }
        space.mainText.text = spaceLable
        curImeName = spaceLable
        updateAlphabetKeys()
    }

    override fun onPopupAction(action: PopupAction) {
        val newAction = when (action) {
            is PopupAction.PreviewAction -> {
                var popLabel = action.labelContent
                if (capsState != CapsState.None || curImeName != labelNeedIme) {
                    popLabel = transformInputString(action.content)
                }
                action.copy(content = popLabel)
            }
            is PopupAction.PreviewUpdateAction -> {
                var popLabel = action.labelContent
                if (capsState != CapsState.None || curImeName != labelNeedIme) {
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
            if (capsState != CapsState.None || curImeName != labelNeedIme) {
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

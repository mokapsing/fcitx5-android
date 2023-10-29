/*
 * SPDX-License-Identifier: LGPL-2.1-or-later
 * SPDX-FileCopyrightText: Copyright 2021-2023 Fcitx5 for Android Contributors
 */
package org.fcitx.fcitx5.android.input.picker

import org.fcitx.fcitx5.android.R

object PickerData {

    class Category(val label: String = "", val icon: Int = 0)

    val RecentlyUsedCategory = Category("⟳", R.drawable.ic_baseline_access_time_24)

    val Symbol: List<Pair<Category, Array<String>>> = listOf(
        Category("1?#", R.drawable.symbol_number_punctuation) to arrayOf(
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            "!", "@", "#", "$", "%", "^", "&", "*", "(", ")",
            "'", "\"", "=", "_", "`", ":", ";", "?",
            "~", "|", "+", "-", "\\", "/", "[", "]", "{", "}",
            "<", ">", "“", "”", "·", "‘", "’", "¡", "¿", "¥",
            "€", "£", "¢", "©", "®", "™", "℃", "℉",
            "°", "§", "№", "†", "‡", "‥", "…", "‰", "※", "‾",
            "⁄", "‼", "⁇", "⁈", "⁉", "√", "π", "±", "×", "÷",
            "¶", "∆", "¤", "µ", "‹", "›", "«", "»"
        ),
        Category("( )", R.drawable.symbol_bracket) to arrayOf(
            "(", ")", "[", "]", "{", "}", "（", "）", "［", "］",
            "｛", "｝", "❨", "❩", "❲", "❳", "❴", "❵", "‘", "’",
            "“", "”", "❛", "❜", "❝", "❞", "<", ">",
            "〈", "〉", "《", "》", "〔", "〕", "【", "】", "〘", "〙",
            "「", "」", "『", "』", "︵", "︶", "︷", "︸", "︹", "︺",
            "︻", "︼", "︽", "︾", "︿", "﹀", "﹁", "﹂",
        ),
        Category("⇄", R.drawable.symbol_arrow) to arrayOf(
            "←", "↑", "→", "↓", "↔", "↕", "↖", "↗", "↘", "↙",
            "↚", "↛", "↜", "↝", "↞", "↟", "↠", "↡", "↢", "↣",
            "↤", "↥", "↦", "↧", "↨", "↩", "↪", "↫",
            "↬", "↭", "↮", "↯", "↰", "↱", "↲", "↳", "↴", "↵",
            "↶", "↷", "↸", "↹", "↺", "↻", "↼", "↽", "↾", "↿",
            "⇀", "⇁", "⇂", "⇃", "⇄", "⇅", "⇆", "⇇",
            "⇈", "⇉", "⇊", "⇋", "⇌", "⇍", "⇎", "⇏", "⇐", "⇑",
            "⇒", "⇓", "⇔", "⇕", "⇖", "⇗", "⇘", "⇙", "⇚", "⇛",
            "⇜", "⇝", "⇞", "⇟", "⇠", "⇡", "⇢", "⇣"
        ),
        Category("±", R.drawable.symbol_math) to arrayOf(
            "+", "-", "×", "÷", "±", "∓", "=", "≠", "∼", "≅",
            "<", ">", "≤", "≥", "√", "∛", "≈", "≡", "⁺", "⁻",
            "⊕", "⊗", "%", "‰", "∀", "∂", "∃", "∅",
            "∆", "∇", "∈", "∉", "∋", "∌", "∏", "∑", "ℵ", "∝",
            "∞", "∟", "∠", "∧", "∨", "∣", "∥", "∩", "∪", "∫",
            "∬", "∮", "∴", "∵", "∶", "∷", "⊂", "⊃",
            "⊄", "⊅", "⊆", "⊇", "∪", "∩", "ⁿ", "α", "β", "γ",
            "δ", "ε", "ζ", "η", "θ", "ι", "κ", "λ", "μ", "ν",
            "ξ", "ο", "π", "ρ", "ς", "σ", "τ", "υ",
            "φ", "χ", "ψ", "ω", "Α", "Β", "Γ", "Δ", "Ε", "Ζ",
            "Η", "Θ", "Ι", "Κ", "Λ", "Μ", "Ν", "Ξ", "Ο", "Π",
            "Ρ", "Σ", "Τ", "Υ", "Φ", "Χ", "Ψ", "Ω",
        ),
        Category("①", R.drawable.symbol_ordinal) to arrayOf(
            "①", "②", "③", "④", "⑤", "⑥", "⑦", "⑧", "⑨", "⑩",
            "⑴", "⑵", "⑶", "⑷", "⑸", "⑹", "⑺", "⑻", "⑼", "⑽",
            "❶", "❷", "❸", "❹", "❺", "❻", "❼", "❽",
            "❾", "❿", "㈠", "㈡", "㈢", "㈣", "㈤", "㈥", "㈦", "㈧",
            "㈨", "㈩", "Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ", "Ⅷ",
            "Ⅸ", "Ⅹ", "Ⅺ", "Ⅻ", "Ⅼ", "Ⅽ", "Ⅾ", "Ⅿ",
            "ⅰ", "ⅱ", "ⅲ", "ⅳ", "ⅴ", "ⅵ", "ⅶ", "ⅷ", "ⅸ", "ⅹ",
            "ⅺ", "ⅻ", "ⅼ", "ⅽ", "ⅾ", "ⅿ", "¹", "²", "³", "⁴",
            "₁", "₂", "₃", "₄", "½", "⅓", "⅔", "㊣"
        ),
        Category("◇", R.drawable.symbol_other) to arrayOf(
            "⚫", "⚪", "●", "○", "■", "□", "⬛", "⬜", "★", "☆",
            "◆", "◇", "▲", "△", "▶", "▷", "▼", "▽", "◀", "◁",
            "◐", "◑", "♀", "♂", "♤", "♡", "♧", "♢",
            "♠", "♥", "♣", "♦", "•", "❖", "✓", "✔", "✕", "✖",
            "✗", "✘", "✙", "✚", "✛", "✜", "✝", "✞", "✟", "✠",
            "✡", "✢", "✣", "✤", "✥", "✦", "✧", "✨",
            "✩", "✪", "✫", "✬", "✭", "✮", "✯", "✰", "✱", "✲",
            "✳", "✴", "✵", "✶", "✷", "✸", "✹", "✺", "✻", "✼",
            "✽", "✾", "✿", "❀", "❁", "❂", "❃", "❄",
            "❅", "❆", "❇", "❈", "❉", "❊", "❋", "❌", "❍", "❎",
            "❏", "❐", "❑", "❒", "◈", "◉", "◊", "○", "◢", "◣",
            "◤", "◥", "❢", "❣", "❤", "❥", "❦", "❧"
        ),
        Category("[全]", R.drawable.symbol_fullwidth) to arrayOf(
            "１", "２", "３", "４", "５", "６", "７", "８", "９", "０",
            "！", "＠", "＃", "＄", "％", "＾", "＆", "＊", "（", "）",
            "‘", "’", "＝", "＿", "｀", "：", "；", "？",
            "〜", "｜", "＋", "―", "＼", "／", "、", "．", "，", "。",
            "＜", "＞", "ー", "−", "・", "￥", "〒", "々", "仝", "〃",
            "ゝ", "ゞ", "ヽ", "ヾ"
        )
    )

    val Emoji: List<Pair<Category, Array<String>>> = listOf(
        Category("🙂", R.drawable.ic_baseline_tag_faces_24) to arrayOf(
            "😀", "😃", "😄", "😁", "😆", "😅", "🤣", "😂", "🙂", "🙃", "🫠", "😉", "😊",
            "😇", "🥰", "😍", "🤩", "😘", "😗", "☺️", "😚", "😙", "🥲", "😋", "😛", "😜",
            "🤪", "😝", "🤑", "🤗", "🤭", "🫢", "🫣", "🤫", "🤔", "🫡", "🤐", "🤨", "😐",
            "😑", "😶", "🫥", "😶‍🌫️", "😏", "😒", "🙄", "😬", "😮‍💨", "🤥", "😌", "😔", "😪",
            "🤤", "😴", "😷", "🤒", "🤕", "🤢", "🤮", "🤧", "🥵", "🥶", "🥴", "😵", "😵‍💫",
            "🤯", "🤠", "🥳", "🥸", "😎", "🤓", "🧐", "😕", "🫤", "😟", "🙁", "☹️", "😮",
            "😯", "😲", "😳", "🥺", "🥹", "😦", "😧", "😨", "😰", "😥", "😢", "😭", "😱",
            "😖", "😣", "😞", "😓", "😩", "😫", "🥱", "😤", "😡", "😠", "🤬", "😈", "👿",
            "💀", "☠️", "💩", "🤡", "👹", "👺", "👻", "👽", "👾", "🤖", "😺", "😸", "😹",
            "😻", "😼", "😽", "🙀", "😿", "😾", "🙈", "🙉", "🙊", "💋", "💌", "💘", "💝",
            "💖", "💗", "💓", "💞", "💕", "💟", "❣️", "💔", "❤️‍🔥", "❤️‍🩹", "❤️", "🧡", "💛",
            "💚", "💙", "💜", "🤎", "🖤", "🤍", "💯", "💢", "💥", "💫", "💦", "💨", "🕳️",
            "💣", "💬", "👁️‍🗨️", "🗨️", "🗯️", "💭", "💤",
        ),
        Category("🧑", R.drawable.ic_baseline_emoji_people_24) to arrayOf(
            "👋", "🤚", "🖐️", "✋", "🖖", "🫱", "🫲", "🫳", "🫴", "👌", "🤌", "🤏", "✌️",
            "🤞", "🫰", "🤟", "🤘", "🤙", "👈", "👉", "👆", "🖕", "👇", "☝️", "🫵", "👍",
            "👎", "✊", "👊", "🤛", "🤜", "👏", "🙌", "🫶", "👐", "🤲", "🤝", "🙏", "✍️",
            "💅", "🤳", "💪", "🦾", "🦿", "🦵", "🦶", "👂", "🦻", "👃", "🧠", "🫀", "🫁",
            "🦷", "🦴", "👀", "👁️", "👅", "👄", "🫦", "👶", "🧒", "👦", "👧", "🧑", "👱",
            "👨", "🧔", "🧔‍♂️", "🧔‍♀️", "👨‍🦰", "👨‍🦱", "👨‍🦳", "👨‍🦲", "👩", "👩‍🦰", "🧑‍🦰", "👩‍🦱", "🧑‍🦱",
            "👩‍🦳", "🧑‍🦳", "👩‍🦲", "🧑‍🦲", "👱‍♀️", "👱‍♂️", "🧓", "👴", "👵", "🙍", "🙍‍♂️", "🙍‍♀️", "🙎",
            "🙎‍♂️", "🙎‍♀️", "🙅", "🙅‍♂️", "🙅‍♀️", "🙆", "🙆‍♂️", "🙆‍♀️", "💁", "💁‍♂️", "💁‍♀️", "🙋", "🙋‍♂️",
            "🙋‍♀️", "🧏", "🧏‍♂️", "🧏‍♀️", "🙇", "🙇‍♂️", "🙇‍♀️", "🤦", "🤦‍♂️", "🤦‍♀️", "🤷", "🤷‍♂️", "🤷‍♀️",
            "🧑‍⚕️", "👨‍⚕️", "👩‍⚕️", "🧑‍🎓", "👨‍🎓", "👩‍🎓", "🧑‍🏫", "👨‍🏫", "👩‍🏫", "🧑‍⚖️", "👨‍⚖️", "👩‍⚖️", "🧑‍🌾",
            "👨‍🌾", "👩‍🌾", "🧑‍🍳", "👨‍🍳", "👩‍🍳", "🧑‍🔧", "👨‍🔧", "👩‍🔧", "🧑‍🏭", "👨‍🏭", "👩‍🏭", "🧑‍💼", "👨‍💼",
            "👩‍💼", "🧑‍🔬", "👨‍🔬", "👩‍🔬", "🧑‍💻", "👨‍💻", "👩‍💻", "🧑‍🎤", "👨‍🎤", "👩‍🎤", "🧑‍🎨", "👨‍🎨", "👩‍🎨",
            "🧑‍✈️", "👨‍✈️", "👩‍✈️", "🧑‍🚀", "👨‍🚀", "👩‍🚀", "🧑‍🚒", "👨‍🚒", "👩‍🚒", "👮", "👮‍♂️", "👮‍♀️", "🕵️",
            "🕵️‍♂️", "🕵️‍♀️", "💂", "💂‍♂️", "💂‍♀️", "🥷", "👷", "👷‍♂️", "👷‍♀️", "🫅", "🤴", "👸", "👳",
            "👳‍♂️", "👳‍♀️", "👲", "🧕", "🤵", "🤵‍♂️", "🤵‍♀️", "👰", "👰‍♂️", "👰‍♀️", "🤰", "🫃", "🫄",
            "🤱", "👩‍🍼", "👨‍🍼", "🧑‍🍼", "👼", "🎅", "🤶", "🧑‍🎄", "🦸", "🦸‍♂️", "🦸‍♀️", "🦹", "🦹‍♂️",
            "🦹‍♀️", "🧙", "🧙‍♂️", "🧙‍♀️", "🧚", "🧚‍♂️", "🧚‍♀️", "🧛", "🧛‍♂️", "🧛‍♀️", "🧜", "🧜‍♂️", "🧜‍♀️",
            "🧝", "🧝‍♂️", "🧝‍♀️", "🧞", "🧞‍♂️", "🧞‍♀️", "🧟", "🧟‍♂️", "🧟‍♀️", "🧌", "💆", "💆‍♂️", "💆‍♀️",
            "💇", "💇‍♂️", "💇‍♀️", "🚶", "🚶‍♂️", "🚶‍♀️", "🧍", "🧍‍♂️", "🧍‍♀️", "🧎", "🧎‍♂️", "🧎‍♀️", "🧑‍🦯",
            "👨‍🦯", "👩‍🦯", "🧑‍🦼", "👨‍🦼", "👩‍🦼", "🧑‍🦽", "👨‍🦽", "👩‍🦽", "🏃", "🏃‍♂️", "🏃‍♀️", "💃", "🕺",
            "🕴️", "👯", "👯‍♂️", "👯‍♀️", "🧖", "🧖‍♂️", "🧖‍♀️", "🧗", "🧗‍♂️", "🧗‍♀️", "🤺", "🏇", "⛷️",
            "🏂", "🏌️", "🏌️‍♂️", "🏌️‍♀️", "🏄", "🏄‍♂️", "🏄‍♀️", "🚣", "🚣‍♂️", "🚣‍♀️", "🏊", "🏊‍♂️", "🏊‍♀️",
            "⛹️", "⛹️‍♂️", "⛹️‍♀️", "🏋️", "🏋️‍♂️", "🏋️‍♀️", "🚴", "🚴‍♂️", "🚴‍♀️", "🚵", "🚵‍♂️", "🚵‍♀️", "🤸",
            "🤸‍♂️", "🤸‍♀️", "🤼", "🤼‍♂️", "🤼‍♀️", "🤽", "🤽‍♂️", "🤽‍♀️", "🤾", "🤾‍♂️", "🤾‍♀️", "🤹", "🤹‍♂️",
            "🤹‍♀️", "🧘", "🧘‍♂️", "🧘‍♀️", "🛀", "🛌", "🧑‍🤝‍🧑", "👭", "👫", "👬", "💏", "👩‍❤️‍💋‍👨", "👨‍❤️‍💋‍👨",
            "👩‍❤️‍💋‍👩", "💑", "👩‍❤️‍👨", "👨‍❤️‍👨", "👩‍❤️‍👩", "👪", "👨‍👩‍👦", "👨‍👩‍👧", "👨‍👩‍👧‍👦", "👨‍👩‍👦‍👦", "👨‍👩‍👧‍👧", "👨‍👨‍👦", "👨‍👨‍👧",
            "👨‍👨‍👧‍👦", "👨‍👨‍👦‍👦", "👨‍👨‍👧‍👧", "👩‍👩‍👦", "👩‍👩‍👧", "👩‍👩‍👧‍👦", "👩‍👩‍👦‍👦", "👩‍👩‍👧‍👧", "👨‍👦", "👨‍👦‍👦", "👨‍👧", "👨‍👧‍👦", "👨‍👧‍👧",
            "👩‍👦", "👩‍👦‍👦", "👩‍👧", "👩‍👧‍👦", "👩‍👧‍👧", "🗣️", "👤", "👥", "🫂", "👣"
        ),
        Category("🌸", R.drawable.ic_baseline_flower_24) to arrayOf(
            "🐵", "🐒", "🦍", "🦧", "🐶", "🐕", "🦮", "🐕‍🦺", "🐩", "🐺", "🦊", "🦝", "🐱",
            "🐈", "🐈‍⬛", "🦁", "🐯", "🐅", "🐆", "🐴", "🐎", "🦄", "🦓", "🦌", "🦬", "🐮",
            "🐂", "🐃", "🐄", "🐷", "🐖", "🐗", "🐽", "🐏", "🐑", "🐐", "🐪", "🐫", "🦙",
            "🦒", "🐘", "🦣", "🦏", "🦛", "🐭", "🐁", "🐀", "🐹", "🐰", "🐇", "🐿️", "🦫",
            "🦔", "🦇", "🐻", "🐻‍❄️", "🐨", "🐼", "🦥", "🦦", "🦨", "🦘", "🦡", "🐾", "🦃",
            "🐔", "🐓", "🐣", "🐤", "🐥", "🐦", "🐧", "🕊️", "🦅", "🦆", "🦢", "🦉", "🦤",
            "🪶", "🦩", "🦚", "🦜", "🐸", "🐊", "🐢", "🦎", "🐍", "🐲", "🐉", "🦕", "🦖",
            "🐳", "🐋", "🐬", "🦭", "🐟", "🐠", "🐡", "🦈", "🐙", "🐚", "🪸", "🐌", "🦋",
            "🐛", "🐜", "🐝", "🪲", "🐞", "🦗", "🪳", "🕷️", "🕸️", "🦂", "🦟", "🪰", "🪱",
            "🦠", "💐", "🌸", "💮", "🪷", "🏵️", "🌹", "🥀", "🌺", "🌻", "🌼", "🌷", "🌱",
            "🪴", "🌲", "🌳", "🌴", "🌵", "🌾", "🌿", "☘️", "🍀", "🍁", "🍂", "🍃", "🪹",
            "🪺"
        ),
        Category("🎂", R.drawable.ic_baseline_cake_24) to arrayOf (
            "🍇", "🍈", "🍉", "🍊", "🍋", "🍌", "🍍", "🥭", "🍎", "🍏", "🍐", "🍑", "🍒",
            "🍓", "🫐", "🥝", "🍅", "🫒", "🥥", "🥑", "🍆", "🥔", "🥕", "🌽", "🌶️", "🫑",
            "🥒", "🥬", "🥦", "🧄", "🧅", "🍄", "🥜", "🫘", "🌰", "🍞", "🥐", "🥖", "🫓",
            "🥨", "🥯", "🥞", "🧇", "🧀", "🍖", "🍗", "🥩", "🥓", "🍔", "🍟", "🍕", "🌭",
            "🥪", "🌮", "🌯", "🫔", "🥙", "🧆", "🥚", "🍳", "🥘", "🍲", "🫕", "🥣", "🥗",
            "🍿", "🧈", "🧂", "🥫", "🍱", "🍘", "🍙", "🍚", "🍛", "🍜", "🍝", "🍠", "🍢",
            "🍣", "🍤", "🍥", "🥮", "🍡", "🥟", "🥠", "🥡", "🦀", "🦞", "🦐", "🦑", "🦪",
            "🍦", "🍧", "🍨", "🍩", "🍪", "🎂", "🍰", "🧁", "🥧", "🍫", "🍬", "🍭", "🍮",
            "🍯", "🍼", "🥛", "☕", "🫖", "🍵", "🍶", "🍾", "🍷", "🍸", "🍹", "🍺", "🍻",
            "🥂", "🥃", "🫗", "🥤", "🧋", "🧃", "🧉", "🧊", "🥢", "🍽️", "🍴", "🥄", "🔪",
            "🫙", "🏺"
        ),
        Category("🚘", R.drawable.ic_baseline_directions_car_24) to arrayOf (
            "🌍", "🌎", "🌏", "🌐", "🗺️", "🗾", "🧭", "🏔️", "⛰️", "🌋", "🗻", "🏕️", "🏖️",
            "🏜️", "🏝️", "🏞️", "🏟️", "🏛️", "🏗️", "🧱", "🪨", "🪵", "🛖", "🏘️", "🏚️", "🏠",
            "🏡", "🏢", "🏣", "🏤", "🏥", "🏦", "🏨", "🏩", "🏪", "🏫", "🏬", "🏭", "🏯",
            "🏰", "💒", "🗼", "🗽", "⛪", "🕌", "🛕", "🕍", "⛩️", "🕋", "⛲", "⛺", "🌁",
            "🌃", "🏙️", "🌄", "🌅", "🌆", "🌇", "🌉", "♨️", "🎠", "🛝", "🎡", "🎢", "💈",
            "🎪", "🚂", "🚃", "🚄", "🚅", "🚆", "🚇", "🚈", "🚉", "🚊", "🚝", "🚞", "🚋",
            "🚌", "🚍", "🚎", "🚐", "🚑", "🚒", "🚓", "🚔", "🚕", "🚖", "🚗", "🚘", "🚙",
            "🛻", "🚚", "🚛", "🚜", "🏎️", "🏍️", "🛵", "🦽", "🦼", "🛺", "🚲", "🛴", "🛹",
            "🛼", "🚏", "🛣️", "🛤️", "🛢️", "⛽", "🛞", "🚨", "🚥", "🚦", "🛑", "🚧", "⚓",
            "🛟", "⛵", "🛶", "🚤", "🛳️", "⛴️", "🛥️", "🚢", "✈️", "🛩️", "🛫", "🛬", "🪂",
            "💺", "🚁", "🚟", "🚠", "🚡", "🛰️", "🚀", "🛸", "🛎️", "🧳", "⌛", "⏳", "⌚",
            "⏰", "⏱️", "⏲️", "🕰️", "🕛", "🕧", "🕐", "🕜", "🕑", "🕝", "🕒", "🕞", "🕓",
            "🕟", "🕔", "🕠", "🕕", "🕡", "🕖", "🕢", "🕗", "🕣", "🕘", "🕤", "🕙", "🕥",
            "🕚", "🕦", "🌑", "🌒", "🌓", "🌔", "🌕", "🌖", "🌗", "🌘", "🌙", "🌚", "🌛",
            "🌜", "🌡️", "☀️", "🌝", "🌞", "🪐", "⭐", "🌟", "🌠", "🌌", "☁️", "⛅", "⛈️",
            "🌤️", "🌥️", "🌦️", "🌧️", "🌨️", "🌩️", "🌪️", "🌫️", "🌬️", "🌀", "🌈", "🌂", "☂️",
            "☔", "⛱️", "⚡", "❄️", "☃️", "⛄", "☄️", "🔥", "💧", "🌊"
        ),
        Category("⚽", R.drawable.ic_baseline_sports_basketball_24) to arrayOf (
            "🎃", "🎄", "🎆", "🎇", "🧨", "✨", "🎈", "🎉", "🎊", "🎋", "🎍", "🎎", "🎏",
            "🎐", "🎑", "🧧", "🎀", "🎁", "🎗️", "🎟️", "🎫", "🎖️", "🏆", "🏅", "🥇", "🥈",
            "🥉", "⚽", "⚾", "🥎", "🏀", "🏐", "🏈", "🏉", "🎾", "🥏", "🎳", "🏏", "🏑",
            "🏒", "🥍", "🏓", "🏸", "🥊", "🥋", "🥅", "⛳", "⛸️", "🎣", "🤿", "🎽", "🎿",
            "🛷", "🥌", "🎯", "🪀", "🪁", "🎱", "🔮", "🪄", "🧿", "🪬", "🎮", "🕹️", "🎰",
            "🎲", "🧩", "🧸", "🪅", "🪩", "🪆", "♠️", "♥️", "♦️", "♣️", "♟️", "🃏", "🀄",
            "🎴", "🎭", "🖼️", "🎨", "🧵", "🪡", "🧶", "🪢"
        ),
        Category("💡", R.drawable.ic_baseline_emoji_objects_24) to arrayOf (
            "👓", "🕶️", "🥽", "🥼", "🦺", "👔", "👕", "👖", "🧣", "🧤", "🧥", "🧦", "👗",
            "👘", "🥻", "🩱", "🩲", "🩳", "👙", "👚", "👛", "👜", "👝", "🛍️", "🎒", "🩴",
            "👞", "👟", "🥾", "🥿", "👠", "👡", "🩰", "👢", "👑", "👒", "🎩", "🎓", "🧢",
            "🪖", "⛑️", "📿", "💄", "💍", "💎", "🔇", "🔈", "🔉", "🔊", "📢", "📣", "📯",
            "🔔", "🔕", "🎼", "🎵", "🎶", "🎙️", "🎚️", "🎛️", "🎤", "🎧", "📻", "🎷", "🪗",
            "🎸", "🎹", "🎺", "🎻", "🪕", "🥁", "🪘", "📱", "📲", "☎️", "📞", "📟", "📠",
            "🔋", "🪫", "🔌", "💻", "🖥️", "🖨️", "⌨️", "🖱️", "🖲️", "💽", "💾", "💿", "📀",
            "🧮", "🎥", "🎞️", "📽️", "🎬", "📺", "📷", "📸", "📹", "📼", "🔍", "🔎", "🕯️",
            "💡", "🔦", "🏮", "🪔", "📔", "📕", "📖", "📗", "📘", "📙", "📚", "📓", "📒",
            "📃", "📜", "📄", "📰", "🗞️", "📑", "🔖", "🏷️", "💰", "🪙", "💴", "💵", "💶",
            "💷", "💸", "💳", "🧾", "💹", "✉️", "📧", "📨", "📩", "📤", "📥", "📦", "📫",
            "📪", "📬", "📭", "📮", "🗳️", "✏️", "✒️", "🖋️", "🖊️", "🖌️", "🖍️", "📝", "💼",
            "📁", "📂", "🗂️", "📅", "📆", "🗒️", "🗓️", "📇", "📈", "📉", "📊", "📋", "📌",
            "📍", "📎", "🖇️", "📏", "📐", "✂️", "🗃️", "🗄️", "🗑️", "🔒", "🔓", "🔏", "🔐",
            "🔑", "🗝️", "🔨", "🪓", "⛏️", "⚒️", "🛠️", "🗡️", "⚔️", "🔫", "🪃", "🏹", "🛡️",
            "🪚", "🔧", "🪛", "🔩", "⚙️", "🗜️", "⚖️", "🦯", "🔗", "⛓️", "🪝", "🧰", "🧲",
            "🪜", "⚗️", "🧪", "🧫", "🧬", "🔬", "🔭", "📡", "💉", "🩸", "💊", "🩹", "🩼",
            "🩺", "🩻", "🚪", "🛗", "🪞", "🪟", "🛏️", "🛋️", "🪑", "🚽", "🪠", "🚿", "🛁",
            "🪤", "🪒", "🧴", "🧷", "🧹", "🧺", "🧻", "🪣", "🧼", "🫧", "🪥", "🧽", "🧯",
            "🛒", "🚬", "⚰️", "🪦", "⚱️", "🗿", "🪧", "🪪"
        ),
       Category("🔣", R.drawable.ic_baseline_emoji_symbols_24) to arrayOf(
            "🏧", "🚮", "🚰", "♿", "🚹", "🚺", "🚻", "🚼", "🚾", "🛂", "🛃", "🛄", "🛅",
            "⚠️", "🚸", "⛔", "🚫", "🚳", "🚭", "🚯", "🚱", "🚷", "📵", "🔞", "☢️", "☣️",
            "⬆️", "↗️", "➡️", "↘️", "⬇️", "↙️", "⬅️", "↖️", "↕️", "↔️", "↩️", "↪️", "⤴️", "⤵️",
            "🔃", "🔄", "🔙", "🔚", "🔛", "🔜", "🔝", "🛐", "⚛️", "🕉️", "✡️", "☸️", "☯️",
            "✝️", "☦️", "☪️", "☮️", "🕎", "🔯", "♈", "♉", "♊", "♋", "♌", "♍", "♎",
            "♏", "♐", "♑", "♒", "♓", "⛎", "🔀", "🔁", "🔂", "▶️", "⏩", "⏭️", "⏯️",
            "◀️", "⏪", "⏮️", "🔼", "⏫", "🔽", "⏬", "⏸️", "⏹️", "⏺️", "⏏️", "🎦", "🔅",
            "🔆", "📶", "📳", "📴", "♀️", "♂️", "⚧️", "✖️", "➕", "➖", "➗", "🟰", "♾️",
            "‼️", "⁉️", "❓", "❔", "❕", "❗", "〰️", "💱", "💲", "⚕️", "♻️", "⚜️", "🔱",
            "📛", "🔰", "⭕", "✅", "☑️", "✔️", "❌", "❎", "➰", "➿", "〽️", "✳️", "✴️",
            "❇️", "©️", "®️", "™️", "#️⃣", "*️⃣", "0️⃣", "1️⃣", "2️⃣", "3️⃣", "4️⃣", "5️⃣", "6️⃣",
            "7️⃣", "8️⃣", "9️⃣", "🔟", "🔠", "🔡", "🔢", "🔣", "🔤", "🅰️", "🆎", "🅱️", "🆑",
            "🆒", "🆓", "ℹ️", "🆔", "Ⓜ️", "🆕", "🆖", "🅾️", "🆗", "🅿️", "🆘", "🆙", "🆚", "🈁",
            "🈂️", "🈷️", "🈶", "🈯", "🉐", "🈹", "🈚", "🈲", "🉑", "🈸", "🈴", "🈳", "㊗️", "㊙️",
            "🈺", "🈵", "🔴", "🟠", "🟡", "🟢", "🔵", "🟣", "🟤", "⚫", "⚪", "🟥", "🟧",
            "🟨", "🟩", "🟦", "🟪", "🟫", "⬛", "⬜", "◼️", "◻️", "◾", "◽", "▪️", "▫️",
            "🔶", "🔷", "🔸", "🔹", "🔺", "🔻", "💠", "🔘", "🔳", "🔲"
        ),
        Category("🏁", R.drawable.ic_baseline_flag_24) to arrayOf(
            "🏁", "🚩", "🎌", "🏴", "🏳️", "🏳️‍🌈", "🏳️‍⚧️", "🏴‍☠️", "🇦🇨", "🇦🇩", "🇦🇪", "🇦🇫", "🇦🇬",
            "🇦🇮", "🇦🇱", "🇦🇲", "🇦🇴", "🇦🇶", "🇦🇷", "🇦🇸", "🇦🇹", "🇦🇺", "🇦🇼", "🇦🇽", "🇦🇿", "🇧🇦",
            "🇧🇧", "🇧🇩", "🇧🇪", "🇧🇫", "🇧🇬", "🇧🇭", "🇧🇮", "🇧🇯", "🇧🇱", "🇧🇲", "🇧🇳", "🇧🇴", "🇧🇶",
            "🇧🇷", "🇧🇸", "🇧🇹", "🇧🇻", "🇧🇼", "🇧🇾", "🇧🇿", "🇨🇦", "🇨🇨", "🇨🇩", "🇨🇫", "🇨🇬", "🇨🇭",
            "🇨🇮", "🇨🇰", "🇨🇱", "🇨🇲", "🇨🇳", "🇨🇴", "🇨🇵", "🇨🇷", "🇨🇺", "🇨🇻", "🇨🇼", "🇨🇽", "🇨🇾",
            "🇨🇿", "🇩🇪", "🇩🇬", "🇩🇯", "🇩🇰", "🇩🇲", "🇩🇴", "🇩🇿", "🇪🇦", "🇪🇨", "🇪🇪", "🇪🇬", "🇪🇭",
            "🇪🇷", "🇪🇸", "🇪🇹", "🇪🇺", "🇫🇮", "🇫🇯", "🇫🇰", "🇫🇲", "🇫🇴", "🇫🇷", "🇬🇦", "🇬🇧", "🇬🇩",
            "🇬🇪", "🇬🇫", "🇬🇬", "🇬🇭", "🇬🇮", "🇬🇱", "🇬🇲", "🇬🇳", "🇬🇵", "🇬🇶", "🇬🇷", "🇬🇸", "🇬🇹",
            "🇬🇺", "🇬🇼", "🇬🇾", "🇭🇰", "🇭🇲", "🇭🇳", "🇭🇷", "🇭🇹", "🇭🇺", "🇮🇨", "🇮🇩", "🇮🇪", "🇮🇱",
            "🇮🇲", "🇮🇳", "🇮🇴", "🇮🇶", "🇮🇷", "🇮🇸", "🇮🇹", "🇯🇪", "🇯🇲", "🇯🇴", "🇯🇵", "🇰🇪", "🇰🇬",
            "🇰🇭", "🇰🇮", "🇰🇲", "🇰🇳", "🇰🇵", "🇰🇷", "🇰🇼", "🇰🇾", "🇰🇿", "🇱🇦", "🇱🇧", "🇱🇨", "🇱🇮",
            "🇱🇰", "🇱🇷", "🇱🇸", "🇱🇹", "🇱🇺", "🇱🇻", "🇱🇾", "🇲🇦", "🇲🇨", "🇲🇩", "🇲🇪", "🇲🇫", "🇲🇬",
            "🇲🇭", "🇲🇰", "🇲🇱", "🇲🇲", "🇲🇳", "🇲🇴", "🇲🇵", "🇲🇶", "🇲🇷", "🇲🇸", "🇲🇹", "🇲🇺", "🇲🇻",
            "🇲🇼", "🇲🇽", "🇲🇾", "🇲🇿", "🇳🇦", "🇳🇨", "🇳🇪", "🇳🇫", "🇳🇬", "🇳🇮", "🇳🇱", "🇳🇴", "🇳🇵",
            "🇳🇷", "🇳🇺", "🇳🇿", "🇴🇲", "🇵🇦", "🇵🇪", "🇵🇫", "🇵🇬", "🇵🇭", "🇵🇰", "🇵🇱", "🇵🇲", "🇵🇳",
            "🇵🇷", "🇵🇸", "🇵🇹", "🇵🇼", "🇵🇾", "🇶🇦", "🇷🇪", "🇷🇴", "🇷🇸", "🇷🇺", "🇷🇼", "🇸🇦", "🇸🇧",
            "🇸🇨", "🇸🇩", "🇸🇪", "🇸🇬", "🇸🇭", "🇸🇮", "🇸🇯", "🇸🇰", "🇸🇱", "🇸🇲", "🇸🇳", "🇸🇴", "🇸🇷",
            "🇸🇸", "🇸🇹", "🇸🇻", "🇸🇽", "🇸🇾", "🇸🇿", "🇹🇦", "🇹🇨", "🇹🇩", "🇹🇫", "🇹🇬", "🇹🇭", "🇹🇯",
            "🇹🇰", "🇹🇱", "🇹🇲", "🇹🇳", "🇹🇴", "🇹🇷", "🇹🇹", "🇹🇻", "🇹🇼", "🇹🇿", "🇺🇦", "🇺🇬", "🇺🇲",
            "🇺🇳", "🇺🇸", "🇺🇾", "🇺🇿", "🇻🇦", "🇻🇨", "🇻🇪", "🇻🇬", "🇻🇮", "🇻🇳", "🇻🇺", "🇼🇫", "🇼🇸",
            "🇽🇰", "🇾🇪", "🇾🇹", "🇿🇦", "🇿🇲", "🇿🇼", "🏴󠁧󠁢󠁥󠁮󠁧󠁿", "🏴󠁧󠁢󠁳󠁣󠁴󠁿", "🏴󠁧󠁢󠁷󠁬󠁳󠁿"
        )
    )

    val Emoticon: List<Pair<Category, Array<String>>> = listOf(
        Category("(^_^)") to arrayOf(
            ":D", ":)", ";)", ":-)",
            "^_^", "(^^)", "(^^♪", "ʕ•ٹ•ʔ",
            "(^o^)", "(^^)/", "(^^)v", "(^_^)",
            "(・∀・)", "(^_-)", "(≧▽≦)", "(^。^)",
            "(^・^)", "(^ム^)", "(•ө•)♡", "(ㆁωㆁ*)",
            "(^_^)v", "(*^^*)", "(*´∀｀)", "( ´∀｀)",
            "(≧∇≦)b", "(*^^)v", "(^o^)v", "(^_^)/",
            "(^o^)／", "(*ﾟ∀ﾟ)", "(^o^)丿", "(^O^)v",
            "(^_^.)", "（ ・∀・）", "(๑´ڡ`๑)", "•̀.̫•́✧",
            "(´ڡ`ლ)", "(･ิω･ิ)", "(*´ڡ`●)", "❤(ӦｖӦ｡)",
            "(●´ϖ`●)", "＼(^o^)／", "(*´ω｀*)", "(*^_^*)",
            "(^o^)丿", "(^_-)-☆", "(*^。^*)", "(^。^)ノ",
            "(ﾉ´∀｀*)", "•̀ω•́ʔ✧", "( ･ิϖ･ิ)", "(♡ε♡ )۶",
            "(　･ิω･ิ)", "( ･ิω･ิ)", "(￣ー￣)ﾆﾔﾘ", "(^^)/~~~",
            "(๑´3｀๑)۶", "(@^^)/~~~", "(^.^)/~~~", "(๑•̀ㅁ•́๑)✧",
            "(๑•̀ㅂ•́)و✧", "(>ω<)", "(*˘︶˘*).｡.:*♡", "(｡>﹏<｡)",
            "(*>_<*)ﾉ", "(｡>﹏<｡)ﾉﾞ✧*。"
        ),
        Category("(-_-;)") to arrayOf(
            "^^;", "^_^;", "(^^ゞ", "(・・;",
            "(;_;", "(・・;)", "(*_*;", "(ーー;)",
            "(^o^;", "(゜o゜;", "(・。・;", "(^.^;",
            "(@@;)", "(¯―¯٥)", "(^_^;)", "(-_-;)",
            "('・ω・')", "(°ー°〃)", "(ーー゛)", "(~_~;)",
            "(；´Д｀)", "(^o^;)", "(；・∀・)", "(；´∀｀)",
            "(-.-;)", "(・_・;)", "(＠_＠;)", "（；^ω^）",
            "(；一_一)", "(_ _;)", "(^O^;)", "(~O~;)",
            "(・.・;)", "(=o=;)", "(-_-;)", "(~_~;)",
            "(-.-;)", "(；一_一)", "(~O~;)", "(=o=;)",
            "(´∀｀；)", "(´-﹏-`；)", "(ㆀ˘･з･˘)", "(_ _;)m",
            "(_ _;)m", "( •̀ㅁ•́;)", "(； ･`д･´)"
        ),
        Category("(*_*)") to arrayOf(
            ":-O", ":-|", "(゜゜)", "(@_@)",
            "(*_*)", "(+_+)", "(・o・)", "(゜o゜)",
            "(゜-゜)", "(?_?)", "(ﾟДﾟ)", "( ﾟдﾟ)",
            "＼(◎o◎)／", "(✽ ﾟдﾟ ✽)", "≡≡ﾍ( ´Д`)ﾉ"
        ),
        Category("(T_T)") to arrayOf(
            "(TT)", "(__)", "(;_;", "(´Д⊂ヽ",
            "(T_T)", "(;_;)", "(._.)", "(ToT)",
            "(_ _)", "(/_;)", "(:_;)", "(;O;)",
            "(TдT)", "(TOT)", "(;_:)", "|￣|○",
            "(_ _;)", "(¯―¯٥)", "(__)m", "(｡ŏ﹏ŏ)",
            "(ヽ´ω`)", "( ；∀；)", "(･ัω･ั)", "(_^_)_",
            "(._.)_", "(_ _)m", "(*´﹃｀*)", "(´・ω・`)",
            "(´・ω・｀)", "(´；ω；｀)", "(´д⊂)‥ﾊｩ", "( ･ั﹏･ั)",
            "(つд⊂)ｴｰﾝ", "(_ _;)m", "( ´Д｀)=3", "(ﾉД`)ｼｸｼｸ",
            "(๑´0`๑)۶", "(ToT)/~~~", "(;_;)/~~~", "(T_T)/~~~",
            "(´；ω；｀)ｳｯ…", "｡ﾟ(ﾟ´Д｀ﾟ)ﾟ｡", "(´；ω；｀)ﾌﾞﾜｯ", "(๑´•.̫ • `๑)",
            "(´ . .̫ . `)", "｡･ﾟ･(ﾉД`)･ﾟ･｡", "｡･ﾟ･(ﾉ∀`)･ﾟ･｡", "(´°̥̥̥̥̥̥̥̥ω°̥̥̥̥̥̥̥̥｀)",
        ),
        Category("(-_-)") to arrayOf(
            ":(", ":|", ":-(", ":-P",
            "=_=", "(--)", "(｀´）", "(-_-)",
            "(-.-)", "(=_=)", "(︶^︶)", "→_→",
            "←_←", "(~o~)", "(~_~)", "(~O~)",
            "(ー_ー)", "( 一一)", "(・へ・)", "(ーー゛)",
            "(－－〆)", "(#･∀･)", "(-_-;)", "(~_~;)",
            "(-.-;)", "(=_=;)", "(~O~;)", "(=o=;)",
            "(-_-メ)", "(~_~メ)", "(^_^メ)", "(ー_ー;)",
            "(；一_一)", "((+_+))", "(# ﾟДﾟ)", "( ´Д｀)=3",
            "(๑`^´๑)۶", "(๑òωó๑)۶",
        ),
        Category("(･∀･)") to arrayOf(
            "(⌒▽⌒)", "（￣▽￣）", "(=・ω・=)", "(｀・ω・´)",
            "(〜￣△￣)〜", "(･∀･)", "(°∀°)ﾉ", "(￣3￣)",
            "╮(￣▽￣)╭", "_(:3」∠)_", "( ´_ゝ｀)", "←_←",
            "→_→", "(<_<)", "(>_>)", "(;¬_¬)",
            "(\"▔□▔)/", "(ﾟДﾟ≡ﾟдﾟ)!?", "Σ(ﾟдﾟ;)", "Σ( ￣□￣||)",
            "(´；ω；`)", "（/TДT)/", "(^・ω・^ )", "(｡･ω･｡)",
            "(●￣(ｴ)￣●)", "ε=ε=(ノ≧∇≦)ノ", "(´･_･`)", "(-_-#)",
            "（￣へ￣）", "(￣ε(#￣) Σ", "ヽ(`Д´)ﾉ", "（#-_-)┯━┯",
            "(╯°口°)╯(┴—┴", "←◡←", "( ♥д♥)", "Σ>―(〃°ω°〃)♡→",
            "⁄(⁄ ⁄•⁄ω⁄•⁄ ⁄)⁄", "(╬ﾟдﾟ)▄︻┻┳═一", "･*･:≡(　ε:)"
        )
    )
}
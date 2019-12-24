package personal.secminhr.androidmark.mark

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import org.commonmark.node.Text
import personal.secminhr.androidmark.view.AMTextView

class TextMark(context: Context, override val node: Text): Mark(context) {

    val literal: String
        get() = node.literal

    override fun render(layout: View) {
        check(layout is AMTextView) { "TextMark must be rendered inside a AndroidMarkTextView" }
        val startIndex = layout.text.length
        val text = SpannableString("${layout.text}$literal")
        val typeface = getTypeface(layout.shouldUseBold, layout.shouldUseItalic)
        val styleSpan = StyleSpan(typeface)
        text.setSpan(styleSpan, startIndex, text.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        layout.text = text
        layout.shouldUseBold = false
        layout.shouldUseItalic = false
    }

    private fun getTypeface(bold: Boolean, italic: Boolean): Int {
        return when {
            bold and italic -> {
                Typeface.BOLD_ITALIC
            }
            italic -> {
                Typeface.ITALIC
            }
            bold -> {
                Typeface.BOLD
            }
            else -> {
                Typeface.NORMAL
            }
        }
    }
}
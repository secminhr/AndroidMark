package personal.secminhr.androidmark.mark

import android.content.Context
import android.graphics.Typeface
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import org.commonmark.node.Emphasis
import personal.secminhr.androidmark.holder.Holder
import personal.secminhr.androidmark.holder.TextHolder

class EmphasisMark(context: Context, override val node: Emphasis): Mark(context) {
    private val textView = TextView(context)
    override val holder: Holder<in Mark> = TextHolder(textView) as Holder<in Mark>

    override fun holdChild(element: Mark) {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        holder.holds(element)
    }

    override fun getView(): View? {
        return textView
    }

}
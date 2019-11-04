package personal.secminhr.androidmark.mark

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import org.commonmark.node.Heading
import personal.secminhr.androidmark.holder.Holder
import personal.secminhr.androidmark.holder.TextHolder

class HeadingMark(context: Context, override val node: Heading): Mark(context) {
    private val textView = TextView(context)
    override val holder: Holder<in Mark> = TextHolder(textView) as Holder<in Mark>

    private val sizeMap = mapOf(
        1 to 80f,
        2 to 60f,
        3 to 48f,
        4 to 34f,
        5 to 24f,
        6 to 20f
    )
    override fun holdChild(element: Mark) {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeMap[node.level]!!)
        textView.setTextColor(Color.BLACK)
        holder.holds(element)
    }

    override fun getView(): View? {
        return textView
    }
}
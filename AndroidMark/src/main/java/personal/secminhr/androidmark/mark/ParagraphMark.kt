package personal.secminhr.androidmark.mark

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import org.commonmark.node.Node
import personal.secminhr.androidmark.holder.Holder
import personal.secminhr.androidmark.holder.TextHolder

class ParagraphMark(context: Context, override val node: Node): Mark(context) {
    private val textView = TextView(context)
    override val holder: Holder<in Mark> = TextHolder(textView) as Holder<in Mark>

    override fun holdChild(element: Mark) {
        when(element) {
            is TextMark -> {
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
                holder.holds(element)
            }
        }
    }

    override fun getView(): View? {
        return holder.getView()
    }
}
package personal.secminhr.androidmark.mark

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import org.commonmark.node.Node
import personal.secminhr.androidmark.view.AMTextView

class ParagraphMark(context: Context, override val node: Node): WithChildrenMark(context) {
    private val textView = AMTextView(context)

    init {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
    }

    override fun render(layout: View) {
        check(layout is LinearLayout) { "ParagraphMark must be rendered inside a LinearLayout" }
        var child = firstChild
        while(child != null) {
            child.render(textView)
            child = child.next
        }
        layout.addView(textView)
    }
}
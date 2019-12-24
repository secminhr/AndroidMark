package personal.secminhr.androidmark.mark

import android.content.Context
import android.view.View
import android.widget.TextView
import org.commonmark.node.SoftLineBreak

class SoftLineBreakMark(context: Context, override val node: SoftLineBreak): Mark(context) {
    override fun render(layout: View) {
        check(layout is TextView) { "SoftLineBreakMark must be rendered inside a TextView" }
        var originalText = layout.text
        layout.text = "$originalText "
    }
}
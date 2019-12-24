package personal.secminhr.androidmark.mark

import android.content.Context
import android.view.View
import android.widget.TextView
import org.commonmark.node.HardLineBreak

class HardLineBreakMark(context: Context, override val node: HardLineBreak): Mark(context) {
    override fun render(layout: View) {
        check(layout is TextView) { "HardLineBreakMark must be rendered inside a TextView" }
        layout.text = "${layout.text}\n"
    }

}
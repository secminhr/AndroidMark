package personal.secminhr.androidmark.mark

import android.content.Context
import android.view.View
import org.commonmark.node.StrongEmphasis
import personal.secminhr.androidmark.view.AMTextView

class StrongEmphasisMark(context: Context, override val node: StrongEmphasis): WithChildrenMark(context) {

    override fun render(layout: View) {
        check(layout is AMTextView) { "StrongEmphasisMark must be rendered inside a AndroidMarkTextView" }
        layout.shouldUseBold = true

        var child = firstChild
        while(child != null) {
            child.render(layout)
            child = child.next
        }
    }
}
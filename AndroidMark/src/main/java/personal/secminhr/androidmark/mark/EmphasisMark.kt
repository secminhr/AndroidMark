package personal.secminhr.androidmark.mark

import android.content.Context
import android.view.View
import org.commonmark.node.Emphasis
import personal.secminhr.androidmark.view.AMTextView

class EmphasisMark(context: Context, override val node: Emphasis): WithChildrenMark(context) {
    override fun render(layout: View) {
        check(layout is AMTextView) { "EmphasisMark must be rendered inside a AndroidMarkTextView" }
        layout.shouldUseItalic = true

        var child = firstChild
        while(child != null) {
            child.render(layout)
            child = child.next
        }
    }

}
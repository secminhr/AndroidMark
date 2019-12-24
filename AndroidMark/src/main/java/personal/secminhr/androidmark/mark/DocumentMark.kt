package personal.secminhr.androidmark.mark

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import org.commonmark.node.Document

class DocumentMark(context: Context, override var node: Document): WithChildrenMark(context) {
    private val layout = LinearLayout(context)

    init {
        layout.orientation = LinearLayout.VERTICAL
    }

    override fun render(layout: View) {
        check(layout is LinearLayout) { "DocumentMark must be rendered inside a LinearLayout" }
        var child = firstChild
        while(child != null) {
            child.render(layout)
            child = child.next
        }
        layout.addView(this.layout)
    }
}
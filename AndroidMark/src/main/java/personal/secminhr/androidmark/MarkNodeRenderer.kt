package personal.secminhr.androidmark

import android.content.Context
import android.widget.LinearLayout
import org.commonmark.node.Node

interface MarkNodeRenderer {
    fun render(node: Node, parent: LinearLayout, context: Context)
}
package personal.secminhr.androidmark

import android.content.Context
import android.widget.LinearLayout
import org.commonmark.node.Node

fun Node.use(renderer: MarkNodeRenderer): SelectedRenderer {
    return SelectedRenderer(this, renderer)
}

class SelectedRenderer(private val node: Node, private val renderer: MarkNodeRenderer) {
    fun toRenderIn(viewParent: LinearLayout, context: Context) {
        renderer.render(node, viewParent, context)
    }
}

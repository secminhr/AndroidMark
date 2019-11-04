package personal.secminhr.androidmark

import android.content.Context
import android.widget.LinearLayout
import org.commonmark.node.Node
import org.commonmark.parser.Parser

class AndroidMark {
    fun parse(text: String): Node {
        val parser = Parser.builder().build()
        return parser.parse(text)
    }

    fun render(node: Node, parent: LinearLayout, context: Context) {
        val renderer = AndroidMarkRenderer.builder().build()
        renderer.render(node, parent, context)
    }

    fun render(text: String, parent: LinearLayout, context: Context) {
        render(parse(text), parent, context)
    }
}
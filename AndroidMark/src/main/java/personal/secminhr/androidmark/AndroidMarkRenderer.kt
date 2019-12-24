package personal.secminhr.androidmark

import android.content.Context
import android.widget.LinearLayout
import org.commonmark.node.*
import personal.secminhr.androidmark.mark.*

class AndroidMarkRenderer private constructor(val builder: Builder) {

    fun render(node: Node, parent: LinearLayout, context: Context) {
        val mark = nodeToMark(node, context)
        renderMark(mark, parent)
    }

    private fun nodeToMark(node: Node, context: Context): Mark {
        val map = mapOf(
            Text::class.java.simpleName to TextMark::class,
            Document::class.java.simpleName to DocumentMark::class,
            Paragraph::class.java.simpleName to ParagraphMark::class,
            SoftLineBreak::class.java.simpleName to SoftLineBreakMark::class,
            HardLineBreak::class.java.simpleName to HardLineBreakMark::class,
            Emphasis::class.java.simpleName to EmphasisMark::class,
            StrongEmphasis::class.java.simpleName to StrongEmphasisMark::class
        )
        val k = map[node::class.java.simpleName]
        val mark = k?.constructors?.first()?.call(context, node)!!
        if(mark is WithChildrenMark) {
            traverseChildren(node) { child ->
                val m = nodeToMark(child, context)
                mark.appendChild(m)
            }
        }
        return mark
    }

    private fun traverseChildren(parent: Node, traversal: (Node) -> Unit) {
        var currentNode = parent.firstChild
        while(currentNode != null) {
            traversal(currentNode)
            currentNode = currentNode.next
        }
    }

    private fun renderMark(mark: Mark, parent: LinearLayout) {
        mark.render(parent)
    }

    companion object {
        @JvmStatic fun builder(): Builder {
            val builder = Builder()
            return builder
        }
    }

    class Builder {

        fun build(): AndroidMarkRenderer {
            return AndroidMarkRenderer(this)
        }
    }
}
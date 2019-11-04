package personal.secminhr.androidmark

import android.content.Context
import android.widget.LinearLayout
import org.commonmark.node.*
import personal.secminhr.androidmark.mark.*

class AndroidMarkRenderer private constructor(val builder: Builder) {

    fun render(node: Node, parent: LinearLayout, context: Context) {
        val mark = nodeToMark(node, context)
        holdMark(mark)
        parent.addView(mark.getView())
    }

    private fun nodeToMark(node: Node, context: Context): Mark {
        val map = mapOf(
            Text::class.java.simpleName to TextMark::class,
            Heading::class.java.simpleName to HeadingMark::class,
            Document::class.java.simpleName to DocumentMark::class,
            Paragraph::class.java.simpleName to ParagraphMark::class,
            BulletList::class.java.simpleName to BulletListMark::class,
            ListItem::class.java.simpleName to ListItemMark::class
        )
        val k = map[node::class.java.simpleName]
        val mark = k?.constructors?.first()?.call(context, node)!!
        return if(node.firstChild == null) {
            mark
        } else {
            var currentNode = node.firstChild
            while(currentNode != null) {
                val m = nodeToMark(currentNode, context)
                mark.appendChild(m)
                currentNode = currentNode.next
            }
            mark
        }
    }

    private fun holdMark(mark: Mark) {
        mark.holdSelf()
        val m = mark.firstChild
        m?.let {
            var currentMark: Mark? = it
            while(currentMark != null) {
                holdMark(currentMark)
                currentMark = currentMark.next
            }
        }
    }

    companion object {
        @JvmStatic fun builder(): Builder {
            val builder = Builder()
            builder.addRenderer(setOf(

            ))
            return builder
        }
    }

    class Builder {

        val map = mutableMapOf<Class<out Node>, MarkNodeRenderer>()

        fun addRenderer(node: Class<out Node>, renderer: MarkNodeRenderer): Builder {
            map += node to renderer
            return this
        }

        fun addRenderer(rendererSet: Set<Pair<Class<out Node>, MarkNodeRenderer>>): Builder {
            map += rendererSet
            return this
        }

        fun build(): AndroidMarkRenderer {
            return AndroidMarkRenderer(this)
        }
    }
}
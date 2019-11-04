package personal.secminhr.androidmark.mark

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import org.commonmark.node.ListItem
import personal.secminhr.androidmark.holder.Holder
import personal.secminhr.androidmark.holder.ParagraphHolder

class ListItemMark(context: Context, override val node: ListItem): Mark(context) {
    private val layout = LinearLayout(context)
    override val holder: Holder<in Mark> = ParagraphHolder(layout) as Holder<in Mark>

    init {
        layout.orientation = LinearLayout.VERTICAL
    }

    override fun holdChild(element: Mark) {
        holder.holds(element)
    }

    override fun getView(): View? {
        return holder.getView()
    }
}
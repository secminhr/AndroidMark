package personal.secminhr.androidmark.mark

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import org.commonmark.node.BulletList
import personal.secminhr.androidmark.holder.Holder
import personal.secminhr.androidmark.holder.ListItemHolder

class BulletListMark(context: Context, override val node: BulletList) : Mark(context) {
    private val layout = LinearLayout(context)
    override val holder: Holder<in Mark> = ListItemHolder(layout) as Holder<in Mark>

    init {
        layout.orientation = LinearLayout.VERTICAL
    }

    override fun holdChild(element: Mark) {
        holder.holds(element)
    }

    override fun getView(): View? {
        return layout
    }
}
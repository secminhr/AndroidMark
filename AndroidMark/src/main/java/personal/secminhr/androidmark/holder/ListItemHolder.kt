package personal.secminhr.androidmark.holder

import android.view.View
import android.widget.LinearLayout
import personal.secminhr.androidmark.mark.ListItemMark
import personal.secminhr.androidmark.view.BulletPointView

class ListItemHolder(private val layout: LinearLayout): Holder<ListItemMark> {

    override fun holds(element: ListItemMark) {
        val row = LinearLayout(layout.context)
        row.orientation = LinearLayout.HORIZONTAL
        row.addView(BulletPointView(row.context))
        row.addView(element.getView())
        layout.addView(row)
    }

    override fun getView(): View? {
        return layout
    }
}
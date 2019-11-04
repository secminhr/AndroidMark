package personal.secminhr.androidmark.mark

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import org.commonmark.node.Document
import personal.secminhr.androidmark.holder.AnyMarkHolder
import personal.secminhr.androidmark.holder.Holder

class DocumentMark(context: Context, override var node: Document): Mark(context) {
    private val layout = LinearLayout(context)
    override var holder: Holder<in Mark> = AnyMarkHolder(layout)

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
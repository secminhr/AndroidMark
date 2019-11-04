package personal.secminhr.androidmark.mark

import android.content.Context
import android.view.View
import org.commonmark.node.Text
import personal.secminhr.androidmark.holder.EmptyHolder
import personal.secminhr.androidmark.holder.Holder

class TextMark(context: Context, override val node: Text): Mark(context) {
    override var holder: Holder<in Mark> = EmptyHolder()

    val literal: String
        get() = node.literal

    override fun holdChild(element: Mark) {
        holder.holds(element)
    }

    override fun getView(): View? {
        return holder.getView()
    }

}
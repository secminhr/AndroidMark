package personal.secminhr.androidmark.mark

import android.content.Context
import android.view.View
import org.commonmark.node.Node

abstract class Mark(val context: Context) {
    //region info about this mark
    abstract val node: Node
    var parent: Mark? = null
    var next: Mark? = null
    val lastSibling: Mark
        get() {
            var m = this
            while(m.next != null) {
                m = m.next!!
            }
            return m
        }
    //endregion

    //region required function
    abstract fun render(layout: View)
    //endregion
}
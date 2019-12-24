package personal.secminhr.androidmark.mark

import android.content.Context

abstract class WithChildrenMark(context: Context): Mark(context) {
    var firstChild: Mark? = null
    fun appendChild(mark: Mark) {
        if(firstChild == null) {
            firstChild = mark
        } else {
            firstChild!!.lastSibling.next = mark
        }
        mark.parent = this
    }
}
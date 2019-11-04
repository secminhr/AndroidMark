package personal.secminhr.androidmark.mark

import android.content.Context
import android.view.View
import org.commonmark.node.Node
import personal.secminhr.androidmark.holder.Holder

abstract class Mark(protected val context: Context) {
    protected abstract val holder: Holder<in Mark>
    abstract val node: Node
    abstract fun holdChild(element: Mark)
    abstract fun getView(): View?


    private var _firstChild: Mark? = null
    val firstChild: Mark?
        get() {
            return _firstChild
        }
    var next: Mark? = null
    var parent: Mark? = null


    fun appendChild(mark: Mark) {
        if(_firstChild == null) {
            _firstChild = mark
        } else {
            var current = _firstChild
            while(current!!.next != null) {
                current = current.next
            }
            current.next = mark
        }
        mark.parent = this
    }

    fun holdSelf() {
        parent?.holdChild(this)
    }
}
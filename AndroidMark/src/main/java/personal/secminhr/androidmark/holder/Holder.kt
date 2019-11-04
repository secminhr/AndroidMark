package personal.secminhr.androidmark.holder

import android.view.View
import personal.secminhr.androidmark.mark.Mark

interface Holder<T: Mark> {
    fun holds(element: T)
    fun getView(): View?
}
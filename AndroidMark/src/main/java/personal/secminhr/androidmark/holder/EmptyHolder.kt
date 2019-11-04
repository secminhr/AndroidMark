package personal.secminhr.androidmark.holder

import android.view.View
import personal.secminhr.androidmark.mark.Mark

class EmptyHolder: Holder<Mark> {
    override fun getView(): View? {
        return null
    }

    override fun holds(element: Mark) {
        //do nothing since it is empty
    }

}
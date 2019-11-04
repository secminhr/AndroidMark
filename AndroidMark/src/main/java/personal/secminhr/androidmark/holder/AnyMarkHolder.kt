package personal.secminhr.androidmark.holder

import android.view.View
import android.widget.LinearLayout
import personal.secminhr.androidmark.mark.Mark

class AnyMarkHolder(private val layout: LinearLayout): Holder<Mark> {

    override fun getView(): View {
        return layout
    }

    override fun holds(element: Mark) {
        layout.addView(element.getView())
    }
}
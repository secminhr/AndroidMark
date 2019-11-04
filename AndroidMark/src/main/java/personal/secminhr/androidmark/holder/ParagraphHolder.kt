package personal.secminhr.androidmark.holder

import android.view.View
import android.widget.LinearLayout
import personal.secminhr.androidmark.mark.ParagraphMark

class ParagraphHolder(private val layout: LinearLayout): Holder<ParagraphMark> {

    override fun holds(element: ParagraphMark) {
        layout.addView(element.getView())
    }

    override fun getView(): View? {
        return layout
    }
}
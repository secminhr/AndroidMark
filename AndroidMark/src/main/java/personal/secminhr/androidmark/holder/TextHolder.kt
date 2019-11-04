package personal.secminhr.androidmark.holder

import android.graphics.Color
import android.view.View
import android.widget.TextView
import personal.secminhr.androidmark.mark.TextMark

class TextHolder(private val textView: TextView): Holder<TextMark> {
    override fun getView(): View? {
        return textView
    }

    override fun holds(element: TextMark) {
        textView.setTextColor(Color.BLACK)
        textView.text = element.literal
    }

}
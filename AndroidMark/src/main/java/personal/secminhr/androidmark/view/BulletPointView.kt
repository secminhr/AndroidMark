package personal.secminhr.androidmark.view

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.view.Gravity
import android.widget.TextView
import personal.secminhr.androidmark.span.CustomBulletSpan

class BulletPointView(context: Context): TextView(context) {
    init {
        val string = SpannableString("")
        val bullet = CustomBulletSpan(40, Color.BLACK, 20f)
        string.setSpan(bullet, 0, 0, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        this.text = string
//        this.textAlignment = TEXT_ALIGNMENT_CENTER
        this.gravity = Gravity.CENTER
    }
}
package personal.secminhr.androidmark.span

import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.Spanned
import android.text.style.BulletSpan

class CustomBulletSpan(gapWidth: Int, private val cColor: Int, private val cBulletR: Float): BulletSpan(gapWidth, cColor) {
    override fun drawLeadingMargin(
        canvas: Canvas,
        paint: Paint,
        x: Int,
        dir: Int,
        top: Int,
        baseline: Int,
        bottom: Int,
        text: CharSequence,
        start: Int,
        end: Int,
        first: Boolean,
        layout: Layout?
    ) {
        if ((text as Spanned).getSpanStart(this) == start) {
            val style = paint.style
            val oldcolor = paint.color
            paint.color = cColor
            paint.style = Paint.Style.FILL
            val yPosition = (top + bottom) / 2f
            val xPosition = (x + dir * cBulletR)
            canvas.drawCircle(xPosition, yPosition, cBulletR, paint)
            paint.color = oldcolor
            paint.style = style
        }
    }
}
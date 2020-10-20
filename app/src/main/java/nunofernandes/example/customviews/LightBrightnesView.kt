package nunofernandes.example.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi

class LightBrightnesView: View {

    var touchY = 0F

    constructor(context: Context?) : super(context){
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    {
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
            context,
            attrs,
            defStyleAttr
    ){
        init()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
            context: Context?,
            attrs: AttributeSet?,
            defStyleAttr: Int,
            defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    fun init(){

    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()

        paint.color = Color.BLUE
        paint.strokeWidth = 30F
        paint.style = Paint.Style.STROKE

        val rect = Rect(100, 100, width-100, height-100)
        canvas?.drawRect(rect, paint)

        paint.color = Color.RED
        paint.style = Paint.Style.FILL

        val rectInside = Rect(115, touchY.toInt(), width-115, height-115)
        canvas?.drawRect(rectInside, paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val y = event?.y
        when(event?.action){
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                touchY = y?:0F
                invalidate()
            }
        }
        return true
    }
}
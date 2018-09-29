package com.deanxd.taxiform.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class LineTextView extends AppCompatTextView {

    private Paint mPaint;
    private PointF pointStart;
    private PointF pointEnd;

    public LineTextView(Context context) {
        super(context);
        initView(context);
    }

    public LineTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LineTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#999999"));
        mPaint.setStrokeWidth(2);

        pointStart = new PointF();
        pointEnd = new PointF();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();

        pointStart.x = 0;
        pointStart.y = measuredHeight / 2;

        pointEnd.x = measuredWidth;
        pointEnd.y = measuredHeight / 2;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y, mPaint);
    }
}

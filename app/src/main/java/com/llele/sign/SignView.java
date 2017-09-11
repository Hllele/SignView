package com.llele.sign;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
/**
 * Author： huanglele on 2017/9/11.
 */

public class SignView extends View {

    private static final String TAG = "SignView";
    private Paint onePaint;
    private Paint twoPaint;
    private Paint threePaint;
    private Paint roundPaint;
    private Paint text1;
    private Paint text2;
    private Paint text3;
    private Paint text4;
    private Paint bitmapPaint;
    private Paint integralPaint;
    private float radius;
    private int centerX;
    private int centerY;
    private int signDays = 0;
    private int signScore = 0;

    public SignView(Context context) {
        super(context);
    }

    public SignView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onePaint = new Paint();
        onePaint.setColor(getResources().getColor(R.color.oneColor));
        onePaint.setAntiAlias(true);
        onePaint.setStyle(Paint.Style.FILL);

        twoPaint = new Paint();
        twoPaint.setColor(getResources().getColor(R.color.twoColor));
        twoPaint.setAntiAlias(true);
        twoPaint.setStyle(Paint.Style.FILL);

        threePaint = new Paint();
        threePaint.setColor(getResources().getColor(R.color.threeColor));
        threePaint.setAntiAlias(true);
        threePaint.setStyle(Paint.Style.FILL);

        roundPaint = new Paint();
        roundPaint.setColor(getResources().getColor(R.color.roundColor));
        roundPaint.setAntiAlias(true);
        roundPaint.setStyle(Paint.Style.FILL);

        text1 = new Paint();
        text1.setTextSize(36);
        text1.setColor(Color.WHITE);
        text1.setAntiAlias(true);
        text1.setStyle(Paint.Style.FILL);
        text1.setTextAlign(Paint.Align.CENTER);

        text2 = new Paint();
        text2.setTextSize(36);
        text2.setColor(Color.WHITE);
        text2.setAntiAlias(true);
        text2.setStyle(Paint.Style.FILL);

        text3 = new Paint();
        text3.setTextSize(100);
        text3.setColor(getResources().getColor(R.color.signDaysColor));
        text3.setAntiAlias(true);
        text3.setStyle(Paint.Style.FILL);
        text3.setTextAlign(Paint.Align.CENTER);

        text4 = new Paint();
        text4.setTextSize(40);
        text4.setAntiAlias(true);
        text4.setColor(Color.WHITE);
        text4.setAntiAlias(true);
        text4.setStyle(Paint.Style.FILL);

        bitmapPaint = new Paint();
        bitmapPaint.setColor(getResources().getColor(R.color.white));
        bitmapPaint.setAntiAlias(true);
        bitmapPaint.setStyle(Paint.Style.FILL);

        integralPaint = new Paint();
        integralPaint.setColor(Color.WHITE);
        integralPaint.setAntiAlias(true);
        integralPaint.setStyle(Paint.Style.FILL);
        integralPaint.setTextSize(52);
        integralPaint.setTextAlign(Paint.Align.CENTER);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        radius = Math.min(h,w)*0.4f;
        centerX = w/2;
        centerY = h/2;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(centerX,centerY,radius, onePaint);
        canvas.drawCircle(centerX,centerY,radius-40,twoPaint);
        canvas.drawCircle(centerX,centerY,radius-80,threePaint);
        canvas.drawText(""+getResources().getString(R.string.sign_1),centerX,centerY-40,text1);
        RectF rect = new RectF(centerX-(int) radius,centerY+radius-100,centerX+(int) radius,centerY+(int) radius);
        canvas.drawRoundRect(rect,55,55,roundPaint);
        if (signDays<10){
            canvas.drawText(""+getResources().getString(R.string.sign_2),centerX+50,centerY+70,text2);
        }else if (signDays >9 && signDays <100){
            canvas.drawText(""+getResources().getString(R.string.sign_2),centerX+70,centerY+70,text2);
        }else if (signDays>99 && signDays <1000){
            canvas.drawText(""+getResources().getString(R.string.sign_2),centerX+90,centerY+70,text2);
        }else {
            canvas.drawText(""+getResources().getString(R.string.sign_2),centerX+110,centerY+70,text2);
        }
        canvas.drawText(""+signDays,centerX,centerY+70,text3);
        Bitmap bm = BitmapFactory.decodeResource(MyApplication.getContext().getResources(),R.mipmap.coin);
        canvas.drawBitmap(bm,centerX-140,centerY+radius-80,bitmapPaint);
        bm.recycle();
        canvas.drawText(""+signScore,centerX,centerY+radius-30,integralPaint);
        if (signScore<10){
            canvas.drawText(getResources().getString(R.string.sign_3),centerX+30,centerY+radius-30,text4);
        }else if (signScore>9 && signScore <100){
            canvas.drawText(getResources().getString(R.string.sign_3),centerX+50,centerY+radius-30,text4);
        }else {
            canvas.drawText(getResources().getString(R.string.sign_3),centerX+70,centerY+radius-30,text4);
        }


    }

    public void setSignDay(int signDays){
        this.signDays = signDays;
        invalidate();
    }

    public void setSignScore(int score){
        this.signScore = score;
        invalidate();
    }
}

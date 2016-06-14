package com.example.dell.myapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.util.AttributeSet;
import android.view.View;

import java.io.InputStream;

/**
 * Created by DELL on 6/10/2016.
 */
public class GifView extends View {
    public Movie mMovie1;
    public Movie mMovie2;
    public Movie mMovie3;
    public Movie mMovie4;
    public long movieStart1;
    public long movieStart2;
    public long movieStart3;
    public long movieStart4;

    public GifView(Context context) {
        super(context);
        initializeView();
    }

    public GifView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView();
    }

    public GifView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeView();
    }

    private void initializeView() {
//R.drawable.loader - our animated GIF
        InputStream is1 = getContext().getResources().openRawResource(+R.drawable.congratulations);
        mMovie1 = Movie.decodeStream(is1);
        InputStream is2 = getContext().getResources().openRawResource(+R.drawable.giffy3);
        mMovie2 = Movie.decodeStream(is2);
        InputStream is3 = getContext().getResources().openRawResource(+R.drawable.giffy4);
        mMovie3 = Movie.decodeStream(is1);
        InputStream is4 = getContext().getResources().openRawResource(+R.drawable.giphy1);
        mMovie4 = Movie.decodeStream(is4);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.TRANSPARENT);
        super.onDraw(canvas);
        long now = android.os.SystemClock.uptimeMillis();
        if (movieStart1 == 0) {
            movieStart1 = now;
        }


        if (mMovie1 != null) {
            int relTime1 = (int) ((now - movieStart1) % mMovie1.duration());

            mMovie1.setTime(relTime1);

            mMovie1.draw(canvas, getWidth() - mMovie1.width(), getHeight() - mMovie1.height());

            this.invalidate();

        }
    }


    int gifId;

    public void setGIFResource(int resId) {
        this.gifId = resId;
        initializeView();
    }

    public int getGIFResource() {
        return this.gifId;
    }
}
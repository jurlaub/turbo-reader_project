package com.example.xyzreader.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import com.android.volley.toolbox.NetworkImageView;

public class DynamicHeightNetworkImageView extends NetworkImageView {
    private final String LOG_TAG = getClass().getSimpleName();
    private float mAspectRatio = 1.5f;

    public DynamicHeightNetworkImageView(Context context) {
        super(context);
        Log.v(LOG_TAG, "DynamicHeightNetworkImageView Constructor");
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.v(LOG_TAG, "DynamicHeightNetworkImageView Constructor");
    }

    public DynamicHeightNetworkImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Log.v(LOG_TAG, "DynamicHeightNetworkImageView Constructor");
    }

    public void setAspectRatio(float aspectRatio) {
        Log.v(LOG_TAG, "setAspectRatio ");

        mAspectRatio = aspectRatio;
        requestLayout();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.v(LOG_TAG, "onMeasure ");
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float calcHeight = measuredWidth / mAspectRatio;
        int forcedIntHeight = (int)calcHeight;
        Log.v(LOG_TAG, "float height: " + calcHeight + " --- measured (" + measuredWidth + "w  x " + measuredHeight + "h)  --? (" + measuredWidth + "w  x  " + forcedIntHeight + " h)");

        setMeasuredDimension(measuredWidth, forcedIntHeight);

//        setMeasuredDimension(measuredWidth, measuredHeight);


//        int measuredWidth = getMeasuredWidth();
//        int measuredHeight = getMeasuredHeight();
//
//        float calcWidth = measuredHeight / mAspectRatio;
//
//
////        float calcHeight = measuredWidth / mAspectRatio;
////        int forcedIntHeight = (int)calcHeight;
//        int forcedIntWidth = (int)calcWidth;
//
//        Log.v(LOG_TAG, "float height: " + calcWidth + " --- measured (" + measuredWidth + "w  x " + measuredHeight + "h)  --? (" + measuredWidth + "w  x  " + forcedIntWidth + " h)" );
//
//        setMeasuredDimension(forcedIntWidth, measuredHeight);





    }



}

package com.got3.yibook;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Implementation of App Widget functionality.
 */
public class HeadView extends FrameLayout {

    private ImageView imgHeadLeft;
    private ImageView imgHeadNotice;
    private TextView tvHeadCenter, tvHeadCenterIndex;
    private ImageView imgHeadCenter;
    private TextView tvHeadRight;
    private ImageView imgHeadRight;
    private RelativeLayout rlHeadRight, rlHeadLeft;

    public HeadView(Context context) {
        super(context);
        init(context);
    }

    public HeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.head_view, this, true);
     //   imgHeadLeft = (ImageView) findViewById(com.got3.yibook.R.id.img_head_left);
    //    imgHeadNotice = (ImageView) findViewById(com.got3.yibook.R.id.img_head_notice);
       // tvHeadCenter = (TextView) findViewById(com.got3.yibook.R.id.tv_head_center);
        imgHeadCenter = (ImageView) findViewById(com.got3.yibook.R.id.img_head_center);
     //   tvHeadRight = (TextView) findViewById(com.got3.yibook.R.id.tv_head_right);
     //   imgHeadRight = (ImageView) findViewById(com.got3.yibook.R.id.img_head_right);
        rlHeadRight = (RelativeLayout) findViewById(com.got3.yibook.R.id.relative_head_right);
        rlHeadLeft = (RelativeLayout) findViewById(com.got3.yibook.R.id.relative_head_left);

        rlHeadLeft.setOnClickListener(onClickListener);
        rlHeadRight.setOnClickListener(onClickListener);
    }

    OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case com.got3.yibook.R.id.relative_head_left:
                    if (headViewListener != null) {
                        headViewListener.onClickLeft();
                    }
                    break;
                case com.got3.yibook.R.id.relative_head_right:
                    if (headViewListener != null) {
                        headViewListener.onClickRight();
                    }
                    break;
            }
        }
    };

    public void showLine(boolean isShow) {
        findViewById(R.id.view_line).setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public void showHeadLeft(boolean isShow) {
        rlHeadLeft.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public void showNotice(boolean isShow) {
        if (isShow) {
            showHeadLeft(isShow);
        }
        imgHeadNotice.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public void setHeadLeftImg(int rId) {
        showHeadLeft(true);
        imgHeadLeft.setImageResource(rId);
    }


    public void setHeadCenterText(String text, boolean isIndex) {
        imgHeadCenter.setVisibility(View.GONE);
        if (isIndex) {
            tvHeadCenter.setVisibility(GONE);
            tvHeadCenterIndex.setText(text);
            tvHeadCenterIndex.setVisibility(View.VISIBLE);
            Typeface typeFace = Typeface.createFromAsset(getContext().getAssets(), "fonts/headCenterTextFont.ttf");
            tvHeadCenterIndex.setTypeface(typeFace);
        } else {
            tvHeadCenterIndex.setVisibility(GONE);
            tvHeadCenter.setText(text);
            tvHeadCenter.setVisibility(View.VISIBLE);
        }
    }

    public void setHeadCenterImg(int rId) {
        imgHeadCenter.setImageResource(rId);
        tvHeadCenter.setVisibility(View.GONE);
        tvHeadCenterIndex.setVisibility(View.GONE);
        imgHeadCenter.setVisibility(View.VISIBLE);
    }

    public void showHeadRight(boolean isShow) {
        rlHeadRight.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public void setHeadRightText(String text) {
        showHeadRight(true);
        tvHeadRight.setText(text);
        imgHeadRight.setVisibility(View.GONE);
        tvHeadRight.setVisibility(View.VISIBLE);
    }

    public void setHeadRightImg(int rId) {
        showHeadRight(true);
        imgHeadRight.setImageResource(rId);
        tvHeadRight.setVisibility(View.GONE);
        imgHeadRight.setVisibility(View.VISIBLE);
    }

    private HeadViewListener headViewListener;

    public void setHeadViewListener(HeadViewListener headViewListener) {
        this.headViewListener = headViewListener;
    }

    public interface HeadViewListener {
        public void onClickLeft();

        public void onClickRight();
    }
}


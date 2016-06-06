package com.yuyh.cavaliers.ui.listener;

import android.view.View;

import java.util.Calendar;

/**
 * 防止重复点击的点击监听
 * Created by Kyrie.Y on 2016/6/6.
 */
public abstract class NoDoubleClickListener implements View.OnClickListener {

    public static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }

    protected abstract void onNoDoubleClick(View view);
}

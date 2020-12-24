package com.onedream.androidxdemo.framework.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getName();
    protected Context mContext;
    protected Bundle mSavedInstanceState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //
        mContext = this;
        mSavedInstanceState = savedInstanceState;
        initView();
        initData();
        initEvent();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }


    //设置布局ID
    public abstract int getLayoutId();

    //初始化视图操作
    public abstract void initView();

    //初始化数据操作
    public abstract void initData();

    //初始化监听事件操作
    public abstract void initEvent();


    public boolean verifyTopActivity() {
        android.app.ActivityManager manager = (android.app.ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
        String name = manager.getRunningTasks(1).get(0).topActivity.getClassName();
        return name.equals(getClass().getName());
    }
}

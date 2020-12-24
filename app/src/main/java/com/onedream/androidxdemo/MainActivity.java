package com.onedream.androidxdemo;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.onedream.androidxdemo.framework.base.BaseActivity;
import com.onedream.androidxdemo.module.home.random_poetry.RandomPoetryActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RandomPoetryActivity.actionStart(mContext);
            }
        });

    }



    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}

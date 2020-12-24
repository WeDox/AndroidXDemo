package com.onedream.androidxdemo.framework.http.support;


import com.onedream.androidxdemo.framework.utils.system.LogHelper;

public class Logger implements LoggingInterceptor.Logger {

    @Override
    public void log(String message) {
        LogHelper.e("ATU Logger", "http : " + message);
    }
}

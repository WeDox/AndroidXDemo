package com.onedream.androidxdemo.framework.utils.system;

import android.util.Log;

import com.onedream.androidxdemo.BuildConfig;

/**
 * @author jdallen
 * @since 2015/4/30
 */
public class LogHelper {

    private static final boolean IS_DEBUG = BuildConfig.DEBUG;

    public static void i(String tag, String msg) {
        if (IS_DEBUG) {
            Log.i(tag, null == msg ? "" : msg);
        }
    }

    public static void v(String tag, String msg) {
        if (IS_DEBUG) {
            Log.v(tag, null == msg ? "" : msg);
        }
    }

    public static void d(String tag, String msg) {
        if (IS_DEBUG) {
            Log.d(tag, null == msg ? "" : msg);
        }
    }

    public static void w(String tag, String msg) {
        if (IS_DEBUG) {
            Log.w(tag, null == msg ? "" : msg);
        }
    }

    public static void e(String tag, String msg) {
        if (IS_DEBUG) {
            Log.e(tag, null == msg ? "" : msg);
        }
    }
}

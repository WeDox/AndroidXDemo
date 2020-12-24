package com.onedream.androidxdemo.framework.utils.json_parse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 原生Json解析工具类
 *
 * @author jdallen
 * @since 2020/7/22
 */
public class OriginJsonParseUtils {
    //Int
    public static int getInt(JSONObject object, String keyName) throws JSONException {
        return getInt(object, keyName, 0);
    }

    public static int getInt(JSONObject object, String keyName, int defaultValue) throws JSONException {
        return object.has(keyName) ? object.getInt(keyName) : defaultValue;
    }

    //Long
    public static long getLong(JSONObject object, String keyName) throws JSONException {
        return getLong(object, keyName, 0);
    }

    public static long getLong(JSONObject object, String keyName, long defaultValue) throws JSONException {
        return object.has(keyName) ? object.getLong(keyName) : defaultValue;
    }

    //Double
    public static double getDouble(JSONObject object, String keyName) throws JSONException {
        return getDouble(object, keyName, 0);
    }

    public static double getDouble(JSONObject object, String keyName, double defaultValue) throws JSONException {
        return object.has(keyName) ? object.getDouble(keyName) : defaultValue;
    }

    //String
    public static String getString(JSONObject object, String keyName) throws JSONException {
        return getString(object, keyName, "");
    }

    public static String getString(JSONObject object, String keyName, String defaultValue) throws JSONException {
        return object.has(keyName) ? object.getString(keyName) : defaultValue;
    }

    //Boolean
    public static boolean getBoolean(JSONObject object, String keyName) throws JSONException {
        return getBoolean(object, keyName, false);
    }

    public static boolean getBoolean(JSONObject object, String keyName, boolean defaultValue) throws JSONException {
        return object.has(keyName) ? object.getBoolean(keyName) : defaultValue;
    }

}

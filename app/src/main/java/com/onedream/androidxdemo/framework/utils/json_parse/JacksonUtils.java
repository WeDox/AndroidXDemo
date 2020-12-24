package com.onedream.androidxdemo.framework.utils.json_parse;

import com.fasterxml.jackson.databind.type.TypeFactory;
import com.onedream.androidxdemo.framework.utils.system.LogHelper;

import java.util.List;

public class JacksonUtils {
    //解析对象
    public static <T> T parseObject(String response, Class<T> clazz) {
        try {
            return JacksonObjectMapper.getInstance().readValue(response, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.e("ATU", "解析出现异常"+e.toString());
            return null;
        }
    }

    //解析数组
    public static <T> List<T> parseObjectList(String response, Class<T> clazz) {
        try {
            TypeFactory typeFactory = JacksonObjectMapper.getInstance().getTypeFactory();
            return JacksonObjectMapper.getInstance().readValue(response, typeFactory.constructCollectionType(List.class, clazz));
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.e("ATU", "解析出现异常"+e.toString());
            return null;
        }
    }
}

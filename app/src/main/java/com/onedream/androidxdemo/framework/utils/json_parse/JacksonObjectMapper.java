package com.onedream.androidxdemo.framework.utils.json_parse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson库的ObjectMapper对象单例化对象类
 *
 * @author
 */
public class JacksonObjectMapper extends ObjectMapper {

    /**
     * 默认序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 单例异步锁，用于维持线程安全
     */
    private static final Object syncLock = new Object();

    /**
     * 单例ObjectMapper对象
     */
    private static JacksonObjectMapper instance;

    /**
     * 获取�?��设置好的单例ObjectMapper对象
     */
    public static ObjectMapper getInstance() {
        if (instance == null) {
            synchronized (syncLock) {
                if (instance == null) {
                    instance = new JacksonObjectMapper();
                }
            }
        }
        return instance;
    }

    /**
     * 单例对象的构造方法，设置相关参数
     */
    private JacksonObjectMapper() {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 忽略未知参数
        configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false); // 忽略异常的分支
        configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false); // 忽略未知参数解析失败
    }

}

package com.onedream.androidxdemo.framework.http.custome;

public class Constant {
    public static String BASE_API_HOST = "http://120.78.120.117/poetry/";//api
    //
    public static final String API_RANDOM_POETRY = "/poetry.php";


    public static String getRealUrl(String shortUrl) {
        return BASE_API_HOST + shortUrl;
    }
}

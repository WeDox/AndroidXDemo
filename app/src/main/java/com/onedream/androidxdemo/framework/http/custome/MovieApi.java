package com.onedream.androidxdemo.framework.http.custome;

import com.onedream.androidxdemo.framework.http.gson_converter_factory.GsonConverterFactory2;
import com.onedream.androidxdemo.framework.http.support.CookieJarImpl;
import com.onedream.androidxdemo.framework.http.support.HeaderInterceptor;
import com.onedream.androidxdemo.framework.http.support.Logger;
import com.onedream.androidxdemo.framework.http.support.LoggingInterceptor;

import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;

public class MovieApi {
    private volatile static MovieApi instance;//加volatile防止D指令重排
    private MovieApiService service;

    private MovieApi() {
        LoggingInterceptor logging = new LoggingInterceptor(new Logger());
        logging.setLevel(LoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(new HeaderInterceptor())
                .cookieJar(new CookieJarImpl())
                .addInterceptor(logging);
        OkHttpClient okHttpClient = builder.build();
        //
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_API_HOST)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory2.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        service = retrofit.create(MovieApiService.class);
    }

    public static MovieApi getInstance() {
        if (instance == null) {
            synchronized (MovieApi.class) {
                if (instance == null) {
                    instance = new MovieApi();
                }
            }
        }
        return instance;
    }

    public Observable<BodyOut> getBodyOutData(String url, Map<String, String> map) {
        return service.doGet(Constant.getRealUrl(url), map);
    }

    //
    public Observable<BodyOut> sendRandomPoetry() {
        Map<String, String> map = new HashMap<>();
        return getBodyOutData(Constant.API_RANDOM_POETRY, map);
    }


    //根据文件路径猜测出文件类型
    private static MediaType guessMimeType(String path) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        path = path.replace("#", "");   //解决文件名中含有#号异常的问题
        String contentType = fileNameMap.getContentTypeFor(path);
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return MediaType.parse(contentType);
    }
}

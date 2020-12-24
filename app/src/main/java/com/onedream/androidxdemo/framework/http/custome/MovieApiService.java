package com.onedream.androidxdemo.framework.http.custome;

import com.onedream.androidxdemo.framework.http.custome.BodyOut;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface MovieApiService {
    @GET
    Observable<BodyOut> doGet(@Url String url);

    @GET
    Observable<BodyOut> doGet(@Url String url, @QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST
    Observable<BodyOut> doPost(@Url String url, @FieldMap Map<String, String> map);

    @Multipart
    @POST
    Observable<BodyOut> doPostImages(@Url String url, @PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> requestBodyMap);

    @POST
    Observable<BodyOut> doBodyPost(@Url String url, @Body RequestBody body);
}

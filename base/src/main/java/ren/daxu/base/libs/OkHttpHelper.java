package ren.daxu.base.libs;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 *
 * 请求
 *
 */
public class OkHttpHelper {

    private OkHttpClient mClient;

    public OkHttpHelper(){

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        /**
         * 日志打印
         */
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        builder.addInterceptor(httpLoggingInterceptor);

        mClient = builder.build();
    }


    public OkHttpClient getOkHttp(){
        return mClient;
    }


}

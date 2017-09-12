package ren.daxu.architecture.data.remote;

import ren.daxu.base.libs.OkHttpHelper;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class Api {

    private static Retrofit retrofit;


    private static String BaseUrl = "http://www.daxu.ren/api/";

    private static  ApiService service;

    private Api() {
    }


    public static  ApiService getService(){
        if (service == null){
            OkHttpHelper httpHelper = new OkHttpHelper();
            retrofit = new Retrofit.Builder()
                    .client(httpHelper.getOkHttp())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BaseUrl)
                    .build();
            service = retrofit.create(ApiService.class);
        }
        return service;
    }

}

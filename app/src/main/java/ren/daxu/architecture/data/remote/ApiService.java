package ren.daxu.architecture.data.remote;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("getitem")
    Observable<TestResponse> test(@Query("index") int index);

}

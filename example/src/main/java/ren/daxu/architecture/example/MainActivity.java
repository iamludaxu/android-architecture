package ren.daxu.architecture.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ren.daxu.architecture.example.api.Api;
import ren.daxu.architecture.example.api.TestResponse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Api.getService().test(1).subscribeOn(Schedulers.newThread()).subscribe(new Consumer<TestResponse>() {

            @Override
            public void accept(@NonNull TestResponse testResponse) throws Exception {
                int ii = testResponse.getStatus();
                Logger.d(ii);
            }
        });


    }
}

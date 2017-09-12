package ren.daxu.architecture.example;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ren.daxu.architecture.example.api.Api;
import ren.daxu.architecture.example.api.TestResponse;

public class MainActivity extends FragmentActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Api.getService().test(1).subscribeOn(Schedulers.newThread()).subscribe(new Consumer<TestResponse>() {

            @Override
            public void accept(@NonNull TestResponse testResponse) throws Exception {
                int ii = testResponse.getStatus();
                Logger.d(ii);
            }
        });


    }
}

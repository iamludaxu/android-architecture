package ren.daxu.architecture.example.test;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ren.daxu.architecture.example.api.Api;
import ren.daxu.architecture.example.api.TestResponse;

public class TestPresenter extends TestContract.Presenter {


    private static int number;


    @Override
    public void destory() {

    }

    @Override
    void change(String text) {
        number++;
        v.chage(number);
    }

    @Override
    void loadData() {
        Api.getService().test(1).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<TestResponse>() {

            @Override
            public void accept(@NonNull TestResponse testResponse) throws Exception {
                int ii = testResponse.getStatus();

                v.addDatas(testResponse.getData());
            }
        });
    }


}

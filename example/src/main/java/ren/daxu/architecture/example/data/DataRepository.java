package ren.daxu.architecture.example.data;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ren.daxu.architecture.example.data.remote.Api;
import ren.daxu.architecture.example.data.remote.TestResponse;

public class DataRepository {



    public DataRepository(){

    }

    public void loadTestData(){
        Api.getService().test(1).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<TestResponse>() {

            @Override
            public void accept(@NonNull TestResponse testResponse) throws Exception {
                int ii = testResponse.getStatus();
                TaskData taskData = new TaskData("","");
                taskData.setData(testResponse.getData());
                EventBus.getDefault().post(taskData);

            }
        });
    }

}

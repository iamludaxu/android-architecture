package ren.daxu.architecture.example.test;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import ren.daxu.architecture.example.data.DataRepository;
import ren.daxu.architecture.example.data.TaskData;
import ren.daxu.architecture.example.data.type.TestData;

public class TestPresenter implements TestContract.Presenter {


    private static int number;

    private TestContract.View mView;

    private DataRepository mDataRepository;

    public TestPresenter(DataRepository dataRepository,TestContract.View view){
        mDataRepository = dataRepository;
        mView = view;
        mView.setPresenter(this);
    }

    public void change(String text) {
        number++;
        mView.chage(number);
    }

    public void loadData() {
        mDataRepository.loadTestData();
    }


    @Override
    public void subscribe() {
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onMessageEvent(TaskData taskData) {
        mView.addDatas((List<TestData>) taskData.getData());
    }

    @Override
    public void unsubscrble() {
        EventBus.getDefault().unregister(this);
    }
}

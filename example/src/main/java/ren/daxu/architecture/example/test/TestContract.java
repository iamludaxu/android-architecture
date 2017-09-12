package ren.daxu.architecture.example.test;

import java.util.List;

import ren.daxu.architecture.example.data.type.TestData;
import ren.daxu.base.BasePresenter;
import ren.daxu.base.BaseView;

public interface TestContract {


    interface View extends BaseView<Presenter> {
        void chage(int number);

        void addDatas(List<TestData> data);
    }

    interface Presenter extends BasePresenter {

        void change(String text);

        void loadData();
    }

}

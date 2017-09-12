package ren.daxu.architecture.example.test;

import ren.daxu.base.BaseModel;
import ren.daxu.base.BasePresenter;
import ren.daxu.base.BaseView;

public interface TestContract {

    interface Model extends BaseModel {

    }

    interface View extends BaseView {
        void chage(int number);
    }

    abstract static class Presenter extends BasePresenter<View, Model> {

        abstract void change(String text);

    }

}

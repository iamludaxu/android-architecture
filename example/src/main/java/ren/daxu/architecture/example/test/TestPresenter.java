package ren.daxu.architecture.example.test;

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
}

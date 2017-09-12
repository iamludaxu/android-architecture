package ren.daxu.architecture.example;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import ren.daxu.architecture.example.comm.CommActivity;
import ren.daxu.architecture.example.test.TestModel;
import ren.daxu.architecture.example.test.TestPresenter;

public class Test2Activity extends CommActivity<TestPresenter,TestModel> {


    @Bind(ren.daxu.architecture.example.R.id.ffff)
    TextView ff;

    @Override
    public int layoutId() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void setBeforeContentView() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ff.setText("我是陆大旭");
    }
}


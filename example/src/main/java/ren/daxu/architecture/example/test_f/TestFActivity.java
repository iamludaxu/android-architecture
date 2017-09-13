package ren.daxu.architecture.example.test_f;

import ren.daxu.architecture.example.R;
import ren.daxu.architecture.example.comm.CommActivity;

public class TestFActivity extends CommActivity {


    @Override
    public int layoutId() {
        return R.layout.activity_testf;
    }

    @Override
    public void initView() {
        setFragmentContainerId(R.id.con);
        showFragment(new TestFragment());
    }

    @Override
    public void initPresenter() {

    }


    @Override
    public void setBeforeContentView() {

    }
}

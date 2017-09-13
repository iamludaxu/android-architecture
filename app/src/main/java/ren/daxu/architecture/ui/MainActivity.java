package ren.daxu.architecture.ui;

import android.content.Context;
import android.content.Intent;

import ren.daxu.architecture.R;
import ren.daxu.architecture.comm.CommActivity;


public class MainActivity extends CommActivity {


    public static Intent getIntent(Context context){
        Intent intent = new Intent();
        intent.setClass(context,MainActivity.class);
        return intent;
    }


    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        SetStatusBarColor();
    }

    @Override
    public void initPresenter() {

    }

}

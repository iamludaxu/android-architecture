package ren.daxu.architecture.example.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import ren.daxu.architecture.example.R;
import ren.daxu.architecture.example.comm.CommActivity;

public class TestActivity extends CommActivity<TestPresenter,TestModel> implements TestContract.View {


    @Bind(R.id.text)
    TextView mTextTV;

    @Bind(R.id.list)
    ListView mListLV;

    @Override
    public int layoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        mTextTV.setText("我是陆大旭");
    }

    @OnClick(R.id.change_btn)
    public void change(){
        presenter.change("");
    }

    @Override
    public void initPresenter() {
        presenter = new TestPresenter();
        presenter.init(this, baseModel);
    }

    @Override
    public void setBeforeContentView() {

    }


    @Override
    public void chage(int number) {
        mTextTV.setText("我是陆大旭 number:"+number);
    }
}

package ren.daxu.architecture.example.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import ren.daxu.architecture.example.R;
import ren.daxu.architecture.example.R2;
import ren.daxu.architecture.example.comm.CommActivity;
import ren.daxu.architecture.example.data.type.TestData;

public class TestActivity extends CommActivity implements TestContract.View {


    @BindView(R2.id.text)
    TextView mTextTV;

    @BindView(R2.id.list)
    ListView mListLV;


    private TestContract.Presenter mPresenter;


    private TestAdapter mTestAdapter;


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
        mTestAdapter = new TestAdapter(this);
        mListLV.setAdapter(mTestAdapter);
    }

    @OnClick(R.id.change_btn)
    public void change() {
        mPresenter.change("");
    }

    @OnClick(R.id.getdata_btn)
    public void getData() {
        mPresenter.loadData();
    }

    @Override
    public void initPresenter() {
        new TestPresenter(mDataRepository, this);
    }

    @Override
    public void setBeforeContentView() {

    }


    @Override
    public void chage(int number) {
        mTextTV.setText("我是陆大旭 number:" + number);
    }

    @Override
    public void addDatas(List<TestData> data) {
        mTestAdapter.add(data);
    }

    @Override
    public void setPresenter(TestContract.Presenter presenter) {
        mPresenter = presenter;
    }
}

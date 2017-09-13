package ren.daxu.architecture.example.test_f;

import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import ren.daxu.architecture.example.R;
import ren.daxu.architecture.example.R2;
import ren.daxu.architecture.example.comm.CommActivity;
import ren.daxu.architecture.example.comm.CommFragment;
import ren.daxu.architecture.example.data.DataRepository;
import ren.daxu.architecture.example.data.type.TestData;
import ren.daxu.architecture.example.test.TestAdapter;
import ren.daxu.architecture.example.test.TestContract;
import ren.daxu.architecture.example.test.TestPresenter;

public class TestFragment extends CommFragment implements TestContract.View{



    @BindView(R2.id.text)
    TextView mTextTV;

    @BindView(R2.id.list)
    ListView mListLV;

    private TestAdapter mTestAdapter;

    private TestContract.Presenter mPresenter;


    @Override
    public int layoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {
        mTextTV.setText("我是陆大旭");
        mTestAdapter = new TestAdapter(getContext());
        mListLV.setAdapter(mTestAdapter);
        mPresenter.subscribe();
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
        DataRepository dataRepository = ((CommActivity)getActivity()).getDataRepository();
        new TestPresenter(dataRepository, this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unsubscrble();
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

package ren.daxu.architecture.example.test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import ren.daxu.architecture.example.R;
import ren.daxu.architecture.example.R2;
import ren.daxu.architecture.example.api.TestResponse;
import ren.daxu.architecture.example.comm.BaseObjectAdapter;
import ren.daxu.architecture.example.comm.ImageHelper;

public class TestAdapter extends BaseObjectAdapter<TestAdapter.TestView,TestResponse.TestData> {


    public TestAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getView() {
        return R.layout.adapter_test;
    }

    @Override
    protected TestView attachViewHolder() {
        return new TestView();
    }

    @Override
    protected void bindView(TestView holder, TestResponse.TestData data, int position, View convertView, ViewGroup parent) {
        ImageHelper.showCommGif(mContext,"http://android-github.daxu.ren/woxingxiao_BubbleSeekBar0.gif?imageMogr2/auto-orient/thumbnail/300x600%3E",holder.imageView);
        holder.textView.setText(data.getName());
    }

    public class TestView {

        @BindView(R2.id.image)
        ImageView imageView;

        @BindView(R2.id.text)
        TextView textView;
    }

}

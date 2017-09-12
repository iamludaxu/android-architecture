package ren.daxu.architecture.test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import ren.daxu.architecture.R;
import ren.daxu.architecture.R2;
import ren.daxu.architecture.comm.BaseObjectAdapter;
import ren.daxu.architecture.comm.ImageHelper;
import ren.daxu.architecture.data.type.TestData;

public class TestAdapter extends BaseObjectAdapter<TestAdapter.TestView, TestData> {


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
    protected void bindView(TestView holder, TestData data, int position, View convertView, ViewGroup parent) {
        ImageHelper.showCommGif(mContext, "http://android-github.daxu.ren/" + data.getImageDatas().get(0).getSrc() + "?imageMogr2/auto-orient/thumbnail/300x600%3E", holder.imageView);
        holder.textView.setText(data.getName());
    }

    public class TestView {

        @BindView(R2.id.image)
        ImageView imageView;

        @BindView(R2.id.text)
        TextView textView;
    }

}

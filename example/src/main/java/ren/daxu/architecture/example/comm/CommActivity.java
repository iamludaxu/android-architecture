package ren.daxu.architecture.example.comm;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ren.daxu.base.BaseFragmentActivity;
import ren.daxu.base.BaseModel;
import ren.daxu.base.BasePresenter;

/**
 *
 * 应用基础层Activity
 *
 * @param <P>
 */
public abstract class CommActivity<P extends BasePresenter> extends BaseFragmentActivity<P> {


    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setAfterContentView() {
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(unbinder!=null){
            unbinder.unbind();
        }
    }
}

package ren.daxu.architecture.example.comm;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ren.daxu.base.BaseFragmentActivity;
import ren.daxu.base.BaseModel;
import ren.daxu.base.BasePresenter;

/**
 *
 * 应用基础层Activity
 *
 * @param <P>
 * @param <M>
 */
public abstract class CommActivity<P extends BasePresenter,M extends BaseModel> extends BaseFragmentActivity<P,M> {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

package ren.daxu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;


/**
 * 0???Activity
 * @param <P>
 * @param <M>
 */
public abstract class BaseFragmentActivity<P extends BasePresenter, M extends BaseModel> extends FragmentActivity {

    public P presenter;

    public M baseModel;

    public abstract int layoutId();

    public abstract void initView();

    public abstract void initPresenter();

    public abstract void setBeforeContentView();

    private BaseFragmentActivity baseFragmentActivity;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.i("BaseFragmentActivity onCreate");
        baseFragmentActivity = this;
        setBeforeContentView();
        int layoutId = layoutId();
        setContentView(layoutId);
        ButterKnife.bind(this);
        initView();
        initPresenter();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);

        if (presenter != null) {
            presenter.destory();
        }

        if (baseModel != null) {
            baseModel.clear();
        }

    }
}

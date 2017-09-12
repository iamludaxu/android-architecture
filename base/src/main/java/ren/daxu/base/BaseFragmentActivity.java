package ren.daxu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.orhanobut.logger.Logger;


/**
 * 0???Activity
 * @param <P>
 */
public abstract class BaseFragmentActivity<P extends BasePresenter> extends FragmentActivity {

    public P presenter;

    public abstract int layoutId();

    public abstract void initView();

    public abstract void initPresenter();

    public abstract void setBeforeContentView();

    public abstract void setAfterContentView();

    private BaseFragmentActivity baseFragmentActivity;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.i("BaseFragmentActivity onCreate");
        baseFragmentActivity = this;
        setBeforeContentView();
        int layoutId = layoutId();
        setContentView(layoutId);
        setAfterContentView();
        initView();
        initPresenter();
        if (presenter!=null){
            presenter.subscribe();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        if (presenter != null) {
            presenter.unsubscrble();
        }

    }
}

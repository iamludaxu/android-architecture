package ren.daxu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    public abstract int layoutId();

    protected abstract void initView();

    public abstract void initPresenter();

    public abstract void setAfterContentView(View view);

    private View rootV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootV == null)
            rootV = inflater.inflate(layoutId(), container, false);
        setAfterContentView(rootV);
        initPresenter();
        initView();
        return rootV;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

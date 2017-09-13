package ren.daxu.architecture.comm;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ren.daxu.architecture.R;
import ren.daxu.architecture.data.DataRepository;
import ren.daxu.architecture.ui.widget.ChangeModeController;
import ren.daxu.architecture.ui.widget.StatusBarCompat;
import ren.daxu.base.BaseFragmentActivity;
import ren.daxu.base.BasePresenter;

/**
 *
 * 应用基础层Activity
 *
 */
public abstract class CommActivity extends BaseFragmentActivity{


    private Unbinder unbinder;

    protected DataRepository mDataRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mDataRepository = ((CommApplication)getApplication()).getDataRepository();
        super.onCreate(savedInstanceState);
    }


    @Override
    public void setAfterContentView() {
        unbinder = ButterKnife.bind(this);
    }

    @Override
    public void setBeforeContentView() {
        //设置昼夜主题
        initTheme();
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 默认着色状态栏
        SetStatusBarColor();
    }

    /**
     * 设置主题
     */
    private void initTheme() {
        ChangeModeController.setTheme(this, R.style.DayTheme, R.style.NightTheme);
    }
    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void SetStatusBarColor(){
        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, R.color.main_color));
    }
    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void SetStatusBarColor(int color){
        StatusBarCompat.setStatusBarColor(this,color);
    }
    /**
     * 沉浸状态栏（4.4以上系统有效）
     */
    protected void SetTranslanteBar(){
        StatusBarCompat.translucentStatusBar(this);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(unbinder!=null){
            unbinder.unbind();
        }
    }

}

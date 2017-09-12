package ren.daxu.base;

import android.app.Application;

import com.orhanobut.logger.Logger;


/**
 * 0层基础Application
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.i("BaseApplication onCreate");
    }

}

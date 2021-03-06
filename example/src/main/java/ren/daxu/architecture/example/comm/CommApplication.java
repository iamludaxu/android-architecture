package ren.daxu.architecture.example.comm;

import ren.daxu.architecture.example.data.DataRepository;
import ren.daxu.base.BaseApplication;


/**
 *
 * 应用基础层Application
 *
 */
public class CommApplication extends BaseApplication {



    private DataRepository mDataRepository;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public DataRepository getDataRepository(){
        if(mDataRepository ==null){
            mDataRepository = new DataRepository();
        }
        return  mDataRepository;
    }
}

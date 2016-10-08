package cn.tofly.mis.waterusermanager;

import android.app.Application;

import cn.tofly.mis.waterusermanager.common.di.ApplicationComponent;
import cn.tofly.mis.waterusermanager.common.di.ApplicationModule;
import cn.tofly.mis.waterusermanager.common.di.DaggerApplicationComponent;
import cn.tofly.mis.waterusermanager.common.tools.ImageUtils;

/**
 * Created by baoxing on 2016/9/26.
 */
public class App extends Application {


    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this, getApplicationContext())).build();

        ImageUtils.init(this);

        restoreAllCommonData();
    }

    private void restoreAllCommonData() {
//TODO should restore some memory data that kill by system when leak memory

    }


    public ApplicationComponent getApplicationComponent() {
        return this.mApplicationComponent;
    }

}

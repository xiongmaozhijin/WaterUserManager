package cn.tofly.mis.waterusermanager.common.di;

import android.content.SharedPreferences;

import cn.tofly.mis.waterusermanager.common.tools.SharedPrefUtils;
import dagger.Component;

/**
 * Created by baoxing on 2016/9/26.
 */
@AppScoped
@Component(modules = ApplicationModule.class)
public abstract class ApplicationComponent {

    //显示提供所需的对象，暴露接口


    public abstract SharedPrefUtils getSharedPrefUtils();




}


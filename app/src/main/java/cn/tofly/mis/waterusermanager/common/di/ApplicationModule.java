package cn.tofly.mis.waterusermanager.common.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import cn.tofly.mis.waterusermanager.App;
import cn.tofly.mis.waterusermanager.common.tools.SharedPrefUtils;
import dagger.Module;
import dagger.Provides;

/**
 * 提供公用的对象
 * Created by baoxing on 2016/9/26.
 */
@Module
public final class ApplicationModule {

    private final App mApplication;

    private final Context mContext;

    public ApplicationModule(App application, Context context) {
        this.mApplication = application;
        this.mContext = context;
    }

    @Provides
    App provideApplication() {
        return this.mApplication;
    }

    @Provides
    Context provideContext() {
        return this.mContext;
    }

    @Provides
    SharedPrefUtils providerSharedPreferences(Context context) {
        return SharedPrefUtils.getInstance(context);
    }




}

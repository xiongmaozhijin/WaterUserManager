package cn.tofly.mis.waterusermanager.common.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import cn.tofly.mis.waterusermanager.App;
import cn.tofly.mis.waterusermanager.common.tools.SharedPrefUtils;
import cn.tofly.mis.waterusermanager.data.local.DBInstance;
import cn.tofly.mis.waterusermanager.data.local.LocalDbFactory;
import cn.tofly.mis.waterusermanager.data.local.gendao.DaoMaster;
import cn.tofly.mis.waterusermanager.data.local.gendao.DaoSession;
import cn.tofly.mis.waterusermanager.data.remote.IExampleNetService;
import cn.tofly.mis.waterusermanager.data.remote.NetServiceFactory;
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

    /**
     * 首选项
     *
     * @param context
     * @return
     */
    @Provides
    SharedPrefUtils providerSharedPreferences(Context context) {
        return SharedPrefUtils.getInstance(context);
    }

    /**
     * 服务器接口
     *
     * @return
     */
    @AppScoped
    @Provides
    IExampleNetService providerExampleNetService() {
        return NetServiceFactory.getExampleNetService();
    }

    /**
     * 数据库实例
     * @param context
     * @return
     */
    @AppScoped
    @Provides
    DBInstance providerDBInstance(Context context) {
        return LocalDbFactory.getDBInstance(context, mApplication);
    }


}

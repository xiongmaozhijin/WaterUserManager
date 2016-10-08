package cn.tofly.mis.waterusermanager.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import javax.inject.Inject;

import cn.tofly.mis.waterusermanager.App;
import cn.tofly.mis.waterusermanager.BuildConfig;
import cn.tofly.mis.waterusermanager.data.DaggerDataComponent;
import cn.tofly.mis.waterusermanager.data.DataModule;
import cn.tofly.mis.waterusermanager.data.local.daoimpl.TbTestDAOImpl;
import cn.tofly.mis.waterusermanager.data.local.dbbiz.DbTestBiz;
import cn.tofly.mis.waterusermanager.data.local.gendao.DaoMaster;
import cn.tofly.mis.waterusermanager.data.local.gendao.DaoSession;
import dagger.Lazy;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by baoxing on 2016/9/27.
 */
public class DBInstance {

    private static DBInstance mInstance;

    private static final String DB_NAME = "water_user_db";

    private DaoSession mDaoSession;

    //other dao impl......
    //it must user Lazy because or it will cause StackOverFlow
    @Inject
    Lazy<DbTestBiz> mDbTestBiz;


    private DBInstance(Context context, App app) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        mDaoSession = new DaoMaster(writableDatabase).newSession();

        if (BuildConfig.DEBUG) {
            QueryBuilder.LOG_SQL = true;
            QueryBuilder.LOG_VALUES = true;
        }

        DaggerDataComponent.builder().applicationComponent(app.getApplicationComponent()).dataModule(new DataModule()).build().inject(this);
    }

    public static synchronized DBInstance getInstance(Context context, App app) {
        if (mInstance == null) {
            mInstance = new DBInstance(context, app);
        }

        return mInstance;
    }

    @Deprecated
    public synchronized static void init(Context context) {
//        mInstance = new DBInstance(context);
    }

    @Deprecated
    public static synchronized DBInstance getInstance() {
        if (mInstance == null) {
            throw new RuntimeException("You had forget init() first, you should init() in application suggested");
        }

        return mInstance;
    }


    public DaoSession getDaoSession() {
        return this.mDaoSession;
    }


    /**
     * 测试的DAO实例
     *
     * @return
     */
    public DbTestBiz getTbTestBiz() {
        return mDbTestBiz.get();
    }


}

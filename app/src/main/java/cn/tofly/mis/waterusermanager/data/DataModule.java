package cn.tofly.mis.waterusermanager.data;

import cn.tofly.mis.waterusermanager.data.local.DBInstance;
import cn.tofly.mis.waterusermanager.data.local.daoimpl.TbTestDAOImpl;
import cn.tofly.mis.waterusermanager.data.local.dbbiz.DbTestBiz;
import dagger.Module;
import dagger.Provides;

/**
 * Created by baoxing on 2016/9/26.
 */
@Module
public class DataModule {


    @DataScoped
    @Provides
    TbTestDAOImpl providerTbTestDAO(DBInstance dbInstance) {
        return new TbTestDAOImpl(dbInstance.getDaoSession());
    }

    //other daoimpl...


    @DataScoped
    @Provides
    DbTestBiz providerDbTestBiz(TbTestDAOImpl mDAOImpl) {
        return new DbTestBiz(mDAOImpl);
    }

}

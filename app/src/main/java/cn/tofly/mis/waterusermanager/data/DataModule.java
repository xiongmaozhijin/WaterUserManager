package cn.tofly.mis.waterusermanager.data;

import cn.tofly.mis.waterusermanager.data.local.DBInstance;
import cn.tofly.mis.waterusermanager.data.local.daoimpl.TbTestDAOImpl;
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



}

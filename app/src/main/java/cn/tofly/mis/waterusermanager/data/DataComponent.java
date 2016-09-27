package cn.tofly.mis.waterusermanager.data;

import cn.tofly.mis.waterusermanager.common.di.ApplicationComponent;
import cn.tofly.mis.waterusermanager.data.local.DBInstance;
import dagger.Component;

/**
 * Created by hasee on 2016/9/26.
 */
@DataScoped
@Component(dependencies = ApplicationComponent.class, modules = DataModule.class)
public abstract class DataComponent {

    public abstract void inject(DBInstance target);

}

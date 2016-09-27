package cn.tofly.mis.waterusermanager.testmodule;

import cn.tofly.mis.waterusermanager.common.di.ActivityScoped;
import cn.tofly.mis.waterusermanager.common.di.ApplicationComponent;
import cn.tofly.mis.waterusermanager.data.DataModule;
import dagger.Component;

/**
 * 作为连接桥
 * Created by hasee on 2016/9/26.
 */
@ActivityScoped
@Component(dependencies = ApplicationComponent.class, modules = {TestModule.class})
public abstract class TestComponent {

    public abstract void inject(TestFragment target);

}

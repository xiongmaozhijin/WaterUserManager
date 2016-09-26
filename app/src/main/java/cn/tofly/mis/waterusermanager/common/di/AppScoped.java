package cn.tofly.mis.waterusermanager.common.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by baoxing on 2016/9/26.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScoped {
}

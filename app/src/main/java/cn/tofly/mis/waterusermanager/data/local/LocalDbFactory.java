package cn.tofly.mis.waterusermanager.data.local;

import android.content.Context;

import cn.tofly.mis.waterusermanager.App;

/**
 * Created by baoxing on 2016/9/27.
 */
public class LocalDbFactory {


    private LocalDbFactory() {}


    public static synchronized DBInstance getDBInstance(Context context, App app) {
        return DBInstance.getInstance(context, app);
    }


}

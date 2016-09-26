package cn.tofly.mis.waterusermanager.common.tools;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by baoxing on 2015/12/8.
 */
public class SharedPrefUtils {

    private static final String PREF_CONFIG = "config";

    private static SharedPreferences mSharedPreferences;

    private static SharedPrefUtils mInstance;

    private SharedPrefUtils(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_CONFIG, Context.MODE_PRIVATE);
    }


    private static synchronized void init(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefUtils(context);
        }

    }

    public static synchronized SharedPrefUtils getInstance(Context context) {
        if (mInstance == null) {
            init(context);
        }

        return mInstance;
    }


    /**
     * @param key
     * @param value
     * @throws IllegalArgumentException
     */
    public synchronized void save(String key, Object value) {
        if (value != null) {
            if (value instanceof Boolean) {
                mSharedPreferences.edit().putBoolean(key, (Boolean) value).commit();

            } else if (value instanceof String) {
                mSharedPreferences.edit().putString(key, (String) value).commit();

            } else if (value instanceof Long) {
                mSharedPreferences.edit().putLong(key, (Long) value).commit();

            } else if (value instanceof Integer) {
                mSharedPreferences.edit().putInt(key, (Integer) value).commit();

            } else if (value instanceof Float) {
                mSharedPreferences.edit().putFloat(key, (Float) value).commit();

            } else {
                throw new IllegalArgumentException("it no support this type! Check it!");

            }
        }
    }

    /**
     * @param key
     * @param value
     * @throws IllegalArgumentException
     */
    public synchronized void saveAsync(String key, Object value) {
        if (value != null) {
            if (value instanceof Boolean) {
                mSharedPreferences.edit().putBoolean(key, (Boolean) value).apply();

            } else if (value instanceof String) {
                mSharedPreferences.edit().putString(key, (String) value).apply();

            } else if (value instanceof Long) {
                mSharedPreferences.edit().putLong(key, (Long) value).apply();

            } else if (value instanceof Integer) {
                mSharedPreferences.edit().putInt(key, (Integer) value).apply();

            } else if (value instanceof Float) {
                mSharedPreferences.edit().putFloat(key, (Float) value).apply();

            } else {
                throw new IllegalArgumentException("it no support this type! Check it!");
            }
        }
    }


    public SharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }


//    public synchronized void save(String key, boolean value) {
//        mSharedPreferences.edit().putBoolean(key, value).commit();
//    }
//
//    public synchronized void save(String key, String value) {
//        mSharedPreferences.edit().putString(key, value).commit();
//    }
//
//    public synchronized void save(String key, long value) {
//        mSharedPreferences.edit().putLong(key, value).commit();
//    }

//    public synchronized void saveAsync(String key, boolean value) {
//        mSharedPreferences.edit().putBoolean(key, value).apply();
//    }
//
//    public synchronized void saveAsync(String key, String value) {
//        mSharedPreferences.edit().putString(key, value).apply();
//    }
//
//    public synchronized void saveAsync(String key, long value) {
//        mSharedPreferences.edit().putLong(key, value).apply();
//    }


}

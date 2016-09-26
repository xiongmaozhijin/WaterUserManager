package cn.tofly.mis.waterusermanager.common.tools;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

/**
 * log工具类
 * Created by baoxing on 2015/12/2.
 */
public class LogUtils {


    public static void writeln(String format, Object... msg) {
        System.out.println(String.format(format, msg));
    }

    public static void writeln(String msg) {
        System.out.println(msg);
    }

    public static void writelnErr(String msg) {
        System.err.println(msg);
    }

    public static void writelnErr(String format, Object... msg) {
        System.err.println(String.format(format, msg));
    }


    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void i(String tag, String format, Object... args) {
        Log.i(tag, String.format(format, args));
    }

    public static void v(String tag, String msg) {
        Log.v(tag, msg);
    }

    public static void v(String tag, String format, Object... args) {
        Log.v(tag, String.format(format, args));
    }


    public static void w(String tag, String msg) {
        Log.w(tag, msg);
    }

    public static void w(String tag, String format, Object... args) {
        Log.w(tag, String.format(format, args));
    }


    public static void e(String tag, String msg) {
        Log.e(tag, msg);
    }

    public static void e(String tag, String format, Object... args) {
        Log.e(tag, String.format(format, args));
    }


    private static Toast mToast;

    private static void showShortToast(Context context, String msg) {
        if (mToast == null) {
            synchronized (LogUtils.class) {
                if (mToast == null) {
                    mToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
                }
            }
        }

        if (!TextUtils.isEmpty(msg)) {
            mToast.setText(msg);
            mToast.show();
        }
    }

    public static void dismissShortToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    public static void toastShortMsg(Context context, String msg) {
        showShortToast(context, msg);
    }

    public static void toastShortMsg(Context context, int stringRedId) {
        showShortToast(context, context.getResources().getString(stringRedId));
    }

}

package cn.tofly.mis.waterusermanager.common.ui;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;


import cn.tofly.mis.waterusermanager.R;


/**
 * Created by baoxing on 2016/8/2.
 */
public class UIHelper {

    /**
     * 显示Notification
     *
     * @param context
     * @param title
     * @param content
     * @param pushMessageId
     * @param isVibrate
     */
    public static void showNotification(Context context, String title, String content, long pushMessageId, boolean isVibrate) {
        NotificationCompat.Builder builder;
        Intent showIntent;
        PendingIntent pi;
        NotificationManager nm;
        Bundle bundle;

        bundle = new Bundle();
        showIntent = new Intent(context, Object.class);
        bundle.putLong("", pushMessageId);
        bundle.putString("", "");
        bundle.putString("alise", "info_detail");
        showIntent.putExtra("bundle", bundle);
        pi = PendingIntent.getActivity(context, (int) pushMessageId, showIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setPriority(NotificationCompat.PRIORITY_MAX);
        builder.setAutoCancel(true);
        builder.setContentIntent(pi);

        if (!isVibrate) {
            builder.setVibrate(new long[]{0, 0, 0, 0});

        } else {
            builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);

        }

        nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify((int) pushMessageId, builder.build());
    }


    public static StateListDrawable createStateListDrawable(Drawable pressDrawable, Drawable normalDrawable) {
        StateListDrawable sld = new StateListDrawable();
        sld.addState(new int[]{android.R.attr.state_pressed}, pressDrawable);
        sld.addState(new int[]{}, normalDrawable);

        return sld;
    }


    /**
     * 震动手机
     *
     * @param context
     */
    public static void startVibrator(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator.hasVibrator()) {
            vibrator.vibrate(new long[]{200, 300, 300, 350}, -1);
        }
    }



}

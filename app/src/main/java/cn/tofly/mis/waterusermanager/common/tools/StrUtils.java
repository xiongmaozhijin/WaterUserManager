package cn.tofly.mis.waterusermanager.common.tools;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hasee on 2016/8/15.
 */
public class StrUtils {

    /**
     * @param date Date(1365436800000+0800)
     * @return
     */
    public static String getHumanbleDate(String date) {
        final String format = "yyyy/MM/dd";
        String humanableDate;
        SimpleDateFormat sdf;

        try {
            sdf = new SimpleDateFormat(format);
            date = date.substring(date.indexOf('(') + 1, date.indexOf(')'));
            date = date.substring(0, date.indexOf('+'));

            humanableDate = sdf.format(new Date(Long.parseLong(date)));
        } catch (Exception e) {
            e.printStackTrace();
            humanableDate = "xxxx/xx/xx";
        }


        return humanableDate;
    }

    /**
     * 返回时间戳  Date(1365436800000+0800)
     *
     * @param date
     * @return
     */
    public static long getTimeStamp(String date) {
        long timeStamp = 0;

        try {
            date = date.substring(date.indexOf('(') + 1, date.indexOf(')'));
            date = date.substring(0, date.indexOf('+'));
            timeStamp = Long.parseLong(date);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return timeStamp;
    }


    /**
     * MD5加密
     *
     * @param plain
     * @return
     */
    public static String getMD5Encrypt(String plain) {
        String sEncrypt;

        if (plain != null) {
//            sEncrypt = DigestUtils.md5Hex(plain);
            sEncrypt = new String(Hex.encodeHex(DigestUtils.md5(plain)));

        } else {
            throw new IllegalArgumentException("参数：明文为空");
        }

        return sEncrypt;
    }


    public static String getSaftStr(String str) {
        return str == null ? "" : str;
    }


}

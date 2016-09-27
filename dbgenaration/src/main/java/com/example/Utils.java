package com.example;

/**
 * Created by hasee on 2016/8/25.
 */
public class Utils {
    public static void log(String msg) {
        System.out.println(msg);
    }

    public static void log(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

}

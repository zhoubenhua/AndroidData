package com.apex_data_collect.sample.utils;

import android.util.Log;

/**
 * @author SteelCabbage
 * @date 2018/10/17
 */
public class AppLog {
    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;

    private static int sMinLevel = VERBOSE;

    private static final String TAG = "SampleApp-";

    public static void setLevel(int minLevel) {
        sMinLevel = minLevel;
    }

    private static boolean shouldLog(int level) {
        return sMinLevel <= level;
    }

    public static void v(String tag, String message) {
        if (shouldLog(VERBOSE)) {
            Log.v((TAG + tag), message);
        }
    }

    public static void d(String tag, String message) {
        if (shouldLog(DEBUG)) {
            Log.d((TAG + tag), message);
        }
    }

    public static void i(String tag, String message) {
        if (shouldLog(INFO)) {
            Log.i((TAG + tag), message);
        }
    }

    public static void w(String tag, String message) {
        if (shouldLog(WARN)) {
            Log.w((TAG + tag), message);
        }
    }

    public static void e(String tag, String message) {
        if (shouldLog(ERROR)) {
            Log.e((TAG + tag), message);
        }
    }

}

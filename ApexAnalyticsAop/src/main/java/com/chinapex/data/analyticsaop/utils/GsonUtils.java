package com.chinapex.data.analyticsaop.utils;

import com.google.gson.Gson;

/**
 * @author SteelCabbage
 * @date 2018/03/23
 */

public class GsonUtils {

    private static final String TAG = GsonUtils.class.getSimpleName();

    private static Gson sGson;

    private GsonUtils() {

    }

    static {
        sGson = new Gson();
    }

    public static String toJsonStr(Object object) {
        String jsonStr = null;
        if (null != sGson) {
            try {
                jsonStr = sGson.toJson(object);
            } catch (Exception e) {
                AppLog.e(TAG, "toJsonStr() is exception:" + e.getMessage());
            }
        }
        return jsonStr;
    }

}

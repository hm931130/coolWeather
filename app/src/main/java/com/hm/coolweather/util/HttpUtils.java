package com.hm.coolweather.util;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by ThinkPad on 2017/11/13.
 */

public class HttpUtils {
    public static void sendOkHttpRequest(String adress, Callback callback) {
        OkHttpClient okhttp = new OkHttpClient();
        Request request = new Request.Builder().url(adress)
                .get().build();
        okhttp.newCall(request).enqueue(callback);
    }
}

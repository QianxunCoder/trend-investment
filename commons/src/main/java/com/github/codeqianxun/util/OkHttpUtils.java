package com.github.codeqianxun.util;

import okhttp3.*;

import java.io.IOException;

public class OkHttpUtils {
    private static OkHttpClient client = new OkHttpClient();

    /**
     * 发送 GET 请求
     * @param url 请求的 URL
     * @return 响应内容
     */
    public static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }

    /**
     * 发送 POST 请求
     * @param url 请求的 URL
     * @param json 请求的 JSON 内容
     * @return 响应内容
     */
    public static String post(String url, String json) throws IOException {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        }
    }
}
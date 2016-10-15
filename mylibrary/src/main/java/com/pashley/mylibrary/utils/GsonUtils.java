package com.pashley.mylibrary.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.Reader;
import java.lang.reflect.Type;

/**
 * Created by jeff on 2016/7/8.
 */
public class GsonUtils {
    private static Gson mGson = new GsonBuilder().disableHtmlEscaping().create();

    public static Gson getGson() {
        return mGson;
    }

    /**
     * fromJson
     *
     * @param json json
     * @param c    c
     * @param <T>  <T>
     * @return T
     */
    public static <T> T fromJson(String json, Class<T> c) {
        return mGson.fromJson(json, c);
    }

    /**
     * fromJson
     *
     * @param json json
     * @param c    c
     * @param <T>  <T>
     * @return T
     */
    public static <T> T fromJson(JsonElement json, Class<T> c) {
        return mGson.fromJson(json, c);
    }

    /**
     * fromJson
     *
     * @param json json
     * @param type type
     * @param <T>  <T>
     * @return T
     */
    public static <T> T fromJson(JsonElement json, Type type) {
        return mGson.fromJson(json, type);
    }

    /**
     * fromJson
     *
     * @param json json
     * @param type type
     * @param <T>  <T>
     * @return T
     */
    public static <T> T fromJson(String json, Type type) {
        return mGson.fromJson(json, type);
    }

    /**
     * fromJson
     *
     * @param json json
     * @param type type
     * @param <T>  <T>
     * @return T
     */
    public static <T> T fromJson(Reader json, Type type) {
        return mGson.fromJson(json, type);
    }

    /**
     * toJson
     *
     * @param src src
     * @return String
     */
    public static String toJson(Object src) {
        return mGson.toJson(src);
    }
}

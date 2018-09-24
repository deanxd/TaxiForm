package com.deanxd.taxiform.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 创建者: Mr-Li
 * 创建时间: 2017/3/6 0006
 * 功能说明:
 * 使用方法:
 * 注意事项:
 */
public class JsonTools {

    static {
        //解析json数据时，将null字段替换成"",再解析，避免解析list时 报空指针错误
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(String.class, new StringConverter());
        gson = gb.create();
    }

    private static Gson gson;

    public static <T> String beanToJsonString(T bean) {
        try {
            return gson.toJson(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> JSONObject beanToJsonObject(T bean) {
        String s = beanToJsonString(bean);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static <T> T jsonToBean(String json, Class<T> tClass) {
        try {
            return gson.fromJson(json, tClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T jsonToBean(JSONObject json, Class<T> tClass) {
        return gson.fromJson(json.toString(), tClass);
    }

    public static <T> List<T> jsonToBean(String json, Type type) {
        try {
            return gson.fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getInt(JSONObject jsonObject, String key) {
        int value = 0;
        try {
            value = jsonObject.getInt(key);

        } catch (Exception e) {

        }
        return value;
    }

    public static double getDouble(JSONObject jsonObject, String key) {
        double value = 0;
        try {
            value = jsonObject.getDouble(key);
        } catch (JSONException e) {

        }
        return value;
    }

    public static long getLong(JSONObject jsonObject, String key) {
        long value = 0;
        try {
            value = jsonObject.getLong(key);
        } catch (JSONException e) {

        }
        return value;
    }

    public static String getString(JSONObject jsonObject, String key) {
        String value = "";
        try {
            value = jsonObject.getString(key);
        } catch (JSONException e) {

        }
        return value;
    }

    public static Gson getGson() {
        return gson;
    }


    private static class StringConverter implements JsonSerializer<String>,
            JsonDeserializer<String> {
        @Override
        public JsonElement serialize(String src, Type typeOfSrc,
                                     JsonSerializationContext context) {
            if (src == null) {
                return new JsonPrimitive("");
            } else {
                return new JsonPrimitive(src.toString());
            }
        }

        @Override
        public String deserialize(JsonElement json, Type typeOfT,
                                  JsonDeserializationContext context)
                throws JsonParseException {
            return json.getAsJsonPrimitive().getAsString();
        }
    }
}

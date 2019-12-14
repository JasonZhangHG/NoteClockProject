package cool.camerax.noteclockproject.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.lang.reflect.Type;


public class GsonConverter {

    private final static Gson GSON = new GsonBuilder().disableHtmlEscaping().create();

    public static Gson getGson() {
        return GSON;
    }

    public static boolean isValidityJson(String json) {
        try {
            if (!TextUtils.isEmpty(json)) {
                new JsonParser().parse(json);
                return true;
            }
        } catch (JsonParseException e) {
            return false;
        }
        return false;
    }

    public static boolean isContainJSONArray(String json) {
        try {
            if (!TextUtils.isEmpty(json)) {
                Object jsonObject = new JSONTokener(json).nextValue();
                if (jsonObject != null && jsonObject instanceof JSONArray) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static <T> T fromJson(String json, Class<T> tClass) {
        return GSON.fromJson(json, tClass);
    }

    public static <T> T fromJson(String json, Type type) {
        return GSON.fromJson(json, type);
    }

    public static String toJson(Object o) {
        return GSON.toJson(o);
    }

    public static <T> T fromObject(Object obj, Class<T> tClass) {
        String json = toJson(obj);
        return fromJson(json, tClass);
    }
}

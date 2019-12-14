package cool.camerax.noteclockproject.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import cool.camerax.noteclockproject.base.CCApplication;


public class SharedPrefUtils {

    private static SharedPrefUtils spUtils;

    private SharedPreferences sp;

    private SharedPrefUtils() {
        sp = CCApplication.getInstance().getSharedPreferences(CCApplication.getInstance().getPackageName(), Context.MODE_PRIVATE);
    }

    public static SharedPrefUtils getInstance() {
        if (spUtils == null) {
            synchronized (SharedPrefUtils.class) {
                if (spUtils == null) {
                    spUtils = new SharedPrefUtils();
                }
            }
        }
        return spUtils;
    }

    public String getString(String key) {
        return sp.getString(key, "");
    }

    public String getString(String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    public void putString(String key, String value) {
        Editor edit = sp.edit();
        edit.putString(key, value);
        edit.apply();
    }

    public int getInt(String key) {
        return sp.getInt(key, 0);
    }

    public void putInt(String key, int value) {
        Editor edit = sp.edit();
        edit.putInt(key, value);
        edit.apply();
    }

    public float getFloat(String key) {
        return sp.getFloat(key, 0);
    }

    public void putFloat(String key, float value) {
        Editor edit = sp.edit();
        edit.putFloat(key, value);
        edit.apply();
    }

    public long getLong(String key) {
        return sp.getLong(key, 0);
    }

    public void putLong(String key, long value) {
        Editor edit = sp.edit();
        edit.putLong(key, value);
        edit.apply();
    }

    public Boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }

    public Boolean getBoolean(String key, boolean value) {
        return sp.getBoolean(key, value);
    }

    public void putBoolean(String key, boolean value) {
        Editor edit = sp.edit();
        edit.putBoolean(key, value);
        edit.apply();
    }

    public void removeValue(String key) {
        Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }
}

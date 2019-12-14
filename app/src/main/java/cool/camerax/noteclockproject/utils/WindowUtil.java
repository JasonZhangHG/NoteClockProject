package cool.camerax.noteclockproject.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cool.camerax.noteclockproject.base.CCApplication;


/**
 * 与屏幕相关的工具类，可以方便的设置全屏模式，可以得到屏幕的宽度高度。
 */

public class WindowUtil {

    public static int[] getScreenSize() {
        WindowManager wm = (WindowManager) CCApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return new int[]{outMetrics.widthPixels, outMetrics.heightPixels};
    }

    public static void setFullScreen(ViewGroup.LayoutParams layoutParams) {
        int[] screenSize = getScreenSize();
        layoutParams.width = screenSize[0];
        layoutParams.height = screenSize[1];
    }

    /**
     * 获得屏幕宽度
     */
    public static int getScreenWidth() {
        WindowManager wm = (WindowManager) CCApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获得屏幕高度
     */
    public static int getScreenHeight() {
        WindowManager wm = (WindowManager) CCApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    public static String getVersionName() {
        String version = "";
        PackageManager packageManager = CCApplication.getInstance().getPackageManager();
        try {
            if (packageManager != null) {
                PackageInfo packInfo = packageManager.getPackageInfo(CCApplication.getInstance().getPackageName(), 0);
                if (packInfo != null) {
                    version = packInfo.versionName;
                    return version;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    //版本号
    public static int getVersionCode() {
        int versionCode = 0;
        PackageManager packageManager = CCApplication.getInstance().getPackageManager();
        try {
            if (packageManager != null) {
                PackageInfo packInfo = packageManager.getPackageInfo(CCApplication.getInstance().getPackageName(), 0);
                if (packInfo != null) {
                    versionCode = packInfo.versionCode;
                    return versionCode;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }


    public static boolean shouldUpdate(@NonNull String version, String minVersion) {

        List<String> versionNums = new ArrayList<>(Arrays.asList(version.split("\\.")));
        List<String> minVersionNums = new ArrayList<>(Arrays.asList(minVersion.split("\\.")));

        int len = Math.max(versionNums.size(), minVersionNums.size());
        for (int i = 0; i < len; i++) {
            if (versionNums.size() < i + 1) {
                versionNums.add("0");
            }

            if (minVersionNums.size() < i + 1) {
                minVersionNums.add("0");
            }

            int gap = Integer.valueOf(versionNums.get(i)) - Integer.valueOf(minVersionNums.get(i));
            if (gap != 0) {
                return gap < 0;
            }
        }

        return true;
    }

    /*
     * 判断服务是否启动,context上下文对象 ，className服务的name
     */
    public static boolean isServiceRunning(Context mContext, String className) {

        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) mContext
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager
                .getRunningServices(30);

        if (!(serviceList.size() > 0)) {
            return false;
        }

        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(className) == true) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }

    public static boolean isPad() {
        if (CCApplication.getInstance() != null) {
            TelephonyManager telephony = (TelephonyManager) CCApplication.getInstance().getSystemService(Context.TELEPHONY_SERVICE);
            if (telephony != null && (telephony.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE)) {
                return true;
            }
        }
        return false;
    }
}

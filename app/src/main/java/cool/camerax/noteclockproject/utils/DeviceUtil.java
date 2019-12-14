package cool.camerax.noteclockproject.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Surface;
import android.view.WindowManager;

import java.util.Locale;

import cool.camerax.noteclockproject.base.CCApplication;
import okio.Buffer;


public class DeviceUtil {

    public static String getDeviceId() {
        TelephonyManager tManager = (TelephonyManager) CCApplication.getInstance().getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") String deviceId = tManager.getDeviceId();
        return TextUtils.isEmpty(deviceId) ? "Emulator" : deviceId;
    }

    public static String getDeviceLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getPhoneModelName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }

        return phrase.toString();
    }

    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {return appProcess.processName;}
        }
        return null;
    }

    /**
     * 处理header是中文的情况
     *
     * @param s
     * @return Returns {@code s} with control characters and non-ASCII characters replaced with '?'
     */
    public static String toHumanReadableAscii(String s) {
        for (int i = 0, length = s.length(), c; i < length; i += Character.charCount(c)) {
            c = s.codePointAt(i);
            if (c > '\u001f' && c < '\u007f') {continue;}

            Buffer buffer = new Buffer();
            buffer.writeUtf8(s, 0, i);
            for (int j = i; j < length; j += Character.charCount(c)) {
                c = s.codePointAt(j);
                buffer.writeUtf8CodePoint(c > '\u001f' && c < '\u007f' ? c : '?');
            }
            return buffer.readUtf8();
        }
        return s;
    }


    public static String getCountryCode() {
        String countryCode = "";
        TelephonyManager manager = (TelephonyManager) CCApplication.getInstance().getSystemService(Context.TELEPHONY_SERVICE);
        String simCountryID = manager.getSimCountryIso().toUpperCase();
        String networkCountryID = manager.getNetworkCountryIso().toUpperCase();
        if (!TextUtils.isEmpty(simCountryID)) {
            countryCode = simCountryID;
        } else if (!TextUtils.isEmpty(networkCountryID)) {
            countryCode = networkCountryID;
        }
        return countryCode;
    }

    public static boolean isNorthAmerican() {
        return getCountryCode().equals("US") || getCountryCode().equals("CA");
    }

    public static boolean isIndia() {
        return getCountryCode().equals("IN");
    }

    public static boolean isRegional() {
        return isIndia() || getCountryCode().equals("PK") || getCountryCode().equals("TR") || getCountryCode().equals("BR") ||
                getCountryCode().equals("SA") || getCountryCode().equals("GB") || getCountryCode().equals("DE") ||
                getCountryCode().equals("IQ") || getCountryCode().equals("RU") || getCountryCode().equals("FR");
    }

    public static boolean isLatinAmerica() {
        return getCountryCode().equals("MX") || getCountryCode().equals("AR") || getCountryCode().equals("CO") ||
                getCountryCode().equals("CL") || getCountryCode().equals("PE") || getCountryCode().equals("CR") ||
                getCountryCode().equals("EC");
    }

    public static int getDisplayRotation() {
        int rotation = ((WindowManager) (CCApplication.getInstance().getSystemService(Context.WINDOW_SERVICE))).getDefaultDisplay().getRotation();
        switch (rotation) {
            case Surface.ROTATION_0:
                return 0;
            case Surface.ROTATION_90:
                return 90;
            case Surface.ROTATION_180:
                return 180;
            case Surface.ROTATION_270:
                return 270;
        }
        return 0;
    }


    /**
     * check the app is installed
     */
    public static boolean isAppInstalled(String packagename) {
        PackageInfo packageInfo;
        try {
            packageInfo = CCApplication.getInstance().getPackageManager().getPackageInfo(packagename, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        if (packageInfo == null) {
            return false;
        } else {
            return true;
        }
    }

}

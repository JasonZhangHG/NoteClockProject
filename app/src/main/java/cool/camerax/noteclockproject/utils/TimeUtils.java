package cool.camerax.noteclockproject.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {

    private static SimpleDateFormat mShortFormater;

    /*
     * 将时间转换为时间戳
     */
    public static long dateToStamp(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
            if (date != null) {
                long ts = date.getTime();
                return ts;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        return stampToDate(Long.parseLong(s));
    }

    public static String stampToDate(long timestamp) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDateDay(long time) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(time);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
     * 将时间戳转换为英语时间
     */
    public static String stampToEnglishDate(long time) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
        Date date = new Date(time);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
     * 将时间戳转换为英文时间
     */
    public static String toEnglishDateFromUtc(String utcTime) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date(getCurrentTimeFromUTC(utcTime));
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String toBirthdayTime(String time) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(time);
            long ts = date.getTime();
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
            Date date2 = new Date(ts);
            String res = simpleDateFormat2.format(date2);
            return res;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static long getCurrentTimeFromUTC(String utcTime) {
        //2018-08-13T07:25:00.000Z
        String date = utcTime.replace("Z", " UTC");//注意是空格+UTC
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");//注意格式化的表达式
        Date d = null;
        try {
            d = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (d != null && d.getTime() > 0) {
            return d.getTime();
        } else {
            return 0;
        }
    }

    public static boolean isSameDay(long time1, long time2) {
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date1.setTimeInMillis(time1);
        date2.setTimeInMillis(time2);
        if (date1.get(Calendar.DAY_OF_MONTH) != date2.get(Calendar.DAY_OF_MONTH)) {
            return false;
        }
        if (date1.get(Calendar.MONTH) != date2.get(Calendar.MONTH)) {
            return false;
        }
        if (date1.get(Calendar.YEAR) != date2.get(Calendar.YEAR)) {
            return false;
        }
        return true;
    }

    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static String convertAsShortTime(long time) {
        if (mShortFormater == null) {
            mShortFormater = new SimpleDateFormat("MMM. d   hh:mm aa", Locale.ENGLISH);
        }
        return mShortFormater.format(time);
    }

    public static String stampToEngShotDate(long time) {
        SimpleDateFormat mShortFormater = new SimpleDateFormat("MMM d", Locale.ENGLISH);
        return mShortFormater.format(new Date(time));
    }
}

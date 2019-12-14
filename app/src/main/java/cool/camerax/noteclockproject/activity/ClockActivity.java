package cool.camerax.noteclockproject.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.blankj.utilcode.util.LogUtils;

import cool.camerax.noteclockproject.R;
import cool.camerax.noteclockproject.base.BaseActivity;
import cool.camerax.noteclockproject.receiver.AlarmClockBroadcast;

public class ClockActivity extends BaseActivity {

    AlarmManager alarmManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(ClockActivity.this, AlarmClockBroadcast.class);
        intent.putExtra("ABC", "2019.12.13 17：12 +1");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(ClockActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent);
        LogUtils.d("AlarmClockBroadcast  ClockActivity()  000 ");


//        Intent intent2 = new Intent(ClockActivity.this, AlarmClockBroadcast.class);
//        intent2.putExtra("ABC", "2019.12.13 17：13 +2");
//        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(ClockActivity.this, 0, intent2, PendingIntent.FLAG_ONE_SHOT);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 2 * 60 * 1000, pendingIntent2);
//        LogUtils.d("AlarmClockBroadcast  ClockActivity()  2222 ");

    }
}

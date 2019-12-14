package cool.camerax.noteclockproject.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.blankj.utilcode.util.LogUtils;

public class AlarmClockBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtils.d("AlarmClockBroadcast  onReceive() intent.getStringExtra :" + intent.getStringExtra("ABC"));
    }
}

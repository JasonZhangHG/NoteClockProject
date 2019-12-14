package cool.camerax.noteclockproject.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;

import org.greenrobot.eventbus.EventBus;

import cool.camerax.noteclockproject.bean.NoteBean;
import cool.camerax.noteclockproject.constants.AppConstant;
import cool.camerax.noteclockproject.utils.GsonConverter;

public class AlarmClockBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String jason = intent.getStringExtra(AppConstant.IntentKey.EXTRA_DATA);
            LogUtils.d("AlarmClockBroadcast  onReceive() jason :" + jason);
            if (TextUtils.isEmpty(jason)) {
                return;
            }
            NoteBean noteBean = GsonConverter.fromJson(jason, NoteBean.class);
            LogUtils.d("AlarmClockBroadcast  onReceive() noteBean :" + noteBean);
            if (noteBean != null) {
                EventBus.getDefault().post(noteBean);
            }
        }
    }
}

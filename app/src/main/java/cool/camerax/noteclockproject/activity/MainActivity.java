package cool.camerax.noteclockproject.activity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.blankj.utilcode.util.LogUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import cool.camerax.noteclockproject.R;
import cool.camerax.noteclockproject.adapter.MyKindAdapter;
import cool.camerax.noteclockproject.base.BaseActivity;
import cool.camerax.noteclockproject.base.CCApplication;
import cool.camerax.noteclockproject.bean.DataSaveEvent;
import cool.camerax.noteclockproject.bean.NoteBean;
import cool.camerax.noteclockproject.constants.AppConstant;
import cool.camerax.noteclockproject.dialog.ShowClockDialog;
import cool.camerax.noteclockproject.receiver.AlarmClockBroadcast;
import cool.camerax.noteclockproject.utils.DBNoteUtils;
import cool.camerax.noteclockproject.utils.GsonConverter;
import cool.camerax.noteclockproject.view.AudioPlayer;

import static android.app.Notification.VISIBILITY_SECRET;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btnKnowledgeActivityAdd)
    Button btnKnowledgeActivityAdd;
    @BindView(R.id.lvKnowledgeActivity)
    ListView lvKnowledgeActivity;
    @BindView(R.id.edt_search_chats_fragment)
    EditText mSearchEditTextt;

    private List<NoteBean> mAllData = new ArrayList<>();
    private List<NoteBean> mCurrentData = new ArrayList<>();
    private List<NoteBean> mSearchConversationAndUserList = new ArrayList<>();
    private MyKindAdapter myAdapter;
    private NoteBean mClockNoteBean;
    private NoteBean mReceiveNoteBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        ButterKnife.bind(this);
        getListViewData();
        setListViewClick();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    public void getListViewData() {
        if (mSearchEditTextt == null) {
            return;
        }
        List<NoteBean> diaryBeanList = DBNoteUtils.getInstance().queryALLData();
        Collections.reverse(diaryBeanList);
        initRecyclerView(diaryBeanList);
        mAllData = diaryBeanList;
        mClockNoteBean = null;
        long currentTime = System.currentTimeMillis();
        LogUtils.d(" MainActivity  currentTime : " + currentTime + " diaryBeanList : " + diaryBeanList);
        if (diaryBeanList != null && diaryBeanList.size() > 0) {
            for (NoteBean noteBean : diaryBeanList) {
                LogUtils.d(" MainActivity  noteBean : " + noteBean);
                if (noteBean != null && (noteBean.getClockTime() > currentTime)) {
                    if (mClockNoteBean == null) {
                        LogUtils.d(" MainActivity  getListViewData 0000");
                        mClockNoteBean = noteBean;
                    } else {
                        if (mClockNoteBean.getClockTime() > noteBean.getClockTime()) {
                            mClockNoteBean = noteBean;
                            LogUtils.d(" MainActivity  getListViewData 111  mClockNoteBean ： " + mClockNoteBean);
                        }
                    }
                }
            }
        }
        LogUtils.d(" MainActivity  mClockNoteBean : " + mClockNoteBean);
        if (mClockNoteBean != null) {
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(MainActivity.this, AlarmClockBroadcast.class);
            intent.putExtra(AppConstant.IntentKey.EXTRA_DATA, GsonConverter.toJson(mClockNoteBean));
            PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.set(AlarmManager.RTC_WAKEUP, mClockNoteBean.getClockTime() - (10 * 1000), pendingIntent);
            LogUtils.d("AlarmClockBroadcast  MainActivity()  000 ");
        }
    }

    public void setListViewClick() {
        lvKnowledgeActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, NoteInfoActivity.class);
                intent.putExtra("NotID", mCurrentData.get(position).getCreatTimeAsId());
                startActivity(intent);
            }
        });
    }

    //设置点击事件
    @OnClick({R.id.btnKnowledgeActivityAdd})
    public void onClick(View view) {
        switch (view.getId()) {
            //处理点击添加点击事件
            case R.id.btnKnowledgeActivityAdd:
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveClockNoteBean(NoteBean noteBean) {
        LogUtils.d("AlarmClockBroadcast  receiveClockNoteBean() noteBean :" + noteBean);
        if (noteBean != null && mSearchEditTextt != null) {
            if (mReceiveNoteBean != null && mReceiveNoteBean.getCreatTimeAsId() == noteBean.getCreatTimeAsId()) {
                return;
            }
            mReceiveNoteBean = noteBean;
            // 播放
            AudioPlayer.getInstance(this).playRaw(R.raw.ring_weac_alarm_clock_default, true, true);
            ShowClockDialog showClockDialog = new ShowClockDialog();
            showClockDialog.setData(noteBean, new ShowClockDialog.OnClickedListener() {
                @Override
                public void onHideListener() {
                    LogUtils.d("AlarmClockBroadcast  ShowClockDialog() onHideListener");
                    AudioPlayer.getInstance(MainActivity.this).stop();
                }
            });
            showClockDialog.tryShow(getSupportFragmentManager());
            sendNotification(noteBean);
            mSearchEditTextt.postDelayed(new Runnable() {
                @Override
                public void run() {
                    getListViewData();
                }
            }, 1000);
            btnKnowledgeActivityAdd.removeCallbacks(closeClockRunnable);
            btnKnowledgeActivityAdd.postDelayed(closeClockRunnable, 30 * 60 * 1000);

        }
    }

    private Runnable closeClockRunnable = new Runnable() {
        @Override
        public void run() {
            AudioPlayer.getInstance(MainActivity.this).stop();
        }
    };

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveDataSaveEvent(DataSaveEvent event) {
        getListViewData();
    }

    @OnTextChanged(R.id.edt_search_chats_fragment)
    public void onSearchTextChanged() {
        if (mSearchEditTextt == null) {
            return;
        }
        if (mSearchEditTextt != null && mSearchEditTextt.hasFocus()) {
            String mSearchInputText = mSearchEditTextt.getText().toString();
            if (TextUtils.isEmpty(mSearchInputText)) {
                mSearchConversationAndUserList.clear();
                initRecyclerView(mAllData);
            } else {
                mSearchConversationAndUserList.clear();
                for (NoteBean diaryBean : mAllData) {
                    if (diaryBean == null) {
                        continue;
                    }
                    String title = diaryBean.getTitle();
                    if (!TextUtils.isEmpty(title) && title.contains(mSearchInputText)) {
                        mSearchConversationAndUserList.add(diaryBean);
                    }
                }
                initRecyclerView(mSearchConversationAndUserList);
            }
        }
    }

    public void initRecyclerView(final List<NoteBean> diaryBeans) {
        if (lvKnowledgeActivity == null) {
            return;
        }
        myAdapter = new MyKindAdapter(diaryBeans, MainActivity.this);
        lvKnowledgeActivity.setAdapter(myAdapter);
        mCurrentData = diaryBeans;
    }

    public void sendNotification(NoteBean noteBean) {
        if (noteBean == null) {
            return;
        }
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "default");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default", "闹钟", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setLockscreenVisibility(VISIBILITY_SECRET);
            channel.setBypassDnd(true);
            notificationManager.createNotificationChannel(channel);
        }
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuilder.setContentTitle(noteBean.getTitle());
        notificationBuilder.setContentText(noteBean.getValue()).setAutoCancel(true);
        notificationBuilder.setContentIntent(pendingIntent);
        Bitmap bm = BitmapFactory.decodeResource(CCApplication.getInstance().getResources(), R.mipmap.ic_launcher);
        notificationBuilder.setLargeIcon(bm);
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }

}

package cool.camerax.noteclockproject.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cool.camerax.noteclockproject.R;
import cool.camerax.noteclockproject.base.BaseActivity;
import cool.camerax.noteclockproject.bean.DataSaveEvent;
import cool.camerax.noteclockproject.bean.NoteBean;
import cool.camerax.noteclockproject.utils.DBNoteUtils;
import cool.camerax.noteclockproject.utils.ToastHelper;
import cool.camerax.noteclockproject.view.NoteEditText;

public class NoteInfoActivity extends BaseActivity {

    @BindView(R.id.tvAddActivityTitle)
    TextView tvAddActivityTitle;
    @BindView(R.id.edtNotXiangQingTitle)
    EditText edtNotXiangQingTitle;
    @BindView(R.id.edtNotXiangQingTime)
    EditText edtNotXiangQingTime;
    @BindView(R.id.edtNotXiangQingCount)
    NoteEditText edtNotXiangQingCount;
    @BindView(R.id.btnNotXiangQingActivityUpdata)
    Button btnNotXiangQingActivityUpdata;
    @BindView(R.id.btnNotXiangQingActivityDelete)
    Button btnNotXiangQingActivityDelete;
    @BindView(R.id.btnNotXiangQingActivityCacel)
    Button btnNotXiangQingActivityCacel;
    @BindView(R.id.rlNotXiangQingActivity)
    RelativeLayout rlNotXiangQingActivity;

    private NoteBean mDiaryBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_info);
        ButterKnife.bind(this);
        initData();
    }

    public void initData() {
        mDiaryBean = DBNoteUtils.getInstance().queryOneData(getIntent().getLongExtra("NotID", 0));
        edtNotXiangQingTitle.setText(mDiaryBean.getTitle());
        SimpleDateFormat sdr1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String CreatedTime1 = sdr1.format(new Date(mDiaryBean.getCreatTimeAsId()));
        edtNotXiangQingTime.setText(CreatedTime1);
        edtNotXiangQingCount.setText(mDiaryBean.getValue());
    }

    //设置点击事件
    @OnClick({R.id.btnNotXiangQingActivityUpdata, R.id.btnNotXiangQingActivityDelete, R.id.btnNotXiangQingActivityCacel})
    public void onClick(View view) {
        switch (view.getId()) {
            //处理点击更新点击事件
            case R.id.btnNotXiangQingActivityUpdata:
                saveNote();
                EventBus.getDefault().post(new DataSaveEvent());
                NoteInfoActivity.this.finish();
                break;
            //处理点击删除点击事件
            case R.id.btnNotXiangQingActivityDelete:
                DBNoteUtils.getInstance().deleteOneData(mDiaryBean);
                EventBus.getDefault().post(new DataSaveEvent());
                NoteInfoActivity.this.finish();
                break;
            case R.id.btnNotXiangQingActivityCacel:
                NoteInfoActivity.this.finish();
                break;
            default:
                break;
        }
    }

    //保存备忘录
    public void saveNote() {
        //取得输入的内容
        String title = edtNotXiangQingTitle.getText().toString().trim();
        String content = edtNotXiangQingCount.getText().toString().trim();
        //内容和标题都不能为空
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(content)) {
            ToastHelper.showShortMessage("名称和内容都不能为空");
        } else {
            mDiaryBean.setTitle(title);
            mDiaryBean.setValue(content);
            mDiaryBean.setCreatTimeAsId(System.currentTimeMillis());
            DBNoteUtils.getInstance().updateData(mDiaryBean);
            ToastHelper.showShortMessage("更新数据成功");
            EventBus.getDefault().post(new DataSaveEvent());
        }
    }
}

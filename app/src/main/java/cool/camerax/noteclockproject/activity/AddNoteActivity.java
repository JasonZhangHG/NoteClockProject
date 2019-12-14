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
import cool.camerax.noteclockproject.R;
import cool.camerax.noteclockproject.base.BaseActivity;
import cool.camerax.noteclockproject.bean.DataSaveEvent;
import cool.camerax.noteclockproject.bean.NoteBean;
import cool.camerax.noteclockproject.utils.DBNoteUtils;
import cool.camerax.noteclockproject.utils.ToastHelper;
import cool.camerax.noteclockproject.view.NoteEditText;

public class AddNoteActivity extends BaseActivity {

    @BindView(R.id.tvAddActivityTitle)
    TextView tvAddActivityTitle;
    @BindView(R.id.editText_add_title)
    EditText editTextAddTitle;
    @BindView(R.id.editText_add_time)
    TextView editTextAddTime;
    @BindView(R.id.noteEditText_add_content)
    NoteEditText noteEditTextAddContent;
    @BindView(R.id.button_add_save)
    Button buttonAddSave;
    @BindView(R.id.button_add_cacel)
    Button buttonAddCacel;
    @BindView(R.id.relativeLayout1)
    RelativeLayout relativeLayout1;

    @BindView(R.id.button_small_text)
    TextView mSmallViewt;
    @BindView(R.id.button_middle_text)
    TextView mMiddleViewt;
    @BindView(R.id.button_big_text)
    TextView mBigView;

    //标题、内容和时间
    private EditText editText_add_title;
    private TextView editText_add_time;
    private NoteEditText noteEditText_add_content;
    private int mSelectGradle = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        editText_add_title = (EditText) findViewById(R.id.editText_add_title);
        editText_add_time = (TextView) findViewById(R.id.editText_add_time);
        noteEditText_add_content = (NoteEditText) findViewById(R.id.noteEditText_add_content);
        editText_add_time.setText(formatTime());
    }

    public void clickView(View view) {
        switch (view.getId()) {
            case R.id.button_add_save:
                //保存备忘录信息
                saveNote();
                break;
            case R.id.button_add_cacel:
                AddNoteActivity.this.finish();
                break;
            case R.id.button_small_text:
                if (mSmallViewt.isSelected()) {
                    mSmallViewt.setSelected(false);
                    mSelectGradle = -1;
                } else {
                    mSmallViewt.setSelected(true);
                    mMiddleViewt.setSelected(false);
                    mBigView.setSelected(false);
                    mSelectGradle = 1;
                }
                break;
            case R.id.button_middle_text:
                if (mMiddleViewt.isSelected()) {
                    mMiddleViewt.setSelected(false);
                    mSelectGradle = -1;
                } else {
                    mMiddleViewt.setSelected(true);
                    mSmallViewt.setSelected(false);
                    mBigView.setSelected(false);
                    mSelectGradle = 2;
                }
                break;

            case R.id.button_big_text:
                if (mBigView.isSelected()) {
                    mBigView.setSelected(false);
                    mSelectGradle = -1;
                } else {
                    mBigView.setSelected(true);
                    mMiddleViewt.setSelected(false);
                    mSmallViewt.setSelected(false);
                    mSelectGradle = 3;
                }
                break;
            default:
                break;
        }
    }

    //保存备忘录
    public void saveNote() {
        //取得输入的内容
        String title = editText_add_title.getText().toString().trim();
        String content = noteEditText_add_content.getText().toString().trim();
        //内容和标题都不能为空
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(content)) {
            ToastHelper.showShortMessage("名称和内容都不能为空");
        } else if (mSelectGradle < 0) {
            ToastHelper.showShortMessage("请选择等级后再保存");
        } else {
            NoteBean diaryBean = new NoteBean();
            diaryBean.setTitle(title);
            diaryBean.setValue(content);
            diaryBean.setCreatTimeAsId(System.currentTimeMillis());
            diaryBean.setGrade(mSelectGradle);
            DBNoteUtils.getInstance().insertOneData(diaryBean);
            ToastHelper.showShortMessage("添加成功");
            EventBus.getDefault().post(new DataSaveEvent());
            AddNoteActivity.this.finish();
        }
    }

    //返回当前的时间
    public String formatTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(d);
        return time;
    }
}

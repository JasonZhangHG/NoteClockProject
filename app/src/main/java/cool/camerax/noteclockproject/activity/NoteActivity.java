package cool.camerax.noteclockproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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
import cool.camerax.noteclockproject.bean.DataSaveEvent;
import cool.camerax.noteclockproject.bean.NoteBean;
import cool.camerax.noteclockproject.utils.DBNoteUtils;

public class NoteActivity extends BaseActivity {

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
        List<NoteBean> diaryBeanList = DBNoteUtils.getInstance().queryALLData();
        Collections.reverse(diaryBeanList);
        initRecyclerView(diaryBeanList);
        mAllData = diaryBeanList;
    }

    public void setListViewClick() {
        lvKnowledgeActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NoteActivity.this, NoteInfoActivity.class);
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
                Intent intent = new Intent(NoteActivity.this, AddNoteActivity.class);
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
        myAdapter = new MyKindAdapter(diaryBeans, NoteActivity.this);
        lvKnowledgeActivity.setAdapter(myAdapter);
        mCurrentData = diaryBeans;
    }
}

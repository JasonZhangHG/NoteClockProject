package cool.camerax.noteclockproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cool.camerax.noteclockproject.R;
import cool.camerax.noteclockproject.bean.NoteBean;

public class MyKindAdapter extends BaseAdapter {

    private List<NoteBean> dbUserInvestmentList;
    private LayoutInflater inflater;
    private MyVidewHolder myViewHolder;

    public MyKindAdapter(List<NoteBean> dbUserInvestmentList, Context context) {
        this.dbUserInvestmentList = dbUserInvestmentList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dbUserInvestmentList.size();
    }

    @Override
    public Object getItem(int position) {
        return dbUserInvestmentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_db_chu_xu_activity, null);
            myViewHolder = new MyVidewHolder(convertView);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (MyVidewHolder) convertView.getTag();
        }
        NoteBean noteBean = dbUserInvestmentList.get(position);
        SimpleDateFormat sdr1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String CreatedTime1 = sdr1.format(new Date(noteBean.getCreatTimeAsId()));
        myViewHolder.tvItemTime.setText("记录时间:" + CreatedTime1);
        myViewHolder.tvItemCount.setText("标题：" + noteBean.getTitle());
        myViewHolder.tvItemSign.setText("内容：" + noteBean.getValue());
        myViewHolder.tvRemindTime.setText("提醒时间：" + noteBean.getShowClockTime());
        switch (noteBean.getGrade()) {
            case 1:
                myViewHolder.tvItemGrade.setText("等级:一般");
                break;
            case 2:
                myViewHolder.tvItemGrade.setText("等级:中等");
                break;
            case 3:
                myViewHolder.tvItemGrade.setText("等级:非常重要");
                break;
            default:
                break;
        }
        return convertView;
    }

    class MyVidewHolder {
        @BindView(R.id.tvItemTitle)
        TextView tvItemTitle;
        @BindView(R.id.tvItemCount)
        TextView tvItemCount;
        @BindView(R.id.tvItemTime)
        TextView tvItemTime;
        @BindView(R.id.tvItemSign)
        TextView tvItemSign;
        @BindView(R.id.tvGrade)
        TextView tvItemGrade;
        @BindView(R.id.tvItemRemindTime)
        TextView tvRemindTime;

        MyVidewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}



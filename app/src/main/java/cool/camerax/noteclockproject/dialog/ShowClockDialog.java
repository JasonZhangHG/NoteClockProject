package cool.camerax.noteclockproject.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cool.camerax.noteclockproject.R;
import cool.camerax.noteclockproject.base.BaseFragmentDialog;
import cool.camerax.noteclockproject.bean.NoteBean;

public class ShowClockDialog extends BaseFragmentDialog {

    @BindView(R.id.tv_title)
    TextView mTitleView;
    @BindView(R.id.tv_subscribe)
    TextView mSubscribeView;
    @BindView(R.id.tv_grade)
    TextView mGradeView;
    @BindView(R.id.tv_yes)
    TextView mYesView;
    @BindView(R.id.rl_log_out_dialog)
    RelativeLayout rlLogOutDialog;
    Unbinder unbinder;
    private NoteBean mNoteBean;
    private OnClickedListener mOnClickedListener;

    private boolean mHasSavedInstanceState;

    @Override
    protected boolean hasSavedInstanceState() {
        return mHasSavedInstanceState;
    }

    public void setSavedInstanceState(boolean hasSavedInstanceState) {
        this.mHasSavedInstanceState = hasSavedInstanceState;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.dialog_show_clock;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mNoteBean != null) {
            mTitleView.setText("标题：" + mNoteBean.getTitle());
            mSubscribeView.setText("内容：" + mNoteBean.getValue());
            switch (mNoteBean.getGrade()) {
                case 1:
                    mGradeView.setText("等级:一般");
                    break;
                case 2:
                    mGradeView.setText("等级:中等");
                    break;
                case 3:
                    mGradeView.setText("等级:非常重要");
                    break;
                default:
                    break;
            }
        }
    }

    @OnClick(R.id.rl_log_out_dialog)
    public void onHidleClicked(View view) {
        if (mOnClickedListener != null) {
            mOnClickedListener.onHideListener();
            tryHide();
        }
    }

    @OnClick(R.id.tv_yes)
    public void onOkClicked(View view) {
        if (mOnClickedListener != null) {
            mOnClickedListener.onHideListener();
            tryHide();
        }
    }

    public interface OnClickedListener {
        void onHideListener();
    }

    public void setData(NoteBean noteBean, OnClickedListener listener) {
        this.mNoteBean = noteBean;
        this.mOnClickedListener = listener;
    }
}

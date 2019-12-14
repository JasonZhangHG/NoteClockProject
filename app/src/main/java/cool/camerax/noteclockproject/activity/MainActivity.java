package cool.camerax.noteclockproject.activity;

import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cool.camerax.noteclockproject.R;
import cool.camerax.noteclockproject.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_clock)
    Button mClockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_clock)
    public void onClockClicked() {
        toActivity(ClockActivity.class);
    }

    @OnClick(R.id.btn_note)
    public void onNoteClicked() {
        toActivity(NoteActivity.class);
    }
}

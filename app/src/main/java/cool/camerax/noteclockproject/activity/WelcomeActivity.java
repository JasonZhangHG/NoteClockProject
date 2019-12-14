package cool.camerax.noteclockproject.activity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cool.camerax.noteclockproject.R;
import cool.camerax.noteclockproject.base.BaseActivity;


public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.tv_welcome)
    TextView mWelcomeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        getPermission();
    }

    public void getPermission() {
        if (mWelcomeView != null) {
            mWelcomeView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toActivity(MainActivity.class);
                    finish();
                }
            }, 1000);
        } else {
            toActivity(MainActivity.class);
            finish();
        }
    }
}

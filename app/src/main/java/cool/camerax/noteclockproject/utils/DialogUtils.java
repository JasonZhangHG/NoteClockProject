package cool.camerax.noteclockproject.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

import cool.camerax.noteclockproject.R;
import cool.camerax.noteclockproject.base.BaseDialog;


public class DialogUtils {

    private static DialogUtils a;

    public static DialogUtils getInstance() {
        if (null == a) {
            a = new DialogUtils();
        }
        return a;
    }

    public Dialog getProgressDialog(Activity context) {
        final Dialog dialog = new BaseDialog(context, R.style.AppTheme_Dialog_Transparent);
        dialog.setContentView(context.getLayoutInflater().inflate(R.layout.dialog_progressbar, null));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER);
        lp.width = (int) DensityUtil.dip2px(82f); // 宽度
        lp.height = (int) DensityUtil.dip2px(82f); // 高度
        dialogWindow.setAttributes(lp);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener(new Dialog.OnKeyListener() {

            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                return (keyCode == KeyEvent.KEYCODE_BACK);  // disable back presse
            }
        });
        return dialog;
    }
}


package com.example.proxy.utils;

import android.content.Context;

import com.example.proxy.R;
import com.example.proxy.widget.loading.ShapeLoadingDialog;

/**
 * @Description Dialog工具类
 * @Author 一花一世界
 */
public class DialogUtil {

    private static ShapeLoadingDialog shapeLoadingDialog;

    /**
     * 显示加载状态框
     */
    public static void showDialogLoading(Context context, String message) {
        if (shapeLoadingDialog != null) {
            hideDialogLoading();
            shapeLoadingDialog = new ShapeLoadingDialog.Builder(context)
                    .loadText(!StringUtil.isEmpty(message) ? message : UIUtils.getString(R.string.loading))
                    .build();
        } else {
            shapeLoadingDialog = new ShapeLoadingDialog.Builder(context)
                    .loadText(!StringUtil.isEmpty(message) ? message : UIUtils.getString(R.string.loading))
                    .build();
        }
        shapeLoadingDialog.setCanceledOnTouchOutside(false);
        shapeLoadingDialog.show();
    }

    /**
     * 关闭加载框
     */
    public static void hideDialogLoading() {
        if (shapeLoadingDialog != null) {
            if (shapeLoadingDialog.isShowing()) {
                shapeLoadingDialog.dismiss();
            }
            shapeLoadingDialog = null;
        }
    }
}

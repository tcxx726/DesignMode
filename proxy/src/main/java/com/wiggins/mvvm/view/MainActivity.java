package com.wiggins.mvvm.view;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.wiggins.mvvm.R;
import com.wiggins.mvvm.base.BaseActivity;
import com.wiggins.mvvm.databinding.ActivityMainBinding;
import com.wiggins.mvvm.utils.UIUtils;
import com.wiggins.mvvm.viewModel.ShowViewModel;
import com.wiggins.mvvm.viewModel.impl.IShowViewModel;
import com.wiggins.mvvm.widget.TitleView;

/**
 * @Description Android设计模式之MVVM
 * @Author 一花一世界
 */
public class MainActivity extends BaseActivity {

    private TitleView titleView;
    private ShowViewModel showViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        if (showViewModel == null) {
            showViewModel = new IShowViewModel(this, binding);
        }

        initView();
    }

    private void initView() {
        titleView = (TitleView) findViewById(R.id.titleView);
        titleView.setAppTitle(UIUtils.getString(R.string.title));
        titleView.setLeftImageVisibility(View.GONE);
    }
}
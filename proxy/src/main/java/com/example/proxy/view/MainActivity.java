package com.example.proxy.view;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.proxy.BaseActivity;
import com.example.proxy.R;
import com.example.proxy.databinding.ActivityMainBinding;
import com.example.proxy.utils.UIUtils;
import com.example.proxy.viewModel.ShowViewModel;
import com.example.proxy.viewModel.impl.IShowViewModel;
import com.example.proxy.widget.TitleView;

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
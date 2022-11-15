package com.wiggins.mvvm.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.wiggins.mvvm.R;
import com.wiggins.mvvm.base.BaseActivity;
import com.wiggins.mvvm.databinding.ResourceBinding;
import com.wiggins.mvvm.utils.UIUtils;
import com.wiggins.mvvm.widget.TitleView;

/**
 * @Description 使用资源数据
 * @Author 一花一世界
 */
public class ResourceActivity extends BaseActivity {

    private TitleView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ResourceBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_resource);
        binding.setLarge(true);
        binding.setFirstName("小明");
        binding.setLastName("小花");
        binding.setBananaCount(2);
        binding.setOrangeCount(10);

        initView();
    }

    private void initView() {
        titleView = (TitleView) findViewById(R.id.titleView);
        titleView.setAppTitle(UIUtils.getString(R.string.user_resource_data));
        titleView.setLeftImgOnClickListener();
    }
}

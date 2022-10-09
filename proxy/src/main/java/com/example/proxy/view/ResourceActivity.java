package com.example.proxy.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.example.proxy.BaseActivity;
import com.example.proxy.R;
import com.example.proxy.databinding.ResourceBinding;
import com.example.proxy.utils.UIUtils;
import com.example.proxy.widget.TitleView;

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

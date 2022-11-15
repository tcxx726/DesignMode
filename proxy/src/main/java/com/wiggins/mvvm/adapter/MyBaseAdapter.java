package com.wiggins.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import java.util.List;

/**
 * @Description 通用适配器
 * @Author 一花一世界
 */
public class MyBaseAdapter<T> extends BaseAdapter {

    private LayoutInflater inflater;
    private int layoutId;
    private int variableId;
    private List<T> list;

    public MyBaseAdapter(Context context, int layoutId, int variableId, List<T> list) {
        this.layoutId = layoutId;
        this.variableId = variableId;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<T> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding dataBinding;
        if (convertView == null) {
            dataBinding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        } else {
            dataBinding = DataBindingUtil.getBinding(convertView);
        }
        dataBinding.setVariable(variableId, list.get(position));
        return dataBinding.getRoot();
    }
}
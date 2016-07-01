/**
 * Copyright (c) 2016. 李苜菲 Inc. All rights reserved.
 */
package com.poomoo.homeonline.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.poomoo.commlib.LogUtils;
import com.poomoo.homeonline.R;
import com.poomoo.homeonline.adapter.base.MyBaseAdapter;
import com.poomoo.homeonline.listeners.ClassifyOnItemClickListener;
import com.poomoo.model.response.RSubClassifyBO;

/**
 * 作者: 李苜菲
 * 日期: 2016/6/23 15:56.
 */
public class SubClassifyGridAdapter extends MyBaseAdapter<RSubClassifyBO> {
    private String TAG = "SubClassifyGridAdapter";
    private RSubClassifyBO item;
    private ClassifyOnItemClickListener onItemClickListener;

    public SubClassifyGridAdapter(Context context, ClassifyOnItemClickListener onItemClickListener) {
        super(context);
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        viewHolder = new ViewHolder();
        item = itemList.get(position);
        LogUtils.d(TAG, "getView:" + position + ":" + item.name);
        convertView = inflater.inflate(R.layout.item_grid_sub_classify, null);
        viewHolder.nameTxt = (TextView) convertView.findViewById(R.id.txt_subClassify);
        viewHolder.nameTxt.setText(item.name);
        viewHolder.nameTxt.setOnClickListener(new OnItemClick(item.name));
        return convertView;
    }

    class ViewHolder {
        private TextView nameTxt;
    }

    class OnItemClick implements View.OnClickListener {
        private String name;

        public OnItemClick(String name) {
            this.name = name;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onClick(this.name);
        }
    }


}
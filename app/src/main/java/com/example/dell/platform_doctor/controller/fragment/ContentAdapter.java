package com.example.dell.platform_doctor.controller.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.ittiger.recyclerview.CommonRecyclerViewAdapter;
import cn.ittiger.recyclerview.CommonViewHolder;

/*
 * Created by JohnnyTan on 2017/9/17.
 */

public class ContentAdapter extends CommonRecyclerViewAdapter<String>{
    private Context mContext;
    protected ContentAdapter(Context context, List<String> list)
    {
        super(list);
        mContext = context;
    }

    @Override
    public CommonViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1,parent,false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(CommonViewHolder holder, int position, String item) {
        ContentViewHolder viewHolder = (ContentViewHolder) holder;
        viewHolder.mTextView.setText(mList.get(position));
    }

    private class ContentViewHolder extends CommonViewHolder {
        TextView mTextView;
        private ContentViewHolder(View itemview) {
            super(itemview);
            mTextView = (TextView) itemview;
        }
    }
}

package com.example.dell.platform_doctor.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.platform_doctor.R;

import java.util.ArrayList;
import java.util.List;

import cn.ittiger.recyclerview.CommonRecyclerView;

/*
 * Created by JohnnyTan on 2017/9/17.
 */

public class ContentFragment extends Fragment {
    private CommonRecyclerView mRecyclerView;
    private ContentAdapter mAdapter;
    private int mFragmentIndex;

    public String getName() {

        return "Tab" + (getArguments().getInt("fragmentIndex") + 1);
    }

    public static ContentFragment newInstance(int fragmentIndex) {

        ContentFragment fragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("fragmentIndex", fragmentIndex);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        mFragmentIndex = bundle.getInt("fragmentIndex");

        View view = inflater.inflate(R.layout.fragment_content, null);
        mRecyclerView = (CommonRecyclerView) view.findViewById(R.id.recyclerView);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        List<String> list = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            list.add("Fragment " + mFragmentIndex + ", 第" + (i + 1) + "条数据");
        }

        mAdapter = new ContentAdapter(getContext(), list);
        mRecyclerView.setAdapter(mAdapter);
    }
}

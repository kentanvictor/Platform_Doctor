package com.example.dell.platform_doctor.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.platform_doctor.R;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by KenTan on 2017/7/12.
 */

public class FavFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    public static FavFragment newInstance() {
        return new FavFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        return view;
    }

    private void initViewData() {

        List<ContentFragment> fragments = new ArrayList<>();
        for (int i = 0; i < 5;i++) {
            fragments.add(ContentFragment.newInstance(i));
        }
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        ContentFragmentAdapter adapter = new ContentFragmentAdapter(fragments,getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}

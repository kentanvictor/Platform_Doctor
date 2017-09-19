package com.example.dell.platform_doctor.controller.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/*
 * Created by JohnnyTan on 2017/9/17.
 */

public class ContentFragmentAdapter extends FragmentPagerAdapter {
    private List<ContentFragment> mFragments;

    public ContentFragmentAdapter(List<ContentFragment> fragments, android.support.v4.app.FragmentManager fm) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getName();
    }
}

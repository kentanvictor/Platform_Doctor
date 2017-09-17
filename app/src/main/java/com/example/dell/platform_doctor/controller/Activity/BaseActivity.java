package com.example.dell.platform_doctor.controller.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.platform_doctor.R;
import com.example.dell.platform_doctor.controller.fragment.ContentFragment;
import com.example.dell.platform_doctor.controller.fragment.ContentFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;

/*
 * Created by johnnyTan on 2017/7/12.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private android.support.v4.app.FragmentManager fm;
    private Fragment mFragment;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;
    private AppBarLayout mAppBarLayout;

    protected abstract Fragment createFragment();

    @LayoutRes
    public abstract int getLayoutResId();

    @IdRes
    public abstract int getContainerId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        Bmob.initialize(this, "55591ce0eebfd0a9bb70c0bcee79013f");
        fm = getSupportFragmentManager();
        mFragment = fm.findFragmentById(getContainerId());

        if (mFragment == null) {
            mFragment = createFragment();
            fm.beginTransaction()
                    .add(getContainerId(), mFragment)
                    .commit();
        }
        init();
        initViewData();
    }

    public void init() {
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
    }

    public void switchFragment(Fragment fragment) {
        if (mFragment == null
                || !fragment.getClass().getName().equals(mFragment.getClass().getName())) {
            fm.beginTransaction()
                    .replace(getContainerId(), fragment)
                    .commit();
            mFragment = fragment;
        }
    }

    private void initViewData() {

        List<ContentFragment> fragments = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fragments.add(ContentFragment.newInstance(i));
        }
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

        ContentFragmentAdapter adapter = new ContentFragmentAdapter(fragments, getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}

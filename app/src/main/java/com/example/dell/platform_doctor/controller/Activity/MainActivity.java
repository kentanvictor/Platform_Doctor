package com.example.dell.platform_doctor.controller.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;

import com.example.dell.platform_doctor.R;
import com.example.dell.platform_doctor.controller.fragment.FavFragment;
import com.example.dell.platform_doctor.controller.fragment.FindFragment;
import com.example.dell.platform_doctor.controller.fragment.MapFragment;
import com.example.dell.platform_doctor.controller.fragment.SetFragment;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public BottomNavigationView navigationView;
    private Fragment mFragment;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment createFragment() {
        return MapFragment.newInstance();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public int getContainerId() {
        return R.id.fragment_container;
    }

    @Override
    public void init() {
        super.init();
        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

        mTabLayout.setVisibility(View.GONE);
        mViewPager.setVisibility(View.GONE);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mTabLayout.setVisibility(View.GONE);
        mViewPager.setVisibility(View.GONE);

        switch (item.getItemId()) {
            case R.id.bottom_nav_map:
                switchFragment(MapFragment.newInstance());
                mToolBar.setVisibility(View.VISIBLE);
                break;
            case R.id.bottom_nav_set:
                switchFragment(SetFragment.newInstance());
                mToolBar.setVisibility(View.INVISIBLE);
                break;
            case R.id.bottom_nav_find:
                switchFragment(FindFragment.newInstance());
                mToolBar.setVisibility(View.VISIBLE);
                break;
            case R.id.bottom_nav_fav:
                switchFragment(FavFragment.newInstance());
                mToolBar.setVisibility(View.VISIBLE);
                mTabLayout.setVisibility(View.VISIBLE);
                mViewPager.setVisibility(View.VISIBLE);
                break;
        }
        return true;
    }
}

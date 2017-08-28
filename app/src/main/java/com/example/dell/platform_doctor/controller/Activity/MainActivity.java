package com.example.dell.platform_doctor.controller.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.example.dell.platform_doctor.R;
import com.example.dell.platform_doctor.controller.fragment.FavFragment;
import com.example.dell.platform_doctor.controller.fragment.FindFragment;
import com.example.dell.platform_doctor.controller.fragment.MapFragment;
import com.example.dell.platform_doctor.controller.fragment.SetFragment;

public class  MainActivity extends BaseActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {
    public  BottomNavigationView navigationView;

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
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bottom_nav_map:
                switchFragment(MapFragment.newInstance());
                break;
            case R.id.bottom_nav_set:
                switchFragment(SetFragment.newInstance());
                break;
            case R.id.bottom_nav_find:
                switchFragment(FindFragment.newInstance());
                break;
            case R.id.bottom_nav_fav:
                switchFragment(FavFragment.newInstance());
                break;
        }
        return true;
    }
}

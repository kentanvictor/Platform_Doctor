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

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    /*TabLayout mTabLayout;
    ViewPager mViewPager;
    BottomNavigationView mBottomNavigationView;
    AppBarLayout mAppBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);


        *//**
         * 如果不想使用Behavior实现BottomNavigationView进行隐藏显示的画，也可用采用下面的监听实现此效果
         * *//*
        *//*mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                Log.d("MainActivity", verticalOffset + "");
                mBottomNavigationView.setTranslationY(-verticalOffset);
            }
        });*//*

        initViewData();
    }

    private void initViewData() {

        List<ContentFragment> fragments = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            fragments.add(ContentFragment.newInstance(i));
        }
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

        ContentFragmentAdapter adapter = new ContentFragmentAdapter(fragments, getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }*/
    public BottomNavigationView navigationView;

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

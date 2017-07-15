package com.example.dell.platform_doctor.Activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import cn.bmob.v3.Bmob;

/*
 * Created by KenTan on 2017/7/12.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private android.support.v4.app.FragmentManager fm;
    private Fragment mFragment;

    protected abstract Fragment createFragment();

    @LayoutRes
    public abstract int getLayoutResId();

    @IdRes
    public abstract int getContainerId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        Bmob.initialize(this, "c833ab4f4c879430ecd6da55841e252c");
        fm = getSupportFragmentManager();
        mFragment = fm.findFragmentById(getContainerId());

        if (mFragment == null) {
            mFragment = createFragment();
            fm.beginTransaction()
                    .add(getContainerId(), mFragment)
                    .commit();
        }
        init();
    }

    public void init() {
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
}

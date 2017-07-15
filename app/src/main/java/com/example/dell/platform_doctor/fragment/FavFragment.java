package com.example.dell.platform_doctor.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.platform_doctor.R;

/*
 * Created by KenTan on 2017/7/12.
 */

public class FavFragment extends Fragment {
    public static FavFragment newInstance() {
        return new FavFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        return view;
    }
}

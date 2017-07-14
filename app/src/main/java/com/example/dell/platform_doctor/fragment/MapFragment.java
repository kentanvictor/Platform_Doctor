package com.example.dell.platform_doctor.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dell.platform_doctor.Activity.LBSActivity;
import com.example.dell.platform_doctor.R;

/*
 * Created by KenTan on 2017/7/12.
 */

public class MapFragment extends Fragment implements View.OnClickListener{
    Button lbs_but;
    public static MapFragment newInstance() {
        return new MapFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map,container,false);
        initView(view);
        return view;
    }
    public void initView(View view)
    {
        lbs_but = (Button) view.findViewById(R.id.lbs_but);
        lbs_but.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.lbs_but:
                Intent intent = new Intent(getContext(), LBSActivity.class);
                startActivity(intent);
                break;
        }
    }
}

package com.example.dell.platform_doctor.controller.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.dell.platform_doctor.R;
import com.example.dell.platform_doctor.model.AddData;

/*
 * Created by JohnnyTan on 2017/7/12.
 */

public class SetFragment extends Fragment implements View.OnClickListener {
    private Button back;
    private Button btn_true;
    private EditText addName;
    private EditText addAddress;
    private EditText addPhone;
    private EditText addAge;
    private String name;
    private String address;
    private String number;
    private int age;
    private AddData add;
    private Context context;

    public static SetFragment newInstance() {
        return new SetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set, container, false);
        initView(view);
        return view;
    }

    public void initView(View view) {
        back = (Button) view.findViewById(R.id.btn_back);
        btn_true = (Button) view.findViewById(R.id.btn_true);
        addName = (EditText) view.findViewById(R.id.name_edit1);
        addAddress = (EditText) view.findViewById(R.id.address_edit1);
        addPhone = (EditText) view.findViewById(R.id.phone_number);
        addAge = (EditText) view.findViewById(R.id.age_edit1);
        back.setOnClickListener(this);
        btn_true.setOnClickListener(this);
        addName.setOnClickListener(this);
        addAddress.setOnClickListener(this);
        addPhone.setOnClickListener(this);
        addAge.setOnClickListener(this);
        add = new AddData();
        context = getActivity();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                break;
            case R.id.btn_true:
                name = addName.getText().toString();
                address = addAddress.getText().toString();
                number = addPhone.getText().toString();
                age = Integer.parseInt(addAge.getText().toString());
                add.addSingleData(context, name, address, number, age);
                break;
            default:
                break;
        }
    }
}

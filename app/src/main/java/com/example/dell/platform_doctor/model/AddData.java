package com.example.dell.platform_doctor.model;

import android.content.Context;
import android.widget.Toast;

import com.example.dell.platform_doctor.gson.Person;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/*
 * Created by JohnnyTan on 2017/8/28.
 */

public class AddData {
    //增加單條數據
    public void addSingleData(final Context context, String name, String address, String number, int age) {
        Person p2 = new Person();
        p2.setName(name);
        p2.setAddress(address);
        p2.setPhoneNumber(number);
        p2.setAge(age);
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null) {
                    showToast(context, "添加数据成功，返回objectId为：" + objectId);
                } else {
                    showToast(context, "创建数据失败：" + e.getMessage());
                }
            }
        });
    }

    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}

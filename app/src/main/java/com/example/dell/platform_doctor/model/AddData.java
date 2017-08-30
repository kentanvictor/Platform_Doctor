package com.example.dell.platform_doctor.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.dell.platform_doctor.gson.Person;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobBatch;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BatchResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListListener;
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

    //批量添加數據
    public void addPlentyData(final Context context) {
        List<BmobObject> persons = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Person person = new Person();
            person.setName("張三");
            person.setAddress("北京海淀");
            persons.add(person);
        }
        //v.3.5.0之後開始提供的批量添加數據方法
        new BmobBatch().insertBatch(persons).doBatch(new QueryListListener<BatchResult>() {
            @Override
            public void done(List<BatchResult> list, BmobException e) {
                if (e == null) {
                    for (int i = 0; i < list.size(); i++) {
                        BatchResult result = list.get(i);
                        BmobException ex = result.getError();
                        if (ex == null) {
                            showToast(context, "第" + (i + 1) + "個數據批量添加成功:" + result.getCreatedAt() + "," + result.getObjectId() + "," + result.getUpdatedAt());
                        } else {
                            showToast(context, "第" + (i + 1) + "个数据批量添加失败：" + ex.getMessage() + "," + ex.getErrorCode());
                        }
                    }
                } else {
                    Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
                }
            }
        });
    }

    //用戶註冊
    public void setUser(final Context context) {
        BmobUser user = new BmobUser();
        user.setUsername("sendi");
        user.setPassword("123456");
        user.setEmail("sendi@gmail.com");
        //不能用save方法進行註冊
        user.signUp(new SaveListener<Person>() {
            @Override
            public void done(Person p1, BmobException e) {
                if (e == null) {
                    showToast(context,"注册成功:" + p1.toString());
                } else {
                    showToast(context,"done:" + e);
                }
            }
        });
    }

    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}

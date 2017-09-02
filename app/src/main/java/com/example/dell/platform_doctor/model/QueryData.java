package com.example.dell.platform_doctor.model;

import android.content.Context;
import android.widget.Toast;

import com.example.dell.platform_doctor.gson.Person;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;

/*
 * Created by JohnnyTan on 2017/9/2.
 */

public class QueryData {
    private String name;
    private Object objectId;
    private String createdAt;
    private String address;
    private int age;
    private String phoneNumber;

    //查詢單條數據
    public void querySingleData(final Context context) {
        BmobQuery<Person> p1 = new BmobQuery<>();
        p1.getObject("abaf456099", new QueryListener<Person>() {
            @Override
            public void done(Person person, BmobException e) {
                if (e == null) {
                    showToast(context,"查詢成功!" + person.getAddress());
                } else {
                    showToast(context,"查詢失敗:" + e.getMessage());

                }
            }
        });
    }

    //查詢多條數據
    public void queryPlentyData(final Context context) {
        BmobQuery<Person> query = new BmobQuery<>();
        //查詢name中叫KenTan的數據
        query.addWhereEqualTo("name", "KenTan");
        query.addWhereLessThan("age", 50);//條件:年齡小於50歲
        //返回50條數據,如果不加上這句,默認返回10條
        query.setLimit(50);
        //執行查詢方法
        query.findObjects(new FindListener<Person>() {
            @Override
            public void done(List<Person> list, BmobException e) {
                if (e == null) {
                    showToast(context,"查询成功：共" + list.size() + "条数据。");
                    for (Person p2 : list) {
                        //獲取Name的信息
                        name = p2.getName();
                        //獲取數據的objectId的信息
                        objectId = p2.getObjectId();
                        //獲取createdAt數據創建時間(注意:是createdAt,不是createAt)
                        createdAt = p2.getCreatedAt();
                        //獲取address
                        address = p2.getAddress();
                        //獲取age
                        age = p2.getAge();
                        //獲取number
                        phoneNumber = p2.getPhoneNumber();
                        showToast(context,"數據為:\n" + name + "\n" + "Phone NUmber:" + phoneNumber + "\n" + "Address:" + address + "\n" + "Age:" + age + "\n" + createdAt);
                    }
                } else {
                    showToast(context,"張三查詢失敗:" + e.getMessage() + "," + e.getErrorCode());
                }

            }
        });
    }

    //Toast
    public void showToast(Context context , CharSequence text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}

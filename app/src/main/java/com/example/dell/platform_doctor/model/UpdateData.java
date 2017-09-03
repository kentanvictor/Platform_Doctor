package com.example.dell.platform_doctor.model;

import android.content.Context;
import android.widget.Toast;

import com.example.dell.platform_doctor.gson.Person;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

/*
 * Created by JohnnyTan on 2017/9/3.
 */

public class UpdateData {
    private Object objectId;

    //更新數組數據
    public void updateArray(final Context context) {
        Person p2 = new Person();
        //更新String类型数组中的值
        p2.setValue("hobbys.0", "爬山"); //将hobbys中第一个位置的爱好（上面添加成功的唱歌）修改为爬山
        //更新Object类型数组中的某个位置的对象值(0对应集合中第一个元素)
        p2.setValue("cards.0", new Person.BankCard("中行", "中行卡号"));    //将cards中第一个位置银行卡修改为指定BankCard对象
        //更新Object类型数组中指定对象的指定字段的值
        //p2.setValue("cards.0.bankName", "农行卡");  //将cards中第一个位置的银行卡名称修改为农行卡
        //p2.setValue("cards.1.cardNumber", "农行卡账号"); //将cards中第二个位置的银行卡账号修改为农行卡账号
        p2.update((String) objectId, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    showToast(context,"bmob 保存成功");
                } else {
                    showToast(context,"bmob 保存失败：" + e.getMessage());
                }
            }
        });
    }

    //修改單條數據
    public void changeSingleData(final Context context) {
        final Person p1 = new Person();
        p1.setAddress("上海虹橋");
        p1.update("e3a9364d52", new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    showToast(context,"更新成功" + p1.getUpdatedAt());
                } else {
                    showToast(context,"更新失敗" + e.getMessage());
                }
            }
        });
    }

    //批量更新數據
    public void updatePlentyData() {
        List<BmobObject> persons = new ArrayList<>();
        Person p1 = new Person();
    }


    //Toast
    public void showToast(Context context, CharSequence text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}

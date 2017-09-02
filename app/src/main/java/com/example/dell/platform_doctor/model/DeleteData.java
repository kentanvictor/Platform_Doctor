package com.example.dell.platform_doctor.model;

import android.content.Context;
import android.widget.Toast;

import com.example.dell.platform_doctor.gson.Person;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by JohnnyTan on 2017/9/2.
 */

public class DeleteData {
    //刪除單條數據
    public void deleteSingleData(final Context context) {
        final Person p3 = new Person();
        p3.setObjectId("abaf456099");
        p3.delete(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    showToast(context,"刪除數據成功:" + p3.getUpdatedAt());
                } else {
                    showToast(context,"刪除數據失敗:" + e.getMessage());
                }
            }
        });
    }

    //Toast
    public void showToast(Context context, CharSequence text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}

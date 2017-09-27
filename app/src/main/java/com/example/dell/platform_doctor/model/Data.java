package com.example.dell.platform_doctor.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.dell.platform_doctor.gson.Person;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobBatch;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BatchResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/*
 * Created by JohnnyTan on 2017/9/27.
 */

public class Data {
    private String name;
    private String createdAt;
    private String address;
    private int age;
    private String phoneNumber;
    private Object objectId;

    /**
     * 增加数据
     */
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
                    showToast(context, "注册成功:" + p1.toString());
                } else {
                    showToast(context, "done:" + e);
                }
            }
        });
    }

    /**
     * 第二段
     * 删除数据
     */

    //刪除單條數據
    public void deleteSingleData(final Context context) {
        final Person p3 = new Person();
        p3.setObjectId("abaf456099");
        p3.delete(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    showToast(context, "刪除數據成功:" + p3.getUpdatedAt());
                } else {
                    showToast(context, "刪除數據失敗:" + e.getMessage());
                }
            }
        });
    }

    /**
     * 第三段
     * 查询数据
     */

    //查詢單條數據
    public void querySingleData(final Context context) {
        BmobQuery<Person> p1 = new BmobQuery<>();
        p1.getObject("abaf456099", new QueryListener<Person>() {
            @Override
            public void done(Person person, BmobException e) {
                if (e == null) {
                    showToast(context, "查詢成功!" + person.getAddress());
                } else {
                    showToast(context, "查詢失敗:" + e.getMessage());

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
                    showToast(context, "查询成功：共" + list.size() + "条数据。");
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
                        showToast(context, "數據為:\n" + name + "\n" + "Phone NUmber:" + phoneNumber + "\n" + "Address:" + address + "\n" + "Age:" + age + "\n" + createdAt);
                    }
                } else {
                    showToast(context, "張三查詢失敗:" + e.getMessage() + "," + e.getErrorCode());
                }

            }
        });
    }

    /**
     * 第四段
     * 更新数据
     */

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
                    showToast(context, "bmob 保存成功");
                } else {
                    showToast(context, "bmob 保存失败：" + e.getMessage());
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
                    showToast(context, "更新成功" + p1.getUpdatedAt());
                } else {
                    showToast(context, "更新失敗" + e.getMessage());
                }
            }
        });
    }

    //批量更新數據
    public void updatePlentyData() {
        List<BmobObject> persons = new ArrayList<>();
        Person p1 = new Person();
    }

    private static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}

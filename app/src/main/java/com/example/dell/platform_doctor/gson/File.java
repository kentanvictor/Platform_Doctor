package com.example.dell.platform_doctor.gson;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/*
 * Created by JohnnyTan on 2017/9/3.
 */

public class File extends BmobObject{
    private BmobFile file;
    private String Name;
    private String password;

    public File(String name, String password, BmobFile file) {
        this.Name = name;
        this.password = password;
        this.file = file;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BmobFile getFile() {
        return file;
    }

    public void setFile(BmobFile file) {
        this.file = file;
    }
}

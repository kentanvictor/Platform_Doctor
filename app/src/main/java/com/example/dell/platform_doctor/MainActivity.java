package com.example.dell.platform_doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button lbs_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.lbs_but:
                Intent intent = new Intent(MainActivity.this,LBSActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    //初始化
    public void init() {
        lbs_but = (Button) findViewById(R.id.lbs_but);
        lbs_but.setOnClickListener(this);
    }
}

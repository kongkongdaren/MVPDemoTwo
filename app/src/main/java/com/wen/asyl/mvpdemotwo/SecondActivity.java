package com.wen.asyl.mvpdemotwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Description：xx <br/>
 * Copyright (c) 2018{<br/>
 * This program is protected by copyright laws <br/>
 * Date: 2018-10-10
 *
 * @author jwj
 * @version : 1.0
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String pwd = intent.getStringExtra("pwd");
        Log.e("111111",name+","+pwd);
    }
}

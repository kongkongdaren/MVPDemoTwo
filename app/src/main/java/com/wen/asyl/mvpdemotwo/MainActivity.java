package com.wen.asyl.mvpdemotwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.wen.asyl.model.User;
import com.wen.asyl.presenter.LoginPresenter;
import com.wen.asyl.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{
     private EditText mEtUserName,mEtPassWord;
     private Button mBtnLogin;
     private ProgressBar mPbLoading;
     LoginPresenter mLoginPresenter=new LoginPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEtUserName=  findViewById(R.id.et_username);
        mEtPassWord=  findViewById(R.id.et_password);
        mBtnLogin=  findViewById(R.id.btn_login);
        mPbLoading=  findViewById(R.id.pb_loading);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.login();
            }
        });
    }

    @Override
    public String getUsername() {
        return mEtUserName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return mEtPassWord.getText().toString().trim();
    }

    @Override
    public void toMainActivity(User user) {
        Intent intent=new Intent(this,SecondActivity.class);
        intent.putExtra("name",user.getUsername());
        intent.putExtra("pwd",user.getPassword());
        startActivity(intent);
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
      mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }
}

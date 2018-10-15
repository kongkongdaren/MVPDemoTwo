package com.wen.asyl.presenter;

import android.os.Handler;

import com.wen.asyl.model.IUser;
import com.wen.asyl.model.User;
import com.wen.asyl.model.UserBiz;
import com.wen.asyl.view.LoginView;


/**
 * Description：xx <br/>
 * Copyright (c) 2018{<br/>
 * This program is protected by copyright laws <br/>
 * Date: 2018-10-10
 *
 * @author jwj
 * @version : 1.0
 */
public class LoginPresenter {
    private LoginView loginView;
    private UserBiz userBiz;
    private Handler mHandler=new Handler() ;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        userBiz=new UserBiz();
    }

    public void login() {
        loginView.showLoading();
        userBiz.login(loginView.getUsername(), loginView.getPassword(), new IUser.LoginListener() {
            @Override
            public void success(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toMainActivity(user);
                        loginView.hideLoading();
                    }
                });
            }
            @Override
            public void failed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFailedError();
                        loginView.hideLoading();
                    }
                });
            }
        });
    }
}

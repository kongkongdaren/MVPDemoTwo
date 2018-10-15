package com.wen.asyl.view;

import com.wen.asyl.model.User;

/**
 * Description：xx <br/>
 * Copyright (c) 2018{<br/>
 * This program is protected by copyright laws <br/>
 * Date: 2018-10-10
 *
 * @author jwj
 * @version : 1.0
 */
public interface LoginView {
    //获取用户名和密码
    String getUsername();
    String  getPassword();
    //登录成功与失败
    void toMainActivity(User user);
    void showFailedError();
    //给用户的提示
    void showLoading();
    void hideLoading();
}

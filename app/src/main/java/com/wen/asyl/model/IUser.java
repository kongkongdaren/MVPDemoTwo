package com.wen.asyl.model;

/**
 * Description：登录接口 <br/>
 * Copyright (c) 2018{<br/>
 * This program is protected by copyright laws <br/>
 * Date: 2018-10-10
 *
 * @author jwj
 * @version : 1.0
 */
public interface IUser {
    void login(String username,String password,LoginListener listener);
    interface  LoginListener{
        void success(User user);
        void failed();
    }
}

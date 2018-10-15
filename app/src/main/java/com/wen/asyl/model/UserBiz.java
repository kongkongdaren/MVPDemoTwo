package com.wen.asyl.model;

/**
 * Description：登录接口的实现类 <br/>
 * Copyright (c) 2018{<br/>
 * This program is protected by copyright laws <br/>
 * Date: 2018-10-10
 *
 * @author jwj
 * @version : 1.0
 */
public class UserBiz implements IUser {
    @Override
    public void login(final String username, final String password, final LoginListener listener) {
        //开启子线程模拟登录
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                 if ("admin".equals(username)&&"123456".equals(password)){
                       User user=new User();
                       user.setUsername(username);
                       user.setPassword(password);
                       listener.success(user);
                 }else{
                     listener.failed();
                 }
            }
        }.start();
    }
}

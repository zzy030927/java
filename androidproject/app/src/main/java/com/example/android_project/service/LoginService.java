package com.example.android_project.service;

import android.app.AlertDialog;
import android.content.Context;
import com.example.android_project.mapper.UserDBHelper;
import com.example.android_project.pojo.User;

public class LoginService {
    private final UserDBHelper userDBHelper;
    private final AlertDialog alertDialog;
    public LoginService(Context context) {
        userDBHelper = UserDBHelper.getInstance(context, 1);
        //打开数据库帮助器的写连接
        userDBHelper.openWriteLink();
        alertDialog = new AlertDialog.Builder(context)
                .setPositiveButton("确认", null)
                .create();
    }

    public boolean login(User user) {
        if (!userDBHelper.select(user)) {
            alertDialog.setTitle("登陆失败");
            alertDialog.setMessage("用户名或密码错误");
            alertDialog.show();
            return false;
        }
        return true;
    }

    public boolean register(User user) {
        if ("".equals(user.getUsername()) || "".equals(user.getPwd())) {
            alertDialog.setTitle("注册失败");
            alertDialog.setMessage("用户名或密码为空");
            alertDialog.show();
            return false;
        }
        else if (!userDBHelper.insert(user)) {
            alertDialog.setTitle("注册失败");
            alertDialog.setMessage("用户已注册，请重新更换用户名");
            alertDialog.show();
            return false;
        } else {
            alertDialog.setTitle("注册成功");
            alertDialog.show();
        }
        return true;
    }

    public boolean resetPwd(User user, String resetPwdContext, String surePwdContext) {
        if ("".equals(user.getUsername()) || "".equals(resetPwdContext)) {
            alertDialog.setTitle("设置失败");
            alertDialog.setMessage("请输入用户名或密码");
            alertDialog.show();
            return false;
        } else if (!resetPwdContext.equals(surePwdContext)) {
            alertDialog.setTitle("设置失败");
            alertDialog.setMessage("两次输入的密码不一致，请重新输入");
            alertDialog.show();
            return false;
        } else {
            user.setPwd(resetPwdContext);
            int row = userDBHelper.update(user, "username = ?", new String[]{user.getUsername()});
            if (row == 0) {
                alertDialog.setTitle("设置失败");
                alertDialog.setMessage("无此账号，请检查账号是否正确");
                alertDialog.show();
                return false;
            }
        }
        return true;
    }

    public int selectByUserName(String username) {
        return userDBHelper.selectByUsername(username);
    }
}

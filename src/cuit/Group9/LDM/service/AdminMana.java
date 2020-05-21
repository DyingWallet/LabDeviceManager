package cuit.Group9.LDM.service;

import cuit.Group9.LDM.entity.Admin;
import cuit.Group9.LDM.util.AdminQuery;

import java.util.List;


//管理员管理模块
public class AdminMana {
    private AdminQuery adminQuery = new AdminQuery();
    //public Admin admin = null;     //保存当前登录的管理员对象

    //登录方法
    public int AdminLogin(Admin temp) {
        //从页面获取用户名密码
        //在数据库中进行认证
        return adminQuery.byLogin(temp);
    }

    //注册流程
    public Admin createAccount(String Name, String username,
                               String password) {
        Admin temp = new Admin(Name,username,password);

        System.out.println("temp = " + temp.toString());
        if(adminQuery.signIn(temp))
            return temp;
        return null;
    }

    public List<Admin> show(){
        return adminQuery.byAll();
    }
}

package cuit.Group9.LDM.test;

import cuit.Group9.LDM.entity.Admin;
import cuit.Group9.LDM.service.AdminMana;

import java.util.List;

public class main {
    public static void main(String[] args) {
        //登录测试
        //AdminMana adminMana = new AdminMana();
        //Admin admin = new Admin("xrh888","123");
        //int sta = adminMana.AdminLogin(admin);
        //
        //System.out.println("Status = " + sta);

        //注册测试
        AdminMana adminMana = new AdminMana();
        List<Admin> tmp = adminMana.show();

        for(int i = 0; i < tmp.size(); i++) {
            System.out.println(tmp.get(i).toString());
        }

        //AdminMana adminMana = new AdminMana();


        //String uname = "xrh666";
        //String pword = "123456";
        //String Name = "xrh";

        //Manager manager = new Manager();
        //
        //manager.admin = new Admin(uname,pword);
        //
        //int flag = adminMana.AdminLogin(manager.admin);
        //
        //if(flag ==1){
        //    System.out.println("登陆成功");
        //}else if(flag == -1){
        //    System.out.println("不存在");
        //}else if(flag == -2){
        //    System.out.println("密码错误");
        //}

        //String str = String.valueOf(null);---错误用法
        //System.out.println("str = " +  str);

        //
        ////注册
        //Admin a = new Admin(adminMana.createAccount(uname, pword, Name));
        //System.out.println("\n" + a.toString());
        //
        //
        ////登录
        //Admin admin = new Admin();
        //switch (adminMana.AdminLogin(admin)) {
        //    case -2:
        //        System.out.println("密码错误");
        //        break;
        //    case -1:
        //        System.out.println("用户不存在");
        //        break;
        //    case 0:
        //        System.out.println("未登录");
        //        break;
        //    case 1:
        //        System.out.println("登录成功");
        //        break;
        //    default:
        //        break;
        //}
        ////Manager manager = new Manager();
        //
        ////manager.tableMana.setTable();
    }
}

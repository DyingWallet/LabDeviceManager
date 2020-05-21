package cuit.Group9.LDM.util;

import cuit.Group9.LDM.dao.AdminDao;
import cuit.Group9.LDM.entity.Admin;
import cuit.Group9.LDM.util.Handler.SqlHandler;

import java.util.List;

//用户表查询接口
public class AdminQuery {
    private AdminDao dao = new AdminDao();
    private SqlHandler handler = new SqlHandler();
    private String sql = "";
    private String table = "admin";


    ////按照编号、用户名、姓名检索
    //public Admin byName(String Name) {
    //    sql = "";                       //编辑sql语句
    //    return dao.querySingle(sql);    //查询并返回结果
    //}

    //登录，验证密码
    public int byLogin(Admin temp) {
        String sql1 = handler.select(
                temp.getUsername(),
                "username",
                table),
                sql2 = handler.selectUser(
                        new String[]{" * "},//cols to find
                        new String[]{"username", "password"},//cols to eq
                        new String[]{temp.getUsername(), temp.getPassword()},//vals into
                        table
                );

        System.out.println(sql1);
        System.out.println(sql2);

        //handler
        if (dao.Login(sql1, sql2, temp)) {
            return temp.isLoginFlag();
        } else {
            return 0;
        }
    }

    //注册，信息入库
    public boolean signIn(Admin temp) {
        //数组下标含义：0：编号，1：名字，2：用户名，3：密码
        int num = countAll(table);
        String No = "ad-" + (num + 1);
        temp.setAdminNo(No);
        String[] col = {"adminNo", "adminName",
                "username", "password"};
        String[] val = {
                temp.getAdminNo(),
                temp.getAdminName(),
                temp.getUsername(),
                temp.getPassword()};
        System.out.println("SignIn = " + temp.toString());
        sql = handler.insert(col, val, table);
        System.out.println(sql);

        return dao.insert(sql);
    }

    //统计总人数，用于注册时生成编号
    public int countAll(String table) {
        sql = handler.countAll(table);
        System.out.println(sql);
        return dao.countAll(sql);
    }

    public List<Admin> byAll(){
        sql = handler.selectAll(table);
        System.out.println(sql);
        return dao.querySet(sql);
    }
}

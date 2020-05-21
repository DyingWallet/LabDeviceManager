package cuit.Group9.LDM.dao;

import cuit.Group9.LDM.entity.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

    public AdminDao() {
    }

    //插入操作
    //实现注册功能

    public boolean insert(String sql) {
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/ldm?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC",
                    "root", "123456");

            //检查连接是否成功
            if (!conn.isClosed()) {//进行表更新操作


                System.out.println("连接成功了");

                //创建Statement对象
                stat = conn.createStatement();

                //执行sql语句
                stat.executeUpdate(sql);
                return true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //单条查询

    public Admin querySingle(String sql) {
        Admin temp = null;
        ResultSet rs = null;
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.建立连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/ldm?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC",
                    "root", "123456");

            if (!conn.isClosed()) {       //检查连接是否成功{
                System.out.println("连接成功了");

                //3.创建Statement对象
                stat = conn.createStatement();

                //4.执行sql语句
                rs = stat.executeQuery(sql);

                rs.last();
                //执行查询
                //处理结果集
                while (rs.next()) {
                    temp = new Admin(
                            rs.getString("adminNo"),
                            rs.getString("adminName"),
                            rs.getString("username"),
                            rs.getString("password"));

                }
                return temp;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //6.关闭对象
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //登陆认证
    public boolean Login(String sql1, String sql2,
                         Admin data) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.建立连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/ldm?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC",
                    "root", "123456");
            if (!conn.isClosed())       //检查连接是否成功
            {
                System.out.println("连接成功了");

                //3.创建Statement对象
                stat = conn.createStatement();

                //4.执行sql语句
                rs = stat.executeQuery(sql1);
                rs.last();
                //执行查询
                //查找用户
                if (rs.getRow() == 0) {
                    System.out.println("用户不存在");
                    data.setLoginFlag(-1);
                    return false;
                } else {
                    //验证密码
                    rs = stat.executeQuery(sql2);
                    while (rs.next()) {
                        //更新状态
                        if (data.getPassword().equals(rs.getString("password"))) {
                            data.setLoginFlag(1);
                            data.setAdminNo(rs.getString("adminNo"));
                            data.setAdminName(rs.getString("adminName"));
                            System.out.println("登陆成功！\n");
                            return true;
                        }
                        System.out.println("密码错误");
                        data.setLoginFlag(-2);
                        return false;
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    //整表计数
    public int countAll(String sql) {
        Connection conn = null;
        Statement stat = null;
        int count = 0;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.建立连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/ldm?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC",
                    "root", "123456");

            if (!conn.isClosed())       //检查连接是否成功
            {
                System.out.println("连接成功了");

                //3.创建Statement对象
                stat = conn.createStatement();

                //4.执行sql语句
                rs = stat.executeQuery(sql);
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            }
            return count;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //6.关闭对象
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public List<Admin> querySet(String sql) {
        List<Admin> tmp = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.建立连接
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/ldm?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC",
                    "root", "123456");

            if (!conn.isClosed()) {       //检查连接是否成功{
                System.out.println("连接成功了");

                //3.创建Statement对象
                stat = conn.createStatement();

                //4.执行sql语句
                rs = stat.executeQuery(sql);
                //执行查询
                //处理结果集
                while (rs.next()) {
                    tmp.add(new Admin(
                            rs.getString("adminNo"),
                            rs.getString("adminName"),
                            rs.getString("username"),
                            rs.getString("password")));

                }
                return tmp;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //6.关闭对象
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

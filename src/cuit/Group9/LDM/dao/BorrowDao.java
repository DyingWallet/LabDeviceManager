package cuit.Group9.LDM.dao;

import cuit.Group9.LDM.entity.Borrow;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowDao {

    //插入操作 || 状态更新
    public boolean updateDB(String sql) {
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

    //整表读取
    public List<Borrow> querySet(String sql) {
        List<Borrow> list = new ArrayList<>();
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
                rs = stat.executeQuery(sql);

                while (rs.next()) {
                    list.add(new Borrow(
                            rs.getInt("id"),
                            rs.getString("devNo"),
                            rs.getString("devName"),
                            rs.getString("borDate"),
                            rs.getString("retDate"),
                            rs.getBoolean("retSta"),
                            rs.getString("stuNo"),
                            rs.getString("adminNo")
                    ));
                }
            }
            return list;
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
        return null;
    }

    //单项查询
    public Borrow querySingle(String sql) {
        Borrow tmp = null;
        Connection conn;
        Statement stat;
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
                    tmp = new Borrow(
                            rs.getInt("ID"),
                            rs.getString("devNo"),
                            rs.getString("devName"),
                            rs.getString("borDate"),
                            rs.getString("retDate"),
                            rs.getBoolean("retSta"),
                            rs.getString("stuNo"),
                            rs.getString("adminNo")
                    );
                }
            }
            return tmp;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

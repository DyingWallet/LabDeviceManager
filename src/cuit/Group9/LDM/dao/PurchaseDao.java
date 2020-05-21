package cuit.Group9.LDM.dao;

import cuit.Group9.LDM.entity.tables.PurchaseForm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDao {

    //插入
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

    //查询
    public List<PurchaseForm> querySet(String sql) {
        List<PurchaseForm> purchaseForms = new ArrayList<>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stat = null;
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
                    purchaseForms.add(new PurchaseForm(
                            rs.getInt("ID"),
                            rs.getString("devName"),
                            rs.getInt("applyNum"),
                            rs.getDouble("Price"),
                            rs.getString("applyDate"),
                            rs.getBoolean("Opinion"),
                            rs.getString("adminNo")
                    ));
                }
            }
            return purchaseForms;
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

    public PurchaseForm querySingle(String sql) {
        PurchaseForm purchaseForm = null;
        ResultSet rs = null;
        Connection conn = null;
        Statement stat = null;
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
                    purchaseForm = new PurchaseForm(
                            rs.getInt("ID"),
                            rs.getString("devName"),
                            rs.getInt("applyNum"),
                            rs.getDouble("Price"),
                            rs.getString("applyDate"),
                            rs.getBoolean("Opinion"),
                            rs.getString("adminNo")
                    );
                }
            }
            return purchaseForm;
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
}

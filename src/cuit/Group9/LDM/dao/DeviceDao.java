package cuit.Group9.LDM.dao;

import cuit.Group9.LDM.entity.Device;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceDao {

    public DeviceDao() {

    }

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


    public Device querySingle(String sql) {
        Device tmp = null;
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
                    tmp = new Device(rs.getString("devNo"),
                            rs.getString("devName"),
                            rs.getString("FeaCode"),
                            rs.getBoolean("isAvai"),
                            rs.getBoolean("isBorr"),
                            rs.getBoolean("isRepair"),
                            rs.getBoolean("isScrap"));
                }
            }
            return tmp;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭对象
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


    public List<Device> querySet(String sql) {
        List<Device> list = new ArrayList<>();
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
                    list.add(new Device(rs.getString("devNo"),
                            rs.getString("devName"),
                            rs.getString("FeaCode"),
                            rs.getBoolean("isAvai"),
                            rs.getBoolean("isBorr"),
                            rs.getBoolean("isRepair"),
                            rs.getBoolean("isScrap")));
                }

            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭对象
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

    public int count(String sql) {
        int count = 0;
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
            }
            //处理结果集
            if (rs != null) {
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

}

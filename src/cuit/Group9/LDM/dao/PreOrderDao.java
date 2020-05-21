//package cuit.Group9.LDM.dao.impl;
//
//import cuit.Group9.LDM.dao.Query;
//import cuit.Group9.LDM.entity.PreOrder;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PreOrderDao {
//    Query query = new Query();
//
//    public List<PreOrder> querySet(String sql) {
//        List<PreOrder> list = new ArrayList<>();
//        ResultSet rs = query.doQuery(sql);
//        try {
//            if (rs != null) {
//                while (rs.next()) {
//                    list.add(new PreOrder(
//                            rs.getString("devName"),
//                            rs.getInt("Num"),
//                            rs.getString("ordDate"),
//                            rs.getString("stuNo"),
//                            rs.getString("adminNo")
//                    ));
//                }
//            }
//            return list;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    public boolean insert(String sql) {
//        return query.doUpdate(sql);
//    }
//
//}

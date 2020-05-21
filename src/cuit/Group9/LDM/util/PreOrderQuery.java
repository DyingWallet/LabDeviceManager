//package cuit.Group9.LDM.util;
//
//import cuit.Group9.LDM.dao.impl.preOrderDao;
//import cuit.Group9.LDM.entity.PreOrder;
//import cuit.Group9.LDM.util.Handler.sqlHandler;
//
//import java.util.List;
//
//
////预定表查询接口
//public class PreOrderQuery {
//    private preOrderDao dao = new preOrderDao();
//    private sqlHandler handler = new sqlHandler();
//    private String sql = "", table = "PreOrder";
//
//
//    public PreOrderQuery() {
//    }
//
//    //查询整表
//    public List<PreOrder> byAll() {
//        sql = handler.selectAll(table);
//        return dao.querySet(sql);
//    }
//
//    //插入新项
//    public boolean insert(PreOrder preOrder) {
//        String[] col = {
//                "deviceName", "preOrderNum",
//                "preOrderDate", "stuNo",
//                "adminNo"
//        };
//        String[] val = {
//                preOrder.getDevName(),
//                String.valueOf(preOrder.getDevNum()),
//                preOrder.getOrderDate(),
//                preOrder.getStuNo(),
//                preOrder.getAdminNo()
//        };
//
//        sql = handler.insert(col,val,table);
//
//        return dao.insert(sql);
//    }
//
//}
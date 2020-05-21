package cuit.Group9.LDM.util;

import cuit.Group9.LDM.dao.DeviceDao;
import cuit.Group9.LDM.entity.Admin;
import cuit.Group9.LDM.entity.Device;
import cuit.Group9.LDM.entity.Inventory;
import cuit.Group9.LDM.util.Handler.SqlHandler;

import java.util.List;


//设备表查询接口
public class DeviceQuery {
    private DeviceDao dao = new DeviceDao();
    private SqlHandler handler = new SqlHandler();
    private String table = "devinfo", sql = "";

    //设备相关查询

    //插入
    // 入库操作-同步插入设备

    public boolean insert(Inventory inventory) {
        Device tmp = new Device(
                inventory.getDevName(),
                inventory.getFeaCode());
        sql = handler.count(
                "devName",
                tmp.getDevName(),
                table
        );
        System.out.println(sql);
        int num = dao.count(sql) + 1;
        StringBuilder sb = new StringBuilder();
        String[] col = {
                "devNo", "devName",
                "FeaCode", "isAvai",
                "isBorr", "isRepair", "isScrap"
        };
        String[] val = new String[inventory.getNum()];
        for (int i = 0; i < inventory.getNum(); i++) {
            int len = sb.length();
            if (len != 0) {
                sb.delete(0, len);
            }

            //进行数据拼接
            sb.
                    append("'").append(tmp.getFeaCode() + num + i).append("',").
                    append("'").append(tmp.getDevName()).append("',").
                    append("'").append(tmp.getFeaCode()).append("',").
                    append(tmp.isAvailable()).append(",").
                    append(tmp.isBorrowed()).append(",").
                    append(tmp.isRepairing()).append(",").
                    append(tmp.isScraped());
            val[i] = sb.toString();
            num++;
        }

        sql = handler.insertMulty(col, val, table);
        System.out.println(sql);
        return dao.updateDB(sql);
    }


    //查询所有设备
    public List<Device> byAll() {
        sql = handler.selectAll(table);
        System.out.println(sql);
        return dao.querySet(sql);
    }

    //根据名称查询设备
    public List<Device> byName(String name) {
        sql = handler.selectMulty(
                "devName",
                name,
                table
        );
        System.out.println(sql);
        return dao.querySet(sql);
    }

    //根据设备号查询设备
    public Device byNo(String no) {
        sql = handler.selectMulty(
                "devNo",
                no,
                table
        );
        System.out.println(sql);
        return dao.querySingle(sql);
    }

    //查询符合某状态的所有设备
    //根据可用状态查找
    public List<Device> byAvaiSta(String name) {
        sql = handler.selectByBool(
                "isAvai", "1",
                "devName", name,
                table);
        System.out.println(sql);
        return dao.querySet(sql);
    }

    //被借出设备
    public List<Device> byBorrSta(String name) {
        sql = handler.selectByBool(
                "isBorr","1",
                "devName",name,
                table
        );
        System.out.println(sql);
        return dao.querySet(sql);
    }

    //正在维修
    public List<Device> byRepSta(String name) {
        sql = handler.selectByBool(
                "isRepair", "1",
                "devName", name,
                table);
        System.out.println(sql);
        return dao.querySet(sql);
    }

    //查询报废设备
    public List<Device> byScrap(String name) {
        sql = handler.selectByBool(
                "isScrap", "1",
                "devName", name,
                table);
        System.out.println(sql);
        return dao.querySet(sql);
    }

    //数量检定-如果通过，则能够进行接下来的借出操作
    public int forNum(String DevName){
        sql = handler.count(
                new String[]{"devName","isAvai"},
                new String[]{DevName,"1"},
                table
        );
        System.out.println(sql);
        return dao.count(sql);
    }

    //分派指定数量的设备
    public List<Device> dispatchDev(String devName,int num) {
        System.out.println("into dispa");
        sql = handler.select_limited("devName",devName,
                new String[]{
                        "isAvai", "isBorr"
                },
                new String[]{
                        "true", "false"
                },
                table, num);
        System.out.println(sql);
        return dao.querySet(sql);
    }

    //更新操作

    //设备借出-进行状态更新-同步插入借用表中
    public boolean lend(String DevName, int num) {
        sql = handler.update_Limited(
                new String[]{"isAvai", "isBorr"},
                new String[]{"0", "1"},
                new String[]{"devName"},
                new String[]{DevName},
                num, table
        );
        System.out.println(sql);
        return dao.updateDB(sql);
    }


    //设备归还
    public boolean devRet(String devNo) {
        sql = handler.update(
                new String[]{"isAvai", "isBorr"},
                new String[]{"true", "false"},
                new String[]{"devNo", "isAvai", "isBorr"},
                new String[]{devNo, "false", "true"},
                table
        );
        System.out.println(sql);
        return dao.updateDB(sql);
    }

    //设备维修-进行设备维修登记
    public boolean devRepair(String devNo) {
        sql = handler.update(
                new String[]{"isAvai", "isRepair"},
                new String[]{
                        "true",
                        "false"},
                new String[]{"isAvai", "isRepair"},
                new String[]{
                        "true",
                        "false"},
                table
        );
        System.out.println(sql);
        return dao.updateDB(sql);
    }

    public boolean updateFix(String devNo,
                             boolean isFixed) {
        sql = handler.update(
                new String[]{"isAvai", "isRepair"},
                new String[]{
                        "0",
                        "1"},
                new String[]{"isAvai", "isRepair"},
                new String[]{
                        String.valueOf(isFixed),
                        String.valueOf(!isFixed)},
                table
        );
        System.out.println(sql);
        return dao.updateDB(sql);
    }

    //设备报废
    public boolean devScrap(String devNo){
        sql = handler.update(
                new String[]{"isAvai","isScrap"},
                new String[]{"0","1"},
                new String[]{"devNo"},
                new String[]{devNo},
                table
        );
        System.out.println(sql);
        return dao.updateDB(sql);
    }

    ////预约设备，进行库的更新，并返回操作数量
    //int preOrd(String name,int num){
    //        }

    ////进行维修设备标记，并在数据库中存储相关维修信息
    //boolean rep(String DevNo, RepTable repTable){
    //
    //}
    //

}

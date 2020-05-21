package cuit.Group9.LDM.util;

import cuit.Group9.LDM.dao.PurchaseDao;
import cuit.Group9.LDM.dao.ScrapDao;
import cuit.Group9.LDM.entity.Admin;
import cuit.Group9.LDM.entity.Repair;
import cuit.Group9.LDM.entity.tables.*;
import cuit.Group9.LDM.util.Handler.SqlHandler;

import java.util.List;


//申请表查询
public class TableQuery {
    private String sql = "",
            tableP = "PurInfo",     //购买申请表
            tableS = "Scrap";       //报废申请表
    private SqlHandler handler = new SqlHandler();
    private PurchaseDao pdao = new PurchaseDao();
    private ScrapDao sdao = new ScrapDao();

    //增

    //购买申请
    public boolean insertPurchase(PurchaseForm purchase) {
        String[] col = {
                "ID",
                "devName", "applyNum",
                "Price", "applyDate",
                "adminNo", "Opinion"
        };
        String[] val = {
                "0",
                purchase.getDevName(),
                String.valueOf(purchase.getNum()),
                String.valueOf(purchase.getPrice()),
                handler.setDate(),
                purchase.getAdminNo(),
                String.valueOf(purchase.isAgree())
        };
        sql = handler.insert(col, val, tableP);
        System.out.println(sql);
        return pdao.updateDB(sql);
    }

    //报废记录
    public boolean insertScrap(ScrapForm scrap) {
        String agg = "";
        if (scrap.isAgree()) {
            agg = "true";
        } else {
            agg = "false";
        }
        String[] col = {
                "ID", "devNo", "devName", "scrapDate",
                "scrapReason", "adminNo", "Opinion"
        };
        String[] val = {
                "0",
                scrap.getDevNo(),scrap.getDevName() ,
                scrap.getScrapDate(), scrap.getScrapReason(),
                scrap.getAdminNo(), agg
        };
        sql = handler.insert(col, val, tableS);
        System.out.println(sql);
        return sdao.updateDB(sql);
    }

    //设备维修登记
    public boolean devRepair(Repair repair) {
        DeviceQuery deviceQuery = new DeviceQuery();
        if (deviceQuery.devRepair(repair.getDevNo())) {
            //如果设备表中状态更新成功，则在维修表中插入记录
            RepairQuery repairQuery = new RepairQuery();
            return repairQuery.insert(repair);
        }
        return false;
    }

    //查

    //购买申请
    public List<PurchaseForm> AllPurchase() {
        sql = handler.selectAll(tableP);
        System.out.println(sql);
        return pdao.querySet(sql);
    }

    public PurchaseForm byPurID(String ID) {
        sql = handler.selectAll(
                "id",
                ID,
                tableP
        );
        System.out.println(sql);
        return pdao.querySingle(sql);
    }

    //报废申请/记录
    public List<ScrapForm> AllScrap() {
        //sql = 查询所有报废记录
        sql = handler.selectAll(tableS);
        System.out.println(sql);
        return sdao.querySet(sql);
    }

    public ScrapForm byScrID(String ID) {
        sql = handler.selectAll(
                "id",
                ID,
                tableS
        );
        System.out.println(sql);
        return sdao.querySingle(sql);
    }

    //改

    //根据申请ID号进行购买申请项更新
    public boolean updatePur(int ID) {
        sql = handler.update(
                "Opinion", "1",
                "ID", String.valueOf(ID),
                tableP
        );
        System.out.println(sql);
        return pdao.updateDB(sql);
    }

    //根据设备号进行报废状态更新
    public boolean updateScr(String devNo) {
        //进行状态更新后需要进行设备报废处理
        sql = handler.update(
                "Opinion", "1",
                "devNo", devNo,
                tableS
        );
        System.out.println(sql);
        return sdao.updateDB(sql);
    }

    //根据设备号进行设备维修状态更新
    public boolean updateRep(String devNo, boolean isFixed
            , Admin admin) {
        DeviceQuery deviceQuery = new DeviceQuery();
        RepairQuery repairQuery = new RepairQuery();
        if (isFixed) {//成功修复，设为可用
            return deviceQuery.updateFix(devNo, true) &
                    repairQuery.updateStatus(devNo, true);
        } else {//修复失败，报废
            String[] col = {
                    "devNo", "scrapDate",
                    "scrapReason", "adminNo", "Opinion"
            };
            String[] val = {
                    devNo, handler.setDate(),
                    "维修失败", admin.getAdminNo(),
                    "0"

            };
            sql = handler.insert(col, val, tableS);
            System.out.println(sql);
            return deviceQuery.devScrap(devNo) &
                    repairQuery.updateStatus(devNo, false) &
                    sdao.updateDB(sql);
        }
    }

}

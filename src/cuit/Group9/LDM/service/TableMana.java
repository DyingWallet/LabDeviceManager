package cuit.Group9.LDM.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import cuit.Group9.LDM.entity.*;
import cuit.Group9.LDM.entity.tables.*;
import cuit.Group9.LDM.util.*;
import cuit.Group9.LDM.util.Handler.SqlHandler;

import java.util.ArrayList;
import java.util.List;

//主要业务逻辑模块-进行操作封装
public class TableMana {
    //工具类
    private BillQuery billQuery = new BillQuery();
    private BorrowQuery borrowQuery = new BorrowQuery();
    //private PreOrderQuery preOrderQuery = new PreOrderQuery();
    private RepairQuery repairQuery = new RepairQuery();
    private TableQuery tableQuery = new TableQuery();


    public TableMana() {

    }


    //public boolean insertPreOrder(PreOrder preOrder) {
    //    if (preOrder != null) {
    //        if (preOrderQuery.insert(preOrder)) {
    //            System.out.println("成功保存预定信息");
    //            return true;
    //        } else {
    //            System.out.println("保存失败");
    //        }
    //    } else {
    //        System.out.println("请勿传入空值");
    //    }
    //    return false;
    //}

    //查询操作
    //整表查询
    public List<PurchaseForm> searchAllPurchase() {
        return tableQuery.AllPurchase();
    }

    public List<ScrapForm> searchAllScrap() {
        return tableQuery.AllScrap();
    }

    public List<Borrow> searchAllBorrow() {
        return borrowQuery.bnAll();
    }

    public List<Bill> searchAllBills() {
        return billQuery.byAll();
    }

    //public List<PreOrder> searchAllPreOrder() {
    //    return preOrderQuery.byAll();
    //}

    public List<Repair> searchAllRepairs() {
        return repairQuery.byAll();
    }

    //按照日期区间进行检索
    public List<Borrow> searchBetween(String begin, String end) {
        return borrowQuery.byDate(begin, end);
    }

    //业务逻辑
    /*--------------------设备借用/归还流程--------------------*/
    //设备借用-进行数量检定
    public boolean checkAvaiNum(String devName, int num) {
        DeviceQuery deviceQuery = new DeviceQuery();

        return deviceQuery.forNum(devName) >= num;
    }

    //设备借用-完成数量检定后执行借用操作
    public boolean devBorrow(String devName, String stuNo, String adminNo, int num) {
        //获取被借出的设备信息
        DeviceQuery deviceQuery = new DeviceQuery();
        BorrowQuery borrowQuery = new BorrowQuery();

        System.out.println("before into dispa");
        List<Device> list = deviceQuery.dispatchDev(devName, num);
        for(int i = 0; i< list.size() ;i++) {
            System.out.println(list.get(i).toString());
        }
        //更新设备状态
        if (deviceQuery.lend(devName, num)) {//完成设备状态更新后插入借用表
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
            return borrowQuery.insert(list, stuNo, adminNo);
        }
        else
            return false;
    }

    //学号查找
    public List<Borrow> search_stuNo_NotRet(String stuNo) {
        return borrowQuery.byStuNo(stuNo);
    }

    //设备借用-进行归还操作，同时同步更新设备表信息
    public boolean devReturn(String stuNo, String devNo) {
        DeviceQuery deviceQuery = new DeviceQuery();
        System.out.println("获取未归还设备成功");
        //完成设备表的状态更新
        deviceQuery.devRet(devNo);
        return borrowQuery.devRet(stuNo, devNo);
    }

    /*--------------------设备借用/归还流程--------------------*/


    /*--------------------设备申请->购入流程--------------------*/
    //插入设备购入申请等待审核
    public boolean saveTable(PurchaseForm purchase) {
        if (purchase != null) {
            if (tableQuery.insertPurchase(purchase)) {
                System.out.println("成功保存购买申请！");
                Bill bill = new Bill("购入",purchase.getPrice()*purchase.getNum(),
                        "购入" + purchase.getDevName()+purchase.getNum()+"件",
                        "",purchase.getAdminNo());
                BillQuery billQuery = new BillQuery();
                billQuery.insert(bill);
                return true;
            } else {
                System.out.println("保存失败");
            }
        } else {
            System.out.println("请勿传入空值");
        }
        return false;
    }

    //查找所选取的记录
    public PurchaseForm searchPurID(String ID) {
        return tableQuery.byPurID(ID);
    }

    //更新意见-同意购买申请
    public boolean updatePurchase(PurchaseForm purchase) {
        if (purchase != null) {
            if (tableQuery.updatePur(purchase.getID())) {
                System.out.println("成功更新购买意见！");
                double cost =
                        purchase.getPrice() * purchase.getPrice();
                //进行账目自动插入
                String descy =
                        "购入设备:" + purchase.getDevName() +
                                purchase.getNum() + "件";
                //获取当前日期
                SqlHandler handler = new SqlHandler();
                String date = handler.setDate();

                Bill bill = new Bill(
                        "购入", cost, descy,
                        date, purchase.getAdminNo()
                );
                BillQuery billQuery = new BillQuery();
                billQuery.insert(bill);
                return true;
            } else {
                System.out.println("保存失败");
            }
        } else {
            System.out.println("请勿传入空值");
        }
        return false;
    }

    //设备入库
    public boolean intoInventory(Inventory inventory, Admin admin) {
        InvQuery invQuery = new InvQuery();
        DeviceQuery deviceQuery = new DeviceQuery();
        if (invQuery.insert(inventory, admin) //库存表更新
                &&
                deviceQuery.insert(inventory)//设备逐项插入
        ) {
            System.out.println("入库完成");
            return true;
        } else {
            System.out.println("入库失败");
            return false;
        }
    }

    /*--------------------设备申请->购入流程--------------------*/

    /*--------------------设备报废流程--------------------*/
    //插入报废申请
    public boolean saveTable(ScrapForm scrap) {
        if (scrap != null) {
            if (tableQuery.insertScrap(scrap)) {
                System.out.println("成功保存报废申请");
                return true;
            } else {
                System.out.println("保存失败");
            }
        } else {
            System.out.println("请勿传入空值");
        }
        return false;
    }

    //查找所选取的记录
    public ScrapForm searchScrID(String ID) {
        return tableQuery.byScrID(ID);
    }

    //更新意见-同意报废申请，同时进行报废操作
    public boolean updateScrap(ScrapForm scrap) {

        if (scrap != null) {
            if (tableQuery.updateScr(scrap.getDevNo())) {
                System.out.println("成功更新报废意见！");
                //如果成功更新报废意见，则进行设备的报废操作
                DeviceQuery deviceQuery = new DeviceQuery();
                return deviceQuery.devScrap(scrap.getDevNo());
            } else {
                System.out.println("保存失败");
            }
        } else {
            System.out.println("请勿传入空值");
        }
        return false;
    }

    /*--------------------设备报废流程--------------------*/


    /*--------------------设备维修流程--------------------*/
    //保存维修信息
    public boolean insertRepair(Repair repair) {
        if (repair != null) {
            if (repairQuery.insert(repair)) {
                System.out.println("成功保存维修信息");
                String descy =
                        "对设备" + repair.getDevNo() +
                                ":" + repair.getDevName() +
                                "进行维修";
                //获取当前日期
                SqlHandler handler = new SqlHandler();
                String date = handler.setDate();
                //自动生成账目
                Bill bill = new Bill(
                        "维修", 120, descy,
                        date, repair.getAdminNo()
                );
                BillQuery billQuery = new BillQuery();
                billQuery.insert(bill);
                return true;
            } else {
                System.out.println("保存失败");
            }
        } else {
            System.out.println("请勿传入空值");
        }
        return false;
    }

    //进行状态更新
    public boolean updateRepair(String devNo,boolean isFix) {
        if(repairQuery.updateStatus(devNo, isFix)){
            DeviceQuery deviceQuery = new DeviceQuery();
            return deviceQuery.updateFix(devNo,isFix);
        }
        return false;
    }

    /*--------------------设备维修流程--------------------*/

}

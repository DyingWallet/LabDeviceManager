package cuit.Group9.LDM.service;

import cuit.Group9.LDM.entity.Admin;
import cuit.Group9.LDM.entity.Device;
import cuit.Group9.LDM.entity.Inventory;
import cuit.Group9.LDM.util.DeviceQuery;
import cuit.Group9.LDM.util.InvQuery;

import java.util.List;


//库存/设备管理模块-进行简单的查询处理
public class DeviceMana {
    private DeviceQuery deviceQuery = new DeviceQuery();
    private InvQuery invQuery = new InvQuery();

    //构造方法
    public DeviceMana() {
    }

    //状态查找

    //可用状态
    public List<Device> byIsAvai(String DevName) {
        return deviceQuery.byAvaiSta(DevName);
    }

    //借用状态
    public List<Device> byBorr(String DevName){
        return deviceQuery.byBorrSta(DevName);
    }

    //维修状态
    public List<Device> byRepair(String DevName) {
        return deviceQuery.byRepSta(DevName);
    }

    //报废状态
    public List<Device> byScrap(String DevName) {
        return deviceQuery.byScrap(DevName);
    }
}

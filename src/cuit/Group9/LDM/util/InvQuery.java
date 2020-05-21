package cuit.Group9.LDM.util;

import cuit.Group9.LDM.dao.InvDao;
import cuit.Group9.LDM.entity.Admin;
import cuit.Group9.LDM.entity.Inventory;
import cuit.Group9.LDM.util.Handler.SqlHandler;

import java.util.List;


//库存表查询接口
public class InvQuery {
    private InvDao dao = new InvDao();
    private SqlHandler handler = new SqlHandler();
    private String sql = "", table = "inventory";

    public InvQuery() {

    }

    //增
    //入库操作-更新库存表
    public boolean insert(Inventory inventory, Admin admin) {
        //进行计数
        sql = handler.countAll(table);

        //进行管理员编号登记
        inventory.setAdminNo(admin.getAdminNo());

        sql = handler.insert(
                new String[]{"ID",
                        "devName", "FeaCode",
                        "Num", "purDate",
                        "purWay", "adminNo"
                },
                new String[]{
                        "0",
                        inventory.getDevName(),
                        inventory.getFeaCode(),
                        String.valueOf(inventory.getNum()),
                        handler.setDate(),
                        inventory.getPurWay(),
                        inventory.getAdminNo()
                },
                table);
        System.out.println(sql);
        return dao.insert(sql);
    }

    //查
    public List<Inventory> byAll() {
        sql = handler.selectAll(table);
        System.out.println(sql);
        return dao.querySet(sql);
    }

    public int countAll(){
        sql = handler.countAll(table);
        System.out.println(sql);
        return dao.countAll(sql);
    }

    ////改
    //
    //public boolean updateStatus(Inventory inventory) {
    //    sql = handler.update(
    //            new String[]{"Num"},
    //            new String[]{String.valueOf(inventory.getNum())},
    //            new String[]{"devName", "purDate"},
    //            new String[]{inventory.getDevName(), inventory.getPurDate()},
    //            table
    //    );
    //    //handler
    //    return dao.update(sql);
    //}

}

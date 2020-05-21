package cuit.Group9.LDM.util;

import cuit.Group9.LDM.dao.RepairDao;
import cuit.Group9.LDM.entity.Repair;
import cuit.Group9.LDM.util.Handler.SqlHandler;

import java.util.List;


//维修表查询接口
public class RepairQuery {
    private RepairDao dao = new RepairDao();
    private SqlHandler handler = new SqlHandler();
    private String sql = "", table = "repair";

    public RepairQuery() {
    }


    //增
    public boolean insert(Repair repair) {
        sql = handler.insert(
                new String[]{
                        "ID",
                        "devNo", "devName",
                        "sendDate", "breakDown",
                        "Fix", "Cost",
                        "Repairer", "adminNo"
                },
                new String[]{
                        "0",
                        repair.getDevNo(), repair.getDevName(),
                        handler.setDate(), repair.getBreakDown(),
                        String.valueOf(repair.isFix()), String.valueOf(120),
                        repair.getRepairer(), repair.getAdminNo()
                },
                table);
        System.out.println(sql);
        return dao.updateDB(sql);
    }

    //查
    public List<Repair> byAll() {
        sql = handler.selectAll(table);
        System.out.println(sql);
        return dao.querySet(sql);
    }

    //改
    public boolean updateStatus(String devNo, boolean isFixed) {
        sql = handler.update(
                new String[]{"Fix"},
                new String[]{String.valueOf(isFixed)},
                new String[]{"devNo", "Fix"},
                new String[]{devNo, String.valueOf(false)},
                table
        );
        System.out.println(sql);
        return dao.updateDB(sql);
    }

}
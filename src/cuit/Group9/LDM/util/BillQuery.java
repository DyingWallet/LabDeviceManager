package cuit.Group9.LDM.util;

import cuit.Group9.LDM.dao.BillDao;
import cuit.Group9.LDM.entity.Bill;
import cuit.Group9.LDM.util.Handler.SqlHandler;

import java.util.List;

//账目表查询接口
public class BillQuery {
    final private String table = "bill";
    private BillDao dao = new BillDao();
    private SqlHandler handler = new SqlHandler();
    private String sql = "";

    public BillQuery() {
    }

    //增

    //插入
    public boolean insert(Bill bill) {
        String[] col = {
                "ID", "Issue",
                "Cost", "Descy",
                "date", "AdminNo"};
        String[] val = {
                "0", bill.getIssue(),
                String.valueOf(bill.getCost()), bill.getDescy(),
                handler.setDate(), bill.getAdminNo()};
        sql = handler.insert(col, val, table);
        System.out.println(sql);
        return dao.insert(sql);
    }

    //查

    //整表查询
    public List<Bill> byAll() {
        sql = handler.selectAll(table);
        System.out.println(sql);
        return dao.querySet(sql);
    }
}

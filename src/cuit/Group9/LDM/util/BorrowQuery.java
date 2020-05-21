package cuit.Group9.LDM.util;

import cuit.Group9.LDM.dao.BorrowDao;
import cuit.Group9.LDM.entity.Admin;
import cuit.Group9.LDM.entity.Borrow;
import cuit.Group9.LDM.entity.Device;
import cuit.Group9.LDM.entity.Student;
import cuit.Group9.LDM.util.Handler.SqlHandler;

import java.util.ArrayList;
import java.util.List;

//借用表查询接口
public class BorrowQuery {
    private BorrowDao dao = new BorrowDao();
    private SqlHandler handler = new SqlHandler();
    private String sql = null, table = "borrow";

    public BorrowQuery() {
    }

    //增
    //插入外借记录-在完成了数量检定后在确认借出页面直接执行库的更新操作
    public boolean insert(List<Device> data, String student,
                          String admin) {
        Device tmp;
        String[] col = {"ID",
                "devNo","devName",
                "borDate",
                "retDate", "retSta",
                "stuNo", "adminNo"};

        String[] val = new String[data.size()];
        StringBuilder sb = new StringBuilder();
        int len;
        for (int i = 0; i < data.size(); i++) {
            tmp = data.get(i);
            len = sb.length();
            if (len != 0) {
                sb.delete(0, len);       //进行清空
            }
            //进行每一条记录的数据拼接
            sb.
                    append("0,").
                    append("'").append(tmp.getDevNo()).append("',").
                    append("'").append(tmp.getDevName()).append("',").
                    append("'").append(handler.setDate()).append("',").
                    append("null,").
                    append(false).append(",").
                    append("'").append(student).append("',").
                    append("'").append(admin).append("'");
            val[i] = sb.toString();
        }
        //生成语句
        sql = handler.insertMulty(col, val, table);
        System.out.println(sql);
        return dao.updateDB(sql);
    }

    //查

    //整表查询
    public List<Borrow> bnAll() {
        sql = handler.selectAll(table);
        System.out.println(sql);
        return dao.querySet(sql);
    }

    //基于日期区间查询
    public List<Borrow> byDate(String begin,String end) {
        sql = handler.selectByDate(begin,end,"borDate",table);
        System.out.println(sql);
        return dao.querySet(sql);
    }


    //根据用户编号查找借用记录
    public List<Borrow> byStuNo(String data) {
        sql = handler.selectMulty("stuNo",data,table);
        System.out.println(sql);
        return dao.querySet(sql);
    }

    //基于设备号查询
    public Borrow byDevNo(String data) {
        sql = handler.select(
                data, "deviceNo", table

        );
        System.out.println(sql);
        return dao.querySingle(sql);
    }

    //根据用户编号查找未归还记录
    public List<Borrow> byStuNo_notReturned(String stuNo,String devName) {
        List<Borrow> list = new ArrayList<>();
        sql = handler.selectMulty(
                new String[]{
                        "stuNo", "devName"
                },
                new String[]{
                        stuNo, devName
                },
                "retSta",
                "false",
                table
        );
        System.out.println(sql);
        return dao.querySet(sql);
    }

    //改

    //更新状态
    //归还设备时进行状态更新
    public boolean devRet(String stuNo,String devName) {
        sql = handler.update(
                new String[]{
                        "retDate", "retSta"
                },
                new String[]{
                        handler.setDate(), "true"
                },
                new String[]{
                        "stuNo", "devNo", "retSta"
                },
                new String[]{
                        stuNo, devName, "false"
                },
                table
        );
        System.out.println(sql);
        return dao.updateDB(sql);
    }

    ////判断存在
    //public boolean has(Borrow data){
    //    return false;
    //}
    //
}

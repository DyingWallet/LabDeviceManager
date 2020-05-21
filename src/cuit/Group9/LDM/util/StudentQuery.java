package cuit.Group9.LDM.util;

import cuit.Group9.LDM.dao.StudentDao;
import cuit.Group9.LDM.entity.Student;
import cuit.Group9.LDM.util.Handler.SqlHandler;

import java.util.List;

//学生表查询接口
public class StudentQuery {
    StudentDao dao = new StudentDao();
    SqlHandler handler = new SqlHandler();
    String table = "student";

    private String sql = "";

    //整表查询
    public List<Student> byAll() {
        sql = handler.selectAll(table);
        System.out.println(sql);
        return dao.querySet(sql);
    }

    //按信用分查询
    public List<Student> byCredit(int credit) {
        sql = handler.select(String.valueOf(credit),
                "credit",table);
        System.out.println(sql);
        return dao.querySet(sql);
    }

    //按学号查询
    public Student byNo(String No) {
        sql = handler.select(No,
                "stuNo", table);
        System.out.println(sql);
        return dao.querySingle(sql);
    }

    //更新分数
    public boolean updateCredit(String No, int Credit) {
        //编辑sql语句
        sql = handler.update("credit",String.valueOf(Credit),
                "stuNo",No,
                table);
        System.out.println(sql);
        return dao.updateDB(sql);
    }


}

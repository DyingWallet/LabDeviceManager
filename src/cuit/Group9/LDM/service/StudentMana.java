package cuit.Group9.LDM.service;

import cuit.Group9.LDM.entity.Student;
import cuit.Group9.LDM.util.StudentQuery;

import java.util.List;

//学生管理模块
public class StudentMana {

    private Student student = null;
    private StudentQuery studentQuery = new StudentQuery();

    public StudentMana() {
    }

    //改变信用分
    public Student changeCredit(String No, int Credit) {

        if (studentQuery.updateCredit(No, Credit)) {
            return studentQuery.byNo(No);
        } else {
            System.out.println("更新失败...\n");
            return null;
        }
    }

    //整表查询
    public List<Student> SearchAll() {
        return studentQuery.byAll();
    }

    //按学号查询
    public Student SearchNo(String No) {
        return studentQuery.byNo(No);
    }

}

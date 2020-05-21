package cuit.Group9.LDM.entity;


//学生表
public class Student {
    private String No = "";     //学号
    private String Name = "";   //名字
    private int Credit = 12;    //信用分

    public Student(){}

    public Student(String no){
        No = no;
    }

    public Student(String no, String name, int credit) {
        No = no;
        Name = name;
        Credit = credit;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String No) {
        this.No = No;
    }

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int Credit) {
        this.Credit = Credit;
    }

    @Override
    public String toString() {
        return "Student{" +
                "No='" + No + '\'' +
                ", Name='" + Name + '\'' +
                ", Credit=" + Credit +
                '}';
    }
}

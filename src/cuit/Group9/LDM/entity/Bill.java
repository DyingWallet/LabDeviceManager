package cuit.Group9.LDM.entity;


//账目表
public class Bill {
    private int ID = 0;                 //编号
    private String Issue = "";          //开支事件-购入/维修
    private double Cost = 0;            //金额
    private String Descy = "";          //详细描述
    private String date = "null";       //日期
    private String AdminNo = "";        //管理员编号

    public Bill() {
    }

    //查询用
    public Bill(int ID, String issue,
                double cost, String descy,
                String date, String adminNo) {
        this.ID = ID;
        Issue = issue;
        Cost = cost;
        Descy = descy;
        this.date = date;
        AdminNo = adminNo;
    }

    //录入用


    public Bill(String issue, double cost,
                String descy, String date,
                String adminNo) {
        Issue = issue;
        Cost = cost;
        Descy = descy;
        this.date = date;
        AdminNo = adminNo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIssue() {
        return Issue;
    }

    public void setIssue(String issue) {
        Issue = issue;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public String getDescy() {
        return Descy;
    }

    public void setDescy(String descy) {
        Descy = descy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAdminNo() {
        return AdminNo;
    }

    public void setAdminNo(String adminNo) {
        AdminNo = adminNo;
    }

    @Override
    public String toString() {
        return "Bills{" +
                "Issue='" + Issue + '\'' +
                ", \nCost=" + Cost +
                ", \nDesc='" + Descy + '\'' +
                ", \nAdminNo='" + AdminNo + '\'' +
                '}';
    }
}

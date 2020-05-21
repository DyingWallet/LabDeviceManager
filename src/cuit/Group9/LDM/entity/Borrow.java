package cuit.Group9.LDM.entity;


//外借表       支持查询、插入、更新操作
public class Borrow {
    private int ID = 0;                 //编号
    private String DevNo = "";          //设备编号
    private String DevName = "";        //设备名称
    private String BorDate = "";        //借出时间
    private String RetDate = "null";    //归还时间
    private boolean RetSta = false;     //归还状态
    private String StuNo = "";          //学生编号
    private String AdminNo = "";        //管理员编号


    public Borrow() {
    }


    //后台查询使用
    public Borrow(int ID, String devNo,
                  String devName, String borDate,
                  String retDate, boolean retSta,
                  String stuNo, String adminNo) {
        this.ID = ID;
        DevNo = devNo;
        DevName = devName;
        BorDate = borDate;
        RetDate = retDate;
        RetSta = retSta;
        StuNo = stuNo;
        AdminNo = adminNo;
    }

    //进行状态更新
    public Borrow(String devNo, String retDate,
                  boolean retSta) {
        DevNo = devNo;
        RetDate = retDate;
        RetSta = retSta;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDevNo() {
        return DevNo;
    }

    public void setDevNo(String devNo) {
        DevNo = devNo;
    }

    public String getDevName() {
        return DevName;
    }

    public void setDevName(String devName) {
        DevName = devName;
    }

    public String getBorDate() {
        return BorDate;
    }

    public void setBorDate(String borDate) {
        BorDate = borDate;
    }

    public String getRetDate() {
        return RetDate;
    }

    public void setRetDate(String retDate) {
        RetDate = retDate;
    }

    public boolean isRetSta() {
        return RetSta;
    }

    public void setRetSta(boolean retSta) {
        RetSta = retSta;
    }

    public String getStuNo() {
        return StuNo;
    }

    public void setStuNo(String stuNo) {
        StuNo = stuNo;
    }

    public String getAdminNo() {
        return AdminNo;
    }

    public void setAdminNo(String adminNo) {
        AdminNo = adminNo;
    }
}

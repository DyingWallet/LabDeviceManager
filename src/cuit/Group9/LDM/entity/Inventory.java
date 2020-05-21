package cuit.Group9.LDM.entity;


//库存表
public class Inventory {
    private String ID = "";             //批次
    private String DevName = "";        //设备名
    private String FeaCode = "";        //特征码
    private int Num = 0;                //总数
    private String PurDate = "";        //购买日期
    private String PurWay = "";         //购买渠道
    private String AdminNo = "";        //管理员编号

    public Inventory() {
    }

    //录入用
    public Inventory(String devName, String feaCode,
                     int num, String purWay) {
        DevName = devName;
        FeaCode = feaCode;
        Num = num;
        PurWay = purWay;
    }

    //查询用
    public Inventory(String ID, String devName,
                     String feaCode, int num,
                     String purDate, String purWay,
                     String adminNo) {
        this.ID = ID;
        DevName = devName;
        FeaCode = feaCode;
        Num = num;
        PurDate = purDate;
        PurWay = purWay;
        AdminNo = adminNo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDevName() {
        return DevName;
    }

    public void setDevName(String devName) {
        DevName = devName;
    }

    public String getFeaCode() {
        return FeaCode;
    }

    public void setFeaCode(String feaCode) {
        FeaCode = feaCode;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public String getPurDate() {
        return PurDate;
    }

    public void setPurDate(String purDate) {
        PurDate = purDate;
    }

    public String getPurWay() {
        return PurWay;
    }

    public void setPurWay(String purWay) {
        PurWay = purWay;
    }

    public String getAdminNo() {
        return AdminNo;
    }

    public void setAdminNo(String adminNo) {
        AdminNo = adminNo;
    }
}

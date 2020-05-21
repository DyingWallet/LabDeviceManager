package cuit.Group9.LDM.entity;


//维修表
public class Repair {
    private int ID = 0;                 //编号
    private String DevNo = "";          //设备编号
    private String DevName = "";        //设备名称
    private String SendDate = "";       //送修日期
    private String BreakDown = "";      //故障
    private boolean Fix = false;        //结果
    private double Cost = 0;            //费用
    private String Repairer = "";       //修理方
    private String AdminNo = "";        //管理员编号


    public Repair() {
    }

    //录入用
    public Repair(String devNo, String devName,
                  String breakDown,
                  String repairer,
                  String adminNo) {
        DevNo = devNo;
        DevName = devName;
        BreakDown = breakDown;
        Repairer = repairer;
        AdminNo = adminNo;
    }

    //查询
    public Repair(int ID, String devNo,
                  String devName, String sendDate,
                  String breakDown, boolean fix,
                  double cost, String repairer,
                  String adminNo) {
        this.ID = ID;
        DevNo = devNo;
        DevName = devName;
        SendDate = sendDate;
        BreakDown = breakDown;
        Fix = fix;
        Cost = cost;
        Repairer = repairer;
        AdminNo = adminNo;
    }


    //访问器


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

    public String getSendDate() {
        return SendDate;
    }

    public void setSendDate(String sendDate) {
        SendDate = sendDate;
    }

    public String getBreakDown() {
        return BreakDown;
    }

    public void setBreakDown(String breakDown) {
        BreakDown = breakDown;
    }

    public boolean isFix() {
        return Fix;
    }

    public void setFix(boolean fix) {
        Fix = fix;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public String getRepairer() {
        return Repairer;
    }

    public void setRepairer(String repairer) {
        Repairer = repairer;
    }

    public String getAdminNo() {
        return AdminNo;
    }

    public void setAdminNo(String adminNo) {
        AdminNo = adminNo;
    }
}
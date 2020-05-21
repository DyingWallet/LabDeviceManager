package cuit.Group9.LDM.entity.tables;


//购买申请表
public class PurchaseForm {
    private int ID = 0;                 //编号
    private String DevName = "";        //设备名称
    private int Num = 0;                //数量
    private double Price = 0;           //单价
    private String ApplyDate = "";      //申请日期
    private boolean Agree = false;      //领导意见
    private String AdminNo = "";        //管理员编号

    public PurchaseForm() {
    }
    //查询用
    public PurchaseForm(int ID, String devName,
                        int num, double price,
                        String applyDate, boolean agree,
                        String adminNo) {
        this.ID = ID;
        DevName = devName;
        Num = num;
        Price = price;
        ApplyDate = applyDate;
        Agree = agree;
        AdminNo = adminNo;
    }

    //录入用
    public PurchaseForm(String devName, int num,
                        double price, boolean Opi,
                        String adminNo) {
        DevName = devName;
        Num = num;
        Price = price;
        Agree = Opi;
        AdminNo = adminNo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDevName() {
        return DevName;
    }

    public void setDevName(String devName) {
        DevName = devName;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getApplyDate() {
        return ApplyDate;
    }

    public void setApplyDate(String applyDate) {
        ApplyDate = applyDate;
    }

    public boolean isAgree() {
        return Agree;
    }

    public void setAgree(boolean agree) {
        Agree = agree;
    }

    public String getAdminNo() {
        return AdminNo;
    }

    public void setAdminNo(String adminNo) {
        AdminNo = adminNo;
    }


    @Override
    public String toString() {
        return "PurchaseForm{" +
                "DevName='" + DevName + '\'' +
                ", Num=" + Num +
                ", Price=" + Price +
                ", PurDate='" + ApplyDate + '\'' +
                ", Agree=" + Agree +
                ", AdminNo='" + AdminNo + '\'' +
                '}';
    }
}

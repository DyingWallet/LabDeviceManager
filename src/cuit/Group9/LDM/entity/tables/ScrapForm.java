package cuit.Group9.LDM.entity.tables;

//报废表
public class ScrapForm {
    private int ID = 0;                 //编号
    private String DevNo = "";          //设备编号
    private String DevName = "";        //设备名称
    private String ScrapDate = "";      //报废日期
    private String ScrapReason = "";    //原因
    private String AdminNo = "";        //管理员编号
    private boolean Agree = false;      //意见

    public ScrapForm() {
    }

    //录入用
    public ScrapForm(String devNo, String scrapDate,
                     String scrapReason, String adminNo
                     ) {
        DevNo = devNo;
        ScrapDate = scrapDate;
        ScrapReason = scrapReason;
        AdminNo = adminNo;
    }

    //查询用
    public ScrapForm(int ID, String devNo,
                     String devName, String scrapDate,
                     String scrapReason, String adminNo,
                     boolean agree) {
        this.ID = ID;
        DevNo = devNo;
        DevName = devName;
        ScrapDate = scrapDate;
        ScrapReason = scrapReason;
        AdminNo = adminNo;
        Agree = agree;
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

    public String getScrapDate() {
        return ScrapDate;
    }

    public void setScrapDate(String scrapDate) {
        ScrapDate = scrapDate;
    }

    public String getScrapReason() {
        return ScrapReason;
    }

    public void setScrapReason(String scrapReason) {
        ScrapReason = scrapReason;
    }

    public String getAdminNo() {
        return AdminNo;
    }

    public void setAdminNo(String adminNo) {
        AdminNo = adminNo;
    }

    public boolean isAgree() {
        return Agree;
    }

    public void setAgree(boolean agree) {
        Agree = agree;
    }
}

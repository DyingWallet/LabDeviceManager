package cuit.Group9.LDM.entity;


//设备表
public class Device {
    private String DevNo = "";              //设备编号
    private String DevName = "";            //设备名称
    private String FeaCode = "";            //特征码
    private boolean isAvailable = true;     //可用状态
    private boolean isBorrowed = false;     //借用状态
    private boolean isRepairing = false;    //维修状态
    private boolean isScraped = false;      //报废状态

    //后台查询使用


    public Device(String devNo, String devName,
                  String feaCode, boolean isAvailable,
                  boolean isBorrowed, boolean isRepairing,
                  boolean isScraped) {
        DevNo = devNo;
        DevName = devName;
        FeaCode = feaCode;
        this.isAvailable = isAvailable;
        this.isBorrowed = isBorrowed;
        this.isRepairing = isRepairing;
        this.isScraped = isScraped;
    }

    public Device(String devName, String feaCode) {
        DevName = devName;
        FeaCode = feaCode;
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

    public String getFeaCode() {
        return FeaCode;
    }

    public void setFeaCode(String feaCode) {
        FeaCode = feaCode;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public boolean isRepairing() {
        return isRepairing;
    }

    public void setRepairing(boolean repairing) {
        isRepairing = repairing;
    }

    public boolean isScraped() {
        return isScraped;
    }

    public void setScraped(boolean scraped) {
        isScraped = scraped;
    }
}
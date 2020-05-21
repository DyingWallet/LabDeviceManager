package cuit.Group9.LDM.entity;

//暂未启用
public class DevInfo {
    private String DevName = "";    //设备名
    private String FeaCode = "";    //特征码
    private String PurWay = "";     //购买渠道
    private int Available = 0;      //可用数量
    private int Borrowed = 0;       //借出数量
    private int Repairing = 0;      //维修数量
    private int Scraped = 0;        //报废数量

    public DevInfo(){}


    //供后台查询使用
    public DevInfo(String devName, String feaCode, String purWay,
                   int available, int borrowed,
                   int repairing, int scraped) {
        DevName = devName;
        FeaCode = feaCode;
        PurWay = purWay;
        Available = available;
        Borrowed = borrowed;
        Repairing = repairing;
        Scraped = scraped;
    }

    public String getDevName() {
        return DevName;
    }

    public String getFeaCode() {
        return FeaCode;
    }

    public String getPurWay() {
        return PurWay;
    }

    public int getAvailable() {
        return Available;
    }

    public int getBorrowed() {
        return Borrowed;
    }

    public int getRepairing() {
        return Repairing;
    }

    public int getScraped() {
        return Scraped;
    }
}

package cuit.Group9.LDM.entity;

/**
 * 管理员表
 */
public class Admin {
    private String AdminNo = "";            //管理员编号
    private String AdminName = "";          //管理员名字
    private String username = "";           //登录用户名
    private String password = "";           //登录密码
    private int loginFlag = 0;              //登录状态

    //构造方法，通过admin对象进行初始化，推荐在进行数据库操作时使用
    public Admin() {
    }

    //使用已经存在的对象进行快速构造
    public Admin(Admin admin) {
        init(admin);
    }

    //为登录提供接口
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //为注册提供接口

    public Admin(String adminName,
                 String username, String password) {
        AdminName = adminName;
        this.username = username;
        this.password = password;
    }

    //数据库查询
    public Admin(String adminNo, String adminName,
                 String username, String password) {
        AdminNo = adminNo;
        AdminName = adminName;
        this.username = username;
        this.password = password;
    }

    public void init(Admin admin){
        this.AdminName = admin.getAdminName();
        this.AdminNo = admin.getAdminNo();
        this.username = admin.getUsername();
        this.password = admin.getPassword();
        this.loginFlag = admin.isLoginFlag();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "AdminNo='" + AdminNo + '\'' +
                ", AdminName='" + AdminName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", loginFlag=" + loginFlag +
                '}';
    }

    public String getAdminNo() {
        return AdminNo;
    }

    public void setAdminNo(String adminNo) {
        AdminNo = adminNo;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int isLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(int loginFlag) {
        this.loginFlag = loginFlag;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package cuit.Group9.LDM.web;

import com.mysql.cj.xdevapi.JsonArray;
import cuit.Group9.LDM.entity.*;
import cuit.Group9.LDM.entity.tables.PurchaseForm;
import cuit.Group9.LDM.entity.tables.ScrapForm;
import cuit.Group9.LDM.service.AdminMana;
import cuit.Group9.LDM.service.TableMana;
import cuit.Group9.LDM.util.*;
import javafx.scene.control.Tab;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.swing.JOptionPane;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet(name = "BaseServlet", value = "/BaseServlet", loadOnStartup = 1)
public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Admin admin = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=utf-8");
        System.out.println("前端调用了Servlet");
        //System.out.println("doPost" + request.getParameter("username"));
        //System.out.println("doPost" + request.getParameter("password"));
        System.out.println(request.getParameter("op"));
        String opearatio = request.getParameter("op");
        int method = Integer.parseInt(opearatio);

        if(method == 1) {//注册
            Admin tmp = null;
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String adminName = request.getParameter("adminName");
            System.out.println("1.username:" + username + "\npassword : " + password + "\nadminName : " + adminName);
            if ((tmp = register(adminName, username, password)) != null) {
                request.getRequestDispatcher("./logIn.jsp").forward(request, response);
                System.out.println("注册成功\n" + tmp.toString());

            } else {
                System.out.println("注册失败");
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/logIn.jsp");
            requestDispatcher.forward(request,response);

        } else if(method == 2) {//登录
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String path = "mainPage.jsp";

            System.out.println("2.username:" + username + "\npassword : " + password);
            admin = new Admin(username, password);

            if (Login(admin) == 1) {
                try {
                    request.getRequestDispatcher(path).forward(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
            } else {
                if (admin.isLoginFlag() == -1) {
                    System.out.println("用户名不存在");
                    try {
                        request.getRequestDispatcher("./signIn.jsp").forward(request, response);
                    } catch (ServletException | IOException e) {
                        e.printStackTrace();
                    }
                }
                if (admin.isLoginFlag() == -2) {
                    System.out.println("密码错误");
                    try {
                        request.getRequestDispatcher("./logIn.jsp").forward(request, response);
                    } catch (ServletException | IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
        else  if (method==3){//外借
            response.setContentType("text/html,charset=utf-8");
            System.out.println("前端调用了met3");
            List<Borrow> result = Borr_showALL();


            System.out.println("len = " + result.size());

            //传链表
            request.setAttribute("List", result);
            System.out.println("len = " + result.size()+1);

            //request.getRequestDispatcher("./QueryResults/borrowTable.jsp");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/QueryResults/borrowTable.jsp");

            requestDispatcher.forward(request,response);

        }
        else if(method==4){//维修
            response.setContentType("text/html,charset=utf-8");
            TableMana tableMana=new TableMana();
            List<Repair> result =tableMana.searchAllRepairs();



            System.out.println("len = " + result.size());

            //传链表
            request.setAttribute("List", result);
            System.out.println("len = " + result.size()+1);

            //request.getRequestDispatcher("./QueryResults/borrowTable.jsp");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/QueryResults/repairTable.jsp");

            requestDispatcher.forward(request,response);

        }

        else if(method==5){//报废查询
            response.setContentType("text/html,charset=utf-8");
            TableMana tableMana=new TableMana();
            List<ScrapForm> result = tableMana.searchAllScrap();
            request.setAttribute("List", result);
            System.out.println("len = " + result.size()+1);

            //request.getRequestDispatcher("./QueryResults/borrowTable.jsp");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/QueryResults/scrapTable.jsp");

            requestDispatcher.forward(request,response);
        }

        else if(method == 6) {//购买申请
            String devName = request.getParameter("devName");
            int num = Integer.parseInt(request.getParameter("num"));
            double price = Double.parseDouble(request.getParameter("price"));
            boolean Opinion = Boolean.parseBoolean(request.getParameter("Opinion"));

            System.out.println("devName = " + devName + "num = " + num + "price = " + price + "Opinion" + opearatio);
            TableMana tableMana = new TableMana();

            PurchaseForm purchase = new PurchaseForm(devName, num, price, Opinion, admin.getAdminNo());
            if (tableMana.saveTable(purchase)) {
                System.out.println("保存成功");
            } else {
                System.out.println("保存失败");
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/tables.jsp");
            requestDispatcher.forward(request,response);
        }

        else if(method==7) {//入库操作
            String name = request.getParameter("name");
            String fea = request.getParameter("fea");
            String num = request.getParameter("num");
            String way = request.getParameter("way");

            Inventory inventory = new Inventory(name, fea, Integer.parseInt(num), way);
            if(ShebeiLogin(inventory)){
                System.out.println("入库完成");
            }else{
                System.out.println("入库失败");
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/devManager.jsp");
            requestDispatcher.forward(request,response);
        }

        else if(method == 8){//外借数量检定
            String devName = request.getParameter("devName");
            String num = request.getParameter("num");
            System.out.println("name="+devName + ",num= " + num);

            DeviceQuery deviceQuery = new DeviceQuery();
            if(Integer.parseInt(num) <= deviceQuery.forNum(devName)){//数量足够，进行跳转
                System.out.println("数量足够");
                request.setAttribute("deviceName",devName);
                request.setAttribute("deviceNum",num);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/confirmLend.jsp");
                requestDispatcher.forward(request,response);

            }else{
                System.out.println("数量不足");
                //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/confirmLend.jsp");
                //requestDispatcher.forward(request,response);
            }
        }

        else if(method == 9){//确认借用
            String devName = request.getParameter("devName");
            String num = request.getParameter("num");
            String stuNo = request.getParameter("stuNo");
            System.out.println("name = "+devName + ",num = " + num + ",stuNo = " + stuNo);
            TableMana tableMana = new TableMana();

            if(tableMana.devBorrow(devName,stuNo,admin.getAdminNo(),Integer.parseInt(num))){
                System.out.println("借用成功");
            }else{
                System.out.println("出了点小意外");
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/devManager.jsp");
            requestDispatcher.forward(request,response);
        }

        else if(method == 10) {//账目查询
            TableMana tableMana = new TableMana();
            List<Bill> result = tableMana.searchAllBills();
            System.out.println("len = " + result.size() + 1);
            request.setAttribute("List", result);

            //request.getRequestDispatcher("./QueryResults/BorrowTable.jsp");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/bills.jsp");

            requestDispatcher.forward(request, response);
        }

        else if(method == 11){//查询借用
            String stuNo = request.getParameter("stuNo");
            System.out.println(stuNo);
            TableMana tableMana = new TableMana();
            List<Borrow> list = tableMana.search_stuNo_NotRet(stuNo);
            System.out.println("len = " + list.size());
            request.setAttribute("No",stuNo);
            request.setAttribute("List",list);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/return1.jsp");
            requestDispatcher.forward(request,response);
        }

        else if(method == 12){//归还
            String stuNo = request.getParameter("stuNo");
            String devNo = request.getParameter("devNo");
            System.out.println(stuNo + devNo);
            TableMana tableMana = new TableMana();
            //进行归还设备
            if(tableMana.devReturn(stuNo,devNo)){
                System.out.println("归还设备"+ devNo + "成功");
            }

            //查询剩下未还的设备
            List<Borrow> list = tableMana.search_stuNo_NotRet(stuNo);
            System.out.println("len = " + list.size());
            request.setAttribute("No",stuNo);
            request.setAttribute("List",list);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/return1.jsp");
            requestDispatcher.forward(request,response);
        }
        else if(method == 13){//维修
            String devNo = request.getParameter("devNo");
            String devName = request.getParameter("devName");
            String reason = request.getParameter("rea");
            String repairer = request.getParameter("repairer");



            Repair repair = new Repair(
                    devNo,devName,reason,
                    repairer,admin.getAdminNo());

            TableMana tableMana = new TableMana();

            if(tableMana.insertRepair(repair)){
                System.out.println("保存维修记录成功");
            } else {
                System.out.println("保存维修记录失败");
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/devManager.jsp");
            requestDispatcher.forward(request,response);
        }

        else if(method == 14){//报废
            request.setCharacterEncoding("utf-8");
            String num = request.getParameter("num");
            String date = request.getParameter("date");
            String way = request.getParameter("rea");
            String opi = request.getParameter("Opinion");
            System.out.println("num = " + num + "date = " + date +
                    "way = " + way + "opi = " + opi );
            ScrapForm scrapform = new ScrapForm(num,date, way,opi);
            System.out.println(scrapform.toString());
            if(ScrapLogin(scrapform)){
                System.out.println("入库完成");
            }else{
                System.out.println("入库失败");
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/devManager.jsp");
            requestDispatcher.forward(request,response);
        }


        //if(method==1)//验证用户
        //    account(request,response);
        //else if(method==2)
        //    registInformation(request,response);
        //else if(method==3)
        //    numQuery(request,response);
        //else if(method==4)
        //    statusQuery(request,response);
        //else if(method==5)
        //    fixQuery(request,response);
        //else if(method==6)
        //    brokenQuery(request,response);
        //else if(method==7)
        //    devInsert(request,response);
        //else if(method==8)
        //    Borrow(request,response);
        //else if(method==9)
        //    PreOrder(request,response);

    }


    //业务逻辑实现
    //注册用户
    public Admin register(String adminName,String username,String password){
        AdminMana adminMana = new AdminMana();
        return adminMana.createAccount(adminName,username,password);
    }

    //登录用户
    public int Login(Admin tmp) {
        AdminMana adminMana = new AdminMana();
        return adminMana.AdminLogin(tmp);
    }

    //根据查询借用记录
    public List<Borrow> Borr_showALL(){
        System.out.println("前端调用了Borr_ShowAll");
        TableMana tableMana = new TableMana();
        return tableMana.searchAllBorrow();
    }

    public boolean ShebeiLogin(Inventory inventory) {
        String adminNo = admin.getAdminNo();
        TableMana tableMana = new TableMana();
        return tableMana.intoInventory(inventory, admin);
    }

    public boolean ScrapLogin(ScrapForm scrapform) {
        TableMana tableMana=new TableMana();
        return tableMana.saveTable(scrapform);
    }


    //不做实现
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

}

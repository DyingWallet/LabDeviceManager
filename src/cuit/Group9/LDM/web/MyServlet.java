//package cuit.Group9.LDM.web;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class servlet
// */
////@WebServlet("/MyServlet")
//@WebServlet(name = "MyServlet",value = "/logIn.jsp", loadOnStartup = 1)
//public class MyServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public MyServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**                                                                                                                               bbbbbbbbbbbbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb                                                                                                 nbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request,
//						 HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("前端调用了Servlet");
//		response.setContentType("text/html;charset=utf-8");
//		System.out.println("doPost" + request.getParameter("username"));
//		System.out.println("doPost" + request.getParameter("password"));
//		System.out.println(request.getParameter("op"));
//		String opearatio = request.getParameter("op");
//		int method=Integer.parseInt(opearatio);
//
//			if(method==1)//验证用户
//				account(request,response);
//			else if(method==2)
//				registInformation(request,response);
//			else if(method==3)
//				numQuery(request,response);
//			else if(method==4)
//			    statusQuery(request,response);
//			else if(method==5)
//				fixQuery(request,response);
//			else if(method==6)
//				brokenQuery(request,response);
//			else if(method==7)
//				devInsert(request,response);
//			else if(method==8)
//				Borrow(request,response);
//			else if(method==9)
//				PreOrder(request,response);
//
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("前端调用了Servlet_doPost");
//		response.setContentType("text/html;charset=utf-8");
//		System.out.println("doPost" + request.getParameter("username"));
//		System.out.println("doPost" + request.getParameter("password"));
//		System.out.println("doPost" + request.getParameter("op"));
//		doGet(request, response);
//	}
//
////验证用户
//	public void account(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException,IOException{
//
//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
//
//
//	}
//
//
//	public void registInformation(HttpServletRequest request, HttpServletResponse response)
//	{
//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
//	}
//
//
//	public void numQuery(HttpServletRequest request, HttpServletResponse response)
//	{
//
//	}
//
//
//	public void statusQuery(HttpServletRequest request, HttpServletResponse response)
//	{
//
//	}
//
//
//	public void fixQuery(HttpServletRequest request, HttpServletResponse response)
//	{
//
//	}
//	public void brokenQuery(HttpServletRequest request, HttpServletResponse response)
//	{
//
//	}
//
//
//	public void devInsert(HttpServletRequest request, HttpServletResponse response)
//	{
//
//	}
//
//
//	public void Borrow(HttpServletRequest request, HttpServletResponse response)
//	{
//
//	}
//
//
//	public void PreOrder(HttpServletRequest request, HttpServletResponse response)
//	{
//
//	}
//
//
//
//
//
//
//
//
//
//
//}

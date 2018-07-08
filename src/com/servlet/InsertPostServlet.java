package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class InsertPostServlet extends HttpServlet {

	private static final long serialVersionUID = 5L;

	/**
	 * The doGet method of the Server let.
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// 新建服务对象
		Service serv = new Service();
		
		int p_class=Integer.parseInt(request.getParameter("p_class"));
		String p_theme = request.getParameter("p_theme");
		String p_content = request.getParameter("p_content");
		String p_time = request.getParameter("p_time");
		int p_user=Integer.parseInt(request.getParameter("p_user"));
		String confirm;
//		String password = request.getParameter("r_password");
		System.out.println("test");
		// 验证处理
		boolean reged = serv.insertpost(p_class,p_theme,p_content,p_time,p_user);
		System.out.println("test" + reged);
		if (reged) {
			System.out.print("Succss");
			confirm="\n发帖成功";
			//request.getSession().setAttribute("username", username);
			//response.sendRedirect("welcome.jsp");
		}else {
			System.out.print("Failed");
			confirm="\n发帖失败";
		}


		// 返回信息
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(confirm);
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the Server let.
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}

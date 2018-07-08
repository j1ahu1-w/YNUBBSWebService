package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class InsertReplyServlet extends HttpServlet {

	private static final long serialVersionUID = 6L;

	/**
	 * The doGet method of the Server let.
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// 新建服务对象
		Service serv = new Service();
		
		int r_to_p_id=Integer.parseInt(request.getParameter("r_to_p_id"));
		int r_to_class=Integer.parseInt(request.getParameter("r_to_class"));
		int r_to_id=Integer.parseInt(request.getParameter("r_to_id"));
		String r_content = request.getParameter("r_content");
		String r_time = request.getParameter("r_time");
		int r_user=Integer.parseInt(request.getParameter("r_user"));
		String confirm;
//		String password = request.getParameter("r_password");
		System.out.println("test");
		// 验证处理
		boolean reged = serv.insertreply(r_to_p_id,r_to_class,r_to_id,r_content,r_time,r_user);
		System.out.println("test" + reged);
		if (reged) {
			System.out.print("Succss");
			confirm="\n回复成功";
			//request.getSession().setAttribute("username", username);
			//response.sendRedirect("welcome.jsp");
		}else {
			System.out.print("Failed");
			confirm="\n回复失败";
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

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class DeleteReplyServlet extends HttpServlet {

	private static final long serialVersionUID = 9L;

	/**
	 * The doGet method of the Server let.
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// �½��������
		Service serv = new Service();
		
		int r_id=Integer.parseInt(request.getParameter("r_id"));
		String confirm;
//		String password = request.getParameter("r_password");
		System.out.println("test");
		// ��֤����
		boolean reged = serv.deletereply(r_id);
		System.out.println("test" + reged);
		if (reged) {
			System.out.print("Succss");
			confirm="\nɾ���ɹ�";
			//request.getSession().setAttribute("username", username);
			//response.sendRedirect("welcome.jsp");
		}else {
			System.out.print("Failed");
			confirm="\nɾ��ʧ��";
		}


		// ������Ϣ
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

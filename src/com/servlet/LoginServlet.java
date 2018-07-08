package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.Service;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 01L;

	/**
	 * The doGet method of the Server let.
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ������Ϣ
		int id=Integer.parseInt(request.getParameter("u_id"));
		String password = request.getParameter("u_password");
		String confirm;
		System.out.println(id + "--" + password);

		// �½��������
		Service serv = new Service();

		// ��֤����
		boolean loged = serv.login(id, password);
		System.out.println("----------------------------------------");
		System.out.println(loged);
		if (loged) {
			System.out.print("Succss");
			confirm = "\n��½�ɹ�";
//			request.getSession().setAttribute("id", id);
			// response.sendRedirect("welcome.jsp");
		} else {
			System.out.print("Failed");
			confirm = "\n�˺Ż����벻��ȷ";
		}

		 // ������Ϣ
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.print("�˺ţ�" + id);
		 out.print("���룺" + password);
		 out.print(confirm);
		 out.flush();
		 out.close();

	}

	/**
	 * The doPost method of the Server let.
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ����Ϊ���ֻ����������룬��������
		// System.out.println("u1--"+username);
		// System.out.println("u2--"+username);

	}

}

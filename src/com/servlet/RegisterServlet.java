package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 00L;

	/**
	 * The doGet method of the Server let.
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// �½��������
		Service serv = new Service();
		
		// ����ע����Ϣ
//		String username = request.getParameter("r_name");
		int id=Integer.parseInt(request.getParameter("u_id"));
		String username = request.getParameter("u_name");
		username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		String password = request.getParameter("u_password");
		String confirm;
//		String password = request.getParameter("r_password");
		System.out.println("test");
		// ��֤����
		boolean reged = serv.register(id,username,password);
		System.out.println("test" + reged);
		if (reged) {
			System.out.print("Succss");
			confirm="\nע��ɹ�";
			//request.getSession().setAttribute("username", username);
			//response.sendRedirect("welcome.jsp");
		}else {
			System.out.print("Failed");
			confirm="\nע��ʧ�ܣ��ƺ�����ע��";
		}


		// ������Ϣ
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("�˻���" + id);
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

//		����Ϊ���ֻ����������룬��������
//		System.out.println("u1--"+username);
//		System.out.println("u2--"+username);

	}

}

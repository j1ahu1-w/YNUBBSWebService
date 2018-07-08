package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.Service;
import com.entity.User;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service serv = new Service();
		int id=Integer.parseInt(request.getParameter("id"));
		ArrayList<User> user=new ArrayList<User>();
		if(user.isEmpty()) {
			try {
				user=serv.selectuser(id);
				StringBuilder builder = new StringBuilder();
	            builder.append('[');
	            for (User u : user) {
	                    builder.append('{');
	                        builder.append("u_id:").append(u.GetId()).append(',');
	                        builder.append("u_name:").append(u.GetName()).append(',');
	                        builder.append("u_password:").append(u.GetPassword());
	                    builder.append("},");
	                }
	            builder.deleteCharAt(builder.length()-1);
	            builder.append(']');
	            System.out.println(builder);
	            request.setAttribute("json", builder.toString());
	            request.getRequestDispatcher("/WEB-INF/page/json.jsp").forward(request, response);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.Service;
import com.entity.Post;;
/**
 * Servlet implementation class SelectAllServlet
 */
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service serv = new Service();
		ArrayList<Post> posts=new ArrayList<Post>();
		if(posts.isEmpty()) {
			try {
				posts=serv.selectall();
				StringBuilder builder = new StringBuilder();
	            builder.append('[');
	            for (Post p : posts) {
	                    builder.append('{');
	                        builder.append("p_id:").append(p.GetId()).append(',');
	                        builder.append("p_class:").append(p.GetClass()).append(",");
	                        builder.append("p_theme:\"").append(p.GetTheme()).append("\",");
	                        builder.append("p_content:\"").append(p.GetContent()).append("\",");
	                        builder.append("p_time:\"").append(p.GetTime()).append("\",");
	                        builder.append("p_user:").append(p.GetUserId());
	                    builder.append("},");
	                }
	            builder.deleteCharAt(builder.length()-1);
	            builder.append(']');
	            String s="]";
	            if (builder.toString().equals(s)) {
	            	builder.deleteCharAt(0);
	            	builder.append('[');
	            	builder.append('{');
                    builder.append("p_id:").append(0).append(',');
                    builder.append("p_class:").append(0).append(",");
                    builder.append("p_theme:\"").append("0").append("\",");
                    builder.append("p_content:\"").append("0").append("\",");
                    builder.append("p_time:\"").append("0").append("\",");
                    builder.append("p_user:").append(0);
                builder.append("},");
                builder.deleteCharAt(builder.length()-1);
	            builder.append(']');
	            }
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

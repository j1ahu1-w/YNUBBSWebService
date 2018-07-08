package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.Service;
import com.entity.Reply;;
/**
 * Servlet implementation class SelectAllServlet
 */
public class SelectReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 8L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service serv = new Service();
		int id=Integer.parseInt(request.getParameter("r_to_p_id"));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(id);
		ArrayList<Reply> replys=new ArrayList<Reply>();
		if(replys.isEmpty()) {
			try {
				replys=serv.selectreply(id);
				StringBuilder builder = new StringBuilder();
	            builder.append('[');
	            for (Reply r : replys) {
	                    builder.append('{');
	                        builder.append("r_id:").append(r.GetId()).append(',');
	                        builder.append("r_to_p_id:").append(r.GetRToPId()).append(",");
	                        builder.append("r_to_class:").append(r.GetClass()).append(",");
	                        builder.append("r_to_id:").append(r.GetRToId()).append(",");
	                        builder.append("r_content:\"").append(r.GetContent()).append("\",");
	                        builder.append("r_time:\"").append(r.GetTime()).append("\",");
	                        builder.append("r_user:").append(r.GetUserId());
	                    builder.append("},");
	                }
	            builder.deleteCharAt(builder.length()-1);
	            builder.append(']');
	            String s="]";
	            if (builder.toString().equals(s)) {
	            	builder.deleteCharAt(0);
	            	builder.append('[');
	            	builder.append('{');
                    builder.append("r_id:").append(0).append(',');
                    builder.append("r_to_p_id:").append(0).append(",");
                    builder.append("r_to_class:").append(0).append(",");
                    builder.append("r_to_id:").append(0).append(",");
                    builder.append("r_content:\"").append("0").append("\",");
                    builder.append("r_time:\"").append("0").append("\",");
                    builder.append("r_user:").append(0);
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

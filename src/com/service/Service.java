package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.db.DBManager;
import com.entity.Post;
import com.entity.User;
import com.entity.Reply;

public class Service {

	public Boolean login(int id, String password) {

		// 获取Sql查询语句
		String logSql = "select * from user where u_id ='" + id
				+ "' and u_password ='" + password +"'";

		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.connectDB();

		// 操作DB对象
		try {
			ResultSet rs = sql.executeQuery(logSql);
			System.out.println(rs);
			if (rs.next()) {
				sql.closeDB();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return false;
	}

	public Boolean register(int id,String username, String password) {

		// 获取Sql查询语句
		String regSql = "insert into user (u_id,u_name,u_password) values('"
				+ id + "','"+ username + "','" + password + "') ";
		
		
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		
		int ret = sql.executeUpdate(regSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	
	public ArrayList<Post> selectall() throws Exception{
		ArrayList<Post> posts=new ArrayList<Post>();
		String SelectAllSql="select * from post";
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		try {
			ResultSet rs = sql.executeQuery(SelectAllSql);
			while (rs.next()) {
				Post p=new Post();
				p.SetId(rs.getInt("p_id"));
				p.SetUserId(rs.getInt("p_user"));
				p.SetClass(rs.getInt("p_class"));
				p.SetTheme(rs.getString("p_theme"));
				p.SetContent(rs.getString("p_content"));
				p.SetTime(rs.getString("p_time"));
				posts.add(p);
			}
			return posts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
	public ArrayList<Post> selectsingle(int id) throws Exception{
		ArrayList<Post> posts=new ArrayList<Post>();
		String SelectAllSql="select * from post where p_id='"+id+ "'";
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		try {
			ResultSet rs = sql.executeQuery(SelectAllSql);
			while (rs.next()) {
				Post p=new Post();
				p.SetId(rs.getInt("p_id"));
				p.SetUserId(rs.getInt("p_user"));
				p.SetClass(rs.getInt("p_class"));
				p.SetTheme(rs.getString("p_theme"));
				p.SetContent(rs.getString("p_content"));
				p.SetTime(rs.getString("p_time"));
				posts.add(p);
			}
			return posts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
	public ArrayList<User> selectuser(int id) throws Exception{
		ArrayList<User> user=new ArrayList<User>();
		String SelectAllSql="select * from user where u_id='"+id+ "'";
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		try {
			ResultSet rs = sql.executeQuery(SelectAllSql);
			while (rs.next()) {
				User u=new User();
				u.SetId(rs.getInt("u_id"));
				u.SetName(rs.getString("u_name"));
				u.SetPassword(rs.getString("u_password"));
				user.add(u);
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
	public ArrayList<Post> selectbytype(int type) throws Exception{
		ArrayList<Post> posts=new ArrayList<Post>();
		String SelectAllSql="select * from post where p_class='"+type+ "'";
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		try {
			ResultSet rs = sql.executeQuery(SelectAllSql);
			while (rs.next()) {
				Post p=new Post();
				p.SetId(rs.getInt("p_id"));
				p.SetUserId(rs.getInt("p_user"));
				p.SetClass(rs.getInt("p_class"));
				p.SetTheme(rs.getString("p_theme"));
				p.SetContent(rs.getString("p_content"));
				p.SetTime(rs.getString("p_time"));
				posts.add(p);
			}
			return posts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
	public Boolean insertpost(int p_class,String p_theme, String p_content,String p_time,int p_user) {

		// 获取Sql查询语句
		String insSql = "insert into post (p_class,p_theme,p_content,p_time,p_user) values('"
				+ p_class + "','"+ p_theme + "','" + p_content + "','"+ p_time + "','" + p_user +"') ";
		
		
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		
		int ret = sql.executeUpdate(insSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	
	public Boolean insertreply(int r_to_p_id,int r_to_class,int r_to_id,String r_content,String r_time,int r_user) {

		// 获取Sql查询语句
		String insSql = "insert into reply (r_to_p_id,r_to_class,r_to_id,r_content,r_time,r_user) values('"
				+ r_to_p_id + "','"+ r_to_class + "','"+ r_to_id + "','" + r_content + "','"+ r_time + "','" + r_user +"') ";
		
		
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		
		int ret = sql.executeUpdate(insSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	
	public Boolean deletepost(int p_id) {

		// 获取Sql查询语句
		String delSql = "delete from post where p_id='"+p_id+ "'";
			
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		
		int ret = sql.executeUpdate(delSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	
	public Boolean deletereply(int r_id) {

		// 获取Sql查询语句
		String delSql = "delete from reply where r_id='"+r_id+ "'";
			
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		
		int ret = sql.executeUpdate(delSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	
	public Boolean deletepostreply(int p_id) {

		// 获取Sql查询语句
		String delSql = "delete from reply where r_to_p_id='"+p_id+ "'";
			
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		
		int ret = sql.executeUpdate(delSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	
	public ArrayList<Reply> selectreply(int postid) throws Exception{
		ArrayList<Reply> replys=new ArrayList<Reply>();
		String SelectAllSql="select * from reply where r_to_p_id='"+postid+ "'";
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		try {
			ResultSet rs = sql.executeQuery(SelectAllSql);
			while (rs.next()) {
				Reply r=new Reply();
				r.SetId(rs.getInt("r_id"));
				r.SetUserId(rs.getInt("r_user"));
				r.SetClass(rs.getInt("r_to_class"));
				r.SetRToPId(rs.getInt("r_to_p_id"));
				r.SetRToId(rs.getInt("r_to_id"));
				r.SetContent(rs.getString("r_content"));
				r.SetTime(rs.getString("r_time"));
				replys.add(r);
			}
			return replys;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
	public ArrayList<Reply> selectreply1(int rid) throws Exception{
		ArrayList<Reply> replys=new ArrayList<Reply>();
		String SelectAllSql="select * from reply where r_id='"+rid+ "'";
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		try {
			ResultSet rs = sql.executeQuery(SelectAllSql);
			while (rs.next()) {
				Reply r=new Reply();
				r.SetId(rs.getInt("r_id"));
				r.SetUserId(rs.getInt("r_user"));
				r.SetClass(rs.getInt("r_to_class"));
				r.SetRToPId(rs.getInt("r_to_p_id"));
				r.SetRToId(rs.getInt("r_to_id"));
				r.SetContent(rs.getString("r_content"));
				r.SetTime(rs.getString("r_time"));
				replys.add(r);
			}
			return replys;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
}

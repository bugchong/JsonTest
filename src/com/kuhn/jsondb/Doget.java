package com.kuhn.jsondb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;



@WebServlet("/Doget")
public class Doget extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Statement st = null;
	ResultSet rs = null;   
    Connection conn = null;
    
    public Doget() {
        super();
//        doGet(request, response);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//解决中文乱码
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html");
		ArrayList<Dbinfo> result = new ArrayList<Dbinfo>(); 
		conn = Service.getConnection();
		Integer stockcode = Integer.parseInt(request.getParameter("stockcode"));
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM jsondb WHERE stockcode = " + stockcode);
			//初始化JSONArray
			JSONArray jsonarray = new JSONArray();
			while(rs.next()){
//				Dbinfo dbinfo = new Dbinfo();
//				dbinfo.setId(rs.getInt("id"));
//				dbinfo.setStockcode(rs.getInt("stockcode"));
//				dbinfo.setStockname(rs.getString("stockname"));
//				dbinfo.setTitle(rs.getString("title"));
//				result.add(dbinfo);
				//初始化JSONObject，依次放入相应的数据
				JSONObject jso = new JSONObject();
				jso.put("id",rs.getInt("id"));
				jso.put("stockcode",rs.getInt("stockcode"));
				jso.put("stockname", rs.getString("stockname"));
				jso.put("title", rs.getString("title"));
				//将JSONObject放入JSONArray
				jsonarray.put(jso);
				

				 
			}
			
			
			PrintWriter write = response.getWriter(); 
			//显示JSONArray，使用toString()方法
			write.write(jsonarray.toString());
			response.setHeader("Content-Type" ,"application/json;charset=UTF-8");
			
		} catch (Exception e) {
//			System.out.println(result); 
			e.printStackTrace();
		}		 
		finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(st!=null){
					st.close();
				}
				if(conn!=null){
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

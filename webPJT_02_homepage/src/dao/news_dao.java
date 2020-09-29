package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.news_dto;

public class news_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection	  = null;
	PreparedStatement  ps	  = null;
	ResultSet		   rs 	  = null;
	
	public int deleteNews(String no) {
		int result = 0;
		String query = " delete from h02_news\r\n" + 
						" where no = '"+no+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" deleteNews() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" deleteNews() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
		
	}
	
	
	
	public int updateNews(String no, String title, String content, String reg_name, String reg_date) {
		int result = 0;
		String query = " update h02_news\r\n" + 
						" set title = '"+title+"',\r\n" + 
						"    content = '"+content+"',\r\n" + 
						"    reg_name = '"+reg_name+"',\r\n" + 
						"    reg_date = '"+reg_date+"'\r\n" + 
						" where no = '"+no+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" updateNews() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" updateNews() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
		
	}
	
	
	
	public int hitCount(String no) {
		int result = 0;
		String query = " update h02_news\r\n" + 
						" set hit = hit + 1\r\n" + 
						" where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" hitCount() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" hitCount() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
	
	
	
	public int saveNews(String no, String title, String content, String reg_name, String reg_date) {
		int result = 0;
		String query = " insert into h02_news\r\n" + 
					" (no, title, content, reg_name, reg_date)\r\n" + 
					" values('"+no+"','"+title+"','"+content+"','"+reg_name+"','"+reg_date+"')";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" saveNews() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" saveNews() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
		
	}
	
	public String getNewsNo() {
		String maxNo = "";
		String query = " select max(no) from h02_news ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo == "null") {
				maxNo = "N001";
				
			}else {
				String n = maxNo.substring(1);
				int i = Integer.parseInt(n);
				i++;
				DecimalFormat df = new DecimalFormat("000");
				String newNo = df.format((double)i);
				maxNo = "N"+ newNo;
			}
			
		}catch(SQLException se) {
			System.out.println(" getNewsNo() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getNewsNo() 오류 ");
		}finally {
			common.close(connection, ps,rs);
		}
		
		
		return maxNo;
	}
	
	public news_dto getNewsView(String no) {
		news_dto dto1 = null;
		String query = " select no, title, content ,reg_name, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
						" from h02_news\r\n" + 
						" where no = '"+no+"'";
		System.out.println(query);
			try {
			
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String nn 		= rs.getString(1);
				String title 	= rs.getString(2);
				String content  = rs.getString(3);
				String reg_name = rs.getString(4);
				String reg_date = rs.getString(5);
				int hit 		= rs.getInt(6);
				
				dto1 = new news_dto(nn, title,content, reg_name, reg_date, hit);
				
			}
			
			}catch(SQLException se) {
				System.out.println(" getNewsView() query 오류 : " + query);
			}catch(Exception e) {
				System.out.println(" getNewsView() 오류  ");
			}finally {
				common.close(connection, ps, rs);;
			}
		
			return dto1;
	}
	
	
	
	public ArrayList<news_dto> getNewsList(String select, String search){
		ArrayList<news_dto> arr = new ArrayList();
		String query = " select no, title, reg_name, reg_date, hit\r\n" + 
						" from h02_news\r\n" + 
						" where "+select+" like '%"+search+"%'\r\n" + 
						" order by no desc";
		
		try {
			
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String no 		= rs.getString(1);
				String title 	= rs.getString(2);
				String reg_name = rs.getString(3);
				String reg_date = rs.getString(4);
				int hit 		= rs.getInt(5);
				
				
				news_dto dto = new news_dto(no, title,"", reg_name, reg_date, hit);
				arr.add(dto);
			}
			
			
		}catch(SQLException se) {
			System.out.println(" getNewsList() query 오류 : " + query);
		}catch(Exception e) {
			System.out.println(" getNewsList() 오류  ");
		}finally {
			common.close(connection, ps, rs);;
		}
		
		
		
		return arr;
	}
	
	
	
	
	
}

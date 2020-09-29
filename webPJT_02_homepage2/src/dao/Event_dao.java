package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Event_dto;

public class Event_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection	  = null;
	PreparedStatement  ps	  = null;
	ResultSet		   rs 	  = null;
	
	public int eventDelete(String no) {
		int result = 0;
		String query = " delete from h02_event\r\n" + 
						" where no = '"+no+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" eventDelete() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" eventDelete() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
		
	}
	
	
	
	
	public int eventUpdate(Event_dto dto) {
		int result = 0;
		String query = "update h02_event \r\n" + 
				" set title = '"+dto.getTitle()+"',\r\n" + 
				"    content = '"+dto.getContent()+"',\r\n" + 
				"    s_date = '"+dto.getS_date()+"',\r\n" + 
				"    e_date = '"+dto.getE_date()+"',\r\n" + 
				"    reg_name = '"+dto.getReg_name()+"',\r\n" + 
				"    reg_date = '"+dto.getReg_date()+"'\r\n" + 
				" where no = '"+dto.getNo()+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" eventUpdate() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" eventUpdate() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
	
	public void hitCount(String no) {
		String query = "update h02_event\r\n" + 
						" set hit = hit + 1\r\n" + 
						" where no = '"+no+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" hitCount() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" hitCount() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
	}
	
	
	
	
	public Event_dto getEventView(String no) {
		Event_dto dto = null;
		String query = "select title, content, to_char(s_date,'yyyy-MM-dd'), to_char(e_date,'yyyy-MM-dd'), "
					  + " reg_name, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
						" from h02_event\r\n" + 
						" where no = '"+no+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		
			
			if(rs.next()) {
				String title 	 = rs.getString(1);
				String content 	 = rs.getString(2);
				String s_date 	 = rs.getString(3);
				String e_date 	 = rs.getString(4);
				String reg_name  = rs.getString(5);
				String reg_date  = rs.getString(6);
				int hit			 = rs.getInt(7);
				
				dto = new Event_dto(no, title, content, s_date, e_date, reg_name, reg_date, hit);
			}
			
			
		}catch(SQLException se) {
			System.out.println(" getEventView() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getEventView() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		
		return dto;
	}
	
	
	
	
	public ArrayList<Event_dto> getEventList(String select, String search){
		ArrayList<Event_dto> arr = new ArrayList<>();
		String query = " select no, title, to_char(s_date,'yyyy-MM-dd') as sdate, to_char(e_date,'yyyy-MM-dd'), "
					+ " reg_name, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
						" from h02_event\r\n" + 
						" where "+select+" like '%"+search+"%'" +
						" order by no desc";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		
			
			while(rs.next()) {
				String no 		 = rs.getString("no");
				String title 	 = rs.getString("title");
				String s_date 	 = rs.getString("sdate");
				String e_date 	 = rs.getString(4);
				String reg_name  = rs.getString(5);
				String reg_date  = rs.getString(6);
				int hit			 = rs.getInt(7);
				
				Event_dto dto = new Event_dto(no, title, "", s_date, e_date, reg_name, reg_date, hit);
				arr.add(dto);
			}
			
			
		}catch(SQLException se) {
			System.out.println(" getEventList() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getEventList() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		return arr;
	}
		
		
	
	
	public int eventSave(Event_dto dto) {
		int result = 0;
		String query = " insert into h02_event\r\n" + 
						" (no, title, content, s_date, e_date, reg_name, reg_date)\r\n" + 
						" values\r\n" + 
						" ('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getS_date()+"',"
								+ "'"+dto.getE_date()+"','"+dto.getReg_name()+"','"+dto.getReg_date()+"')";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" eventSave() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" eventSave() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		
		return result;
	}
	
	
	
	public String getEventNo() {
		String maxNo = "";
		String query = " select max(no) from h02_event ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo == "null") {
				maxNo = "E0001";
				
			}else {
				String n = maxNo.substring(1);
				int i = Integer.parseInt(n);
				i++;
				DecimalFormat df = new DecimalFormat("0000");
				String newNo = df.format((double)i);
				maxNo = "E"+ newNo;
			}
			
		}catch(SQLException se) {
			System.out.println(" getEventNo() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getEventNo() 오류 ");
		}finally {
			common.close(connection, ps,rs);
		}
		
		
		return maxNo;
	}
	
	
	
}

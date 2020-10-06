package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.News_dto;
import dto.Notice_dto;

public class News_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	
	
	
	
	// 목록 조회
	public ArrayList<News_dto> getNewsView(){
		ArrayList<News_dto> arr = new ArrayList<News_dto>();
		String query = " select no, title, reg_name, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
						" from h02_news\r\n" + 
						" order by no desc";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				String no = rs.getString(1);
				String title = rs.getString(2);
				String reg_name = rs.getString(3);
				String reg_date = rs.getString(4);
				int hit = rs.getInt(5);
				
				News_dto dto = new News_dto(no, title, "", reg_name, reg_date, hit);
				arr.add(dto);
				
			}
			
			
		}catch(SQLException se) {
			System.out.println("getNewsView() query 오류" + query);
		}catch(Exception e) {
			System.out.println("getNewsView() 오류");
		}finally {
			
		}
		
		
		return arr;
	}
	
	//등록
	public int saveNews(Notice_dto dto){
		int result = 0;
		String query="insert into h02_news\r\n" + 
				"(no, title, content, reg_name, reg_date)\r\n" + 
				"values('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getReg_name()+"','"+dto.getReg_date()+"')";
		
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
	
	
	
	
	//번호 생성
	public String getNewsNo() {
		String maxNo = "";
		String query = "select max(no)\r\n" + 
						" from h02_news";
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
	
	
	
	
}

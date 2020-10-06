package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.catalina.connector.Request;

import common.DBConnectionOracle;
import dto.Notice_dto;

public class Notice_dao {

	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection	  = null;
	PreparedStatement  ps	  = null;
	ResultSet		   rs 	  = null;
	
	String pageType = "";
	
	public void DefinitionPageType(String pageType){
		this.pageType = pageType;
	}
	
	
	//삭제
	public int deleteNotice(String no){
		int result = 0;
		String query = "delete from h02_"+pageType+"\r\n" + 
				"where no = '"+no+"";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" deleteNotice() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" deleteNotice() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return result;
	}
	
	
	
	
	
	//수정
	public int updateNotice(Notice_dto dto){
		int result = 0;
		String query = "update h02_"+pageType+"\r\n" + 
						"set title = '"+dto.getTitle()+"',\r\n" + 
						"    content = '"+dto.getContent()+"',\r\n" + 
						"    attach = '"+dto.getAttach()+"',\r\n" + 
						"    reg_name = '"+dto.getReg_name()+"',\r\n" + 
						"    reg_date = '"+dto.getReg_date()+"'\r\n" + 
						"where no = '"+dto.getNo()+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" updateNotice() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" updateNotice() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return result;
	}
	
	
	
	//조회수 증가
		public void hitCount(String no) {
			String query = "update h02_"+pageType+"\r\n" + 
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
	
	
	//등록조회
	public Notice_dto getNoticeView(String no){
		Notice_dto dto = null;
		String query = " select no, title, content, attach, reg_name, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
						" from h02_"+pageType+"\r\n" + 
						" where no = '"+no+"'";

		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		
			
			if(rs.next()) {
				String nn 		 = rs.getString(1);
				String title 	 = rs.getString(2);
				String content 	 = rs.getString(3);
				String attach 	 = rs.getString(4);
				String reg_name  = rs.getString(5);
				String reg_date  = rs.getString(6);
				int hit			 = rs.getInt(7);
				
				dto = new Notice_dto(nn, title, content, attach, reg_name, reg_date, hit);
			}
			
			
		}catch(SQLException se) {
			System.out.println(" getNoticeView() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getNoticeView() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return dto;
	}
	
	
	
	//목록 조회
	public ArrayList<Notice_dto> getNoticeList(String select, String search){
		ArrayList<Notice_dto> arr = new ArrayList<Notice_dto>();
		String query = " select no, title, attach, reg_name, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
						" from h02_"+pageType+"\r\n" + 
						" where "+select+" like '%"+search+"%'\r\n" + 
						" order by no desc";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		
			
			while(rs.next()) {
				String no 		 = rs.getString(1);
				String title 	 = rs.getString(2);
				String attach 	 = rs.getString(3);
				String reg_name  = rs.getString(4);
				String reg_date  = rs.getString(5);
				int hit			 = rs.getInt(6);
				
				Notice_dto dto = new Notice_dto(no, title,"",attach, reg_name, reg_date, hit);
				arr.add(dto);
			}
			
			
		}catch(SQLException se) {
			System.out.println(" getNoticeList() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getNoticeList() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		
		
		return arr;
	}
	
	
	
	// 등록
	public int SaveNotice(Notice_dto dto){
		int result = 0;
		String query = "insert into h02_"+pageType+"\r\n" + 
					" (no, title, content, attach, reg_name, reg_date)\r\n" + 
					" values\r\n" + 
					" ('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"',"
					+ "'"+dto.getAttach()+"','"+dto.getReg_name()+"','"+dto.getReg_date()+"')";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" SaveNotice() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" SaveNotice() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
	
	// 번호 생성
		public String getNoticeNo() {
			String maxNo = "";
			String query = " select max(no) from h02_"+pageType+" ";
			
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
				System.out.println(" getNoticeNo() query 오류 " + query);
			}catch(Exception e) {
				System.out.println(" getNoticeNo() 오류 ");
			}finally {
				common.close(connection, ps,rs);
			}
			
			
			return maxNo;
		}
}

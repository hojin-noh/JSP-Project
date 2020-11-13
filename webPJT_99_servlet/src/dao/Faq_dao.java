package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Faq_dto;
import dto.News_dto;

public class Faq_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection	  = null;
	PreparedStatement  ps	  = null;
	ResultSet		   rs 	  = null;
	
	
	//수정 목록
	public Faq_dto getFaqView(String no){
		News_dto dto = null;
		String query = " select no, question, answer, reg_id, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
						" from h02_news\r\n" + 
						" where no = '"+no+"'";

		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
		
			
			if(rs.next()) {
				String nn 		 = rs.getString(1);
				String question  = rs.getString(2);
				String answer 	 = rs.getString(3);
				String reg_id 	 = rs.getString(4);
				String reg_date  = rs.getString(5);
				int hit			 = rs.getInt(6);
				
				dto = new Faq_dto(nn, question, answer, reg_id, reg_date, "" ,hit);
			}
			
			
		}catch(SQLException se) {
			System.out.println(" getFaqView() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getFaqView() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return dto;
	}
	
	
	//수정
	public int updateFaq(Faq_dto dto) {
		int result = 0;
		String query = " update h02_faq\r\n" + 
						" set question='"+dto.getQuestion()+"',\r\n" + 
						"    answer='"+dto.getAnswer()+"',\r\n" + 
						"    reg_date='"+dto.getReg_date()+"'\r\n" + 
						" where no='"+dto.getNo()+"' ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" updateFaq() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" updateFaq() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return result;
		
		
	}
	
	
	
	//등록
	public int SaveFaq(Faq_dto dto) {
		int result = 0;
		String query = " insert into h02_faq(no, question, answer, reg_id, reg_date, sort)\r\n" + 
						" values('"+dto.getNo()+"','"+dto.getQuestion()+"','"+dto.getAnswer()+"','"+dto.getReg_id()+"','"+dto.getReg_date()+"','"+dto.getSort()+"')";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" SaveFaq() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" SaveFaq() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
	
	

	//목록조회
	public ArrayList<Faq_dto> getFaqList(String select, String search){
	ArrayList<Faq_dto> dtos = new ArrayList<Faq_dto>();
	String query = " select a.no, a.question, to_char(a.reg_date,'yyyy-MM-dd'), b.name, a.hit \r\n" + 
					" from h02_faq a, h02_member b\r\n" + 
					" where a.reg_id = b.id\r\n" + 
					" and "+select+" like '%"+search+"%' order by a.sort desc, a.no desc ";
	
	try {
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		rs = ps.executeQuery();
	
		
		while(rs.next()) {
			String no 		 = rs.getString(1);
			String question  = rs.getString(2);
			String reg_date  = rs.getString(3);
			String reg_name  = rs.getString(4);
			int hit			 = rs.getInt(5);
			
			Faq_dto dto = new Faq_dto(no, question,"" , reg_name, reg_date, "",hit);
			dtos.add(dto);
		}
		
		
	}catch(SQLException se) {
		System.out.println(" getFaqList() query 오류 " + query);
	}catch(Exception e) {
		System.out.println(" getFaqList() 오류 ");
	}finally {
		common.close(connection, ps, rs);
	}
	return dtos;
}

	
	// 번호 생성
			public String getFaqNo() {
				String maxNo = "";
				String query = " select max(no) from h02_faq ";
				
				try {
					connection = common.getConnection();
					ps = connection.prepareStatement(query);
					rs = ps.executeQuery();
					
					if(rs.next()) {
						maxNo = rs.getString(1);
					}
					if(maxNo == "null") {
						maxNo = "F001";
						
					}else {
						String n = maxNo.substring(1);
						int i = Integer.parseInt(n);
						i++;
						DecimalFormat df = new DecimalFormat("000");
						String newNo = df.format((double)i);
						maxNo = "F"+ newNo;
					}
					
				}catch(SQLException se) {
					System.out.println(" getFaqNo() query 오류 " + query);
				}catch(Exception e) {
					System.out.println(" getFaqNo() 오류 ");
				}finally {
					common.close(connection, ps,rs);
				}
				
				
				return maxNo;
			}

}

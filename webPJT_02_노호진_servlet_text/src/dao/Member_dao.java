package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionOracle;
import dto.Member_dto;

public class Member_dao {

	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection	  = null;
	PreparedStatement  ps	  = null;
	ResultSet		   rs 	  = null;
	
	
	//id 중복 검사
		public int idCheckCount(String id) {
			int count = 0;
			String query = "select count(*)\r\n" + 
							" from h02_member\r\n" + 
							" where id = '"+id+"'";
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
			if(rs.next())count = rs.getInt(1);
				
			}catch(SQLException se) {
				System.out.println(" idCheckCount() query 오류 " + query);
			}catch(Exception e) {
				System.out.println(" idCheckCount() 오류 ");
			}finally {
				common.close(connection, ps, rs);
			}
			
			return count;
		}
	
	
	
	
	//로그인 시 id 랑 비밀번호 조회
	public String getLoginName(String id, String pw) {
		String name = null;
		String query = "select name\r\n" + 
						" from h02_member\r\n" + 
						" where id='"+id+"'and pw ='"+pw+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
		if(rs.next()) {
			name = rs.getString(1);
			
		}
			
		}catch(SQLException se) {
			System.out.println(" getLoginName() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getLoginName() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return name;
	}
	
	
	
	//회원가입
	public int saveMember(Member_dto dto) {
		int result = 0;
		String query = "insert into h02_member\r\n" + 
				"values\r\n" + 
				"('"+dto.getId()+"','"+dto.getName()+"','"+dto.getPw()+"','"+dto.getArea()+"','"+dto.getAddress()+"','"+dto.getTel_1()+"','"+dto.getTel_2()+"','"+dto.getTel_3()+"','"+dto.getMf()+"','"+dto.getHobby_r()+"','"+dto.getHobby_s()+"','"+dto.getHobby_t()+"','"+dto.getReg_date()+"')";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" saveMember() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" saveMember() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
}

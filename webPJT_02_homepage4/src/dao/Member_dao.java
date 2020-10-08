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

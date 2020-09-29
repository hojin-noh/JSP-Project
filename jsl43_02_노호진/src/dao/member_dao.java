package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Memberinfo_dto;

public class member_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	
	//회원 조회_이름으로
	public ArrayList<Memberinfo_dto> getNameList (String name){
		ArrayList<Memberinfo_dto> arr3 = new ArrayList();
		String query = "select id, name, address, tell, age, reg_date\r\n" + 
					" from b02_bookmember\r\n" + 
					" where name like '%"+name+"%'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String Name = rs.getString(2);
				String address = rs.getString(3);
				String tell = rs.getString(4);
				String age = rs.getString(5);
				String regDate = rs.getString(5);
				
				
				Memberinfo_dto dto = new Memberinfo_dto(id,Name,address,tell,age,regDate);
				arr3.add(dto);
			}
		
			
			
		}catch(SQLException se) {
			System.out.println(" getNameList() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getNameList() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr3;
				
	}
	
	//조회_전체조회
	public ArrayList<Memberinfo_dto> getViewMemberList(String work){
		ArrayList<Memberinfo_dto> arr4 = new ArrayList();
		String query = " select id, name, address, tell, age, reg_date\r\n" + 
						" from b02_bookmember";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String Name = rs.getString(2);
				String address = rs.getString(3);
				String tell = rs.getString(4);
				String age = rs.getString(5);
				String regDate = rs.getString(5);
				
				
				Memberinfo_dto dto = new Memberinfo_dto(id,Name,address,tell,age,regDate);
				arr4.add(dto);
			}
			
			
		}catch(SQLException se) {
			System.out.println(" getViewMemberList() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getViewMemberList() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr4;
	}
	
	
	
	
	
	
	
}

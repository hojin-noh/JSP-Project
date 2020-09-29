package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Return_dto;

public class Return_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	public ArrayList<Return_dto> getMemberRentInfo(String id) {
		ArrayList<Return_dto> arr3 = new ArrayList<>();
		String query = "select a.no, b.id, b.name, c.no, c.name, a.rent_date, c.rent_gubun\r\n" + 
					" from b02_rent a, b02_bookmember b, b02_book c\r\n" + 
					" where a.member_id = b.id \r\n" + 
					" and a.book_no = c.no\r\n" + 
					" and a.member_id = '"+id+"'\r\n" + 
					" order by c.rent_gubun";
		
		try {
			connection =common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String rent_no = rs.getString(1);
				String member_id = rs.getString(2);
				String member_name = rs.getString(3);
				String book_no = rs.getString(4);
				String book_name = rs.getString(5);
				String rent_date = rs.getString(6);
				String rent_gubun = rs.getString(7);
				
				Return_dto dto1 = new Return_dto(rent_no,  member_id, member_name,book_no,book_name,rent_date,rent_gubun); 
				arr3.add(dto1);
			}
			
		}catch(SQLException se) {
			System.out.println(" getMemberRentInfo() qyery 오류 " + query );
		}catch(Exception e) {
			System.out.println(" getMemberRentInfo() 오류 " );
		}finally {
			common.close(connection, ps, rs);
		}
				
		
		return arr3;
	}
	
	
	
	//반납시 반납일자 입력하는 매소드
	public int returnRent(String rentNo, String returnDate){
		int result = 0;
		String query = "update b02_rent\r\n" + 
					" set return_date = '"+returnDate+"'\r\n" + 
					" where no = '"+rentNo+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
			
		}catch(SQLException se) {
			System.out.println(" returnRent() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" returnRent() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		
		return result;
	}
	
	
	//반납구분을 y로 바꾸는 매소드
	 public int returnBook(String rentNo){
		int result = 0;
		String query ="update b02_book\r\n" + 
					" set rent_gubun = 'y'\r\n" + 
					" where no = (select book_no\r\n" + 
					" from b02_rent \r\n" + 
					" where no = '"+rentNo+"')";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
			
		}catch(SQLException se) {
			System.out.println(" returnBook() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" returnBook() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		
		return result;
	}

	
	
	
	
}

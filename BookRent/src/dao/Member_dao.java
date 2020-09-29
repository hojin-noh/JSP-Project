package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.HistoryMember_dto;
import dto.Member_dto;
import dto.Rent_dto;

public class Member_dao {
	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	//등록
	public int getMember(String id, String name, String add, String tell, int age, String date) {
		int result = 0;
		String query = " insert into b02_bookmember\r\n" + 
					" values('"+id+"','"+name+"','"+add+"','"+tell+"',"+age+",'"+date+"')";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
			
		}catch(SQLException se) {
			System.out.println(" getMember() query 오류 " + query );
		}catch(Exception e) {
			System.out.println(" getMember() 오류 ");
		}finally {
			common.close(connection, ps,rs);
		}
						
		return result;
	}
	
	// 조회
	public ArrayList<Member_dto> getMemberList(String gubun, String work){
		ArrayList<Member_dto> arr = new ArrayList();
		String query = "select id, name, address, tell, reg_date, age\r\n" + 
						"to_char(reg_date, 'yyyy-MM-dd')"+
						" from b02_bookmember\r\n" + 
						" where "+gubun+" like '%"+work+"%'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String Id = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String tell = rs.getString(4);
				String reg_date = rs.getString(5);
				int age = rs.getInt(6);
				
				Member_dto dto = new Member_dto(Id, name, address, tell, reg_date, age);
				arr.add(dto);
			}
			
			
		}catch(SQLException se) {
			System.out.println(" getMemberList() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getMemberList() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		
		return arr;
	}
	
	
	//수정 조회
	public Member_dto viewMember(String id) {
		Member_dto dto = null;
		String query = "select *\r\n" + 
					" from b02_bookmember\r\n" + 
					" where id like '%"+id+"%'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String Id = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String tell = rs.getString(4);
				String reg_date = rs.getString(5);
				int age = rs.getInt(6);
				
				dto = new Member_dto(Id, name, address, tell, reg_date, age);
			}
			
		}catch(SQLException se) {
			System.out.println(" viewMember() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" viewMember() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return dto;
	}
	
	//수정
	public int updateMember(String id, String name, String address, String tell, String reg_date, int age) {
		int result = 0;
		String query = " update b02_bookmember\r\n" + 
					" set name = '"+name+"',\r\n" + 
					" address = '"+address+"',\r\n" + 
					" tell = '"+tell+"',\r\n" + 
					" reg_date = '"+reg_date+"',\r\n" + 
					" age = "+age+"\r\n" + 
					" where id = '"+id+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" updateMember() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" updateMember() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
				
		
		return result;
	}
	
	//삭제
	public int deleteMember(String id) {
		int result = 0;
		String query = " delete from b02_bookmember\r\n" + 
				" where id = '"+id+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" deleteMember() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" deleteMember()오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		
		return result;
	}
	
	//도서관리_조회
	public ArrayList<Member_dto> getBookList(String gubun, String work){
		ArrayList<Member_dto> arr = new ArrayList();
		String query = " select no, name, publisher, writer, to_char(reg_date,'yyyy-MM-dd'), rent_gubun\r\n" + 
						" from b02_book\r\n" + 
						" where "+gubun+" like '%"+work+"%'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
								
				Member_dto dto = new Member_dto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				arr.add(dto);
			}
			
		}catch(SQLException se) {
			System.out.println(" getBookList() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getBookList() 오류 " );
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	
	
	//도서관리_등록
	public int getBookList(String no, String name, String publisher, String writer, String reg_date) {
		int result = 0;
		String query = " insert into b02_book\r\n" + 
						"(no,name,publisher,writer,reg_date)"+
						" values('"+no+"','"+name+"','"+publisher+"','"+writer+"','"+reg_date+"')";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
			
		}catch(SQLException se) {
			System.out.println(" getBookList() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getBookList() 오류 " );
		}finally {
			common.close(connection, ps, rs);
		}
		
		
		return result;
	}
	
	//도서관리_수정/삭제 조회
	public Member_dto viewBookList(String no) {
		Member_dto dto = null;
		String query = "select no, name, publisher, writer, reg_date, rent_gubun\r\n" + 
				"from b02_book\r\n" + 
				"where no like '%"+no+"%'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new Member_dto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			}
			
			
		}catch(SQLException se) {
			System.out.println(" viewBookList() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" viewBookList() 오류 " );
		}finally{
			common.close(connection, ps, rs);;
		}
		
		
		
		return dto;
	}
	
	//도서관리_수정
	public int updateBookList(String no, String name, String publisher, String writer, String reg_date) {
		int result = 0;
		String query = " update b02_book\r\n" + 
					" set name ='"+name+"',\r\n" + 
					" publisher ='"+publisher+"',\r\n" + 
					" writer ='"+writer+"',\r\n" + 
					" reg_date ='"+reg_date+"'\r\n" + 
					" where no = '"+no+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" updateBookList() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" updateBookList() 오류 " );
		}finally {
			common.close(connection, ps,rs);
		}
		return result;
	}
	
	
	//도서관리_삭제
	public int deleteBookList(String no) {
		int result = 0;
		String query = "delete from b02_book\r\n" + 
						"where no = '"+no+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" deleteBookList() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" deleteBookList() 오류 " );
		}finally {
			common.close(connection, ps, rs);
		}
		
		return result;
	}

	

	

	
	
	
	
	
}

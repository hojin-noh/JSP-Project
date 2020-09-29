package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.HistoryMember_dto;

public class HistoryMember_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	//대여이력_회원 ID로 조회
	public ArrayList<HistoryMember_dto> getHistoryMember(String memberId){
		ArrayList<HistoryMember_dto> arr4 = new ArrayList<>();
		String query = "select a.no, b.name, c.no, c.name, "
					+ " to_char(a.rent_date, 'yyyy-MM-dd'), decode(a.return_date,null,'-',to_char(a.return_date, 'yyyy-MM-dd'))\r\n" + 
					" from b02_rent a, b02_bookmember b, b02_book c\r\n" + 
					" where a.member_id = b.id\r\n" + 
					" and a.book_no = c.no\r\n" + 
					" and a.member_id = '"+memberId+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String rNo = rs.getString(1);
				String memberName = rs.getString(2);
				String bookNo = rs.getString(3);
				String bookName = rs.getString(4);
				String rentDate = rs.getString(5);
				String returnDate = rs.getString(6);
				
				HistoryMember_dto dto4 = new HistoryMember_dto(rNo, memberName, bookNo, bookName, rentDate, returnDate);
				arr4.add(dto4);
			}
			
			
		}catch (SQLException se) {
			System.out.println(" getHistoryMember() query 오류 " + query);
		}catch (Exception e) {
			System.out.println(" getHistoryMember() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr4;
	}
	
	//대여이력_도서명으로
	public ArrayList<HistoryMember_dto> getHistoryBook(String bookName){
		ArrayList<HistoryMember_dto> arr5 = new ArrayList<>();
		String query = "";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String rNo = rs.getString(1);
				String bookNAme = rs.getString(2);
				String memberId = rs.getString(3);
				String memberName = rs.getString(4);
				String rentDate = rs.getString(5);
				String returnDate = rs.getString(6);
				
				HistoryMember_dto dto5 = new HistoryMember_dto(rNo, bookNAme, memberId, memberName, rentDate, returnDate);
				arr5.add(dto5);
			}
			
			
		}catch (SQLException se) {
			System.out.println(" getHistoryMember() query 오류 " + query);
		}catch (Exception e) {
			System.out.println(" getHistoryMember() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		return arr5;
	}
	
}

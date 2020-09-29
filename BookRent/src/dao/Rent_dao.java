package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import common.DBConnectionOracle;
import dto.Rent_dto;

public class Rent_dao {
	private static final String String = null;
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//대여 번호 구하는 매소드
		public String getMaxRentNo() {
			String maxNo = "";
			String query = " select max(no) from b02_rent ";
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					maxNo = rs.getString(1);
				}
				if(maxNo.equals("null")) {
					maxNo = "R0001";
					
				}else {
					String n = maxNo.substring(1);
					int i = Integer.parseInt(n);
					i++;
					DecimalFormat df = new DecimalFormat("0000");
					String newNo = df.format((double)i);
					maxNo = "R"+ newNo;
				}
				
			}catch(SQLException se) {
				System.out.println(" getMaxRentNo() query 오류 " + query);
			}catch(Exception e) {
				System.out.println(" getMaxRentNo() 오류 ");
			}finally {
				common.close(connection, ps,rs);
			}
			
			
			return maxNo;
		}
		
		
		//대여 상태 
		public int setBookRentGubun(String bookNo) {
			int result = 0;
			String query = "update b02_book\r\n" + 
						"set rent_gubun = 'n'\r\n" + 
						"where \r\n" + 
						"no = '"+bookNo+"'";

			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				result = ps.executeUpdate();
				
				
				
			}catch(SQLException se) {
				System.out.println(" setBookRentGubun() query 오류 " + query);
			}catch(Exception e) {
				System.out.println(" setBookRentGubun() 오류 ");
			}finally {
				common.close(connection, ps,rs);
			}
			
			
			
			return result;
		}
		
		
		
		
		//대여
		public int getRentList(String rent_no, String memberId, String bookNo, String rent_date) {
			int result = 0;
			String query ="insert into b02_rent\r\n" + 
						"(no, member_id, book_no, rent_date)\r\n" + 
						"values ('"+rent_no+"','"+memberId+"','"+bookNo+"','"+rent_date+"')"; 
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				result = ps.executeUpdate();
				
				
				
			}catch(SQLException se) {
				System.out.println(" getBookList() query 오류 " + query);
			}catch(Exception e) {
				System.out.println(" getBookList() 오류 ");
			}finally {
				common.close(connection, ps, rs);
			}
			
			
			
			return result;
		}
		
		//대여취소_조회
		public Rent_dto getRentView(String id) {
			Rent_dto dto = null;
			String query = "select no, member_id, book_no, rent_date, return_date\r\n" + 
					"from b02_rent\r\n" + 
					"where member_id = '"+id+"'";
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					
					dto = new Rent_dto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				}
				
			}catch(SQLException se) {
				System.out.println(" getRentView() query 오류 " + query);
			}catch(Exception e) {
				System.out.println(" getRentView() 오류 ");
			}finally {
				common.close(connection, ps, rs);
			}
			
			
			return dto;
		}
		
		//대여 반납
		public int getCheckRentedBook(String book_no) {
			int result = 0;
			String query = "update b02_book\r\n" + 
					" set rent_gubun = 'n'\r\n" + 
					" where no = '"+book_no+"'";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				result = ps.executeUpdate();
				
				
			}catch(SQLException se) {
				System.out.println(" getCheckRentedBook() query 오류 " + query);
			}catch(Exception e) {
				System.out.println(" getCheckRentedBook() 오류 ");
			}finally {
				common.close(connection, ps, rs);
			}
						
			
			return result;
		}
		
		
		
		
		
		//대여자의 ID의 존재 유무 따짐
		public int getCheckMemberId(String member_id) {
			int result = 0;
			String query = "select count(*)\r\n" + 
						" from b02_bookmember\r\n" + 
						" where id = '"+member_id+"'";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt(1);

				}
				
			}catch(SQLException se) {
				System.out.println(" getCheckMemberId() query 오류 " + query);
			}catch(Exception e) {
				System.out.println(" getCheckMemberId() 오류 ");
			}finally {
				common.close(connection, ps, rs);
			}
			
			
			
			return result;
		}
		
		//대여할 도서번호 존재 유무 따짐
				public int getCheckMemberBook(String book_no) {
					int result = 0;
					String query = "select count(*)\r\n" + 
								" from b02_book\r\n" + 
								" where no = '"+book_no+"'\r\n" + 
								" and rent_gubun = 'y'";

					
					try {
						connection = common.getConnection();
						ps = connection.prepareStatement(query);
						rs = ps.executeQuery();
						
						if(rs.next()) {
							result = rs.getInt(1);

						}
						
					}catch(SQLException se) {
						System.out.println(" getCheckMemberBook() query 오류 " + query);
					}catch(Exception e) {
						System.out.println(" getCheckMemberBook() 오류 ");
					}finally {
						common.close(connection, ps, rs);
					}
					
					
					
					return result;
				}
				
	//대여여부		
				public int getCheckRentedBookList(String book_no) {
					int result = 0;
					String query = "select count(*)\r\n" + 
							" from b02_book\r\n" + 
							" where no = '"+book_no+"' and\r\n" + 
							" rent_gubun = 'n'";

					
					try {
						connection = common.getConnection();
						ps = connection.prepareStatement(query);
						rs = ps.executeQuery();
						
						if(rs.next()) {
							result = rs.getInt(1);

						}
						
					}catch(SQLException se) {
						System.out.println(" getCheckRentedBookList() query 오류 " + query);
					}catch(Exception e) {
						System.out.println(" getCheckRentedBookList() 오류 ");
					}finally {
						common.close(connection, ps, rs);
					}
					
					return result;
				}
				
				
	//대여자 ID와 대여 여부 둘다를 합친 경우
/*				public int getCheckValue(String gubun, String val) {
					int result = 0;
					String query = "";
					if(gubun.equals("member")) {
						query = "select count(*)\r\n" + 
								" from b02_book\r\n" + 
								" where id = '"+val+"' and\r\n"; 
								
					}else {
						query = "select count(*)\r\n" + 
								" from b02_book\r\n" + 
								" where no = '"+val+"' and\r\n" + 
								" rent_gubun = 'y'";
					}

					
					try {
						connection = common.getConnection();
						ps = connection.prepareStatement(query);
						rs = ps.executeQuery();
						
						if(rs.next()) {
							result = rs.getInt(1);

						}
						
					}catch(SQLException se) {
						System.out.println(" getCheckRentedBookList() query 오류 " + query);
					}catch(Exception e) {
						System.out.println(" getCheckRentedBookList() 오류 ");
					}finally {
						common.close(connection, ps, rs);
					}
					
					return result;
				}
*/		
}

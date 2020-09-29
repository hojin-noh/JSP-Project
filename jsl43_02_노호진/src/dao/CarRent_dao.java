package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Carinfo_dto;
import dto.carRent_dto;

public class CarRent_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	
	
	//대여시 주문번호 중복 체크
	public int getRentNoOverlapCheck(String rentNumber) {
		int result = 0;
		String query = "select count(*)\r\n" + 
					" from c02_carrent\r\n" + 
					" where rent_no = '"+rentNumber+"'";
		
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException se) {
			System.out.println("getCheckValue() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getCheckValue() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		
		
		return result;
	}
	
	
	//대여시 차량번호로 렌트 가능/불가능을 구분
	public int getRentGubunOverLapCheck(String carNumber) {
		int result = 0;
		String query = "select count(*)\r\n" + 
					" from c02_car\r\n" + 
					" where car_number = '"+carNumber+"' and\r\n" + 
					" rent_gubun = 'y'";
		
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException se) {
			System.out.println("getRentGubunOverLapCheck() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getRentGubunOverLapCheck() 오류");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return result;
	}
	
	
	
	
	
	//반납일자 입력하기
		public int getUpdateReturnDate(String carNumber, String returnDate) {
			int result = 0;
			String query = "update c02_carrent\r\n" + 
						" set return_day = '"+returnDate+"'\r\n" + 
						" where car_no = '"+carNumber+"'";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				result = ps.executeUpdate();
				
				
			}catch(SQLException se) {
				System.out.println(" carRent() query 오류 : " + query);
			}catch(Exception e) {
				System.out.println(" carRent() 오류  ");
			}finally {
				common.close(connection, ps);
			}
			
			
			return result;
		}
	
	
	
	
	//대여시 차번호 체크
	public int getCheckValue(String gubun, String value){
		int result = 0;
		String query = "";
		if(gubun.equals("id")) {
			query = "select count(*) \r\n" + 
					"from b02_bookmember\r\n" + 
					"where "+gubun+" = '"+value+"'";
		}else if(gubun.equals("car_number")) {
			query = "select count(*)\r\n" + 
					"from c02_car\r\n" + 
					"where "+gubun+" = '"+value+"'";
		}
		
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException se) {
			System.out.println("getCheckValue() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getCheckValue() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		
		
		return result;
		
	}
	
	
	//반납이후 렌트번호 삭제
	public int removeRentNumber(String carNumber){
		int result = 0;
		String query = "update c02_carrent \r\n" + 
					" set rent_no = '-'\r\n" + 
					" where car_no ='"+carNumber+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
			
		}catch(SQLException se) {
			System.out.println(" removeRentNumber() query 오류 : " + query);
		}catch(Exception e) {
			System.out.println(" removeRentNumber() 오류  ");
		}finally {
			common.close(connection, ps);
		}
		
		
		
		
		
		return result;
	}
	
	
	
	
	//대여
	public int carRent(String rentNumber, String memberId, String carNumber, String rentDate, String returnScheDate) {
		int result = 0;
		String query = "";
		
		if(rentNumber.length() == 5) {
		
			query =  "insert into c02_carrent\r\n" + 
					" values('"+rentNumber+"','"+memberId+"','"+carNumber+"','"+rentDate+"','','"+returnScheDate+"')";
		}else {}
		
				
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
			
		}catch(SQLException se) {
			System.out.println(" carRent() query 오류 : " + query);
		}catch(Exception e) {
			System.out.println(" carRent() 오류  ");
		}finally {
			common.close(connection, ps);
		}
		
		
		return result;
	}
	
	//렌트구분 변경
	public int rentGubunChange(String carNumber) {
		int result = 0;
		String query = " update c02_car \r\n" + 
					" set rent_gubun = 'n'\r\n" + 
					" where car_number = '"+carNumber+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" rentGubunChange() query 오류 : " + query);
		}catch(Exception e) {
			System.out.println(" rentGubunChange() 오류  ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
		
	}
	
	//렌트시 이전에 입력된 반납날짜 제거
	public int returnDateChangeToDefalut(String carNumber) {
		int result = 0;
		String query = "update c02_carrent\r\n" + 
					" set return_day = ''\r\n" + 
					" where car_no = '"+carNumber+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" returnDateChangeToDefalut() query 오류 : " + query);
		}catch(Exception e) {
			System.out.println(" returnDateChangeToDefalut() 오류  ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
	
	
	
	
	
	//반납할 차량 조회
	public ArrayList<carRent_dto> getViewList(String carNumber){
		ArrayList<carRent_dto> arr6 = new ArrayList();
		String query = "  select rent_no, member_id, car_no, to_char(rent_date,'yyyy-MM-dd'), to_char(return_day,'yyyy-MM-dd'), to_char(return_sche_date,'yyyy-MM-dd')\r\n" + 
						" from c02_carrent\r\n" + 
						" where car_no = '"+carNumber+"'";
		
		try {
			
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String rentNo = rs.getString(1);
				String memberid = rs.getString(2);
				String carNo = rs.getString(3);
				String rentDate = rs.getString(4);
				String returnDate = rs.getString(5);
				String returnScheDate = rs.getString(6);
				
				carRent_dto dto4 = new carRent_dto(rentNo, memberid, carNo, rentDate, returnDate,returnScheDate);
				arr6.add(dto4);
			}
			
			
		}catch(SQLException se) {
			System.out.println(" getViewList() query 오류 : " + query);
		}catch(Exception e) {
			System.out.println(" getViewList() 오류  ");
		}finally {
			common.close(connection, ps, rs);;
		}
		
		
		
		return arr6;
	}
	
	//반납 전 ID와 차량 번호 제대로 입력했는지 확인
	public int getSearch(String gubun, String value) {
		int result = 0;
		String query = "select count(*)\r\n" + 
					" from c02_carrent\r\n" + 
					" where "+gubun+" = '"+value+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt(1);
			}
			
		}catch(SQLException se) {
			System.out.println(" getSearch() query 오류 : " + query);
		}catch(Exception e) {
			System.out.println(" getSearch() 오류  ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		
		return result;
	
	}
	
	
		
	
	
	//반납 후 렌트 구분 n 에서 y로 복귀
	public int getGubunReturn(String memberId) {
		int result = 0;
		String query = " update c02_car\r\n" + 
					" set rent_gubun = 'y'\r\n" + 
					" where car_number = '"+memberId+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" getGubunReturn() query 오류 : " + query);
		}catch(Exception e) {
			System.out.println(" getGubunReturn() 오류  ");
		}finally {
			common.close(connection, ps);
		}
		
		
		return result;
	}
	
	//대여 조회
			public ArrayList<carRent_dto> getViewRentList(String rentNumber){
				ArrayList<carRent_dto> arr5 = new ArrayList<>();
				String query = " select rent_no, member_id, car_no, to_char(rent_date,'yyyy-MM-dd'), return_day ,to_char(return_sche_date,'yyyy-MM-dd')\r\n" + 
							" from c02_carrent\r\n" + 
							" where rent_no = '"+rentNumber+"'" ;
				
				try {
					
					connection = common.getConnection();
					ps = connection.prepareStatement(query);
					rs = ps.executeQuery();
					
					while(rs.next()) {
						String rentNo = rs.getString(1);
						String memberId = rs.getString(2);
						String carNo = rs.getString(3);
						String rentDate = rs.getString(4);
						String returnScheDate = rs.getString(6);
						
						carRent_dto dto5 = new carRent_dto(rentNo, memberId, carNo, rentDate, returnScheDate);
						arr5.add(dto5);
					}
					
					
				}catch(SQLException se) {
					System.out.println(" getViewRentList() query 오류 : " + query);
				}catch(Exception e) {
					System.out.println(" getViewRentList() 오류  ");
				}finally {
					common.close(connection, ps, rs);;
				}
				
				
				return arr5;
			}

			
			//대여이력조회
			public ArrayList<carRent_dto> getViewRentCarList(String carNumber){
				ArrayList<carRent_dto> arr7 = new ArrayList();
				String query = "select b. name, a.car_no, to_char(a.rent_date,'yyyy-MM-dd'), to_char(a.return_sche_date,'yyyy-MM-dd'), nvl(to_char(a.return_day,'yyyy-MM-dd'),'-')\r\n" + 
							" from c02_carrent a, b02_bookmember b\r\n" + 
							" where a.member_id = b.id and\r\n" + 
							" car_no = '"+carNumber+"'";
				try {
					connection =common.getConnection();
					ps = connection.prepareStatement(query);
					rs = ps.executeQuery();
					
					while(rs.next()) {
						String Name = rs.getString(1);
						String carNUmber = rs.getString(2);
						String rentDAte = rs.getString(3);
						String returnSchDate = rs.getString(4);
						String returnDate = rs.getString(5);
						
						
						carRent_dto dto7 = new carRent_dto(Name,carNUmber,rentDAte,returnSchDate,returnDate);
						arr7.add(dto7);
						
					}
					
				}catch(SQLException se) {
					System.out.println(" getViewRentCarList() query 오류 : " + query);
				}catch(Exception e) {
					System.out.println(" getViewRentCarList() 오류  ");
				}finally {
					common.close(connection, ps, rs);
				}
				
				
				
				return arr7;
			}
			
			
			//대여 조회시 차량번호와 ID로 대여자가 맞는지 확인
			public int getListRentedCarHistory(String gubun, String val) {
				int result = 0;
				String query = "";
						
				if(gubun == "car_no") {
					query = " select count(*)\r\n" + 
							" from c02_carrent\r\n" + 
							" where "+gubun+" = '"+val+"'";
				}else if(gubun == "id") {
					query = "select count(*)\r\n" + 
							" from c02_carrent a, b02_bookmember b\r\n" + 
							" where a.member_id = b.id and\r\n" + 
							" id = 'B0003'";
				}
				
						
				
				try {
					connection = common.getConnection();
					ps = connection.prepareStatement(query);
					rs = ps.executeQuery();
					
					while(rs.next()) {
						result = rs.getInt(1);
					}
					
				}catch(SQLException se) {
					System.out.println(" getListRentedCarHistory() query 오류 : " + query);
				}catch(Exception e) {
					System.out.println(" getListRentedCarHistory() 오류  ");
				}finally {
					common.close(connection, ps, rs);
				}
				
				
				return result;
			}
			
			
}

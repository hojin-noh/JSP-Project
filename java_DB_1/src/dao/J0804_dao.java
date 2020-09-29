package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.J0804_dto;

public class J0804_dao {
	DBConnectionOracle common = new DBConnectionOracle();   
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	
// 삭제	
	public int deleteMember(String nn) {
		int result = 0;
		String query = " delete from t02_member\r\n" + 
					" where no = '"+nn+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();		
			
			
		}catch(SQLException se) {
			System.out.println(" deleteMember() query 오류~ : " + query);
		}catch(Exception e) {
			System.out.println(" deleteMember() query 오류~ ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
		
	
	
	
	
// 수정
	public int updateMember(String nn, String name, String area, int age){
		int result = 0;
		String query = " update t02_member\r\n" + 
				" set name = '"+ name +"',\r\n" + 
				" area = '"+area+"',\r\n" + 
				" age = "+age+"\r\n" + 
				" where no = '"+nn+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();		
			
			
		}catch(SQLException se) {
			System.out.println(" updateMember() query 오류~ : " + query);
		}catch(Exception e) {
			System.out.println(" updateMember() query 오류~ ");
		}finally {
			common.close(connection, ps);
		}
		
		
		
		return result;
	}
	
	
	
	
// 수정 조회	
	public J0804_dto getMemberView(String no) {
		J0804_dto dto = null;
		String query = " select a.no, a.name, b.area_name, nvl(a.age,0) as age \r\n" + 
				" from t02_member a, a_area_info b\r\n" + 
				" where a.area = b.area_code\r\n" + 
				" and a.no = '"+ no +"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();											/*조회하는거니까 필요함*/
			while(rs.next()) {
				String nn   = rs.getString(1);
				String name = rs.getString(2);
				String area = rs.getString(3);
				int    age  = rs.getInt(4);
				
				dto = new J0804_dto(nn, name, area, age);
				
			}
			
			
			
		}catch(SQLException se) {
			System.out.println(" getMemberView() query 오류 "+ query);
		}catch(Exception e) {
			System.out.println(" getMemberView() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return dto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<J0804_dto> getMemberList(String gubun, String search) {
		ArrayList<J0804_dto> arr = new ArrayList<J0804_dto>();
		String query =" select a.no, a.name, b.area_name, nvl(a.age,0) as age \r\n" + 
					" from t02_member a, a_area_info b\r\n" + 
					" where a.area = b.area_code\r\n"+
					" and " + gubun + " like '%"+ search +"%'";
		
		
/*		if(gubun.equals("no")) {
			query+= " and a.no like '%"+ search +"%'" ;
		}else if(gubun.equals("name")){
			query+= " and a.name like '%"+ search +"%'" ;
		}else if(gubun.equals("area")) {
			query+= " and b.area_name like '%"+ search +"%'" ;
		}
*/
		
		
		try {
			Connection connection =common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String no   = rs.getString("no");
				String name = rs.getString("name");
				String area = rs.getString("area_name");
				int    age  = rs.getInt("age");
				
				J0804_dto dto = new J0804_dto(no, name, area, age);
				arr.add(dto);
			}
			
		}catch(SQLException se) {
			System.out.println(" getMemberList() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getMemberList() 오류 " );
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	
	
	
	
	public int saveMember(J0804_dto dto) {
		int result = 0;
		String query = " insert into T02_MEMBER \r\n" + 
				" (no, name, area, age) \r\n" + 
				" values('"+ dto.getNo() +"','"+ dto.getName() +"','"+ dto.getArea() +"',"+ dto.getAge() +")";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();					/*조회(select)가 아니고 등록(insert),수정(update), 삭제(delete)하는 거니까 rs=ps.executeSelect가 필요 없고,result = ps.executeUpdate 가 필요 */
			
			
		}catch(SQLException se) {
			System.out.println(" query 오류~ : " + query);
		}catch(Exception e) {
			System.out.println(" query 오류~ ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	public int saveMember(String no, String name, String area, int age) {
		int result = 0;
		String query = " insert into T02_MEMBER \r\n" + 
				" (no, name, area, age) \r\n" + 
				" values('"+ no +"','"+ name +"','"+ area +"',"+ age +")";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();					/*조회(select)가 아니고 등록(insert),수정(update), 삭제(delete)하는 거니까 rs=ps.executeSelect가 필요 없고,result = ps.executeUpdate 가 필요 */
			
			
		}catch(SQLException se) {
			System.out.println(" query 오류~ : " + query);
		}catch(Exception e) {
			System.out.println(" query 오류~ ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
	
	
	
	
}

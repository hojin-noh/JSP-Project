package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.J0729_dto;

public class J0729_dao {
	
	DBConnectionOracle common = new DBConnectionOracle();    //이 안에 connection이 있으니까 이걸 사용해야함
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
/*	
	//전체조회
	public ArrayList<J0729_dto> getListAll() {
		ArrayList<J0729_dto> arr = new ArrayList<>();
		String query = " select id, name, area, age from member ";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String area = rs.getString("area");
				int age = rs.getInt("age");
				//String age = rs.getString(4);    이거는 나중에 형변환 해야함
			J0729_dto dto = new J0729_dto(id, name, area, age);
			arr.add(dto);		//arr.add(new J0729_dto(id, name, area, age));라고 해도 됨 근데 이렇게 하려면 34번째줄 없어야 함
			}
		}catch(SQLException se) {
			System.out.println("getListAll() query 오류~" + query);
		}catch(Exception e) {
			System.out.println("getListAll() 오류~~");
		} finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	//이름 검색 
	public ArrayList<J0729_dto> getListName(String search) {
		ArrayList<J0729_dto> arr = new ArrayList<>();
		String query = " select id, name, area, age from member "+
						" where name like '%" + search + "%' ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String area = rs.getString("area");
				int age = rs.getInt("age");
				//String age = rs.getString(4);    이거는 나중에 형변환 해야함
			J0729_dto dto = new J0729_dto(id, name, area, age);
			arr.add(dto);		//arr.add(new J0729_dto(id, name, area, age));라고 해도 됨 근데 이렇게 하려면 34번째줄 없어야 함
			}
		}catch(SQLException se) {
			System.out.println("getListName() query 오류~" + query);
		}catch(Exception e) {
			System.out.println("getListName() 오류~~");
		} finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	// 지역 검색
	public ArrayList<J0729_dto> getListArea(String search) {
		ArrayList<J0729_dto> arr = new ArrayList<>();
		String query = " select id, name, area, age from member "+
						" where area like '%" + search +"%' ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String area = rs.getString("area");
				int age = rs.getInt("age");
				//String age = rs.getString(4);    이거는 나중에 형변환 해야함
			J0729_dto dto = new J0729_dto(id, name, area, age);
			arr.add(dto);		//arr.add(new J0729_dto(id, name, area, age));라고 해도 됨 근데 이렇게 하려면 34번째줄 없어야 함
			}
		}catch(SQLException se) {
			System.out.println("getListArea() query 오류~" + query);
		}catch(Exception e) {
			System.out.println("getListArea() 오류~~");
		} finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	
	//나이 검색
	public ArrayList<J0729_dto> getListAge(int startAge, int endAge) {
		ArrayList<J0729_dto> arr = new ArrayList<>();
		String query = " select id, name, area, age from member "+
						" where age >= " + startAge + " and age <= "+ endAge;
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String area = rs.getString("area");
				int age = rs.getInt("age");
				//String age = rs.getString(4);    이거는 나중에 형변환 해야함
			J0729_dto dto = new J0729_dto(id, name, area, age);
			arr.add(dto);		//arr.add(new J0729_dto(id, name, area, age));라고 해도 됨 근데 이렇게 하려면 34번째줄 없어야 함
			}
		}catch(SQLException se) {
			System.out.println("getListAge() query 오류~" + query);
		}catch(Exception e) {
			System.out.println("getListAge() 오류~~");
		} finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	
	// MemberList 여러개 조회(전체, 이름, 지역 검색)
		public ArrayList<J0729_dto> getMemberList(String gubun, String search) {
			ArrayList<J0729_dto> arr = new ArrayList<>();
			String query = " select id, name, area, age from member ";
			if(gubun.equals("sName")) {
				query = query + " where name like '%" + search +"%' ";
			}else if(gubun.equals("sArea")) {
				query = query + " where area like '%" + search +"%' ";
			}
							
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					String area = rs.getString("area");
					int age = rs.getInt("age");
					//String age = rs.getString(4);    이거는 나중에 형변환 해야함
				J0729_dto dto = new J0729_dto(id, name, area, age);
				arr.add(dto);		//arr.add(new J0729_dto(id, name, area, age));라고 해도 됨 근데 이렇게 하려면 34번째줄 없어야 함
				}
			}catch(SQLException se) {
				System.out.println("getListArea() query 오류~" + query);
			}catch(Exception e) {
				System.out.println("getListArea() 오류~~");
			} finally {
				common.close(connection, ps, rs);
			}
			
			return arr;
		}
	
*/	
		
		// MemberList 모든 항목 조회(전체, 이름, 지역, 나이 검색)
		public ArrayList<J0729_dto> getMemberList(String gubun, String search, int startAge, int endAge) {
			ArrayList<J0729_dto> arr = new ArrayList<>();
			String query = " select id, name, area, age from member ";
			if(gubun.equals("sName")) {
				query = query + " where name like '%" + search +"%' ";
			} else if(gubun.equals("sArea")) {
				query = query + " where area like '%" + search +"%' ";
			} else if(gubun.equals("sAge")) {
				query = query + " where age >= " + startAge + " and age <= "+ endAge;
			}
							
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					String area = rs.getString("area");
					int age = rs.getInt("age");
					//String age = rs.getString(4);    이거는 나중에 형변환 해야함
				J0729_dto dto = new J0729_dto(id, name, area, age);
				arr.add(dto);		//arr.add(new J0729_dto(id, name, area, age));라고 해도 됨 근데 이렇게 하려면 34번째줄 없어야 함
				}
			}catch(SQLException se) {
				System.out.println("getMemberList() query 오류~" + query);
			}catch(Exception e) {
				System.out.println("getMemberList() 오류~~");
			} finally {
				common.close(connection, ps, rs);
			}
			
			return arr;
		}
	
	
}
	
	
	
	
	
	
	


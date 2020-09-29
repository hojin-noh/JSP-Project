package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.J0803_dto;

public class J0803_dao {
	DBConnectionOracle common = new DBConnectionOracle();    
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public ArrayList<J0803_dto> getListAll(String work, String search) {
		ArrayList<J0803_dto> arr = new ArrayList<>();
		String query = "select a.empno, a.ename, a.job, a.sal ,b.dname from emp a, dept b ";
		if(work.equals("no")) {
			query = query + " where a.deptno = b.deptno and a.empno like '%"+ search + "%'";
		}else if(work.equals("name")) {
			query = query + " where a.deptno = b.deptno and a.ename like '%"+ search + "%'";
		}else if(work.equals("dename")) {
			query = query + " where a.deptno = b.deptno and b.dname like '%"+ search + "%'";
		}

		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String n = rs.getString(1);
				String name = rs.getString(2);
				String  job = rs.getString(3);
				int sal = rs.getInt(4);
				String dename = rs.getString(5);
				
			J0803_dto dto = new J0803_dto(n, name, job, dename, sal);
			arr.add(dto);		
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
	
/*	
	public ArrayList<J0803_dto> getListNo(String no) {
		ArrayList<J0803_dto> arr = new ArrayList<>();
		String query = "select a.empno, a.ename, a.job, a.sal ,b.dname from emp a, dept b "
						+ " where a.deptno = b.deptno and a.empno like '%" + no + "%' ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String n = rs.getString(1);
				String name = rs.getString(2);
				String  job = rs.getString(3);
				int sal = rs.getInt(4);
				String dename = rs.getString(5);
				
			J0803_dto dto = new J0803_dto(n, name, job, dename, sal);
			arr.add(dto);		
			}
			
		}catch(SQLException se) {
			System.out.println("getListNo() query 오류~" + query);
		}catch(Exception e) {
			System.out.println("getListNo() 오류~~");
		} finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	
	public ArrayList<J0803_dto> getListName(String search) {
		ArrayList<J0803_dto> arr = new ArrayList<>();
		String query = "select a.empno, a.ename, a.job, a.sal ,b.dname from emp a, dept b "
						+ " where a.deptno = b.deptno and a.ename like '%" + search + "%'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String n = rs.getString(1);
				String name = rs.getString(2);
				String  job = rs.getString(3);
				int sal = rs.getInt(4);
				String dename = rs.getString(5);
				
			J0803_dto dto = new J0803_dto(n, name, job, dename, sal);
			arr.add(dto);		
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
	
	public ArrayList<J0803_dto> getListDename(String search) {
		ArrayList<J0803_dto> arr = new ArrayList<>();
		String query = "select a.empno, a.ename, a.job, a.sal ,b.dname from emp a, dept b "
				+ " where a.deptno = b.deptno and b.dname like '%"+ search + "%'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String n = rs.getString(1);
				String name = rs.getString(2);
				String  job = rs.getString(3);
				int sal = rs.getInt(4);
				String dename = rs.getString(5);
				
			J0803_dto dto = new J0803_dto(n, name, job, dename, sal);
			arr.add(dto);		
			}
			
		}catch(SQLException se) {
			System.out.println("getListDename() query 오류~" + query);
		}catch(Exception e) {
			System.out.println("getListDename() 오류~~");
		} finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	
*/		
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.J0806_dto;

public class J0806_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int getTotal(int k, int e, int m) {
		int result = 0;
		result = k + e + m;
		
		return result;
	}
	
	
	public int getAva(int total, int count) {
		int ava = 0;
		ava = total / count;
		
		return ava;
	}
	
	// 검색
	public ArrayList<J0806_dto> getScoreList(String gubun, String search) {
		ArrayList<J0806_dto> arr = new ArrayList<>();
		String query = " select * from t02_score\r\n" + 
					" where "+gubun+" like '%"+search+"%'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();							//수정(update), 삭제(delete), 삽입(insert)에서는 resultSet 안씀
			while(rs.next()) {
				String no = rs.getString(1);
				String name = rs.getString(2);
				int kor = rs.getInt(3);
				int eng = rs.getInt(4);
				int mat = rs.getInt(5);
				int total = rs.getInt(6);
				int ava = rs.getInt(7);
				
				J0806_dto dto = new J0806_dto(no,name,kor,eng,mat,total,ava);
//				J0806_dto dto = new J0806_dto(getString(1),getString(2),getInt(3),getInt(4),getInt(5),getInt(6),getInt(7));
				arr.add(dto);
			}
						
		}catch(SQLException se){
			System.out.println(" getScoreList() query 오류 " + query);
		}catch(Exception e){
			System.out.println(" saveScore() 오류 " );
		}finally {
			common.close(connection, ps, rs);
		}
		
		
		return arr;
	}
	
	
	
	
	// 등록
	public int saveScore(String no, String na, int k, int en, int m, int t, int a){
		int result = 0;
		String query = "insert into t02_score\r\n" + 
				"values('"+no+"','"+na+"',"+k+","+en+","+m+","+t+","+a+")";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" saveScore() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" saveScore() 오류 " );
		}finally {
			common.close(connection, ps);
		};
		
		
		return result;
	}
		
	//수정 조회
	public J0806_dto getScoreView(String no) {
		J0806_dto dto = null;
		String query = " select * from t02_score\r\n" + 
					" where no = '"+no+"'";
		
		try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
			
				if(rs.next()) {												//조회하니까 1명 정보만 나와서 if로 해도 됨. 그리고 rs.next()는 값이  boolearn이라서 괜찮음
					String n = rs.getString(1);
					String name = rs.getString(2);
					int kor = rs.getInt(3);
					int eng = rs.getInt(4);
					int mat = rs.getInt(5);
					int total = rs.getInt(6);
					int ava = rs.getInt(7);
					
					dto = new J0806_dto(n, name, kor, eng, mat, total, ava);
				}
			
		}catch(SQLException se) {
			System.out.println(" getScoreView() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getScoreView() 오류 " );
		}finally {
			common.close(connection, ps, rs);
		}
		
		return dto;
	}
	
	//수정
	public int updateScore(String no, String name, int k, int en, int m, int t, int a) {
		int result = 0; 
		String query = " update t02_score \r\n" + 
					" set name = '"+name+"',\r\n" + 
					" kor = "+k+",\r\n" + 
					" eng = "+en+",\r\n" + 
					" mat = "+m+",\r\n" + 
					" total = "+t+",\r\n" + 
					" ava = "+a+"\r\n" + 
					" where no = '"+no+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" updateScore() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" updateScore() 오류 " );
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
	//삭제
	public int deleteScore(String no) {
		int result = 0;
		String query = " delete from t02_score\r\n" + 
					" where no = '"+no+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
		}catch(SQLException se) {
			System.out.println(" deleteScore() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" deleteScore() 오류 " );
		}finally {
			common.close(connection, ps);
		}
		
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

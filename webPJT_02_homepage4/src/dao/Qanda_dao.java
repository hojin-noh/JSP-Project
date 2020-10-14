package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.News_dto;

public class Qanda_dao {
	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// 목록 조회
		public ArrayList<Qanda_dto> getQandaList(){
			ArrayList<News_dto> arr = new ArrayList<News_dto>();
			String query = " select q.no, q.title, q.answer, m.name, q.q_reg_date, q.hit\r\n" + 
							" from h02_qna q, h02_member m\r\n" + 
							" where q.q_reg_id = m.id";
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				
				while(rs.next()) {
					String no = rs.getString(1);
					String title = rs.getString(2);
					String reg_name = rs.getString(3);
					String reg_date = rs.getString(4);
					int hit = rs.getInt(5);
					
					News_dto dto = new News_dto(no, title, "", reg_name, reg_date, hit);
					arr.add(dto);
					
				}
				
				
			}catch(SQLException se) {
				System.out.println("getNewsView() query 오류" + query);
			}catch(Exception e) {
				System.out.println("getNewsView() 오류");
			}finally {
				
			}
			
			
			return arr;
		}
		
}

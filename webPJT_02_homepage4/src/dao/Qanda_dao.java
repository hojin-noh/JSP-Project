package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.News_dto;
import dto.Qanda_dto;

public class Qanda_dao {
	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// 목록 조회
		public ArrayList<Qanda_dto> getQandaList(String select, String search){
			ArrayList<Qanda_dto> arr = new ArrayList<Qanda_dto>();
			String query = " select q.no, q.title, q.answer, m.name, to_char(q.q_reg_date,'yyyy-MM-dd'), q.hit\r\n" + 
							" from h02_qna q, h02_member m \r\n" + 
							" where q.q_reg_id = m.id" + 
							" and q."+select+" like '%"+search+"%'";
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				
				while(rs.next()) {
					String no = rs.getString(1);
					String title = rs.getString(2);
					String answer = rs.getString(3);
					String name = rs.getString(4);
					String reg_date = rs.getString(5);
					int hit = rs.getInt(6);
					
					Qanda_dto dto = new Qanda_dto(no, title, answer, name, reg_date, hit);
					arr.add(dto);
					
				}
				
				
			}catch(SQLException se) {
				System.out.println("getQandaList() query 오류" + query);
			}catch(Exception e) {
				System.out.println("getQandaList() 오류");
			}finally {
				
			}
					
			return arr;
		}
		
}

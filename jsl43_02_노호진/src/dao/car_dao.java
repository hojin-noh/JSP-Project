package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Carinfo_dto;
import dto.carRent_dto;

public class car_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	
	//등록
	public int saveCar(String no, String modelName, String carNumber, String carMade, String carMadeYm, 
			String autoYn, String optionYn, String accidentYn, String fuelType, String importDate) {
		int result = 0;
		String query = "insert into c02_car\r\n" + 
				"(no,model_name,car_number,car_made,car_made_ym,auto_yn,option_yn,accident_yn,fuel_type,import_date)\r\n" + 
				"values\r\n" + 
				"('"+no+"','"+modelName+"','"+carNumber+"','"+carMade+"','"+carMadeYm+"','"+autoYn+"','"+optionYn+"','"+accidentYn+"','"+fuelType+"','"+importDate+"')";
		
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
			
			
		}catch(SQLException se) {
			System.out.println(" saveCar() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" saveCar() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
	
	// 등록시 중복 확인(차량등록 번호, 차 번호)
	public int getOverLapChk(String gubun, String value) {
		int result = 0;
		String query = "select count(*)\r\n" + 
					" from c02_car\r\n" + 
					" where "+gubun+" = '"+value+"'";
		
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(SQLException se) {
			System.out.println("getOverLapChk() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getOverLapChk() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		
		return result;
	}
	
	
	
	//조회
	public ArrayList<Carinfo_dto> getListCar (String gubun, String work){
		ArrayList<Carinfo_dto> arr = new ArrayList<>();
		String query = " select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, a.auto_yn, a.option_yn, a.accident_yn, b.fuel_name,\r\n" + 
				"to_char(a.import_date,'yyyy-MM-dd'), a.rent_gubun\r\n" + 
				"from c02_car a, car_common_fuel b, car_common_made c\r\n" + 
				"where a.car_made = c.made_code and\r\n" + 
				"a.fuel_type = b.fuel_type and\r\n" + 
				""+gubun+" like '%"+work+"%'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString(1);
				String modelName = rs.getString(2);
				String carNumber = rs.getString(3);
				String carMade = rs.getString(4);
				String carMadeYm = rs.getString(5);
				String autoYn = rs.getString(6);
				String optionYn = rs.getString(7);
				String accidentYn = rs.getString(8);
				String fuelType = rs.getString(9);
				String importDate = rs.getString(10);
				String rentGubun = rs.getString(11);
				
				Carinfo_dto dto = new Carinfo_dto(no,modelName,carNumber,carMade,carMadeYm,autoYn,optionYn,accidentYn,
						fuelType,importDate,rentGubun);
				arr.add(dto);
			}
		
			
			
		}catch(SQLException se) {
			System.out.println(" getListCar() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getListCar() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	
	//전체조회
	public ArrayList<Carinfo_dto> getListAllCar() {
		ArrayList<Carinfo_dto> arr = new ArrayList<>();
		String query = " select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, a.auto_yn, a.option_yn, a.accident_yn, b.fuel_name,\r\n" + 
				"to_char(a.import_date,'yyyy-MM-dd'), a.rent_gubun\r\n" + 
				"from c02_car a, car_common_fuel b, car_common_made c\r\n" + 
				"where a.car_made = c.made_code and\r\n" + 
				"a.fuel_type = b.fuel_type\r\n";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString(1);
				String modelName = rs.getString(2);
				String carNumber = rs.getString(3);
				String carMade = rs.getString(4);
				String carMadeYm = rs.getString(5);
				String autoYn = rs.getString(6);
				String optionYn = rs.getString(7);
				String accidentYn = rs.getString(8);
				String fuelType = rs.getString(9);
				String importDate = rs.getString(10);
				String rentGubun = rs.getString(11);
				
				Carinfo_dto dto = new Carinfo_dto(no,modelName,carNumber,carMade,carMadeYm,autoYn,optionYn,accidentYn,
						fuelType,importDate,rentGubun);
				arr.add(dto);
			}
		}catch(SQLException se) {
			System.out.println(" getListCar() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getListCar() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
		}
	
	
	//수정 조회
	public ArrayList<Carinfo_dto> getUpdateList(String work) {
		ArrayList<Carinfo_dto> arr1 = new ArrayList<>();
		String query = "select no, model_name,car_number, b.made_name, car_made_ym, auto_yn,\r\n" + 
					" option_yn, accident_yn, c.fuel_name, to_char(import_date,'yyyy-MM-dd'), rent_gubun\r\n" + 
					" from c02_car a, car_common_made b, car_common_fuel c\r\n" + 
					" where a.car_made = b.made_code and\r\n" + 
					" a.fuel_type = c.fuel_type and\r\n" + 
					" no = '"+work+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString(1);
				String modelName = rs.getString(2);
				String carNumber = rs.getString(3);
				String carMade = rs.getString(4);
				String carMadeYm = rs.getString(5);
				String autoYn = rs.getString(6);
				String optionYn = rs.getString(7);
				String accidentYn = rs.getString(8);
				String fuelType = rs.getString(9);
				String importDate = rs.getString(10);
				String rentGubun = rs.getString(11);
				
				Carinfo_dto dto = new Carinfo_dto(no,modelName,carNumber,carMade,carMadeYm,autoYn,optionYn,accidentYn,
						fuelType,importDate,rentGubun);
				arr1.add(dto);
			}
			
			
			
			
		}catch(SQLException se) {
			System.out.println(" getUpdateList() query 오류 : " + query);
		}catch(Exception e) {
			System.out.println(" getUpdateList() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr1;
	}
	
	//수정
	public int getUpdate(String no, String modelName, String carNumber, String carMade, String carMadeYm, 
			String autoYn, String optionYn, String accidentYn, String fuelType, String importDate, String gubun) {
		int result = 0;		
		String query = " update c02_car\r\n" + 
					" set \r\n" + 
					" model_name = '"+modelName+"',\r\n" + 
					" car_number = '"+carNumber+"',\r\n" + 
					" car_made = '"+carMade+"',\r\n" + 
					" car_made_ym = '"+carMadeYm+"',\r\n" + 
					" auto_yn = '"+autoYn+"',\r\n" + 
					" option_yn = '"+optionYn+"',\r\n" + 
					" accident_yn = '"+accidentYn+"',\r\n" + 
					" fuel_type = '"+fuelType+"',\r\n" + 
					" import_date = '"+importDate+"',\r\n" + 
					" rent_gubun = '"+gubun+"'\r\n" + 
					" where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
			
			
		}catch(SQLException se) {
			System.out.println(" getUpdate() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getUpdate() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		
		return result;
		
	}
	
	//삭제조회
	public ArrayList<Carinfo_dto> getDeleteList(String work){
		ArrayList<Carinfo_dto> arr2 = new ArrayList<>();
		String query = "select no, model_name,car_number, b.made_name, car_made_ym, auto_yn,\r\n" + 
					" option_yn, accident_yn, c.fuel_name, to_char(import_date,'yyyy-MM-dd'), rent_gubun \r\n" + 
					" from c02_car a, car_common_made b, car_common_fuel c\r\n" + 
					" where a.car_made = b.made_code and\r\n" + 
					" a.fuel_type = c.fuel_type and\r\n" + 
					" no = '"+work+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString(1);
				String modelName = rs.getString(2);
				String carNumber = rs.getString(3);
				String carMade = rs.getString(4);
				String carMadeYm = rs.getString(5);
				String autoYn = rs.getString(6);
				String optionYn = rs.getString(7);
				String accidentYn = rs.getString(8);
				String fuelType = rs.getString(9);
				String importDate = rs.getString(10);
				String rentGubun = rs.getString(11);
				
				Carinfo_dto dto2 = new Carinfo_dto(no,modelName,carNumber,carMade,carMadeYm,autoYn,optionYn,accidentYn,
						fuelType,importDate,rentGubun);
				arr2.add(dto2);
			}
						
		}catch(SQLException se) {
			System.out.println(" getDeleteList() query 오류 : " + query);
		}catch(Exception e) {
			System.out.println(" getDeleteList() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		
		return arr2;
	}
	
	//삭제 
	public int getDelete(String work) {
		int result = 0;
		String query = "delete from c02_car\r\n" + 
					" where no = '"+work+"'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
			
			
		}catch(SQLException se) {
			System.out.println(" getDelete() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getDelete() 오류 ");
		}finally {
			common.close(connection, ps);
		}
		
		
		return result;
	}
	
	
	
	

	
	
	
	
		
		
		
	
	
	
	
	
}

package dao;

import java.text.DecimalFormat;

public class J0717_1_dao {
	public String getDepartName (int code) {
		String name = "";
		if(code == 1) name = "총무";
		else if(code == 2) name = "영업";
		else if(code == 3) name = "인사";
		else if(code == 4) name = "관리";
		
		return name;
	}
	
	public String getPositionName (int code) {
		String name = "";
		if(code == 1) name = "사원";
		else if(code == 2) name = "대리";
		else if(code == 3) name = "과장";
		else if(code == 4) name = "부장";
		
		return name;
	}
	
	public int getMoney(int position) {
		int money = 0;
		if(position == 1) money = 1200000; 
		else if(position == 2) money = 1400000; 
		else if(position == 3) money = 1600000; 
		else if(position == 4) money = 1800000;
				
		return money;
	}
	public String getMoneyDis(int money2) {
		DecimalFormat df = new DecimalFormat(",###");
	
		String moneyResult = df.format((double)money2);
		
		return moneyResult;
	}	
	
	public int getPositionMoney(int money) {
		double result = money * 0.1;
		
		return (int)result;
		
	}
	
}

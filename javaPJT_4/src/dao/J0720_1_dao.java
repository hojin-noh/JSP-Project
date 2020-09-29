package dao;

import java.text.DecimalFormat;

public class J0720_1_dao {

	public String getDepartName(int code) {
		String name = "";
		if(code == 1) name = "총무";
		else if (code == 2) name = "영업";
		else if (code == 3) name = "인사";
		else if(code == 4) name = "관리";
		
		return name;
	}
	
	public String getPositionName(int code2) {
		String name = "";
		if(code2 == 1) name = "사원";
		else if(code2 == 2) name = "대리";
		else if(code2 == 3) name = "과장";
		else if(code2 == 4) name = "부장";
		
		return name;
	}
	
	public int getSalaryMon(int position) {
		int salary = 0;
		if(position == 1) salary = 1100000;
		else if(position == 2) salary = 1200000;
		else if(position == 3) salary = 1300000;
		else if(position == 4) salary = 1400000;
		
		return salary;
	}
	
	
	public String getSalaryMonDis(int salary) {
		DecimalFormat df = new DecimalFormat(",###");
		
		String result = df.format((double)salary);
		
		return result;
	}
	
	public int getPostionMoney(int salary) {
		 double result = salary * 0.1;
		 
		 return (int)result;
	}
	
	public int getBonus(int salary) {
		double result = (salary*12)*0.5;
		
		return (int)result;
		
	}
	
	
	public int getSalaryYear(int salary, int positionMoney, int bonus) {
		int result = (salary+positionMoney)*12 + bonus;
		
		return result;
	}
	
	/*  월급 구하는 방법 2(월급만 넣고)
	 	public int getSalaryYear(int salary) {
		int po = getPostionMoney(salary);							직책수당
		int bo = getBonus(int salary);								보너스
		int result = (salary + po)*12 + bo;
		
		return result;
	}
	*/
	
	
	public String getMemberNo(String no) {
	no = no.substring(1);   
	int noNum = Integer.parseInt(no);  
	noNum++;
	no = Integer.toString(noNum); 		
	int noLength = no.length(); 
	
	if(noLength == 1) no = "00"+no; 
	else if(noLength == 2) no = "0"+no;
	
	return "S"+no;
	}
	
	
}

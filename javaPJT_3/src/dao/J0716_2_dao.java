package dao;

public class J0716_2_dao {
	public String getDepartName (int code) {
		String name = "";
		if(code == 1) name = "총무";
		else if (code == 2) name = "영업";
		else if (code == 3) name = "인사";
		else if (code == 4) name = "관리";
		
		return name;
	}
	
	public String getPositionName (String code) {
		String name = "";
		if(code.equals("1")) name="사원";
		else if(code.equals("2")) name="대리";
		else if(code.equals("3")) name="과장";
		else if(code.equals("4")) name="부장";
		else name="직급없음";
		
		return name;
	}
	
}	


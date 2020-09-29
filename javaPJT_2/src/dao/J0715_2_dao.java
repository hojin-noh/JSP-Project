package dao;

import java.text.DecimalFormat;

public class J0715_2_dao {
	public int getTotal(int k, int e, int m){
		return k + e + m;
	}
	
	public double getAva(int total, int count){
		DecimalFormat df = new DecimalFormat("0.0");
		
		double ava = total / (double)count; 
		String result = df.format(ava);
		
		double re = Double.parseDouble(result);
		
		return re;
	}
	
	public String getResult(double ava){
		String result = "";
		if(ava >= 90 )result = "수";
		else if(ava >= 80 )result = "우";
		else if(ava >= 70 )result = "미";
		else if(ava >= 60 )result = "양";
		else result = "가";
		
		return result;
	}
}

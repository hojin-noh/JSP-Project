package dao;

import java.text.DecimalFormat;

public class dao {
	
	
	
	public String getNo(String no) {
	DecimalFormat df = new DecimalFormat("0000");
	String noS = no.substring(1);
	int noN = Integer.parseInt(noS);
	noN++;
	noS=df.format(noN);
	
	return "S" + noS;
	}
}

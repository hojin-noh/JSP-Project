package dao;

import java.text.DecimalFormat;

public class J0721_1_dao {
	public String getNo(String no) {
		DecimalFormat df = new DecimalFormat("000");
		String sNo = no.substring(1);
		int n = Integer.parseInt(sNo);
		n++;
		sNo = df.format(n);
		return "N" + sNo;
	}
}

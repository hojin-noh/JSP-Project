package dao;

public class J0715_1_dao {
	public int getTotal(int k, int e, int m){						//다른  package 에서도 사용할 수 있도록 public 을 붙여줘야 함
		int total = k + e + m;
		return total;
	}
	
	
	public int getAva(int total, int count){
		int ava = total / count;
		return ava;
	}
}


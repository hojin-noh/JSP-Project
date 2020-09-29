package main;
													
public class J0724_child_two extends J0724_parent{
	@Override
	public int getTotal(int kor, int eng) {
		return kor + eng;
		}
	
	@Override
	public int getAva(int t, int c) {
		return t / t;
		}
	
	public String getName() {
		return "홍길동";
	}
	
	public int getEng(int eng) {
		return eng;
	}
	
	public String getResult() {
		return "우";
	}

	@Override
	public int getEng() {
		// TODO Auto-generated method stub
		return 0;
	}
}

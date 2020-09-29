package main;

public class J0724_child extends J0724_parent {
	
	@Override
	public int getTotal(int kor, int eng) {
		return kor + eng;
		}
	
	@Override
	public int getAva(int t, int c) {
		return t / t;
		}
	
	public String getResult() {
		return "수";
	}
	
	@Override
	public int getEng() {
		return 90;
	}
}

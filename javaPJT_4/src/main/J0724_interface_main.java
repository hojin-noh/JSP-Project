package main;
																			//interface를 상속하려면 extends 말고 implements로 해야함(interface 1개이상 상속 가능), 추상클래스도 상속 동시에 가능(1개만 상속 가능)				
public class J0724_interface_main extends J0724_parent 
		implements J0724_interface_1, J0724_interface_2{
	
	public String getName() {													//일반 메소드도 가능함
		return "홍";
	}
	
	@Override
	public int getTotal(int k, int e) {
		return k + e;
	}							
	
	@Override
	public int getAva(int t, int c) {
		return t / c;
	}
	

	
	@Override
	public int getEng() {
		return 90;
	}
	/* object(객체)의 3요소------> ex) J0723_child child = new J0723_child(); 에서 child가 object(객체)임
	 	1. 캡슐화 - 객체 안에 메소드들을 담고 있어서
	 	2. 상속 - 상속해서 부모 클래스의 메소드를 자식 클래스에서 사용할 수 있음
	 	3. 다형성 - 객체만 바꿔서 다양하게 사용할 수 있어서*/

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}
}

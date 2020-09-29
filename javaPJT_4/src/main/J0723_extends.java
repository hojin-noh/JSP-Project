package main;

public class J0723_extends {
	public static void main(String[] args) {
		J0723_child child = new J0723_child();				//부모 클래스가 있으면 부모클래스의 생성자 먼저 생성 해주고 자식 클래스의 생성자 생성해줌
		
		child.childPrint();
		child.parentsPrint();				//부모 클래스 <<< 자식 클래스
		
	}

}

package main;

public class J0724_abstract {
	public static void main(String[] args) {
		J0724_parent child = new J0724_child();							//상속 관계에서는 자식 클래스의 타입이 부모로 될 수 있음--> 이렇게 타입을 부모로 설정하면 부모가 갖고 있는 메소드만 사용 가능
		int a = child.getTotal(50, 60);
	/*	String c = child.getResult(50);									//부모 클래스에는 없기 때문에 사용 못함
		*/
		J0724_parent child2 = new J0724_child_two();
		int b = child2.getAva(100, 2);
		
		
		
	}

}

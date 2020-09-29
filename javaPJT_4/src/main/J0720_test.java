package main;

public class J0720_test {
	public static void main(String[] args) {
		String name = "JSL인재개발원";
		String n1 = name.substring(3);
		
		System.out.println(" n1 : " + n1);						/*3번째부터 주욱*/
		
		String n2 = name.substring(3, 5);
		System.out.println(" n2 : " + n2);						/*3번째부터 5번째전까지*/
		

		String no = "S001";
		no = no.substring(1);    // no = "001" 이 들어감
		int noNum = Integer.parseInt(no);  //noNum = 1
		noNum++;
		no = Integer.toString(noNum); 		// no = "1"
		int noLength = no.length();  //noLength = 1
		
		if(noLength == 1) no = "00"+no;   // no = "001"
		else if(noLength == 2) no = "0"+no;
				
		System.out.println("no :" + no);
		
	}

}

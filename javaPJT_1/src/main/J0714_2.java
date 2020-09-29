package main;

import java.util.ArrayList;
import dto.J0714_2_dto;

public class J0714_2 {

	public static void main(String[] args) {
		ArrayList<J0714_2_dto> arr = new ArrayList<>();
		J0714_2_dto dto1 = new J0714_2_dto("홍길동", "대전", 30);
		J0714_2_dto dto2 = new J0714_2_dto("박길수", "서울", 50);
//		arr.add(new J0714_2_dto("홍길동", "대전", 30));
//		arr.add(new J0714_2_dto("박길수", "서울", 50));
		
		arr.add(dto1);
		arr.add(dto2);
		arr.add(new J0714_2_dto("안상수", "부산",40));
		
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getArea()+"\t");
			System.out.print(arr.get(k).getAge()+"\n");
	}
/*		System.out.println(arr.get(0).getName());							//arr.get(1)은 dto2의 주소를 구하는 것 그래서 그 주소에 있는 값들을 불러 올 수 있음
		System.out.println(arr.get(1).getName());	
		System.out.println(arr.get(2).getName());	
		*/
	}
}

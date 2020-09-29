package main;

import java.util.ArrayList;
import java.util.Scanner;

import dto.J0714_2_dto;

public class J0717_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<J0714_2_dto> arr = new ArrayList<>();
		
		System.out.println(" 몇 명 ? ");
		int count = sc.nextInt();
		
		for(int k = 0; k < count; k++) {
			System.out.println(" 이름은 ? ");
			String name = sc.next();
			
			System.out.println(" 지역은 ? ");
			String area = sc.next();
			
			System.out.println(" 나이는 ? ");
			int age = sc.nextInt();
			
			
//			J0714_2_dto dtos = new J0714_2_dto(name, area, age);
//			arr.add(dtos);
			arr.add(new J0714_2_dto(name, area, age));
		}
//		sc.close();
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getArea()+"\t");
			System.out.print(arr.get(k).getAge()+"\n");
		}
	
		
		
		sc.close();
		
	}

}

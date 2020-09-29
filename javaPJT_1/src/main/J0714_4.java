package main;

import java.util.ArrayList;
import java.util.Scanner;

import dto.J0714_3_dto;

public class J0714_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<J0714_3_dto> arr = new ArrayList<>();
		
		System.out.println(" 몇 명 ?");
		int count = sc.nextInt();
		
		for(int k = 0; k < count; k++) {
			
			System.out.println(" 이름은 ? ");
			String name = sc.next();
			
			System.out.println(" 국어 점수는 ? ");
			int kor = sc.nextInt();
			
			System.out.println(" 영어 점수는 ? ");
			int eng = sc.nextInt();
			
			System.out.println(" 수학 점수는 ? ");
			int mat = sc.nextInt();
			
//			J0714_3_dto dtos = new J0714_3_dto(name, kor, eng, mat);
//			arr.add(dtos);
			
			arr.add(new J0714_3_dto(name, kor, eng, mat));
						
		}
		
		for(int k = 0;  k < count; k++) {
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getKor()+"\t");
			System.out.print(arr.get(k).getEng()+"\t");
			System.out.print(arr.get(k).getMat()+"\n");
		}
		
		sc.close();
	}

}

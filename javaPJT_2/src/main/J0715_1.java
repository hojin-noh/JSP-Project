package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0715_1_dao;
import dto.J0715_dto;

public class J0715_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0715_dto> arr = new ArrayList<>();
		J0715_1_dao dao = new J0715_1_dao();
		
		
		System.out.println(" 몇 명 ? ");
		int count = sc.nextInt();
		
		
		
		
		for(int k = 0; k < count; k++) {
			System.out.println(" 이름은 ? ");
			String name = sc.next();
			
			System.out.println(" 국어점수는 ? ");
			int kor = sc.nextInt();
			
			System.out.println(" 영어점수는 ? ");
			int eng = sc.nextInt();
			
			System.out.println(" 수학점수는 ? ");
			int mat = sc.nextInt();
			
			int total = dao.getTotal(kor, eng, mat);
			int ava = dao.getAva(total, 3);
					
			
			arr.add(new J0715_dto(name, kor, eng, mat, total, ava));
			
			
		}
		
		
		for(int k = 0; k < arr.size(); k++){
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getKor()+"\t");
			System.out.print(arr.get(k).getEng()+"\t");
			System.out.print(arr.get(k).getMat()+"\t");
			System.out.print(arr.get(k).getTotal()+"\t");
			System.out.print(arr.get(k).getAva()+"\n");
		}
		
		sc.close();
		
		
		
		
		
	}

}

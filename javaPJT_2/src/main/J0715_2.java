package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0715_2_dao;
import dto.J0715_2_dto;

public class J0715_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0715_2_dto> arr = new ArrayList();
		J0715_2_dao dao = new J0715_2_dao();
		
		
		System.out.println(" 몇 명 ? ");
		int count = sc.nextInt();
		
		for(int k = 0; k < count; k++){
			System.out.println(" 이름은 ? ");
			String name = sc.next();
			
			System.out.println(" 국어 점수는 ? ");
			int kor = sc.nextInt();
			
			System.out.println(" 영어 점수는 ? ");
			int eng = sc.nextInt();
			
			System.out.println(" 수학 점수는 ? ");
			int mat = sc.nextInt();
			
			int total = dao.getTotal(kor, eng, mat);
			double ava = dao.getAva(total, 3);
			String result = dao.getResult(ava);
			
			arr.add(new J0715_2_dto(name, result, kor, eng, mat, total, ava));
			
		}
		
		for(int k = 0; k < count; k++){
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getResult()+"\t");
			System.out.print(arr.get(k).getKor()+"\t");
			System.out.print(arr.get(k).getEng()+"\t");
			System.out.print(arr.get(k).getMat()+"\t");
			System.out.print(arr.get(k).getTotal()+"\t");
			System.out.print(arr.get(k).getAva()+"\n");
			
		}
		
		sc.close();
		
		
	}

}

package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0716_1_dao;
import dto.J0716_1_dto;

public class J0716_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0716_1_dto> arr = new ArrayList();
		J0716_1_dao dao = new J0716_1_dao();
		
		System.out.println(" 몇 명 ? ");
		int count = sc.nextInt();
		
		String name, ava, result;
		int kor, eng, total;
		
		for(int k = 0; k < count; k++) {
			System.out.println(" 이름은 ? ");
			name = sc.next();
						
			System.out.println(" 국어 점수는 ? ");
			kor = sc.nextInt();
			
			System.out.println(" 영어 점수는 ? ");
			eng = sc.nextInt();
			
			total = dao.getTotal(kor, eng);
			ava = dao.getAva(total, 2);
			result = dao.getResult(Double.parseDouble(ava));
			
			
			J0716_1_dto dto = new J0716_1_dto(name, ava, result, kor, eng, total);
			arr.add(dto);
		}
		
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getKor()+"\t");
			System.out.print(arr.get(k).getEng()+"\t");
			System.out.print(arr.get(k).getTotal()+"\t");
			System.out.print(arr.get(k).getAva()+"\t");
			System.out.print(arr.get(k).getResult()+"\n");
		}
		sc.close();
		
	}

}


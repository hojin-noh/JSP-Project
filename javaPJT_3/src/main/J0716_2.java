package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0716_2_dao;
import dto.J0716_2_dto;

public class J0716_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0716_2_dao dao = new J0716_2_dao();
		ArrayList<J0716_2_dto> arr = new ArrayList();
		
		System.out.println(" 사번은 ? ");
		String no = sc.next();
		
		System.out.println(" 성명은 ? ");
		String name = sc.next();
		
		System.out.println(" 부서 코드를 입력하시오. 총무: 1, 영업: 2, 인사: 3, 관리: 4 ");
		int depart = sc.nextInt();
		
		System.out.println(" 직급 코드를 입력하시오. 사원: 1, 대리: 2, 과장: 3, 부장: 4, 직급없음: 5 ");
		String position = sc.next();
		
		String departName = dao.getDepartName(depart);
		String positionName = dao.getPositionName(position);
		
		J0716_2_dto dto = new J0716_2_dto(no, name, departName, positionName);
		arr.add(dto);
	
	
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getNo()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getDepart()+"\t");
			System.out.print(arr.get(k).getPosition()+"\n");
		}
	sc.close();
	}	

}

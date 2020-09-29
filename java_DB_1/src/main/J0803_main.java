package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0803_dao;
import dto.J0803_dto;

public class J0803_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0803_dao dao = new J0803_dao();
		ArrayList<J0803_dto> arr = new ArrayList<>();
		int gubun = 0;
		
		do {
			System.out.println(" 검색 사번: 1, 성명: 2, 부서명: 3, 종료: 0  선택 ? ");
			gubun = sc.nextInt();
			if(gubun == 1) {
				System.out.println(" 사번은 ? ");
				String no = sc.next();
				arr = dao.getListAll("no",no);					//no 앞은 no의 구분값임 아래도 값은 의미로 무언가 들어있음
//				arr = dao.getListNo(no);
				
			} else if(gubun == 2) {
				System.out.println(" 성명은 ? ");
				String name = sc.next();
				name = name.toUpperCase();
				arr = dao.getListAll("name", name);
//				arr = dao.getListName(name);
			} else if(gubun == 3) {
				System.out.println(" 부서는 ? ");
				String dename = sc.next();	
				dename = dename.toUpperCase();
				arr = dao.getListAll("dename", dename);
//				arr = dao.getListDename(dename);
			}
			if(gubun != 0) {
			System.out.println(" ========================================= ");
			System.out.println("사번\t 성명\t 업무\t\t 급여\t 부서명 ");
			System.out.println(" ----------------------------------------- ");
			for(int k = 0; k < arr.size(); k++) {
				System.out.print(arr.get(k).getEmpno()+"\t");
				System.out.print(arr.get(k).getEname()+"\t");
				System.out.print(arr.get(k).getJob()+"\t\t");
				System.out.print(arr.get(k).getSal()+"\t");
				System.out.print(arr.get(k).getDname()+"\n");
			}
			}
		}while(gubun != 0);
		
		sc.close();
		
		System.out.println("=========== 검색 종료 =========");
	}

}

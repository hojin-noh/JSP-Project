package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0729_dao;
import dto.J0729_dto;
																//조회하는 방법만 한 경우(종료는 실행 안 됨; 종료까지 하려면 do while문을 써야 함)
public class J0729_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0729_dao dao = new J0729_dao();
		ArrayList<J0729_dto> arr = null;
		
		System.out.println(" 검색 전체조회: 1, 이름: 2, 지역: 3, 나이: 4, 종료: 0 ");
		int gubun = sc.nextInt();
						
		if(gubun == 1) {
			
			//ArrayList<J0729_dto> arr = dao.getListAll();
			
			
			arr = dao.getMemberList("all","",0,0);
///				arr = dao.getListAll();
			/*for(int k = 0; k < arr.size(); k++) {
				System.out.print(arr.get(k).getId()+"\t");
				System.out.print(arr.get(k).getName()+"\t");
				System.out.print(arr.get(k).getArea()+"\t");
				System.out.print(arr.get(k).getAge()+"\n");
			}
				*/	
		}else if(gubun == 2) {
			System.out.println(" 검색 이름은 ? ");
			String name = sc.next();
			
			//ArrayList<J0729_dto> arr = dao.getListName(name);
			
			arr = dao.getMemberList("sName", name,0,0);
///				arr = dao.getListName(name);
			/*for(int k = 0; k < arr.size(); k++) {
				System.out.print(arr.get(k).getId()+"\t");
				System.out.print(arr.get(k).getName()+"\t");
				System.out.print(arr.get(k).getArea()+"\t");
				System.out.print(arr.get(k).getAge()+"\n");
			}*/
			
		}else if(gubun == 3) {
			System.out.println(" 검색 지역은 ? ");
			String area = sc.next();
			
			arr = dao.getMemberList("sArea", area,0,0);
///			arr = dao.getListArea(area);
			
		}else if(gubun == 4) {
			System.out.println(" 몇살 부터 ? ");
			int startAge = sc.nextInt();
			System.out.println(" 몇살 까지 ? ");
			int endAge = sc.nextInt();
			
			arr = dao.getMemberList("sAge","",startAge, endAge);
///			arr = dao.getListAge(startAge, endAge);
			
		}
			for(int k = 0; k < arr.size(); k++) {
				System.out.print(arr.get(k).getId()+"\t");
				System.out.print(arr.get(k).getName()+"\t");
				System.out.print(arr.get(k).getArea()+"\t");
				System.out.print(arr.get(k).getAge()+"\n");
			}
		sc.close();
	}

}

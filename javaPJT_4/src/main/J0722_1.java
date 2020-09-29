package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0722_1_dao;
import dto.J0722_1_dto;

public class J0722_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0722_1_dao dao = new J0722_1_dao();
		ArrayList<J0722_1_dto> arr = new ArrayList();
		
		arr.add(new J0722_1_dto("S0001","홍길동","대전",30));
		arr.add(new J0722_1_dto("S0002","안산동","구미",41));
		arr.add(new J0722_1_dto("S0003","김이수","서울",28));
		arr.add(new J0722_1_dto("S0004","강민오","부산",50));
		
		
		int gubun = 0;
		do {
			System.out.println(" 검색: 1, 등록: 2, 수정: 3, 삭제: 4, 종료: 0 ");
			gubun = sc.nextInt();
			if(gubun == 1) {
				int gu;
				do{
					System.out.println("이름검색: 1, 지역: 2, 나가기: 0");
					gu = sc.nextInt();
					if(gu == 1) {
						System.out.println(" 검색할 이름 ? ");
						String searchName = sc.next();
						for(int k = 0; k < arr.size(); k++) {
							if(arr.get(k).getName().indexOf(searchName) != -1) {
								System.out.print(arr.get(k).getNo()+"\t");
								System.out.print(arr.get(k).getName()+"\t");
								System.out.print(arr.get(k).getArea()+"\t");
								System.out.print(arr.get(k).getAge()+"\n");
							}
						}
					}else if(gu == 2) {
						System.out.println(" 검색할 지역은 ? ");
						String searchArea = sc.next();
						for(int k = 0; k < arr.size(); k++) {
							if(arr.get(k).getArea().indexOf(searchArea) != -1) {
								System.out.print(arr.get(k).getNo()+"\t");
								System.out.print(arr.get(k).getName()+"\t");
								System.out.print(arr.get(k).getArea()+"\t");
								System.out.print(arr.get(k).getAge()+"\n");
							}
						}
					}
				}while(gu != 0);
				
				System.out.println("-------검색 종료--------");
				
				
			}else if(gubun == 2) {
				// no = "S0001"
				String no = "";
				if(arr.size() == 0) {
					no = "S0001";
				}else {
					String n = arr.get(arr.size()-1).getNo();
					no = dao.getNo(n);
					
					
				}
				
				System.out.println(" 이름은 ? ");
				String name = sc.next();
				
				System.out.println(" 지역은 ? ");
				String area = sc.next();
				
				System.out.println(" 나이는 ? ");
				int age = sc.nextInt();
				
				J0722_1_dto dto = new J0722_1_dto(no, name, area, age);
				arr.add(dto);
				
				
			}else if(gubun == 3) {
				System.out.println(" 수정할 사번은? ");
				String no = sc.next();
				int updateNo = -1;
					for(int k = 0; k < arr.size(); k++) {
						if(arr.get(k).getNo().equals(no)) {
							updateNo = k;
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\n");
						}
						
					}
					if(updateNo == -1) {
						System.out.println("----------수정할 정보 없음---------");
					}else {
						
						System.out.println(" 수정할 이름 ? ");
						String name = sc.next();
						System.out.println(" 수정할 지역 ? ");
						String area = sc.next();
						System.out.println(" 수정할 나이 ? ");
						int age = sc.nextInt();
						
						J0722_1_dto d = new J0722_1_dto(no, name, area, age);
						arr.set(updateNo, d);
						
						for(int k = 0; k < arr.size(); k++) {
						System.out.print(arr.get(k).getNo()+"\t");
						System.out.print(arr.get(k).getName()+"\t");
						System.out.print(arr.get(k).getArea()+"\t");
						System.out.print(arr.get(k).getAge()+"\n");
						}
					}System.out.println("----------수정 종료---------");
				
				
				
			}else if(gubun == 4) {
				System.out.println(" 삭제할 사번은 ? ");
				String no = sc.next();
				int deleteNo = -1;
				for(int k = 0; k < arr.size(); k++) {
					if(arr.get(k).getNo().equals(no)) {
						deleteNo = k;
						System.out.print(arr.get(k).getNo()+"\t");
						System.out.print(arr.get(k).getName()+"\t");
						System.out.print(arr.get(k).getArea()+"\t");
						System.out.print(arr.get(k).getAge()+"\n");
					}
				}if( deleteNo == -1) {
					System.out.println(" 삭제할 정보 없음 ");
				}else {
					System.out.println(" 정말 삭제 하시겠습니까 ? 예:Y ");
					String yn = sc.next();
					if(yn.equals("Y") || yn.equals("y") ) {
						arr.remove(deleteNo);
						for(int k = 0; k < arr.size(); k++) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\n");
						}
						
					}
				}
				
			}
			
		}while(gubun != 0);
		
		
		
		
		
		
		
		
	}

}

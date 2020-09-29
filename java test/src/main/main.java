package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.dao;
import dto.dto;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dao daoo = new dao();
		ArrayList<dto> arr = new ArrayList();
		
		arr.add(new dto("S0001","홍길동","대전",35));
		arr.add(new dto("S0002","안산동","충북",29));
		arr.add(new dto("S0003","박달재","수원",48));
		arr.add(new dto("S0004","만수르","영월",51));
		
		int gubun = 0;
		do {
			System.out.println(" 검색: 1, 등록: 2, 수정: 3, 삭제: 4, 종료: 0");
			gubun = sc.nextInt();
			if(gubun == 1) {
				int gu = 3 ;
				do {
					System.out.println(" 이름 검색: 1, 지역: 2, 나가기: 0");
					gu = sc.nextInt();
					if(gu == 1) {
						System.out.println(" 검색할 이름은 ? ");
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
				} while (gu != 0);
				
				System.out.println("---------검색 종료---------");
				
			}else if(gubun == 2) {
				String no = "";
				if(arr.size() == 0) {
					no = "S0001";
				}else {
					String n = arr.get(arr.size()-1).getNo();
					no = daoo.getNo(n);
				}
				
				System.out.println(" 등록할 이름은 ? ");
				String name = sc.next();
				
				System.out.println(" 등록할 지역은 ? ");
				String area = sc.next();
				
				System.out.println(" 등록할 나이는 ? ");
				int age = sc.nextInt();
				
				arr.add(new dto(no, name, area, age));
				
			}else if(gubun == 3) {
				System.out.println(" 수정할 사번은 ? ");
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
				}if(updateNo == -1) {
					System.out.println("---------수정 종료--------");
				}else {
					System.out.println(" 수정할 이름은 ? ");
					String name = sc.next();
					
					System.out.println(" 수정할 지역은 ? ");
					String area = sc.next();
					
					System.out.println(" 수정할 나이는 ? ");
					int age = sc.nextInt();
					
					
					arr.set(updateNo, new dto(no, name, area, age));
				}
				
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
					
				}if(deleteNo == -1) {
					System.out.println("--------삭제할 정보 없음--------");
				}else {
					System.out.println(" 삭제하시겠습니까 ? 예:Y, 아니오: N");
					String an = sc.next();
					if(an.equals("Y")|| an.equals("y")) {
						arr.remove(deleteNo);
						for(int k = 0; k < arr.size(); k++) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\t");
						}
					}else if(an.equals("N")|| an.equals("n")) {
						
					}
				}
			}
			
			
			
			
			
		}while(gubun != 0);
		
	}

}

























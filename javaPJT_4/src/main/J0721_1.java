package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0721_1_dao;
import dto.J0721_1_dto;

public class J0721_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<J0721_1_dto> arr = new ArrayList<>();
		J0721_1_dao dao = new J0721_1_dao();
		J0721_1_dto dto1 = new J0721_1_dto("N001", "홍길동", "총무", "사원", 25);
		J0721_1_dto dto2 = new J0721_1_dto("N002", "안산동", "인사", "대리", 35);
		J0721_1_dto dto3 = new J0721_1_dto("N003", "김이수", "총무", "대리", 28);
		arr.add(dto1);
		arr.add(dto2);
		arr.add(dto3);
		/*
		arr.add(new J0721_1_dto("N001", "홍길동", "총무", "사원", 25));
		arr.add(new J0721_1_dto("N002", "안산동", "인사", "대리", 35));
		arr.add(new J0721_1_dto("N003", "김이수", "총무", "대리", 28));

		*/
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getNo()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getDepart()+"\t");
			System.out.print(arr.get(k).getPosition()+"\t");
			System.out.print(arr.get(k).getAge()+"\n");
		}
		
		
		System.out.println("--------------------------");
		System.out.println(" 등록: 0, 이름검색: 1, 부서검색: 2, 정보수정: 3, 삭제: 4  선택 ? ");
		int gubun = sc.nextInt();
		
		if(gubun == 0) {
			System.out.println(" 이름은 ? ");
			String name = sc.next();
			System.out.println(" 부서명은 ? ");
			String depart = sc.next();
			System.out.println(" 직위명은 ? ");
			String position = sc.next();
			System.out.println(" 나이는 ? ");
			int age = sc.nextInt();
			
			String no = arr.get(arr.size()-1).getNo();
			String newNo = dao.getNo(no);
			
			J0721_1_dto dto = new J0721_1_dto(newNo, name, depart, position, age);
			
			arr.add(dto);
			
			for(int k = 0; k < arr.size(); k++) {
					System.out.print(arr.get(k).getNo()+"\t");
					System.out.print(arr.get(k).getName()+"\t");
					System.out.print(arr.get(k).getDepart()+"\t");
					System.out.print(arr.get(k).getPosition()+"\t");
					System.out.print(arr.get(k).getAge()+"\n");
				
			}
			System.out.println("------------등록 종료-------------");
			
			
		}else if(gubun == 1) {
			System.out.println(" 검색할 이름은 ?");
			String search = sc.next();
			for(int k = 0; k < arr.size(); k++) {
				if(arr.get(k).getName().indexOf(search) != -1) {
					System.out.print(arr.get(k).getNo()+"\t");
					System.out.print(arr.get(k).getName()+"\t");
					System.out.print(arr.get(k).getDepart()+"\t");
					System.out.print(arr.get(k).getPosition()+"\t");
					System.out.print(arr.get(k).getAge()+"\n");
				}
			}
			System.out.println("------------이름 검색 종료--------------");	
			
			
		}else if(gubun == 2) {
			System.out.println(" 검색할 부서는 ?");
			String search = sc.next();
			for(int k = 0; k < arr.size(); k++) {
				if(arr.get(k).getDepart().indexOf(search) != -1) {
					System.out.print(arr.get(k).getNo()+"\t");
					System.out.print(arr.get(k).getName()+"\t");
					System.out.print(arr.get(k).getDepart()+"\t");
					System.out.print(arr.get(k).getPosition()+"\t");
					System.out.print(arr.get(k).getAge()+"\n");
				}
			}
			System.out.println("------------이름 검색 종료--------------");
		}else if(gubun == 3) {
			System.out.println(" 수정하고자 하는 사번은 ? ");
			String no = sc.next();
			int updateNo = -1;
			for(int k = 0; k < arr.size(); k++) {
				if(arr.get(k).getNo().equals(no)) {
					updateNo = k;
					System.out.print(arr.get(k).getNo()+"\t");
					System.out.print(arr.get(k).getName()+"\t");
					System.out.print(arr.get(k).getDepart()+"\t");
					System.out.print(arr.get(k).getPosition()+"\t");
					System.out.print(arr.get(k).getAge()+"\n");
				}
			}		
			if(updateNo == -1) {
				System.out.println(" -----수정 정보 없음 ------");
			}else {
				
				System.out.println(" 수정할 이름은 ? ");
				String name = sc.next();
				System.out.println(" 수정할 부서명은 ? ");
				String depart = sc.next();
				System.out.println(" 수정할 직위명은 ? ");
				String position = sc.next();
				System.out.println(" 수정할 나이는 ? ");
				int age = sc.nextInt();
				
				J0721_1_dto d = new J0721_1_dto(no, name, depart, position, age);
				arr.set(updateNo, d);
//				arr.get(updateNo).setName(name);
//				arr.get(updateNo).setDepart(depart);;
//				arr.get(updateNo).setPosition(position);;
//				arr.get(updateNo).setAge(age);
				
				for(int k = 0; k < arr.size(); k++) {
					 	System.out.print(arr.get(k).getNo()+"\t");
						System.out.print(arr.get(k).getName()+"\t");
						System.out.print(arr.get(k).getDepart()+"\t");
						System.out.print(arr.get(k).getPosition()+"\t");
						System.out.print(arr.get(k).getAge()+"\n");
					}	
			}System.out.println("------------수정 종료--------------");	
				
		}else if(gubun == 4) {
				System.out.println(" 삭제할 사번 ? ");
				String no = sc.next();
				int deleteNo = -1;
				for(int k = 0; k < arr.size(); k++) {
					if(arr.get(k).getNo().equals(no)) {
						deleteNo = k;
						System.out.print(arr.get(k).getNo()+"\t");
						System.out.print(arr.get(k).getName()+"\t");
						System.out.print(arr.get(k).getDepart()+"\t");
						System.out.print(arr.get(k).getPosition()+"\t");
						System.out.print(arr.get(k).getAge()+"\n");
					}
				}
					if(deleteNo == -1) {
						System.out.println(" -----삭제 정보 없음 ------");
					}else {
						System.out.println(" 정말 삭제 하겠습니까? 예:Y");
						String yn = sc.next();
						if(yn.equals("Y") || yn.equals("y") || yn.equals("ㅛ")) {
							arr.remove(deleteNo);
							for(int k = 0; k < arr.size(); k++) {
							 	System.out.print(arr.get(k).getNo()+"\t");
								System.out.print(arr.get(k).getName()+"\t");
								System.out.print(arr.get(k).getDepart()+"\t");
								System.out.print(arr.get(k).getPosition()+"\t");
								System.out.print(arr.get(k).getAge()+"\n");
								
						}
							
					}
				}		
			
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*DecimalFormat df = new DecimalFormat("0000");
		String a = "kB_0024_A";
		a = a.substring(3, 7);

		int n = Integer.parseInt(a);
		n++;
		
		a = df.format(n);
				a = Integer.toString(n);
		if(a.length() == 1) a = "000" +a;
		if(a.length() == 2) a = "00" + a;
		if(a.length() == 3) a = "0" + a;
		
		a = "kB_" + a + "_A";
		System.out.println("a : " + a);
		
		*/
		
		/*		
		String a = "S001-DE";
		a = a.substring(1, 4);
		System.out.println(" a :" + a);
		int n = Integer.parseInt(a);
		n++;  //n = n + 1;
		System.out.println(" n :" + n);
		
		a = Integer.toString(n);
		if(a.length() == 1) a = "00"+a;
		if(a.length() == 2) a = "0"+a; 
		System.out.println(" a :" + a);
		
		a = "S" + a + "-DE";
		System.out.println(" a :" + a);
*/		
	}
	}	
}

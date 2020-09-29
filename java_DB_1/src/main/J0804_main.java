package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0804_dao;
import dto.J0804_dto;

public class J0804_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0804_dao dao = new J0804_dao();
		ArrayList<J0804_dto> arr = new ArrayList<>();
		
		
		int gubun = 0;
		do {
			System.out.println(" 검색:[1], 등록:[2], 수정:[3], 삭제:[4], 종료:[0] ? ");
			gubun = sc.nextInt();
			if(gubun == 1) {
				int searchGubun = 0;
				do {
					System.out.println(" 검색   사번[1], 성명[2], 지역[3], 종료[0] ");
					searchGubun = sc.nextInt();
					
					if(searchGubun == 1) {
						System.out.println(" 검색할 사번은 ? ");
						String no = sc.next();
						arr = dao.getMemberList("a.no", no);
						
					}else if(searchGubun == 2) {
						System.out.println(" 검색할 성명은 ? ");
						String name = sc.next();
						arr = dao.getMemberList("a.name", name);
						
					}else if(searchGubun == 3) {
						System.out.println(" 검색할 지역은 ? ");
						String area = sc.next();
						arr = dao.getMemberList("b.area_name", area);
						
					}
					if(searchGubun != 0) {
						System.out.println("=============================");
						System.out.println(" 사번\t 성명\t 지역\t 나이");
						System.out.println("-----------------------------");
						if(arr.size() == 0) {
							System.out.println(" 검색 내용 없음 ");
						}
						for(int k = 0; k < arr.size(); k++) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getName()+"\t");
							System.out.print(arr.get(k).getArea()+"\t");
							System.out.print(arr.get(k).getAge()+"\n");
						}
						System.out.println("=============================");
					}else {
					System.out.println(" 검색 종료 ");
					}
				}while(searchGubun != 0 );
				sc.close();
				
				
				
			}else if(gubun == 2) {
				System.out.println(" 사번은 ? ");
				String no = sc.next();
				
				System.out.println(" 이름은 ? ");
				String name = sc.next();
				
				System.out.println(" 지역코드 ? 서울: [10], 대전: [20], 부산: [30] ?");
				String area = sc.next();
				
				System.out.println(" 나이는 ? ");
				int age = sc.nextInt();
				
				
				int result = dao.saveMember(no, name, area, age);
				
//				J0804_dto dto = new J0804_dto(no, name, area, age); 
//				int result = dao.saveMember(dto);							/*overloading 임 자바 안에서 같은 이름의 클래스를 사용한 경우 하지만 매개변수는 다름*/
				
				if(result == 1) {
					System.out.println(" 등록 되었습니다. ");
					
				} else {
					System.out.println(" 등록 실패. ");
				}
			}else if(gubun == 3) {
				System.out.println(" 수정할 사번은 ? ");
				String no = sc.next();
				J0804_dto dto = dao.getMemberView(no);						/* 한 명만 조회 할 예정이라서 arrylist까지는 필요없고 dto로 가져오면 됨 */
				if(dto == null) {
					System.out.println(no + " 사번 정보 없음 ");
				}else {
					System.out.print(" 사번 : " + no );
					System.out.print(" 성명 : " + dto.getName() );
					System.out.print(" 지역 : " + dto.getArea() );
					System.out.print(" 나이 : " + dto.getAge()+"\n");
				
					System.out.println(" 수정하시겠습니까 ? 예: Y, 아니오: N ");
					String updateGubun = sc.next();
					if(updateGubun.equals("y")||updateGubun.equals("Y")||updateGubun.equals("ㅛ")) {
						System.out.print(dto.getName() + " -> 성명 ? ");
						String name = sc.next();
						
						System.out.print(dto.getArea() + " -> 지역 ? 서울:[10], 대전:[20], 부산:[30] ");
						String area = sc.next();
						
						System.out.print(dto.getAge() + " -> 나이 ? "+"\n");
						int age = sc.nextInt();
						
						int result = dao.updateMember(no, name, area, age);
						if(result == 1) {
							System.out.println(" 수정되었습니다. ");
						}else {
							System.out.println(" 수정 오류~~ ");
						}
					}
					
					
				}
								
			}else if(gubun == 4) {
				System.out.println(" 삭제할 사번은 ? ");
				String no = sc.next();
				J0804_dto dto = dao.getMemberView(no);
				if(dto == null) {
					System.out.println(no + " 사번 정보 없음 ");
				}else {
					System.out.print(" 사번 : " + no );
					System.out.print(" 성명 : " + dto.getName() );
					System.out.print(" 지역 : " + dto.getArea() );
					System.out.print(" 나이 : " + dto.getAge()+"\n");
					
					System.out.println(" 삭제하겠습니까 ? 예:[Y], 아니오:[N] ");
					String deleteGubun = sc.next();
					if(deleteGubun.equals("y")||deleteGubun.equals("Y")||deleteGubun.equals("ㅛ")) {
						int result = dao.deleteMember(no);
						if(result == 1) {
							System.out.println(" 삭제되었습니다. ");
						}else {
							System.out.println(" 삭제 오류 ");
						}
					} 
				}
				
			}
			
		}while(gubun != 0);
		
		System.out.println(" 검색 종료 ");
		
		
		
		
	}

}

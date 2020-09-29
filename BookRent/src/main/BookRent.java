package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.HistoryMember_dao;
import dao.Member_dao;
import dao.Rent_dao;
import dao.Return_dao;
import dto.HistoryMember_dto;
import dto.Member_dto;
import dto.Rent_dto;
import dto.Return_dto;

public class BookRent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member_dto> arr = new ArrayList<>();
		ArrayList<Rent_dto> arr2 = new ArrayList<>();
		ArrayList<Return_dto> arr3 = new ArrayList<>();
		Member_dao dao = new Member_dao();
		Rent_dao dao2 = new Rent_dao();
		Return_dao dao3 = new Return_dao();
		HistoryMember_dao dao4 = new HistoryMember_dao();
		int workGubun = 0;
		
		do {
			System.out.println(" 회원관리[1]  도서관리[2]  대여[3]  반납[4]  대출이력[5]  시스템종료[0] ");
			workGubun = sc.nextInt();
			
			if(workGubun == 1) {
				int gubun = 0;
				do {
					System.out.println(" 회원 조회[1]  등록[2]  수정[3]  삭제[4]  이전[0] ");
					gubun = sc.nextInt();
					
					if(gubun == 1) {
						int searchGubun = 0;
						do {
							System.out.println(" 무엇으로 검색하시겠습니까 ? ID[1]  이름[2]  이전[0] ");
							searchGubun = sc.nextInt();
							
							if(searchGubun == 1) {
								System.out.println(" 검색할 회원의 ID 는 ? ");
								String id = sc.next();
								arr = dao.getMemberList("id", id);
								
							}else if(searchGubun == 2) {
								System.out.println(" 검색할 회원의 이름은 ? ");
								String name = sc.next();
								arr = dao.getMemberList("name", name);
								
							}
							
							if(searchGubun != 0) {
								for(int k = 0; k < arr.size(); k++) {
									System.out.println("===========================================");
									System.out.println("ID\t  이름\t 주소\t 연락처\t 등록일\t 나이\t");
									System.out.println("-------------------------------------------");
									System.out.print(" ID " + arr.get(k).getId()+"\t");
									System.out.print(" 이름 " + arr.get(k).getName()+"\t");
									System.out.print(" 주소 " + arr.get(k).getAdress()+"\t");
									System.out.print(" 연락처 " + arr.get(k).getTell()+"\t");
									System.out.print(" 등록일 " + arr.get(k).getReg_date()+"\t");
									System.out.print(" 나이 " + arr.get(k).getAge()+"\n");
									System.out.println("===========================================");
								}
								
								if(arr.size() == 0) {
									System.out.println(" 검색 내용 없음 ");
								}
							}
							
							
							
						}while(searchGubun != 0);
						
						
						
						
						
					}else if(gubun == 2) {
						System.out.println(" 등록할 ID를 입력하시오. ");
						String id = sc.next();
						
						System.out.println(" 등록할 이름을 입력하시오. ");
						String name = sc.next();
						
						System.out.println(" 등록할 주소를 입력하시오. ");
						String address = sc.next();
						
						System.out.println(" 등록할 연락처를 입력하시오. ");
						String tell = sc.next();
						
						System.out.println(" 나이를 입력하시오. ");
						int age = sc.nextInt();
						
						System.out.println(" 등록한 날짜를 입력하시오. ");
						String reg_date = sc.next();
						
						
						int result = dao.getMember(id, name, address, tell, age, reg_date);
						
						if(result == 1) {
							System.out.println(" 등록 완료 ");
						}else {
							System.out.println(" 등록 실패 ");
						}
						
						
					}else if(gubun == 3) {
						System.out.println(" 수정할 회원의 ID는 무엇입니까 ? ");
						String id = sc.next();
						Member_dto dto = dao.viewMember(id);
						
						if(dto == null) {
							System.out.println(" 수정할 정보 없음 ");
						}else {
							System.out.print("ID" + dto.getId()+"\t");
							System.out.print("이름" + dto.getName()+"\t");
							System.out.print("주소" + dto.getAdress()+"\t");
							System.out.print("연락처" + dto.getTell()+"\t");
							System.out.print("등록일" + dto.getReg_date()+"\t");
							System.out.print("나이" + dto.getAge()+"\n");
							
							
							System.out.println(" 정말로 수정하시겠습니까? 예[Y]  아니요[N] ");
							String response = sc.next();
							if(response.equals("Y")|| response.equals("y")|| response.equals("ㅛ")) {
								System.out.println(" 수정할 이름은 ? ");
								String name = sc.next();
								
								System.out.println(" 수정할 주소는 ? ");
								String address = sc.next();
								
								System.out.println(" 수정할 연락처는 ? ");
								String tell = sc.next();
								
								System.out.println(" 수정할 등록일은 ? ");
								String reg_date = sc.next();
								
								System.out.println(" 수정할 나이는 ? ");
								int age = sc.nextInt();
								
								int result = dao.updateMember(id, name, address, tell, reg_date, age);
								
								if(result == 1) {
									System.out.println(" 수정 완료 ");
								}else {
									System.out.println(" 수정 실패 ");
								}
							}
							
						}
						
						
					}else if(gubun == 4) {
						System.out.println(" 삭제할  회원의 ID는 ? ");
						String id = sc.next();
						Member_dto dto = dao.viewMember(id);
						if(dto == null) {
							System.out.println(" 삭제할 정보 없음 ");
						}else {
							System.out.print("ID" + id+"\t");
							System.out.print("이름" + dto.getName()+"\t");
							System.out.print("주소" + dto.getAdress()+"\t");
							System.out.print("연락처" + dto.getTell()+"\t");
							System.out.print("등록일" + dto.getReg_date()+"\t");
							System.out.print("나이 " + dto.getAge()+"\t");
							
							System.out.println(" 정말로 삭제하시겠습니까 ? 예:[Y], 아니요:[N]");
							String updateGubun = sc.next();
							
							if(updateGubun.equals("Y")||updateGubun.equals("y")||updateGubun.equals("ㅛ")) {
								
								int result = dao.deleteMember(id);
								
								if(result == 1) {
									System.out.println(" 삭제 완료 ");
								}else {
									System.out.println(" 삭제 실패 ");
								}
							}
						}
					}
					
					
				}while(gubun != 0);
				
				System.out.println(" 회원관리 종료 ");
				
				
				
			}else if(workGubun == 2) {
				
				int gubun = 0; 
				
				do {
					System.out.println(" 도서 조회[1]  등록[2]  수정[3]  삭제[4]  이전[0] ");
					gubun = sc.nextInt();
					
					
					if(gubun == 1) {
					int searchGubun = 0;
					do {
						System.out.println(" 조회할 도서의  도서번호[1]  저자명[2]  이전[0] ");
						searchGubun = sc.nextInt();
						
						if(searchGubun == 1) {
							System.out.println(" 조회할 도서번호를 입력하시오. ");
							String no = sc.next();
							arr = dao.getBookList("no", no);
							
						}else if(searchGubun == 2) {
							System.out.println(" 조회할 저자명를 입력하시오. ");
							String writer = sc.next();
							arr = dao.getBookList("writer", writer);
							
						}
						
						if(searchGubun != 0) {
							for(int k = 0; k < arr.size(); k++) {
							System.out.println("=============================================");
							System.out.println("도서번호\t 도서명\t 출판사\t 저자\t 입고일자\t 대여상태\t");
							System.out.println("=============================================");
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getBookName()+"\t");
							System.out.print(arr.get(k).getPublisher()+"\t");
							System.out.print(arr.get(k).getWriter()+"\t");
							System.out.print(arr.get(k).getBookReg_date()+"\t");
							System.out.print(arr.get(k).getRent_gubun()+"\n");
							}
						}
						
						
						
						
						
					}while(searchGubun != 0);
						System.out.println(" 도서조회 종료 ");
						
					}else if(gubun == 2) {
						System.out.println(" 등록할 도서의 도서번호는 ? ");
						String no = sc.next();
						
						System.out.println(" 등록할 도서의 도서이름은 ? ");
						String name = sc.next();

						System.out.println(" 등록할 도서의 출판사는 ? ");
						String publisher = sc.next();

						System.out.println(" 등록할 도서의 저자는 ? ");
						String writer = sc.next();

						System.out.println(" 등록할 도서의 입고일자는 ? ");
						String reg_date = sc.next();

						
						int result = dao.getBookList(no,name,publisher,writer,reg_date);
						
						if(result == 1) {
							System.out.println(" 등록 완료 ");
						}else {
							System.out.println(" 등록 실패 ");
						}
						
					}else if(gubun == 3) {
						System.out.println(" 수정할 도서의 도서번호를 입력하시오. ");
						String no = sc.next();
						Member_dto dto = dao.viewBookList(no);
						
						if(dto == null) {
							System.out.println(" 수정할 도서 정보 없음 ");
						}else {
							System.out.print(" 도서번호: " + dto.getNo()+ "\t");
							System.out.print(" 도서이름: " + dto.getBookName()+ "\t");
							System.out.print(" 출판사: " + dto.getPublisher()+ "\t");
							System.out.print(" 저자명: " + dto.getWriter()+ "\t");
							System.out.print(" 등록일자: " + dto.getBookReg_date()+ "\t");
							System.out.print(" 대여상태: " + dto.getRent_gubun()+ "\n");
							
							System.out.println(" 정말로 수정하시겠습니까 ? 예[Y]  아니요[N] ");
							String response = sc.next();
							if(response.equals("Y")||response.equals("y")||response.equals("ㅛ")) {
								System.out.println(" 수정할 도서명은 ? ");
								String name = sc.next();
								
								System.out.println(" 수정할 출판사명은 ? ");
								String publisher = sc.next();

								System.out.println(" 수정할 저자명은 ? ");
								String writer = sc.next();

								System.out.println(" 수정할 등록일자는 ? ");
								String reg_date = sc.next();

								int result = dao.updateBookList(no, name, publisher, writer, reg_date);
								
								if(result == 1) {
									System.out.println(" 수정완료 ");
								}else {
									System.out.println(" 수정실패");
								}
							}
							
							
						}
						
					}else if(gubun == 4) {
						System.out.println(" 삭제할 도서의 도서번호를 입력하시오. ");
						String no = sc.next();
						Member_dto dto = dao.viewBookList(no);
						
						if(dto == null) {
							System.out.println(" 삭제할 도서정보 없음 ");
						}else {
							System.out.print(" 도서번호: " + dto.getNo()+ "\t");
							System.out.print(" 도서이름: " + dto.getBookName()+ "\t");
							System.out.print(" 출판사: " + dto.getPublisher()+ "\t");
							System.out.print(" 저자명: " + dto.getWriter()+ "\t");
							System.out.print(" 등록일자: " + dto.getBookReg_date()+ "\t");
							System.out.print(" 대여상태: " + dto.getRent_gubun()+ "\n");
							
							System.out.println(" 정말로 삭제하시겠습니까 ? 예[Y]  아니요[N] ");
							String response = sc.next();
							
							if(response.equals("Y")||response.equals("y")||response.equals("ㅛ")) {
								int result = dao.deleteBookList(no);
								
								if(result == 1) {
									System.out.println(" 삭제 완료 ");
								}else {
									System.out.println(" 삭제 실패 ");
								}
								
							}
						}
						
						
						
					}
					
				}while(gubun != 0);
				
				System.out.println(" 도서관리 종료 ");
				
				
				
			}else if(workGubun == 3) {
				System.out.println(" 대여[1]  대여취소[2]  이전[0] ");							
				int gubun = sc.nextInt();
				
				if(gubun == 1) {
					int ingYN = 0;
					String member_id = "";
					do {
						System.out.println(" 회원 ID를 입력하시오. ");
						member_id = sc.next();
						ingYN = dao2.getCheckMemberId(member_id);				//ingYN 이 1인 경우는 회원ID가 존재한다는 의미
						//ingYN = dao2.getCheckValue("member",member_id);		//회원 ID랑 대여여부를 같은 메소드로 돌릴 때
						if(ingYN == 0) {
							System.out.println(" 입혁하신 회원 ID 가 존재하지 않습니다. ");
						}
					}while(ingYN == 0);
					
					int ingBN = 0;
					String book_no = "";
					do {
						System.out.println(" 대여할 도서의 도서번호는 ? ");
						book_no = sc.next();
						ingBN = dao2.getCheckMemberBook(book_no);
						//ingYN = dao2.getCheckValue("book",book_no);			//회원 ID랑 대여여부를 같은 메소드로 돌릴 때
						if(ingBN == 0) {
							System.out.println(" 입력하신 도서번호는 존재하지 않습니다. ");
						}
					}while(ingBN == 0);
					
					System.out.println(" 도서를 대여하는 날짜는(yyyy-mm-dd) ? ");
					String rent_date = sc.next();
					
					String rent_no = dao2.getMaxRentNo();

					int result = dao2.getRentList(rent_no, member_id, book_no, rent_date);
					int updateResult = 0;
					if(result == 1) {
						updateResult = dao2.setBookRentGubun(book_no);
						if(updateResult == 1) {
							System.out.println(" 대여 완료 ");
						}else {
							System.out.println(" 대여 실패 ");
						}
					}
					
					
				}else if(gubun == 2) {
					System.out.println(" 회원 ID를 입력하시오. ");
					String id = sc.next();
					
					Rent_dto dto = dao2.getRentView(id);
					
					for(int k = 0; k < arr2.size(); k++) {
					System.out.println("========================================");
					System.out.println("대여번호\t 회원ID\t 도서번호\t 대여날짜\t 반납날짜\t");
					System.out.println("========================================");
					System.out.print(arr2.get(k).getRent_no()+"\t");
					System.out.print(arr2.get(k).getMember_id()+"\t");
					System.out.print(arr2.get(k).getBook_no()+"\t");
					System.out.print(arr2.get(k).getRent_date()+"\t");
					System.out.print(arr2.get(k).getReturn_date()+"\n");
					}
					
					int ingRB = 0;
					String book_no = "";
					do {
						System.out.println(" 대여했던 도서의 도서번호를 입력하시오. ");
						book_no = sc.next();
						ingRB = dao2.getCheckRentedBookList(book_no);
						if(ingRB == 0) {
							System.out.println(" 도서번호를 다시 입력해주세요. ");
						}
					}while(ingRB == 0);
									
					int result = dao2.getCheckRentedBook(book_no);
					if(result == 1) {
						System.out.println(" 대여 취소 완료 ");
					}else {
						System.out.println(" 대여 취소 실패 ");
					}
					
					
				}
				
							
			}else if(workGubun == 4) {
				System.out.println(" 회원의 ID 는 ? ");
				String id = sc.next();
				ArrayList<Return_dto> arr31 = dao3.getMemberRentInfo(id);
				
				for(int k = 0; k < arr31.size(); k++ ) {
					System.out.print(arr31.get(k).getRent_no()+"\t");
					System.out.print(arr31.get(k).getMember_id()+"\t");
					System.out.print(arr31.get(k).getMember_name()+"\t");
					System.out.print(arr31.get(k).getBook_no()+"\t");
					System.out.print(arr31.get(k).getBook_name()+"\t");
					System.out.print(arr31.get(k).getRent_date()+"\t");
					System.out.print(arr31.get(k).getRent_gubun()+"\n");
				}
				
				System.out.println(" 반납할 대여 번호를 입력하시오. ");
				String rNo = sc.next();
				
				System.out.println(" 반납 일자를 입력하시오. ");
				String returnDate = sc.next();
				
				int procFirst = dao3.returnRent(rNo, returnDate);
				int procSecond = 0;
				if(procFirst == 1) {
					procSecond = dao3.returnBook(rNo);
				}
				if(procSecond == 1) {
					System.out.println(" 반납 완료 ");
				}else {
					System.out.println(" 반납 오류 ");
				
				} 
			
			}else if(workGubun == 5) {  //대출이력
				int hisGubun = 0;
				do {
					System.out.println(" 회원대출이력[1]  도서대출이력[2]  이전[3]  ");
					hisGubun = sc.nextInt();
					if(hisGubun == 1) {
						System.out.println(" 회원 ID 를 입력하시오. ");
						String memberId = sc.next();
						ArrayList<HistoryMember_dto> arr4 = dao4.getHistoryMember(memberId);
						System.out.println("===================================================");
						System.out.println("대출번호\t 회원명\t 도서번호\t 도서명\t 대출일자\t 반납일자\t");
						System.out.println("---------------------------------------------------");
						for(int k = 0; k < arr4.size(); k++) {
							System.out.print(arr4.get(k).getRentNo()+"\t");
							System.out.print(arr4.get(k).getMemberName()+"\t");
							System.out.print(arr4.get(k).getBookNo()+"\t");
							System.out.print(arr4.get(k).getBookName()+"\t");
							System.out.print(arr4.get(k).getRentDate()+"\t");
							System.out.print(arr4.get(k).getReturnDate()+"\n");
						}
						System.out.println("----------------------------------------------------");
						
					}else if(hisGubun == 2) {
						System.out.println(" 대여한 도서명을 입력하시오. ");
						String bookName = sc.next();
						ArrayList<HistoryMember_dto> arr5 = dao.getHistoryBook();
					}
				
				}while(hisGubun != 0);
				}
		}while(workGubun != 0);
		sc.close();
		System.out.println(" ===종료=== ");
		
	}

}

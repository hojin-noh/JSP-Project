package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0806_dao;
import dto.J0806_dto;

public class J0806_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0806_dao dao = new J0806_dao();
		ArrayList<J0806_dto> arr = new ArrayList<>();
		
		int gubun = 0;
		do {
			System.out.println(" 검색:[1], 등록:[2], 수정:[3], 삭제:[4], 종료:[0] ");
			gubun = sc.nextInt();
			if(gubun == 1) {
				int searchGubun = 0;
					do {
						System.out.println(" 검색 ? 학번:[1], 이름:[2], 이전[0] ");
						searchGubun = sc.nextInt();
						
						if(searchGubun == 1) {
							System.out.println(" 검색할 사번은 ? ");
							String no = sc.next();
							arr = dao.getScoreList("no",no);
							
						}else if(searchGubun == 2) {
							System.out.println(" 검색할 이름은 ? ");
							String name = sc.next();
							arr = dao.getScoreList("name",name);
						}
						if(searchGubun != 0) {
							for(int k = 0; k < arr.size(); k++) {
								System.out.print(arr.get(k).getNo()+"\t");
								System.out.print(arr.get(k).getName()+"\t");
								System.out.print(arr.get(k).getKor()+"\t");
								System.out.print(arr.get(k).getEng()+"\t");
								System.out.print(arr.get(k).getMat()+"\t");
								System.out.print(arr.get(k).getTotal()+"\t");
								System.out.print(arr.get(k).getAva()+"\n");
							}
							if(arr.size() == 0) {
								System.out.println(" 검색 내용 없음 ");
							}
						}
					}while(searchGubun != 0);
					
						
				
			}else if(gubun == 2) {
				System.out.print(" 등록할 학번은 ? ");
				String no = sc.next();
				if(no.length() > 4) {
					do {
						System.out.println(" 학번 4자리입니다.  다시 입력 해주세요");
					}while(no.length() < 4);
				}
								
				System.out.print(" 등록할 이름은 ? ");
				String name = sc.next();
				
				System.out.print(" 등록할 국어 점수는 ? ");
				int kor = sc.nextInt();
				if(kor >= 100 || kor < 0) {
					do {
						System.out.println(" 점수는 0 ~ 100 점 사이 ");
						kor = sc.nextInt();
					}while(kor >= 100 || kor < 0);
				}
				
				int eng = 0;
				do {
					System.out.println(" 등록할 영어 점수는 ? ");
					eng = sc.nextInt();
					if(eng > 100 || eng < 0) {
						System.out.println(" 점수는 0 ~ 100 사이 ");
					}
				}while(eng > 100 || eng < 0);
				
				
				System.out.print(" 등록할 수학 점수는 ? ");
				int mat = sc.nextInt();
				
				int getTotal = dao.getTotal(kor, eng, mat);
				int getAva = dao.getAva(getTotal, 3);
				
				int result = dao.saveScore(no, name, kor, eng, mat, getTotal, getAva);
				
				if(result == 1) {
					System.out.println(" 등록완료 ");
				}else {
					System.out.println(" 등록실패 ");
				}
				
				
			}else if(gubun == 3) {
				System.out.println(" 수정할 정보의 학번 입력 하시오. ");
				String no = sc.next();
				J0806_dto dto = dao.getScoreView(no);
				if(dto == null) {
					System.out.println(" 수정할 정보 없음 ");
				}else {
					System.out.print("학번 :" + no+"\t");
					System.out.print("이름 :" + dto.getName()+"\t");
					System.out.print("국어 점수 :" + dto.getKor()+"\t");
					System.out.print("영어 점수 :" + dto.getEng()+"\t");
					System.out.print("수학 점수 :" + dto.getMat()+"\t");
					System.out.print("총점 :" + dto.getTotal()+"\t");
					System.out.print("평균 :" + dto.getAva()+"\n");
					
					System.out.println(" 정말로 수정하시겠습니까 ? 예:[Y], 아니요:[N]");
					String updateGubun = sc.next();
					if(updateGubun.equals("Y")||updateGubun.equals("y")||updateGubun.equals("ㅛ")) {
						System.out.println(" 수정할 이름은 ? ");
						String name = sc.next();
						
						System.out.println(" 수정할 국어점수는 ? ");
						int kor = sc.nextInt();
						
						System.out.println(" 수정할 영어점수는 ? ");
						int eng = sc.nextInt();
						
						System.out.println(" 수정할 수학점수는 ? ");
						int mat = sc.nextInt();
						
						int total = dao.getTotal(kor, eng, mat);
						int ava = dao.getAva(total, 3);
						
						int result = dao.updateScore(no, name, kor, eng, mat, total, ava);
						
						if(result == 1) {
							System.out.println(" 수정 완료 ");
						}else {
							System.out.println(" 수정 실패 ");
						}
						
						
					}
				}
				
			}else if(gubun == 4) {
				System.out.println(" 삭제할 정보의 학번 입력 하시오. ");
				String no = sc.next();
				J0806_dto dto = dao.getScoreView(no);
				if(dto == null) {
					System.out.println(" 삭제할 정보 없음 ");
				}else {
					System.out.print("학번 :" + no+"\t");
					System.out.print("이름 :" + dto.getName()+"\t");
					System.out.print("국어 점수 :" + dto.getKor()+"\t");
					System.out.print("영어 점수 :" + dto.getEng()+"\t");
					System.out.print("수학 점수 :" + dto.getMat()+"\t");
					System.out.print("총점 :" + dto.getTotal()+"\t");
					System.out.print("평균 :" + dto.getAva()+"\n");
					
					System.out.println(" 정말로 삭제하시겠습니까 ? 예:[Y], 아니요:[N]");
					String updateGubun = sc.next();
					
					if(updateGubun.equals("Y")||updateGubun.equals("y")||updateGubun.equals("ㅛ")) {
						
						int result = dao.deleteScore(no);
						
						if(result == 1) {
							System.out.println(" 삭제 완료 ");
						}else {
							System.out.println(" 삭제 실패 ");
						}
					}
				}
			}
			
			
			
		}while(gubun != 0);
		
		System.out.println(" ===종료=== ");
		sc.close();
	}

}

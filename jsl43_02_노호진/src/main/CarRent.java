package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.CarRent_dao;
import dao.car_dao;
import dao.member_dao;
import dto.Carinfo_dto;
import dto.Memberinfo_dto;
import dto.carRent_dto;

public class CarRent {

	public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);
 		car_dao dao = new car_dao();
 		member_dao dao2 = new member_dao();
 		CarRent_dao dao3 = new CarRent_dao();
 		
 		int workGubun = 0;
 		do {
 			System.out.println("차량 관리[1]  차량대여[2]  차량반납[3]  대여이력[4]  회원조회[5]  시스템종료[0] ");
 			workGubun = sc.nextInt();
 			if(workGubun == 1) {
 				int gubun = 0;
 				do {
 					System.out.println(" 차량 조회[1]  차량 등록[2]  차량 정보 수정[3]  차량 정보 삭제[4]  이전[0]  ");
 					gubun = sc.nextInt();
 					if(gubun == 1) {
 						System.out.println(" 차량 번호로 조회[1]  제조사로 조회[2]  모델명으로 조회[3]  전체조회[9]  종료[0] ");
 						int searchGubun = sc.nextInt();
 						
 						do {
 						if(searchGubun == 1) {
 							System.out.println(" 차량번호를 입력하시오.(00가0000) ");
 							String carNumber = sc.next();
 							ArrayList<Carinfo_dto> arr = dao.getListCar("car_number", carNumber);
 							
 							System.out.println("===================================================================================================================================================================================");
 							System.out.println("차량 등록 번호\t 모델명\t 차량 번호\t\t 제조사\t 차량 제조 연월\t 변속 기어 타입(자동:Y 수동: N)\t 옵션 여부(풀옵션: Y 일반:N)\t 사고 이력 (있으면Y, 없으면N)\t 연료구분\t 입고날짜\t\t 렌트여부(가능:Y 불가N)\t");
 							System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
 							for(int k = 0; k < arr.size(); k++) {
 								System.out.print(arr.get(k).getNo()+"\t"+"\t");
 								System.out.print(arr.get(k).getModel_name()+"\t");
 								System.out.print(arr.get(k).getCar_number()+"\t"+"\t");
 								System.out.print(arr.get(k).getCar_made()+"\t");
 								System.out.print(arr.get(k).getCar_made_ym()+"\t"+"\t");
 								System.out.print(arr.get(k).getAuto_yn()+"\t"+"\t"+"\t"+"\t");
 								System.out.print(arr.get(k).getOption_yn()+"\t"+"\t"+"\t");
 								System.out.print(arr.get(k).getAccident_yn()+"\t"+"\t");
 								System.out.print(arr.get(k).getFuel_type()+"\t");
 								System.out.print(arr.get(k).getImport_date()+"\t"+"\t");
 								System.out.print(arr.get(k).getRent_gubun()+"\n");
 							}
 							System.out.println("===================================================================================================================================================================================");
 							break;
 						}else if(searchGubun == 2) {
 							System.out.println(" 제조사를 입력하시오. 현대[10]  기아[20]  르노삼성[30]  쌍용[40]  쉐보레[50]  벤츠[60]  BMW[70]  아우디[80]  테슬라[90]");
 							String carMade = sc.next();
 							ArrayList<Carinfo_dto> arr = dao.getListCar("car_made", carMade);
 							System.out.println("===================================================================================================================================================================================");
 							System.out.println("차량 등록 번호\t 모델명\t 차량 번호\t\t 제조사\t 차량 제조 연월\t 변속 기어 타입(자동:Y 수동:N)\t 옵션 여부(풀옵션:Y 일반:N)\t 사고 이력 (있으면Y, 없으면N)\t 연료구분\t 입고날짜\t\t 렌트여부(가능:Y 불가N)\t");
 							System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
 							for(int k = 0; k < arr.size(); k++) {
 								System.out.print(arr.get(k).getNo()+"\t"+"\t");
 								System.out.print(arr.get(k).getModel_name()+"\t");
 								System.out.print(arr.get(k).getCar_number()+"\t"+"\t");
 								System.out.print(arr.get(k).getCar_made()+"\t");
 								System.out.print(arr.get(k).getCar_made_ym()+"\t"+"\t");
 								System.out.print(arr.get(k).getAuto_yn()+"\t"+"\t"+"\t"+"\t");
 								System.out.print(arr.get(k).getOption_yn()+"\t"+"\t"+"\t");
 								System.out.print(arr.get(k).getAccident_yn()+"\t"+"\t");
 								System.out.print(arr.get(k).getFuel_type()+"\t");
 								System.out.print(arr.get(k).getImport_date()+"\t"+"\t");
 								System.out.print(arr.get(k).getRent_gubun()+"\n");
 							}
 							System.out.println("===================================================================================================================================================================================");
 							
 							break;
 						}else if(searchGubun == 3) {
 							System.out.println(" 모델명을 입력하시오. ");
 							String modelName = sc.next();
 							ArrayList<Carinfo_dto> arr = dao.getListCar("model_name", modelName);
 							System.out.println("===================================================================================================================================================================================");
 							System.out.println("차량 등록 번호\t 모델명\t 차량 번호\t\t 제조사\t 차량 제조 연월\t 변속 기어 타입(자동:Y 수동:N)\t 옵션 여부(풀옵션:Y 일반:N)\t 사고 이력 (있으면Y, 없으면N)\t 연료구분\t 입고날짜\t\t 렌트여부(가능:Y 불가N)\t");
 							System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
 							for(int k = 0; k < arr.size(); k++) {
 								System.out.print(arr.get(k).getNo()+"\t"+"\t");
 								System.out.print(arr.get(k).getModel_name()+"\t");
 								System.out.print(arr.get(k).getCar_number()+"\t"+"\t");
 								System.out.print(arr.get(k).getCar_made()+"\t");
 								System.out.print(arr.get(k).getCar_made_ym()+"\t"+"\t");
 								System.out.print(arr.get(k).getAuto_yn()+"\t"+"\t"+"\t"+"\t");
 								System.out.print(arr.get(k).getOption_yn()+"\t"+"\t"+"\t");
 								System.out.print(arr.get(k).getAccident_yn()+"\t"+"\t");
 								System.out.print(arr.get(k).getFuel_type()+"\t");
 								System.out.print(arr.get(k).getImport_date()+"\t"+"\t");
 								System.out.print(arr.get(k).getRent_gubun()+"\n");
 							}
 							System.out.println("===================================================================================================================================================================================");
 							
 							break;
 						}else if(searchGubun == 9) {
 							ArrayList<Carinfo_dto> arr = dao.getListAllCar();
 							System.out.println("===================================================================================================================================================================================");
 							System.out.println("차량 등록 번호\t 모델명\t 차량 번호\t\t 제조사\t 차량 제조 연월\t 변속 기어 타입(자동:Y 수동:N)\t 옵션 여부(풀옵션:Y 일반:N)\t 사고 이력 (있으면Y, 없으면N)\t 연료구분\t 입고날짜\t\t 렌트여부(가능:Y 불가N)\t");
 							System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
 							for(int k = 0; k < arr.size(); k++) {
 								System.out.print(arr.get(k).getNo()+"\t"+"\t");
 								System.out.print(arr.get(k).getModel_name()+"\t");
 								System.out.print(arr.get(k).getCar_number()+"\t"+"\t");
 								System.out.print(arr.get(k).getCar_made()+"\t");
 								System.out.print(arr.get(k).getCar_made_ym()+"\t"+"\t");
 								System.out.print(arr.get(k).getAuto_yn()+"\t"+"\t"+"\t"+"\t");
 								System.out.print(arr.get(k).getOption_yn()+"\t"+"\t"+"\t");
 								System.out.print(arr.get(k).getAccident_yn()+"\t"+"\t");
 								System.out.print(arr.get(k).getFuel_type()+"\t");
 								System.out.print(arr.get(k).getImport_date()+"\t"+"\t");
 								System.out.print(arr.get(k).getRent_gubun()+"\n");
 							}
 							System.out.println("===================================================================================================================================================================================");
 							
 							break;
 						}
 						
 						}while(searchGubun != 0);
 						
 						
 					}else if(gubun == 2) {
 						int overLapChk = 0;
 						String no = "";
 						String carNumber = "";
 						
 						do {
 						do {
 						do {
 						System.out.println(" 등록할 차량의 등록번호를 입력하시오 (C000). ");
 						no = sc.next();
 						if(no.indexOf("C") != 0) System.out.println(" 앞자리는 대문자 C로 시작합니다. ");
 						}while(no.indexOf("C") != 0);
 						if(no.length() != 4) System.out.println(" 대문자 C + 숫자 3자리를 입력하시오. ");
 						}while(no.length() != 4);
 						overLapChk = dao.getOverLapChk("no",no);
 						if(overLapChk == 1) System.out.println(" 중복된 차량등록 번호 입니다. ");
 						}while(overLapChk != 0);
 						
 							
 						System.out.println(" 등록할 차량의 모델명을 입력하시오. ");
 						String modelName = sc.next();
 						
 						
 						do {
 						System.out.println(" 등록할 차량의 번호를 입력하시오.(00가0000) ");
 						carNumber = sc.next();
 						overLapChk = dao.getOverLapChk("car_number",carNumber);
 						}while(overLapChk != 0);
 						
 						System.out.println(" 등록할 차량의 제조사를 입력하시오. 현대[10]  기아[20]  르노삼성[30]  쌍용[40]  쉐보레[50]  벤츠[60]  BMW[70]  아우디[80]  테슬라[90] ");
 						String carMade = sc.next();
 						
 						System.out.println(" 등록할 차량의 연식를 입력하시오.(yyyymm) ");
 						String carMadeYm = sc.next();
 						
 						System.out.println(" 등록할 차량은 자동인가요? 스틱인가요? 자동[Y] 스틱[N] ");
 						String autoYn = sc.next();
 						
 						System.out.println(" 등록할 차량은 풀옵션인가요? 일반 옵션인가요? 풀옵션[Y] 일반옵션[N] ");
 						String optionYn = sc.next();
 						
 						System.out.println(" 등록할 차량의 사고이력 여부를 입력하시오. 있으면[Y] 없으면[N] ");
 						String accidentYn = sc.next();
 						
 						System.out.println(" 등록할 차량의 연료는 무엇입니까? 가솔린[1]  디젤[2]  LPG[3]  전기[4]  ");
 						String fuelType = sc.next();
 						
 						System.out.println(" 등록할 차량의 입고 날짜를 입력하시오.(yyyy-mm-dd) ");
 						String importDate = sc.next();
 						
 						int result = dao.saveCar(no,modelName,carNumber,carMade,carMadeYm,autoYn,optionYn,accidentYn,fuelType,importDate);
 						
 						if(result == 1) {
 							System.out.println(" 등록 완료 ");
 						}else {
 							System.out.println(" 등록 실패 ");
 						}
 						
 						
 					}else if(gubun == 3) {
 						System.out.println(" 수정할 차량의 등록 번호를 선택하시오. ");
 						String no = sc.next();
 						ArrayList<Carinfo_dto> arr1 = dao.getUpdateList(no);
 						
 						System.out.println("===================================================================================================================================================================================");
						System.out.println("차량 등록 번호\t 모델명\t 차량 번호\t\t 제조사\t 차량 제조 연월\t 변속 기어 타입(자동:Y 수동:N)\t 옵션 여부(풀옵션:Y 일반:N)\t 사고 이력 (있으면Y, 없으면N)\t 연료구분\t 입고날짜\t\t 렌트여부(가능:Y 불가N)\t");
						System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
 						for(int k = 0; k < arr1.size(); k++) {
 							System.out.print(arr1.get(k).getNo()+"\t"+"\t");
								System.out.print(arr1.get(k).getModel_name()+"\t");
								System.out.print(arr1.get(k).getCar_number()+"\t"+"\t");
								System.out.print(arr1.get(k).getCar_made()+"\t");
								System.out.print(arr1.get(k).getCar_made_ym()+"\t"+"\t");
								System.out.print(arr1.get(k).getAuto_yn()+"\t"+"\t"+"\t"+"\t");
								System.out.print(arr1.get(k).getOption_yn()+"\t"+"\t"+"\t");
								System.out.print(arr1.get(k).getAccident_yn()+"\t"+"\t");
								System.out.print(arr1.get(k).getFuel_type()+"\t");
								System.out.print(arr1.get(k).getImport_date()+"\t"+"\t");
								System.out.print(arr1.get(k).getRent_gubun()+"\n");
 						}
 						System.out.println("===================================================================================================================================================================================");
							
						System.out.println(" 수정하시겠습니까 ? 예[Y] 아니오[N] ");	
						String response = sc.next();
						
						if(response.equals("y") || response.equals( "Y") || response.equals("ㅛ")) {
							for(int k = 0; k < arr1.size(); k++) {
							System.out.println(" 현재의 모델명 : " + arr1.get(k).getModel_name() + " ===> 수정하고자 하는 모델명은 ? " );
							String carModel = sc.next();
							
							System.out.println(" 현재의 차량번호 : " + arr1.get(k).getCar_number() + " ===> 수정하고자 하는 차량번호은 ? " );
							String carNumber = sc.next();
							
							System.out.println(" 현재의 제조사 : " + arr1.get(k).getCar_made() + 
									" ===> 수정하고자 하는 제조사명은 ? (현대[10]  기아[20]  르노삼성[30]  쌍용[40]  쉐보레[50]  벤츠[60]  BMW[70]  아우디[80]  테슬라[90])" );
							String carMade = sc.next();
							
							System.out.println(" 현재의 제조연월 : " + arr1.get(k).getCar_made_ym() + " ===> 수정하고자 하는 제조연월은 ? " );
							String carMadeYm = sc.next();
							
							System.out.println(" 현재의 자동[Y]/수동[N] : " + arr1.get(k).getAuto_yn() + " ===> 자동[Y]/수동[N]으로 수정 ? " );
							String autoYn = sc.next();
							
							System.out.println(" 현재의 옵션여부(풀옵션[Y]/일반[N]) : " + arr1.get(k).getOption_yn() + " ===> 수정하고자 하는 옵션여부는 ? " );
							String optionYn = sc.next();
							
							System.out.println(" 현재의 차량의 사고이력 : " + arr1.get(k).getAccident_yn() + " ===> 수정하고자 하는 사고이력은 ? (있으면[Y]/없으면[N]) " );
							String accidentYn = sc.next();
							
							System.out.println(" 현재의 차량의 연료종류 : " + arr1.get(k).getFuel_type() + " ===> 수정하고자 하는 연료종류는 ? (가솔린[1]  디젤[2]  LPG[3]  전기[4]) " );
							String fuelType = sc.next();
							
							System.out.println(" 현재의 입고일자 : " + arr1.get(k).getImport_date() + " ===> 수정하고자 하는 입고일자(YYYY-MM-DD)는 ? " );
							String importDate = sc.next();
							
							System.out.println(" 현재의 렌트가능여부 : " + arr1.get(k).getRent_gubun() + " ===> 렌트가능 여부(가능[Y]/불가능[N]) 수정 ? " );
							String rentGubun = sc.next();
							
							int result = dao.getUpdate(no, carModel,carNumber, carMade, carMadeYm, autoYn, optionYn, accidentYn, fuelType, importDate, rentGubun);
							
							if(result == 1) {
								System.out.println(" 수정 완료 ");
							}else {
								System.out.println(" 수정 실패 ");
							}
							
							}
						}
						
							
 					}else if(gubun == 4) {
 						System.out.println(" 삭제할 차량의 등록 번호를 선택하시오. ");
 						String no = sc.next();
 						ArrayList<Carinfo_dto> arr2 = dao.getDeleteList(no);
 						
 						System.out.println("===================================================================================================================================================================================");
						System.out.println("차량 등록 번호\t 모델명\t 차량 번호\t\t 제조사\t 차량 제조 연월\t 변속 기어 타입(자동:Y 수동:N)\t 옵션 여부(풀옵션:Y 일반:N)\t 사고 이력 (있으면Y, 없으면N)\t 연료구분\t 입고날짜\t\t 렌트여부(가능:Y 불가N)\t");
						System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
 						for(int k = 0; k < arr2.size(); k++) {
 							System.out.print(arr2.get(k).getNo()+"\t"+"\t");
								System.out.print(arr2.get(k).getModel_name()+"\t");
								System.out.print(arr2.get(k).getCar_number()+"\t"+"\t");
								System.out.print(arr2.get(k).getCar_made()+"\t");
								System.out.print(arr2.get(k).getCar_made_ym()+"\t"+"\t");
								System.out.print(arr2.get(k).getAuto_yn()+"\t"+"\t"+"\t"+"\t");
								System.out.print(arr2.get(k).getOption_yn()+"\t"+"\t"+"\t");
								System.out.print(arr2.get(k).getAccident_yn()+"\t"+"\t");
								System.out.print(arr2.get(k).getFuel_type()+"\t");
								System.out.print(arr2.get(k).getImport_date()+"\t"+"\t");
								System.out.print(arr2.get(k).getRent_gubun()+"\n");
 						}
 						System.out.println("===================================================================================================================================================================================");
							
						System.out.println(" 삭제하시겠습니까 ? 예[Y] 아니오[N] ");	
						String response = sc.next();
						
						if(response.equals("Y")||response.equals("y")||response.equals("ㅛ")) {
							int result = dao.getDelete(no);
							
							if(result == 1) {
								System.out.println(" 삭제 완료 ");
							}else {
								System.out.println(" 삭제 실패 ");
							}
						}
 					}
 					
 				}while(gubun != 0);
 			}else if(workGubun == 2) {
 				
 				int overlapCk = 0;
 				String rentNumber = "";
 				do {
 				do {
 				do {
 				System.out.println(" 렌트번호를 입력하시오.(R0000) ");
 				rentNumber = sc.next();
 				if(rentNumber.indexOf("R") != 0)System.out.println(" 대문자 R로 시작합니다. 다시 입력해주세요. ");
 				}while(rentNumber.indexOf("R") != 0);
 				if(rentNumber.length() != 5) System.out.println(" 대문자 R + 숫자 네자리를 입력해주세요. ");
 				}while(rentNumber.length() != 5);
 				overlapCk = dao3.getRentNoOverlapCheck(rentNumber);
 				if(overlapCk == 1) System.out.println(" 중복된 렌트번호 입니다. ");
 				}while(overlapCk != 0);
 				
 				
 				
 				int Yn = 0;
 				String memberId = "";
 				String carNumber = "";
 				
 				do {
 				System.out.println(" 렌트하는 사용자의 ID를 입력하시오.(B0000) ");
 				memberId = sc.next();
 				Yn = dao3.getCheckValue("id",memberId);
 				if(Yn == 0) System.out.println(" 존재하지 않는 회원 ID입니다. 다시 입력해주세요. ");
 				}while(Yn == 0);
 				
 				int overLapChkCarNm = 0;
 				do {
 				do {
 				System.out.println(" 렌트하고자 하는 차량의 번호를 입력하시오. (00가0000) ");
 				carNumber = sc.next();
 				Yn = dao3.getCheckValue("car_number",carNumber);
 				if(Yn == 0) System.out.println(" 존재하지 않는 차량 번호입니다. 다시 입력해주세요. ");
 				}while(Yn == 0);
 				overLapChkCarNm = dao3.getRentGubunOverLapCheck(carNumber);
 				if(overLapChkCarNm == 0) System.out.println(" 이미 렌트된 차량입니다. ");
 				}while(overLapChkCarNm != 1);
 				
 				System.out.println(" 렌트 시작날짜를 입력하시오. ('YYYY-MM-DD') ");
 				String rentDate = sc.next();
 				
 				System.out.println(" 반납 예정일을 입력하시오. ");
 				String returnScheDate = sc.next();
 				 				
 				int result = dao3.carRent(rentNumber, memberId, carNumber, rentDate, returnScheDate);
 				int rentResult = dao3.rentGubunChange(carNumber);
 				int rentResult2 = dao3.returnDateChangeToDefalut(carNumber);
 				
 				if(result == 1) {
 					System.out.println(" 렌트 완료 ");
 					
 					ArrayList<carRent_dto> arr5 = dao3.getViewRentList(rentNumber);
 					
 					System.out.println("======================================================================================================");
 					System.out.println("렌트번호\t  회원 ID\t  차 번호\t\t  대여날짜\t\t  반납예정일\t  ");
 					System.out.println("------------------------------------------------------------------------------------------------------");
 					
 					for(int k = 0; k < arr5.size(); k++) {
 						System.out.print(arr5.get(k).getRent_no()+"\t");
 						System.out.print(arr5.get(k).getMember_id()+"\t");
 						System.out.print(arr5.get(k).getCar_no()+"\t\t");
 						System.out.print(arr5.get(k).getRent_date()+"\t");
 						System.out.print(arr5.get(k).getReturn_sche_date()+"\n");
 					}
 					
 					System.out.println("======================================================================================================");
 					
 				}else {
 					System.out.println(" 렌트 실패 ");
 				}
 				
 				
 			}else if(workGubun == 3) {
 				int find = 0;
 				String carNumber = "";
 				
 				do {
 				System.out.println(" 대여하셨던 차량의 번호를 입력하시오. ");
 				carNumber = sc.next();
 				find = dao3.getSearch("car_no", carNumber);
 				if(find != 1) System.out.println(" 대여차량의 번호가 아닙니다. 다시입력해주세요 ");
 				}while(find != 1);
 				
 				System.out.println(" 반납날짜를 입력하시오. (YYYY-MM-DD) ");
 				String returnDate = sc.next();
 				
 				int resulte = dao3.getUpdateReturnDate(carNumber, returnDate);
 				
 				
 				ArrayList<carRent_dto> arr6 = dao3.getViewList(carNumber);
 				System.out.println("================================================================");
				System.out.println("렌트번호\t  회원 ID\t  차 번호\t\t  대여날짜\t\t  반납예정일\t  ");
				System.out.println("----------------------------------------------------------------");
 				for(int k = 0; k < arr6.size(); k++) {
 					System.out.print(arr6.get(k).getRent_no()+"\t");
 					System.out.print(arr6.get(k).getMember_id()+"\t");
 					System.out.print(arr6.get(k).getCar_no()+"\t\t");
 					System.out.print(arr6.get(k).getRent_date()+"\t");
 					System.out.print(arr6.get(k).getReturn_sche_date()+"\n");
 				}
 				System.out.println("==================================================================");
 				
 				System.out.println(" 입력하신 날짜에 반납하시겠습니까 ? 예[Y]  아니오[N] ");
 				String response = sc.next();
 				
 				if(response.equals("Y")||response.equals("y")||response.equals("ㅛ")) {
 					int result = dao3.removeRentNumber(carNumber);
 					int returntoback = dao3.getGubunReturn(carNumber);
 					if(result == 1 & returntoback == 1) {
 						System.out.println(" 반납 완료 ");
 						
 					}else {
 						System.out.println(" 반납 실패  ");
 					}
 				}else {}
 				
 				
 			}else if(workGubun == 4) {
 				
 				int find = 0;
 				String carNumber = "";
 				
 				do {
 				System.out.println(" 대여 이력을 조회할 차량의 차 번호를 입력하세요.(00가0000) ");
 				carNumber = sc.next();
 				find = dao3.getListRentedCarHistory("car_no",carNumber);
 				if(find != 1) System.out.println(" 입력하신 차량번호는 대여된 차량이 아닙니다. 다시 입력해주세요. ");
 				}while(find != 1);
 				
 				
 				ArrayList<carRent_dto> arr7 = dao3.getViewRentCarList(carNumber);
 				
 				System.out.println("==========================================================================================");
 				System.out.println(" 회원이름\t  차량번호\t\t  대여날짜\t\t  반납예정일\t\t\t  반납일\t\t ");
 				System.out.println("------------------------------------------------------------------------------------------");
 				for(int k = 0; k < arr7.size(); k++) {
 					System.out.print(arr7.get(k).getRent_no()+"\t");
 					System.out.print(arr7.get(k).getMember_id()+"\t\t");
 					System.out.print(arr7.get(k).getCar_no()+"\t");
 					System.out.print(arr7.get(k).getRent_date()+"\t\t");
 					System.out.print(arr7.get(k).getReturn_sche_date()+"\n");
 				}
 				System.out.println("==========================================================================================");
 				
 				
 			}else if(workGubun == 5) {
 				System.out.println(" 이름으로 조회[1]  전체조회[9]  종료[0]");
				int searchGubun = sc.nextInt();
					
				if(searchGubun == 1) {
						
				System.out.println(" 조회할 회원의 이름을 입력하시오. ");
				String name = sc.next();
						
				ArrayList<Memberinfo_dto> arr3 = dao2.getNameList(name);
				System.out.println("===============================================");
				System.out.println("ID\t  이름\t  주소\t  전화번호\t\t  나이\t ");
				System.out.println("-----------------------------------------------");
					
				for(int k = 0; k < arr3.size(); k++) {
					System.out.print(arr3.get(k).getId()+"\t");
					System.out.print(arr3.get(k).getName()+"\t");
					System.out.print(arr3.get(k).getAddress()+"\t");
					System.out.print(arr3.get(k).getTell()+"\t");
					System.out.print(arr3.get(k).getAge()+"\n");
							
					
					}
					System.out.println("===============================================");
				 							
				}else if(searchGubun == 9) {
				ArrayList<Memberinfo_dto> arr4 = dao2.getViewMemberList("");
						
				System.out.println("================================================================================================");
	 			System.out.println("ID\t  이름\t  주소\t  전화번호\t\t  나이\t ");
	 			System.out.println("------------------------------------------------------------------------------------------------");
						
				for(int k = 0; k < arr4.size(); k++ ) {
					System.out.print(arr4.get(k).getId()+"\t");
	 				System.out.print(arr4.get(k).getName()+"\t");
	 				System.out.print(arr4.get(k).getAddress()+"\t");
	 				System.out.print(arr4.get(k).getTell()+"\t");
	 				System.out.print(arr4.get(k).getAge()+"\n");
							}
					System.out.println("================================================================================================");
						}else {}
					
 			}
 			
 			
 		}while(workGubun != 0);
 			System.out.println(" 시스템 종료 ");
	
	
	}

}

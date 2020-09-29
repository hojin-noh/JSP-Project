package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0720_1_dao;
import dto.J0720_1_dto;

public class J0720_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0720_1_dao dao = new J0720_1_dao();
		ArrayList<J0720_1_dto> arr = new ArrayList();
		String no = "";
		System.out.println(" 몇 명 ? ");
		int count = sc.nextInt();
		
		for(int k = 0; k < count; k++) {
/*		System.out.println(" 사번은 ? ");
		String no = sc.next();  */
			
		if(arr.size() == 0)no = "S001" ;
		else no = dao.getMemberNo(arr.get(arr.size()-1).getNo());
		
		
		System.out.println(" 성명은 ? ");
		String name = sc.next();
		
		System.out.println(" 부서코드 입력 \n 총무: 1, 영업: 2, 인사: 3, 관리: 4 ");
		int code = sc.nextInt();
		
		System.out.println(" 직급코드 입력 \n 사원: 1, 대리: 2, 과장: 3, 부장: 4 ");
		int position = sc.nextInt();
		
		String departName = dao.getDepartName(code);
		String positionName = dao.getPositionName(position);
		int salaryMon = dao.getSalaryMon(position);
		int positionMoney = dao.getPostionMoney(salaryMon);
		int bonus = dao.getBonus(salaryMon);
		int salaryYear = dao.getSalaryYear(salaryMon, positionMoney, bonus);
		
		J0720_1_dto dto = new J0720_1_dto(no, name, departName, positionName, salaryMon, positionMoney, bonus, salaryYear);
		arr.add(dto);
		}
		
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getNo()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getDepart()+"\t");
			System.out.print(arr.get(k).getPosition()+"\t");
			System.out.print(dao.getSalaryMonDis(arr.get(k).getSalaryMon())+"\t");
			System.out.print(dao.getSalaryMonDis(arr.get(k).getPositionMoney())+"\t\t");
			System.out.print(dao.getSalaryMonDis(arr.get(k).getBonus())+"\t");
			System.out.print(dao.getSalaryMonDis(arr.get(k).getSalaryYear())+"\n");
		}
		
		
		sc.close();
		
		
	}

}

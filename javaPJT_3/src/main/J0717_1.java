package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.J0717_1_dao;
import dto.J0717_1_dto;

public class J0717_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		J0717_1_dao dao = new J0717_1_dao();
		ArrayList<J0717_1_dto> arr = new ArrayList();
		
		System.out.println(" 사번은 ? ");
		String no = sc.next();
		
		System.out.println(" 성명은 ? ");
		String name = sc.next();
		
		System.out.println(" 부서는 ? 총무: 1, 영업: 2, 인사: 3, 관리: 4 ");
		int depart = sc.nextInt();
		
		System.out.println(" 직급은 ? 사원: 1, 대리: 2, 과장: 3, 부장: 4 ");
		int position = sc.nextInt();
		
		String departName = dao.getDepartName(depart);
		String positionName = dao.getPositionName(position);
		int moneyName = dao.getMoney(position);
		int positionMoney = dao.getPositionMoney(moneyName);
		
		
		J0717_1_dto dto = new J0717_1_dto(no, name, positionName, departName, moneyName, positionMoney);
		arr.add(dto);
				
			
	
		for(int k = 0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getNo()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getDepart()+"\t");
			System.out.print(arr.get(k).getPosition()+"\t");
			System.out.print(dao.getMoneyDis(arr.get(k).getMoney())+"\t");
			System.out.print(dao.getMoneyDis(arr.get(k).getPositionMoney())+"\n");
		}
		sc.close();
	}
}

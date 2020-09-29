package main;

import java.util.ArrayList;

public class J0714 {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();						
		arr.add("AAA");
		arr.add("BBB");												//배열에 값을 넣을 때
		arr.add("CCC");
		System.out.println("===: "+ arr.get(0));
		System.out.println("===: "+ arr.get(1));
		System.out.println("===: "+ arr.get(2));
		
		
		for(int k =0; k < arr.size(); k++) {						//배열의 크기를 구할 때 배열.size()
			System.out.println("=for==: "+ arr.get(k));
			}
		
		arr.remove(1);											//원하는 위치 값 삭제할 때
		for(int k =0; k < arr.size(); k++) {
			System.out.println("=remove==: "+ arr.get(k));
			}
		
		arr.add(1, "bbb");											//원하는 위치에 값 넣을 때
		for(int k =0; k < arr.size(); k++) {
			System.out.println("=끼워넣기==: "+ arr.get(k));
			}
		
		arr.clear();												//값 모두 지울때
		System.out.println("==clear==:" + arr.size());
		
		arr.add("A");
		arr.add("B");
		for(int k =0; k < arr.size(); k++) {
			System.out.println("===: "+ arr.get(k));
			}
		
		arr.set(1, "CCC");											//값 바꿀때
		for(int k =0; k < arr.size(); k++) {
			System.out.println("==set==: "+ arr.get(k));
			}
		
		
		
		
		
		
	}
}

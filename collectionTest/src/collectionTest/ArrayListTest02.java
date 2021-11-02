https://velog.io/@vgo_dongv/Java-equals%EC%99%80-hashCod-%EC%9E%AC%EC%A0%95%EC%9D%98

package collectionTest;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("이름1을 입력");
//		String name1=sc.nextLine();
//		System.out.println("이름2을 입력");
//		String name2=sc.nextLine();
//		System.out.println("이름3을 입력");
//		String name3=sc.nextLine();
//		System.out.println("이름4을 입력");
//		String name4=sc.nextLine();
//		System.out.println("이름5을 입력");
//		String name5=sc.nextLine();
//		
//		
	
//		list.add(name1);
//		list.add(name2);
//		list.add(name3);
//		list.add(name4);
//		list.add(name5);
		
		ArrayList<String> list = new ArrayList<>();
		for(int i=1; i<5; i++){
			System.out.println(i+"번째 사람 이름:");
			String name = sc.next();
			list.add(name);
			
		}
		
		for(int i=0; i<list.size(); i++){
		if(list.get(i).charAt(0) =='김'){
			System.out.println("성이 김씨인 이름:" + list.get(i));
		}
		}
		
		System.out.println("-------------------------------------");
		for(int i=0; i<list.size(); i++){
		if(list.get(i).substring(0,1).equals("김")){ //0,1인이유는 1이아니라 1앞까지만 자르기때문!
			System.out.println("성이 김씨인 이름:" + list.get(i));
		}
		}
		
		System.out.println("-------------------------------------");
		for(int i=0; i<list.size(); i++){
			if(list.get(i).indexOf("김")==0){
				System.out.println("성이 김씨인 이름:" + list.get(i));
			}
			}
		
		System.out.println("-------------------------------------");
		for(int i=0; i<list.size(); i++){
			if(list.get(i).startsWith("김")){
				System.out.println("성이 김씨인 이름:" + list.get(i));
			}
			}
		
		
		
		
		
		
		
		
	}

}

package collectionTest;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("�̸�1�� �Է�");
//		String name1=sc.nextLine();
//		System.out.println("�̸�2�� �Է�");
//		String name2=sc.nextLine();
//		System.out.println("�̸�3�� �Է�");
//		String name3=sc.nextLine();
//		System.out.println("�̸�4�� �Է�");
//		String name4=sc.nextLine();
//		System.out.println("�̸�5�� �Է�");
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
			System.out.println(i+"��° ��� �̸�:");
			String name = sc.next();
			list.add(name);
			
		}
		
		for(int i=0; i<list.size(); i++){
		if(list.get(i).charAt(0) =='��'){
			System.out.println("���� �达�� �̸�:" + list.get(i));
		}
		}
		
		System.out.println("-------------------------------------");
		for(int i=0; i<list.size(); i++){
		if(list.get(i).substring(0,1).equals("��")){ //0,1�������� 1�̾ƴ϶� 1�ձ����� �ڸ��⶧��!
			System.out.println("���� �达�� �̸�:" + list.get(i));
		}
		}
		
		System.out.println("-------------------------------------");
		for(int i=0; i<list.size(); i++){
			if(list.get(i).indexOf("��")==0){
				System.out.println("���� �达�� �̸�:" + list.get(i));
			}
			}
		
		System.out.println("-------------------------------------");
		for(int i=0; i<list.size(); i++){
			if(list.get(i).startsWith("��")){
				System.out.println("���� �达�� �̸�:" + list.get(i));
			}
			}
		
		
		
		
		
		
		
		
	}

}

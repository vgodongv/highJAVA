package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/*
 	Vector, Hashtable�� �������� �����ϴ� Collection ��ü���� ���ο� ����ȭ ó���� �Ǿ� �ִ�.
 	�ֱٿ� ���� ������ Collection ��ü���� ����ȭ ó���� �Ǿ����� �ʴ�. �׷��� ����ȭ�� �ʿ��� ���α׷����� 
 	�̷� Collection���� ����Ϸ��� ����ȭ ó���� �� �Ŀ� ����ؾ� �Ѵ�.
 	
 */

public class ThreadTest18 {
	private static Vector<Integer> vec = new Vector<>();
	
	
	// ����ȭ ó���� ���� ���� list
	private static ArrayList<Integer> list1 = new ArrayList<>();
	
	// ����ȭ ó���� �� list
	private static List<Integer> list2 = Collections.synchronizedList(new ArrayList<Integer>());
	
	public static void main(String[] args) {
		
		// �͸� ����ü�� ������ ����
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<10000; i++){
					// vec.add(i);
					// list1.add(i);
					list2.add(i);
				}
				
			}
		};
		
		Thread[] thArr = new Thread[]{
			new Thread(r),	new Thread(r),	new Thread(r),	
			new Thread(r),	new Thread(r)
		};
		
		for(Thread th: thArr){
			th.start();
		}
		
		for(Thread th: thArr){
		
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		}
		
		// System.out.println("vec�� ����: "+vec.size());
		// System.out.println("list1�� ����: "+list1.size());
		 System.out.println("list2�� ����: "+list2.size());
		
	}

}

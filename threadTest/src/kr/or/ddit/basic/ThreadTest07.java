package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest07 {

	public static void main(String[] args) {
		// ����ڷκ��� ������ �Է¹ޱ� 
		String str = JOptionPane.showInputDialog("�ƹ��ų� �Է��ϼ���");
		System.out.println("�Է°�: "+ str);
		
		
		for(int i=10; i>=1; i--){
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
		

	}

}

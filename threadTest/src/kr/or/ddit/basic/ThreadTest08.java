package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest08 {

	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();

	}

}

// �����͸� �Է��ϴ� ������
class DataInput extends Thread{
	
	// �Է� ���θ� Ȯ���ϱ� ���� ���� ����. �����忡�� �������� ����� ����
	public static boolean inputCheck = false;
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("�ƹ��ų� �Է��ϼ���");
		inputCheck = true; //�Է��� �Ϸ�Ǹ� true�� ����
		System.out.println("�Է°�: "+ str);
	}
}

// ī��Ʈ �ٿ��� �����ϴ� ������

class CountDown extends Thread{
	@Override
	public void run() {
		for(int i=10; i>=1; i--){
			System.out.println(i);
			// �Է��� �Ϸ�Ǿ����� ���θ� �˻��ؼ� �Է��� �Ϸ�Ǹ� �����带 �����Ų��. 
			if(DataInput.inputCheck==true){
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		
		System.out.println("10�ʰ� �������ϴ�. ���α׷��� �����մϴ�.");
		System.exit(0);

	}
}

package kr.or.ddit.basic;



import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
 
 	��ǻ�Ϳ� ���� ���� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 	
 	��ǻ���� ���� ���� ���� ������ �̿��ؼ� ���ϰ�
 	������� ���� ���� ���� showInputDialog()�޼��带 �̿��ؼ� �Է¹޴´�.
 	
 	�Է½ð��� 5�ʷ� �����ϰ� ī��Ʈ �ٿ��� �Ѵ�.
 	5�ʾȿ� �Է��� ������ ���ӿ� �������� ó���� �� ������.
 	
 	5�ʾȿ� �Է��� ������ ���и� ���ؼ� ����Ѵ�.
 	
 	�������
 	1) 5�ʾȿ� �Է��� �Ϸ�Ǿ��� ��
 	-- ��� -- 
 	��ǻ�� : ����
 	����� : ����
 	���: ����� �̰���ϴ�.
 	
 	2) 5�ʾȿ� �Է¸����� ���
 	-- ��� -- 
 	�ð��ʰ��� ����� �����ϴ�.

 	
 */

public class ThreadTest09 {

	
	
	public static void main(String[] args) {
		Thread th1 = new Input();
		Thread th2 = new Count();
		
		th1.start();
		th2.start();

	}

}

class Count extends Thread{	
	
	@Override
	public void run() {
		for(int i=5; i>=1; i--){
			System.out.println(i);
			// �Է��� �Ϸ�Ǿ����� ���θ� �˻��ؼ� �Է��� �Ϸ�Ǹ� �����带 �����Ų��. 
			if(Input.inputCheck==true){
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		
		System.out.println("5�ʰ� �������ϴ�. �ð��ʰ��� ����� �����ϴ�.");
		System.exit(0);

	}
}



//�����͸� �Է��ϴ� ������
class Input extends Thread{
	
	// �Է� ���θ� Ȯ���ϱ� ���� ���� ����. �����忡�� �������� ����� ����
	public static boolean inputCheck = false;
	
	@Override
	public void run() {
		ArrayList<String> list = new ArrayList<>();
		list.add("����");
		list.add("����");
		list.add("��");
		
		int num= (int)Math.random()*3;
		
		
		String str = JOptionPane.showInputDialog("����, ����, ���� �Է����ּ���");
		inputCheck = true; //�Է��� �Ϸ�Ǹ� true�� ����
		System.out.println("--���--");
		System.out.println("��ǻ��: "+list.get(num));
		System.out.println("�����: "+ str);
		
//		if(list.get(num).equals(str)){
//			System.out.println("�����ϴ�.");
//		}else if(list.get(num).equals("����")&&str.equals("����")){
//			System.out.println("�̰���ϴ�.");
//		}else if(list.get(num).equals("����")&&str.equals("��")){
//			System.out.println("�̰���ϴ�.");
//		}else if(list.get(num).equals("��")&&str.equals("����")){
//			System.out.println("�̰���ϴ�.");
//		}else{
//			System.out.println("�����ϴ�.");
//		}
		
		if(list.get(num).equals(str)){
			System.out.println("�����ϴ�.");
		}else if((list.get(num).equals("����")&&str.equals("����"))||
				(list.get(num).equals("����")&&str.equals("��"))||
				(list.get(num).equals("��")&&str.equals("����"))){
			System.out.println("�̰���ϴ�.");
			
		}else{
			System.out.println("�����ϴ�.");
		}
		
		
		
	}
}



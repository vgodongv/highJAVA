package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest09_2 {

	public static void main(String[] args) {
		GameTimer gt = new GameTimer();
		
		// ������ �̿��ؼ� ��ǻ���� ���� ���� �� ���ϱ�
		String[] data = {"����","����","��"}; // index : 0~2
		int index = (int)(Math.random()*3); //0~2������ ����
		String com = data[index];
		
		// ������� ���� ���� �� �Է¹ޱ�
		gt.start();
		
		String man = JOptionPane.showInputDialog("������������ �Է��ϼ���");
		GameTimer.inputCheck = true;
		
		// ��� �����ϱ�
		String result = ""; //����� ����� ����
		if(com.equals(man)){
			result="�����ϴ�.";
			System.out.println("�����ϴ�.");
		}else if((man.equals("����")&&com.equals("��")) ||
				  (man.equals("����")&&com.equals("����"))||
				  (man.equals("��")&&com.equals("����"))){ //���� �̱�ɷ� ����_����� ����
			result = "����� �̰���ϴ�.";
			
		}else{
			result= "����� �����ϴ�.";
		}
			//������
		System.out.println("-- ��� --");
		System.out.println("��ǻ��:"+com);
		System.out.println("�����:"+man);
		System.out.println("�� ��:"+result);

	}

}

// ī��Ʈ �ٿ� ������
class GameTimer extends Thread{
	public static boolean inputCheck = false;
	
	@Override
	public void run() {
		System.out.println("ī��Ʈ �ٿ� ����");
		
		for(int i=5; i>0; i--){
			if(inputCheck==true){
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
		
		System.out.println("-- ��� --");
		System.out.println("�ð��ʰ��� ����� �����ϴ�.");
		System.exit(0);
		
	}
	
}

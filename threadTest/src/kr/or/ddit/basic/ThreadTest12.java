package kr.or.ddit.basic;


/*
 	3���� �����尡 ���� ���ĺ� A~Z���� ����ϴµ�
 	����� ���� ������� ����� ��Ÿ���� ���α׷� �ۼ��ϱ�
 	
 
 */
public class ThreadTest12 {

	public static void main(String[] args) {
		DisplayCharacter[] ths = new DisplayCharacter[]{
			new DisplayCharacter("ȫ�浿"),
			new DisplayCharacter("�̼���"),
			new DisplayCharacter("������")
		
		};
		
		for(DisplayCharacter dc : ths){
			dc.start();
		}
		
		for(DisplayCharacter dc : ths){
			try {
				dc.join(); // ��� ��Ⱑ ���������� ��ٸ���.
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
	System.out.println();
	System.out.println("�����");
	System.out.println("����: "+ DisplayCharacter.setRank);
	}

}

// A~Z���� ����ϴ� ������
class DisplayCharacter extends Thread{
	public static String setRank = "";
	private String name;
	
	// ������
	public DisplayCharacter(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(char ch='A'; ch<='Z'; ch++){
			System.out.println(name+"�� ��� ����: "+ ch);	
			try {
				// 0~499������ ���������� �Ͻ����� ��Ų��.
			Thread.sleep((int)(Math.random()*500)); // 0~500
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println(name+" ��� ��");
		
		// ����� ���� ������� �̸��� ��ġ�Ѵ�.
		DisplayCharacter.setRank += name+" ";
	}
}

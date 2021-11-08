package kr.or.ddit.basic;

// ���� ������ ���� : �ڵ� �����ϴ� ������ �����

public class ThreadTest06 {

	public static void main(String[] args) {
		AutoSaveThread autoSave = new AutoSaveThread();
		
		// ���� ������� �����ϱ�: �ݵ�� setart()�޼��� ȣ������ �����Ѵ�.
		autoSave.setDaemon(true); //���� �����尡 �ƴ϶� �׳� ������� ����� ���ѹݺ�
		
		autoSave.start();
		
		try {
			
			for(int i=1; i<=20; i++){
				System.out.println(i);
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("main ������ �۾� ��");

	}

}

// �ڵ� �����ϴ� ������ �ۼ� (3�ʿ� �ѹ��� �ڵ� �����ϱ�)
class AutoSaveThread extends Thread{
	
	// �۾� ������ �����ϴ� �޼���
	public void save(){
		System.out.println("�۾� ������ �����մϴ�.");
		
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(3000); //3�ʿ� �ѹ��� �ڵ� ����
			} catch (InterruptedException e) {
				
			}
			save();
		}
	}
}

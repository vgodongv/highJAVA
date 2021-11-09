package kr.or.ddit.basic;

// yield() �޼��� ����

public class ThreadTest11 {

	public static void main(String[] args) {
		YieldThread th1 = new YieldThread("1�� ������");
		YieldThread th2 = new YieldThread("2�� ������");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("-------------------1������");
		th1.work = false;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			
		}
		System.out.println("-------------------2������");
		
		th1.work = true;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			
		}
		System.out.println("-------------------3������");
		th1.stop = true;
		th2.stop = true;
		
	}

}

// yield() �޼��� ������ ������
class YieldThread extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	public YieldThread(String name){
		super(name); // �������� �̸� �����ϱ�. super �θ� �������� ������ : Thread��ü. Thread��ü���� name�̶�� �Ӽ�������. �������̸��� �����
	}
	
	@Override
	public void run() {
		while(!stop){ // stop���� true�̸� �ݺ��� Ż��
			if(work){
				// getName()�޼���: ������ �̸�(name�Ӽ���) ��ȯ
				System.out.println(getName()+"�۾���...");
			}else{
				System.out.println(getName()+ "�纸...");
				Thread.yield();
			}
			
		}
	}
}

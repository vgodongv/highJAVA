package kr.or.ddit.basic;

 /*
  	Thread�� stop()�޼��带 ȣ���ϸ� �����尡 �ٷ� �����.
  	�� �� ����ϴ� �ڿ��� �������� ���ϰ� ���α׷��� ����Ǿ� �� �Ŀ� ����Ǵ� ���α׷��� ������ �� �� �ִ�. 
  	�׷��� stop()�޼���� ����õ���� �Ǿ� �ִ�.
  */

public class ThreadTest14 {

	public static void main(String[] args) {
	/*	ThreadStopTest1 th1 = new ThreadStopTest1();
		th1.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		//th1.setStop(true);
		th1.stop();
	*/
		ThreadStopTest2 th2= new ThreadStopTest2();
		th2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		th2.interrupt(); //1���� ����
	}

}

// �����带 ���߰� �ϴ� ������ ������
class ThreadStopTest1 extends Thread{
	private boolean stop; //false
	
	public void setStop(boolean stop){
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop){
			System.out.println("������ ���� ��");
			
		}
		System.out.println("�ڿ�����");
		System.out.println("������ ����");
	}
	
	
}

// interrupt() �޼��带 �̿��Ͽ� �����带 ���߰��ϴ� ���
class ThreadStopTest2 extends Thread{
		
	@Override
	public void run() {
		// ���1: interrupt() �޼����, sleep()�޼��带 �̿��ϴ� ���
		/*try {
			while(true){
				System.out.println("������");
				
				Thread.sleep(1); //�Ͻ� ���� ���¿��� interrupt()�޼��尡 ����Ǹ� imterruptedException�� �߻��Ѵ�.
			}
			
		} catch (InterruptedException e) {
			
		}*/
		
		// ���2:interrupt() �޼��尡 ȣ��Ǿ����� �˻��ϴ� ���
		while(true){
			System.out.println("������");
			// interrupt() �޼��尡 ȣ��Ǿ����� �˻�.
			// �˻���1: Thread�� �ν��Ͻ� �޼����� isInterrupted()�� �̿��Ͽ� �˻��ϱ�
			// - isInterrupted()�޼���� interrupt()�޼��尡 ȣ��Ǹ� true�� ��ȯ�Ѵ�.
			/*if(this.isInterrupted()==true){
				break;
			}*/
			
			// �˻���2: Thread�� �����޼����� interrupted�޼��带 �̿��Ͽ� �˻�
			// interrupt()�޼��尡 ȣ��Ǹ� true�� ��ȯ�Ѵ�.
			if(Thread.interrupted()){
				break;
			}
		}
		
		System.out.println("�ڿ� ������");
		System.out.println("������ ����");
		
	}
	
	
	
}


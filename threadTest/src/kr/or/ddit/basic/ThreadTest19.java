package kr.or.ddit.basic;

/*
  	wait(). notify()�� �̿��ؼ� �� �����尡 ������ �ѹ��� �����ϴ� ����
  	
  	wait(), notify(), notifyAll()�� ����ȭ ���������� ��밡���ϴ�.
  	
  	
 */
public class ThreadTest19 {

	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();

	}

}

// �������� ����� Ŭ����
class WorkObject{
	
	public synchronized void methodA(){
		System.out.println("methodA() ���� ������");
		
		notify(); //notify()�� ����������: ������ ������ �����尡����
		
		try {
			wait(); //wait ������ try�� ���������
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("methodA() ���� ������");
	}
	
	public synchronized void methodB(){
		System.out.println("methodB() ���� ������");
		
		notify();
		
		try {
			wait(); //wait ������ try�� ���������
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("methodB() ���� ������");
	
	}
}

// WorkObject�� methodA()�� ȣ���ϴ� ������
class ThreadA extends Thread{
	private WorkObject workObj;

	// ������
	public ThreadA(WorkObject workObj) {
		super();
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++){	
			workObj.methodA();
		}
		synchronized (workObj) {
			workObj.notify();
		}
	}
	
}

//WorkObject�� methodB()�� ȣ���ϴ� ������
class ThreadB extends Thread{
	private WorkObject workObj;

	// ������
	public ThreadB(WorkObject workObj) {
		super();
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++){	
			workObj.methodB();
		}
		synchronized (workObj) {
			workObj.notify();
		}
	}
	
}







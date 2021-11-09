package kr.or.ddit.basic;

public class ThreadTest16 {

	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		TestThread th1 = new TestThread("1��������", sObj);
		TestThread th2 = new TestThread("2��������", sObj);
		
		th1.start();
		th2.start();
		

	}

}

// �������� ����� Ŭ����
class ShareObject{
	private int sum = 0;
	
	// ����ȭ ó���ϱ�
	
	// public synchronized void add(){  ���1 : �޼��忡 ����ȭ �����ϱ�
	public void add(){
		synchronized(this){ // ���2 : ����ȭ������ �����ϱ�
		int n = sum;
		n+= 10;
		
		sum = n;
		
		System.out.println(Thread.currentThread().getName()+"�հ�: "+ sum);
		
		}
	}
	
}

class TestThread extends Thread{
	private ShareObject sObj;
	
	public TestThread(String name, ShareObject sObj){
		super(name);
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++){
			sObj.add();
		}
	}
}







package kr.or.ddit.basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		// �����尡 ����Ǵ� �ð� üũ�ϱ�
		
		Thread th = new Thread(new MyRunner2());
		
		// 1970�� 1�� 1�� 0��0��0��(ǥ�ؽð�)�� ���� ����� �ð��� �и������� ����(1/1000��)�� ��ȯ�Ѵ�.
		long startTime = System.currentTimeMillis();
		
		th.start();
		
		try {
			th.join(); // ���� �������� �����忡�� ����� �Ǵ� ������(���⼭�� ���� th)�� ����� ������ ��ٸ���.
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("��� �ð�: "+ (endTime - startTime)); 
		// try catch ���ϸ� ����ð� �ȳ��� -> start()�� ������ �����غ����. ������ȯ���� ����� ���ุ ����.
		// start()������ ������� ���ư��� ��. 
		
		
	}

}

class MyRunner2 implements Runnable{
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i=1; i<=1_000_000_000L; i++){
			sum+= i;
		}
		System.out.println("�հ�: " + sum);
	}
	
}



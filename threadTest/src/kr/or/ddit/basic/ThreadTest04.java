package kr.or.ddit.basic;

/*
  1 ~ 20������� �հ踦 ���ϴ� ���α׷� �ۼ��ϱ�

  - �� �۾��� �ϳ��� �����尡 �ܵ����� ó���ϴ� ����  �������� �����尡 �����ؼ� ó���� ���� ����ð��� ���غ���.
 */

public class ThreadTest04 {

	public static void main(String[] args) {
		// �ܵ����� ó���ϴ� ����� ������ ����
		SumThread sm = new SumThread(1L, 2_000_000_000L);
		
		// �����ؼ� ó���ϴ� ������ ���� (4���� ������ ��ü ����)
		SumThread[] smArr = new SumThread[]{
				
				new SumThread(           1L,    500_000_000L),
				new SumThread(  500_000_001L, 1_000_000_000L),
				new SumThread(1_000_000_001L, 1_500_000_000L),
				new SumThread(1_500_000_001L, 2_000_000_000L)
				
		};
		
		//�ܵ����� ó���ϱ�
		
		long startTime = System.currentTimeMillis();
		sm.start();
		
		try {
			sm.join();
		} catch (InterruptedException e) {
			
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("�ܵ����� ó���Ҷ� ����ð�: "+ (endTime - startTime));
		
		System.out.println();
		System.out.println();
		
		// ���� �����尡 �����ؼ� ó���ϴ� ���
		startTime = System.currentTimeMillis();
		
		for(SumThread s : smArr){
			s.start();
		}
		
		for(int i=0; i<smArr.length; i++){
			
			try {
				smArr[i].join();
			} catch (InterruptedException e) {
				
			}
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("�����ؼ� ó���� ��� �ð�: "+ (endTime - startTime));
	}

}

class SumThread extends Thread{
	// �հ踦 ���� ������ ���۰��� ���ᰪ�� ����� ���� ����
	private long min, max;
	
	public SumThread(long min, long max) {
		this.min =min;
		this.max = max;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		
		for(long i=min; i<=max; i++){
			sum += i;
		}
		
		System.out.println("�հ�: " + sum);
		
		
	}
}

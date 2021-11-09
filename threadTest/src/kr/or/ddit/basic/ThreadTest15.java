package kr.or.ddit.basic;

// �����忡�� ��ü�� �������� ����ϴ� ����

/*
 	������(pi)�� ����ϴ� ������� ���� �������� ����ϴ� �����尡 �ִ�.
 	
 	�������� �����ϴ� ��ü�� �ʿ��ϴ�.
 	�� ��ü�� �� �����尡 �������� ����ؼ� ó���Ѵ�.
 */
public class ThreadTest15 {

	public static void main(String[] args) {
		// �������� ����� ��ü ����
		ShareData sd = new ShareData();
		
		// ������ ��ü�� �����ϰ� �������� ����� ��ü�� �����忡 �����Ѵ�.
		CalcPIThread ct = new CalcPIThread();
		ct.setSd(sd);
		
		PrintPIthread pt = new PrintPIthread(sd);
		
		ct.start();
		pt.start();

	}

}

//�������� �����ϴ� Ŭ���� �ۼ�(�������� ����� Ŭ����)
class ShareData{
	public double result; // ���� �������� ����� ����
	public boolean isOk=false; // ����� �Ϸ�Ǿ������� ��Ÿ���� ����
}

//�������� ����ϴ� ������
class CalcPIThread extends Thread{
	private ShareData sd;
	
	// setter
	public void setSd(ShareData sd){
		this.sd = sd;
	}
	
	@Override
	public void run() {
		/* ������ ���
		 ������ = (1/1- 1/3 +1/5 -1/7 +1/9 -1/11...) * 4;
		 1 - 3 + 5 - 7 + 9 - 11...
		 
		 0  1  2  3  4  5 
		 
		 ���ڰ��� 2�γ��� ���� ¦���϶��� + Ȧ���϶���-
		 
		 
		 */
		double sum = 0.0;
		for(int i=1; i<=100000000; i+=2){
			if( (i/2) % 2 == 0 ){ // ���� ¦���� ���
				sum += (1.0/i);
			}else{
				sum-=(1.0/i);
			}
		}
		
		sd.result = sum * 4; // ����� �Ϸ�� ���� ���밴ü�� �����Ѵ�.
		sd.isOk = true;
		
	}
	
}

//����� �Ϸ�Ǹ� ���� �������� ����ϴ� ������
class PrintPIthread extends Thread{
	private ShareData sd;
	
	// ������
	public PrintPIthread(ShareData sd){
		this.sd = sd;
	}
	
	@Override
	public void run() {
		while(true){
			if(sd.isOk==true){
				break;
			}
			Thread.yield();
		}
		
		System.out.println();
		System.out.println("���:"+sd.result);
		System.out.println("PI: "+Math.PI);
		
	}
}















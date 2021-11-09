package kr.or.ddit.basic;

// ������ ������� ������� ó���ϴ� ����(����ȭ ó������)

public class ThreadTest17 {
	private int balance; // �ܾ��� ����� ����
	
	public int getBalance(){
		return balance;
	}
	
	public void setBalance(int balance){
		this.balance = balance;
	}
	
	// ����ϴ� �޼��� (��� ������ ��ȯ�� true, �����ϸ� false)
	//public synchronized boolean withdraw(int money){ // �޼��忡 synchronized
	public  boolean withdraw(int money){ //����ȭ ��Ͼ���
		synchronized(this){
		if(balance>=money){
			for(int i=1; i<=100_000_000; i++){} // �ð� ������
			balance -= money;	
			System.out.println("�޼��� �ȿ��� balance ="+ balance);
			return true;	
		}else{
			return false;
		}
		}
	}
	
	// �Ա��ϴ� �޼���
	public void deposit(int money){
		balance += money;
	}
	public static void main(String[] args) {
		final ThreadTest17 acount = new ThreadTest17();
		acount.setBalance(10000); // �ܾ��� �������� �����Ѵ�.
		
		// �͸���ü�� ������ �����
		Runnable test = new Runnable(){
			
			@Override
			public void run() {
				boolean result = acount.withdraw(6000); // 6000�� ���
				
				System.out.println("�����忡�� result = "+ result+ ", balance= "+ acount.getBalance());
			}
			
		};
		
		
		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);
		
		th1.start();
		th2.start();

	}

}

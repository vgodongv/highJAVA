package kr.or.ddit.basic;

// 은행의 입출금을 스레드로 처리하는 예제(동기화 처리예제)

public class ThreadTest17 {
	private int balance; // 잔액이 저장될 변수
	
	public int getBalance(){
		return balance;
	}
	
	public void setBalance(int balance){
		this.balance = balance;
	}
	
	// 출금하는 메서드 (출금 성공시 반환값 true, 실패하면 false)
	//public synchronized boolean withdraw(int money){ // 메서드에 synchronized
	public  boolean withdraw(int money){ //동기화 블록쓰기
		synchronized(this){
		if(balance>=money){
			for(int i=1; i<=100_000_000; i++){} // 시간 지연용
			balance -= money;	
			System.out.println("메서드 안에서 balance ="+ balance);
			return true;	
		}else{
			return false;
		}
		}
	}
	
	// 입급하는 메서드
	public void deposit(int money){
		balance += money;
	}
	public static void main(String[] args) {
		final ThreadTest17 acount = new ThreadTest17();
		acount.setBalance(10000); // 잔액을 만원으로 설정한다.
		
		// 익명구현체로 스레드 만들기
		Runnable test = new Runnable(){
			
			@Override
			public void run() {
				boolean result = acount.withdraw(6000); // 6000원 출금
				
				System.out.println("스레드에서 result = "+ result+ ", balance= "+ acount.getBalance());
			}
			
		};
		
		
		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);
		
		th1.start();
		th2.start();

	}

}

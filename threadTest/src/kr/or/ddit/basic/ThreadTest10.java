package kr.or.ddit.basic;

// 스레드의 상태를 출력하는 예제

public class ThreadTest10 {

	public static void main(String[] args) {
		StatePrintThread th = new StatePrintThread(new TargetThread());
		th.start();

	}

}

// 스레드 상태의 검사 대상이되는 스레드
class TargetThread extends Thread{
	@Override
	public void run() {
		
		for(long i=1L; i<=20_000_000_000L; i++){} //시간 지연용_RUNNABLE
			
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
		
		}
		
		for(long i=1L;  i<=20_000_000_000L; i++){}
			
		
	}
}

// TargetThread의 상태를 검사하고 출력하는 스레드
class StatePrintThread extends Thread{
	private TargetThread target;
	
	// 생성자 : TargetThread 초기화
	public StatePrintThread(TargetThread target){
		this.target = target;
	}
	
	@Override
	public void run() {
		while(true){
			// 스레드의 현재 상태값 구하기 
			Thread.State state = target.getState();
			
			System.out.println("TargetThread의 현재 상태값: "+ state);
			
			if(state == Thread.State.NEW){ // 스레드가 new 상태이면
				target.start();
			}
			
			if(state == Thread.State.TERMINATED){ // 스레드가 종료 상태면
				break;
			}
			
			try {
				Thread.sleep(500); 
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	}
}











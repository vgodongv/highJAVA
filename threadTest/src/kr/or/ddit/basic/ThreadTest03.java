package kr.or.ddit.basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		// 스레드가 수행되는 시간 체크하기
		
		Thread th = new Thread(new MyRunner2());
		
		// 1970년 1월 1일 0시0분0초(표준시간)로 부터 경과한 시간을 밀리세컨드 단위(1/1000초)로 반환한다.
		long startTime = System.currentTimeMillis();
		
		th.start();
		
		try {
			th.join(); // 현재 실행중인 스레드에서 대상이 되는 스레드(여기서는 변수 th)가 종료될 때까지 기다린다.
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과 시간: "+ (endTime - startTime)); 
		// try catch 안하면 경과시간 안나옴 -> start()의 역할을 생각해보면됨. 스레드환경을 만들고 실행만 해줌.
		// start()끝나도 스레드는 돌아가는 중. 
		
		
	}

}

class MyRunner2 implements Runnable{
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i=1; i<=1_000_000_000L; i++){
			sum+= i;
		}
		System.out.println("합계: " + sum);
	}
	
}



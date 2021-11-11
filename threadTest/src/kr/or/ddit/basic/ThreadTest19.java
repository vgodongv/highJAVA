package kr.or.ddit.basic;

/*
  	wait(). notify()를 이용해서 두 스레드가 번갈아 한번씩 실행하는 예제
  	
  	wait(), notify(), notifyAll()은 동기화 영역에서만 사용가능하다.
  	
  	
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

// 공통으로 사용할 클래스
class WorkObject{
	
	public synchronized void methodA(){
		System.out.println("methodA() 앞쪽 실행중");
		
		notify(); //notify()를 먼저쓴이유: 없으면 깨워줄 스레드가없음
		
		try {
			wait(); //wait 쓰려면 try로 묶어줘야함
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("methodA() 뒤쪽 실행중");
	}
	
	public synchronized void methodB(){
		System.out.println("methodB() 앞쪽 실행중");
		
		notify();
		
		try {
			wait(); //wait 쓰려면 try로 묶어줘야함
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("methodB() 뒤쪽 실행중");
	
	}
}

// WorkObject의 methodA()를 호출하는 스레드
class ThreadA extends Thread{
	private WorkObject workObj;

	// 생성자
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

//WorkObject의 methodB()를 호출하는 스레드
class ThreadB extends Thread{
	private WorkObject workObj;

	// 생성자
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







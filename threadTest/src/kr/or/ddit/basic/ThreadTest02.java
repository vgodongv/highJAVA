package kr.or.ddit.basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		// 멀티 스레드 프로그램

		//Thread를 사용하는 방법. 스레드 정의방식 3가지 = 어쨌든간 run 메서드 재정의. 
		// 왜 방법이여러개? 상속한번밖에못해서 혼합해서 사용할 수 있도록? class MyRunner1 A implements Runnable 이렇게 쓸수도 있다.

		// 방법1- Thread클래스를 상속한 class를 작성한 후 이 class의 인스턴스를 생성한 후 이 인스턴스의 start()메서드를 호출해서 실핸한다.

		MyThread1 th1= new MyThread1();
		th1.start(); // 스레드 실행하기. 왜 run이 아니라 start()? run()으로 직접실행하면 스레드 환경이 안만들어진거라 순서대로 실행됨. 
		
		// start(): 스레드 환경을 만들어주고 그 스레드에서 run()이라는 메서드를 자동으로 호출해주는 역할.

		// 방법2- Runnable 인터페이스를 구현한 class를 작성한다. 이 class의 인스턴스를 생성한다. 
		// Thread클래스의 인스턴스를  생성할 때 생성자의 인수값으로 이 class의 인스턴스를 넣어준다.
		// Thread클래스의 인스턴스의 start()메서드를 호출해서 실행한다.

		//		MyRunner1 r = new MyRunner1();
		//		Thread th2 = new Thread(r);

		Thread th2 = new Thread(new MyRunner1());
		th2.start();

		// 방법3- 2번을 조금 다르게 하는 방법. 익명구현체(이름없이구현할수이뙁)를 이용하는 방법
		Thread th3 =new Thread(new Runnable() { //인터페이스라 new안되는데

			@Override
			public void run() {

				for(int i=1; i<=200; i++){
					System.out.print("@");

					try {
						Thread.sleep(100); 
					} catch (InterruptedException e) {

					}
				}


			}
		});

		th3.start();
		
		System.out.println("main() 메서드 끝"); //마지막에 출력될거같지만 아님. 메인스레드끝나도 나머지 프로그램은 계속 돌아가고있음.
	}
}


class MyThread1 extends Thread{ // Thread 상속받은 클래스 생성

	@Override
	public void run() {
		for(int i=1; i<=200; i++){
			System.out.print("*");

			try {
				//Thread.sleep(시간); : 주어진 '시간'동안 잠시 멈춘다.
				// '시간'은 밀리세컨드 단위를 사용한다. 즉, 1000은 1초를 의미한다.
				Thread.sleep(100); //0.1초
			} catch (InterruptedException e) {

			}

		}
	}
}

// 방법2 - Runnable 인터페이스 구현하기
class MyRunner1 implements Runnable{ //class MyRunner1 A implements Runnable

	@Override
	public void run() {
		for(int i=1; i<=200; i++){
			System.out.print("$");

			try {
				Thread.sleep(100); 
			} catch (InterruptedException e) {

			}


		}
	}
}

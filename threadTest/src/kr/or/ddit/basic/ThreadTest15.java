package kr.or.ddit.basic;

// 스레드에서 객체를 공통으로 사용하는 예제

/*
 	원주율(pi)를 계산하는 스레드와 계산된 원주율을 출력하는 스레드가 있다.
 	
 	원주율을 저장하는 객체가 필요하다.
 	이 객체를 두 스레드가 공통으로 사용해서 처리한다.
 */
public class ThreadTest15 {

	public static void main(String[] args) {
		// 공통으로 사용할 객체 생성
		ShareData sd = new ShareData();
		
		// 스레드 객체를 생성하고 공통으로 사용할 객체를 스레드에 주입한다.
		CalcPIThread ct = new CalcPIThread();
		ct.setSd(sd);
		
		PrintPIthread pt = new PrintPIthread(sd);
		
		ct.start();
		pt.start();

	}

}

//원주율을 관리하는 클래스 작성(공통으로 사용할 클래스)
class ShareData{
	public double result; // 계산된 원주율이 저장될 변수
	public boolean isOk=false; // 계산이 완료되었는지를 나타내는 변수
}

//원주율을 계산하는 스레드
class CalcPIThread extends Thread{
	private ShareData sd;
	
	// setter
	public void setSd(ShareData sd){
		this.sd = sd;
	}
	
	@Override
	public void run() {
		/* 원주율 계산
		 원주율 = (1/1- 1/3 +1/5 -1/7 +1/9 -1/11...) * 4;
		 1 - 3 + 5 - 7 + 9 - 11...
		 
		 0  1  2  3  4  5 
		 
		 분자값을 2로나눈 몫이 짝수일때는 + 홀수일때는-
		 
		 
		 */
		double sum = 0.0;
		for(int i=1; i<=100000000; i+=2){
			if( (i/2) % 2 == 0 ){ // 몫이 짝수인 경우
				sum += (1.0/i);
			}else{
				sum-=(1.0/i);
			}
		}
		
		sd.result = sum * 4; // 계산이 완료된 값을 공통객체에 저장한다.
		sd.isOk = true;
		
	}
	
}

//계산이 완료되면 계산된 원주율을 출력하는 스레드
class PrintPIthread extends Thread{
	private ShareData sd;
	
	// 생성자
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
		System.out.println("결과:"+sd.result);
		System.out.println("PI: "+Math.PI);
		
	}
}















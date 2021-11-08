package kr.or.ddit.basic;

public class ThreadTest01 {

	public static void main(String[] args) {// 메인메서드 = 메인스레드. 메인메서드에서 처리하는것도 하나의 스레드라고 할 수 있다. = single 스레드
		
		// 싱글 스레드 프로그램 = 데이터 처리가 순차적 위->아래. 동시에 실행된것처럼 할 수 없음
		for(int i=1; i<=200; i++){
			System.out.print("*");
		}
		
		System.out.println();
		System.out.println();
		
		for(int j=0; j<=200; j++){
			System.out.print("$");
			
		}
	}

}

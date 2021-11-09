package kr.or.ddit.basic;

import java.util.Arrays;

/* 
 10마리의 말들이 경주하는 프로그램을 작성하시오

 말은 Horse라는 이름의 스레드 클래스로 작성하는데
 이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다. 
 그리고 이 클래스에는 등수를 오름차순으로 정렬할 수 있는 내부 정렬 기준이 있다. (Comparable 인터페이스 구현)

 경기 구간은 1~50구간으로 되어있다.

 경기가 끝나면 등수 순으로 출력한다.

 경기 중에는 중간 중간에 각 말들의 위치를 아래와 같이 나타내 준다.
 예) 
 말이름1: --->--------------------------
 말이름2: -------->----------------------
 ...
 말이름10: ------>------------------------

 */


public class ThreadTest13 {

	public static void main(String[] args) {
		Horse[] horses = new Horse[] { 
				new Horse("말말이"), 
				new Horse("말발이"),
				new Horse("말똥이"), 
				new Horse("말붕이"), 
				new Horse("말동이"),
				new Horse("말랑이"), 
				new Horse("말랭이"), 
				new Horse("조랑이"),
				new Horse("조수경이"), 
				new Horse("조하영이")
	};
		GameState gs = new GameState(horses);
		
		for(Horse h: horses){
			h.start();
		}
		
		gs.start(); // 경주 상태를 출력하는 스레드 시작
		
		for(Horse h: horses){ 
			try {
				h.join(); //말의 경주가 끝날때까지 기달
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		try {
			gs.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println();
		System.out.println("경기끝");
		System.out.println();
		
		System.out.println("경기 결과");
		
		Arrays.sort(horses); // 배열 정렬하기
		
		for(Horse h : horses){
			System.out.println(h.toString());
		}

}
}

class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0; // 경기가 끝난 말의 등수를 정하기 위한 변수
	private String horseName; //말이름
	private int rank;		  //등수
	private int position;	  //현재위치
	
	public Horse(String horseName) {
		super();
		this.horseName = horseName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	// 등수의 오름차순 내부정렬 기준
	@Override
	public int compareTo(Horse h) {
		
		return Integer.compare(rank, h.getRank());
	}

	@Override
	public String toString() {
		return "경주마 "+ horseName + "은(는)"+ rank+ "등입니다.";
	}
	
	@Override
	public void run() { //경주진행
		// 경기 구간은 1~50구간으로 되어있다.
		for(int i=1; i<=50; i++){
			position = i; //말의 현재위치를 저장
			
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				
			}
		}
		
		// 한 마리의 말이 경주가 끝나면 등수를 구해서 설정한다.
		currentRank++;
		this.rank = currentRank;
	}

}

/*
 경기 중에는 중간 중간에 각 말들의 위치를 아래와 같이 나타내 준다.
 예) 
 말이름1: --->--------------------------
 말이름2: -------->----------------------
 ...
 말이름10: ------>------------------------
 
 */

class GameState extends Thread{
	private Horse[] horses;

	// 생성자
	public GameState(Horse[] horses) {
		super();
		this.horses = horses;
	}
	
	@Override
	public void run() {
		while(true){
			// 모든 말들의 경기가 종료되었는지 여부를 검사
			if(Horse.currentRank==horses.length){
				break;
			}
			
			for(int i=1; i<=15; i++){
				System.out.println();
			}
			for(int i=0; i<horses.length; i++){
				System.out.print(horses[i].getHorseName()+":");
			
				for(int j=1; j<=50; j++){
					if(horses[i].getPosition()==j){ //말의 현재위치
						System.out.println(">");
					}else{
					System.out.print("-");
					}
				}
				System.out.println(); 
				
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	}
	
	
}




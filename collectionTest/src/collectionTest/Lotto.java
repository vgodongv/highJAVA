package collectionTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
	
	ArrayList<Integer> numList;
	
	Scanner sc = new Scanner(System.in);
	
	int money;
	
	int input;
	
	//로또 구입 메서드
	public void buy(){
		
		System.out.println("Lotto 구입 시작. 1000원에 로또번호 하나입니다.");
		System.out.println("금액 입력 : ");
		money = sc.nextInt();
		
		if(money<1000){
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
		}else if(money>=101000){
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
		}else{
			System.out.println("test");
			getNum(money);
		}
		
	}
	
	//로또 번호 생성
	public void getNum(int money){
		int buy = money/1000;
		Set<Integer> numSet = new HashSet<>();
		for(int i=1; i<=buy; i++){
			while(numSet.size()<6){
				numSet.add( (int)(Math.random() * 45 + 1) );
			}

			ArrayList<Integer> list = new ArrayList<>(numSet);

			System.out.println("로또번호" +i+":" + list);
			numSet.clear();

		}
		exchange();
		startGame();

	}
	
	// 거스름돈 메서드
	
	public void exchange(){
		int ex = money%1000;
		if(ex<1000){
			System.out.println("받은 금액은"+money+"원이고 거스름돈은"+ex+"원 입니다.");
		}else{
			System.out.println("거스름돈은 없습니다.");
		}
	}
	
	public void startGame(){
		do{
			System.out.println("==========================");
			System.out.println("Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==========================");
			System.out.println("메뉴선택: ");
			input = sc.nextInt();
			
			if(input==1){
				// 로또 번호를 만드는 메서드 호출
				buy();
				return;
			}else if(input==2){
				System.out.println("감사합니다.");
				return;
			}
			
			
		}while(input==2); //3s가 될때까지 반복
		

	      }


	public static void main(String[] args) {
		Lotto lo = new Lotto();
		lo.startGame();

	}

}

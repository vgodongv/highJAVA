package collectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;




/*
 문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오
 	(컴퓨터의 숫자는 난수를 이용하여 구한다.)
 	(스트라이크는 S, 볼은 B로 나타낸다.)
 	
 예시) 컴퓨터의 난수가 9 5 7
      숫자 입력: 356
      356 = 1S 0B
      숫자 입력: 789
      789 = 0S 2B
 
 */
public class BaseBallTest {

	ArrayList<Integer> numList;
	ArrayList<Integer> userList;
	int num;
	 int S;
	 int B;
	 
	Scanner sc = new Scanner(System.in);
	
	public void getNum(){
		
		Set<Integer> numSet = new HashSet<Integer>();
		
		while(numSet.size()<3){
			numSet.add((int)(Math.random()*9+1));
		}
		
		numList = new ArrayList<>(numSet);
		
		Collections.shuffle(numList);
		
	}
	
	// 사용자로부터 3개의 정수를 입력받아 List에 저장하는 메서드
	// 입력한 정수는 중복되지 않게 한다.
	public void inputNum(){
		int n1, n2, n3; //입력한 정수 저장될 변수
		
		do{
			System.out.println("숫자입력:");
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			n3 = sc.nextInt();
			
			if(n1==n2 || n1==n3 || n2==n3){
				System.out.println("중복되는 숫자는 입력할 수 없습니다. 다시 입력하세요");
			}
		}while(n1==n2 || n1==n3 || n2==n3);
		
		// 입력받은 데이터를 List에 저장한다.
		userList = new ArrayList<>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
		
	}
	
	//스트라이크와 볼을 판정하고 출력하는 메서드
	public void ballCount(){
		S = 0;
		B = 0;
		
		for(int i =0; i<numList.size(); i++){
			for(int j=0; j<userList.size(); j++){
				if(numList.get(i)==userList.get(j)){
					if(i== j){ // 위치가 같은지 확인
						S++;
					}else{
						B++;
					}
				}
			}
		}
		
		System.out.println(userList.get(0) + ", "+ userList.get(1)+"," + userList.get(2)+ " ="+S+"S"+B+"B");
		
		
	}
	
	// 게임을 진행하는 메서드
	public void startGame(){
		// 난수를 만드는 메서드 호출
		getNum();
		
		// 확인용 출력
		System.out.println("컴퓨터 난수: "+numList);
		
		int cnt = 0; // 몇번만에 맞췄는지를 저장하는 변수
		
		do{
			cnt++;
			inputNum(); // 사용자 입력용 메서드 호출
			ballCount();
			
		}while(S!=3); //3s가 될때까지 반복
		
		System.out.println();
		System.out.println(cnt + "번째만에 맞췄습니다.");
		
	      }
	
	
	public static void main(String[] args) {
		BaseBallTest test = new BaseBallTest();
		test.startGame();

	}
	}



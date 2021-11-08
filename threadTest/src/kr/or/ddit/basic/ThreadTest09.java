package kr.or.ddit.basic;



import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
 
 	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 	
 	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
 	사용자의 가위 바위 보는 showInputDialog()메서드를 이용해서 입력받는다.
 	
 	입력시간은 5초로 제한하고 카운트 다운을 한다.
 	5초안에 입력이 없으면 게임에 진것으로 처리한 후 끝낸다.
 	
 	5초안에 입력이 있으면 승패를 구해서 출력한다.
 	
 	결과예시
 	1) 5초안에 입력이 완료되었을 때
 	-- 결과 -- 
 	컴퓨터 : 가위
 	사용자 : 바위
 	결과: 당신이 이겼습니다.
 	
 	2) 5초안에 입력못했을 경우
 	-- 결과 -- 
 	시간초과로 당신이 졌습니다.

 	
 */

public class ThreadTest09 {

	
	
	public static void main(String[] args) {
		Thread th1 = new Input();
		Thread th2 = new Count();
		
		th1.start();
		th2.start();

	}

}

class Count extends Thread{	
	
	@Override
	public void run() {
		for(int i=5; i>=1; i--){
			System.out.println(i);
			// 입력이 완료되었는지 여부를 검사해서 입력이 완료되면 스레드를 종료시킨다. 
			if(Input.inputCheck==true){
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		
		System.out.println("5초가 지났습니다. 시간초과로 당신이 졌습니다.");
		System.exit(0);

	}
}



//데이터를 입력하는 스레드
class Input extends Thread{
	
	// 입력 여부를 확인하기 위한 변수 선언. 스레드에서 공통으로 사용할 변수
	public static boolean inputCheck = false;
	
	@Override
	public void run() {
		ArrayList<String> list = new ArrayList<>();
		list.add("가위");
		list.add("바위");
		list.add("보");
		
		int num= (int)Math.random()*3;
		
		
		String str = JOptionPane.showInputDialog("가위, 바위, 보를 입력해주세요");
		inputCheck = true; //입력이 완료되면 true로 변경
		System.out.println("--결과--");
		System.out.println("컴퓨터: "+list.get(num));
		System.out.println("사용자: "+ str);
		
//		if(list.get(num).equals(str)){
//			System.out.println("비겼습니다.");
//		}else if(list.get(num).equals("가위")&&str.equals("바위")){
//			System.out.println("이겼습니다.");
//		}else if(list.get(num).equals("바위")&&str.equals("보")){
//			System.out.println("이겼습니다.");
//		}else if(list.get(num).equals("보")&&str.equals("가위")){
//			System.out.println("이겼습니다.");
//		}else{
//			System.out.println("졌습니다.");
//		}
		
		if(list.get(num).equals(str)){
			System.out.println("비겼습니다.");
		}else if((list.get(num).equals("가위")&&str.equals("바위"))||
				(list.get(num).equals("바위")&&str.equals("보"))||
				(list.get(num).equals("보")&&str.equals("가위"))){
			System.out.println("이겼습니다.");
			
		}else{
			System.out.println("졌습니다.");
		}
		
		
		
	}
}



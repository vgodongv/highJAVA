package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest09_2 {

	public static void main(String[] args) {
		GameTimer gt = new GameTimer();
		
		// 난수를 이용해서 컴퓨터의 가위 바위 보 정하기
		String[] data = {"가위","바위","보"}; // index : 0~2
		int index = (int)(Math.random()*3); //0~2사이의 난수
		String com = data[index];
		
		// 사용자의 가위 바위 보 입력받기
		gt.start();
		
		String man = JOptionPane.showInputDialog("가위바위보를 입력하세요");
		GameTimer.inputCheck = true;
		
		// 결과 판정하기
		String result = ""; //결과가 저장될 변수
		if(com.equals(man)){
			result="비겼습니다.";
			System.out.println("비겼습니다.");
		}else if((man.equals("가위")&&com.equals("보")) ||
				  (man.equals("바위")&&com.equals("가위"))||
				  (man.equals("보")&&com.equals("바위"))){ //누가 이긴걸로 할지_사용자 기준
			result = "당신이 이겼습니다.";
			
		}else{
			result= "당신이 졌습니다.";
		}
			//결과출력
		System.out.println("-- 결과 --");
		System.out.println("컴퓨터:"+com);
		System.out.println("사용자:"+man);
		System.out.println("결 과:"+result);

	}

}

// 카운트 다운 스레드
class GameTimer extends Thread{
	public static boolean inputCheck = false;
	
	@Override
	public void run() {
		System.out.println("카운트 다운 시작");
		
		for(int i=5; i>0; i--){
			if(inputCheck==true){
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
		
		System.out.println("-- 결과 --");
		System.out.println("시간초과로 당신이 졌습니다.");
		System.exit(0);
		
	}
	
}

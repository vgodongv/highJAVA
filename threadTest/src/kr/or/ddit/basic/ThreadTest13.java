package kr.or.ddit.basic;

import java.util.Arrays;

/* 
 10������ ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�

 ���� Horse��� �̸��� ������ Ŭ������ �ۼ��ϴµ�
 �� Ŭ������ ���̸�(String), ���(int), ������ġ(int)�� ��������� ���´�. 
 �׸��� �� Ŭ�������� ����� ������������ ������ �� �ִ� ���� ���� ������ �ִ�. (Comparable �������̽� ����)

 ��� ������ 1~50�������� �Ǿ��ִ�.

 ��Ⱑ ������ ��� ������ ����Ѵ�.

 ��� �߿��� �߰� �߰��� �� ������ ��ġ�� �Ʒ��� ���� ��Ÿ�� �ش�.
 ��) 
 ���̸�1: --->--------------------------
 ���̸�2: -------->----------------------
 ...
 ���̸�10: ------>------------------------

 */


public class ThreadTest13 {

	public static void main(String[] args) {
		Horse[] horses = new Horse[] { 
				new Horse("������"), 
				new Horse("������"),
				new Horse("������"), 
				new Horse("������"), 
				new Horse("������"),
				new Horse("������"), 
				new Horse("������"), 
				new Horse("������"),
				new Horse("��������"), 
				new Horse("���Ͽ���")
	};
		GameState gs = new GameState(horses);
		
		for(Horse h: horses){
			h.start();
		}
		
		gs.start(); // ���� ���¸� ����ϴ� ������ ����
		
		for(Horse h: horses){ 
			try {
				h.join(); //���� ���ְ� ���������� ���
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
		System.out.println("��ⳡ");
		System.out.println();
		
		System.out.println("��� ���");
		
		Arrays.sort(horses); // �迭 �����ϱ�
		
		for(Horse h : horses){
			System.out.println(h.toString());
		}

}
}

class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0; // ��Ⱑ ���� ���� ����� ���ϱ� ���� ����
	private String horseName; //���̸�
	private int rank;		  //���
	private int position;	  //������ġ
	
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
	
	// ����� �������� �������� ����
	@Override
	public int compareTo(Horse h) {
		
		return Integer.compare(rank, h.getRank());
	}

	@Override
	public String toString() {
		return "���ָ� "+ horseName + "��(��)"+ rank+ "���Դϴ�.";
	}
	
	@Override
	public void run() { //��������
		// ��� ������ 1~50�������� �Ǿ��ִ�.
		for(int i=1; i<=50; i++){
			position = i; //���� ������ġ�� ����
			
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				
			}
		}
		
		// �� ������ ���� ���ְ� ������ ����� ���ؼ� �����Ѵ�.
		currentRank++;
		this.rank = currentRank;
	}

}

/*
 ��� �߿��� �߰� �߰��� �� ������ ��ġ�� �Ʒ��� ���� ��Ÿ�� �ش�.
 ��) 
 ���̸�1: --->--------------------------
 ���̸�2: -------->----------------------
 ...
 ���̸�10: ------>------------------------
 
 */

class GameState extends Thread{
	private Horse[] horses;

	// ������
	public GameState(Horse[] horses) {
		super();
		this.horses = horses;
	}
	
	@Override
	public void run() {
		while(true){
			// ��� ������ ��Ⱑ ����Ǿ����� ���θ� �˻�
			if(Horse.currentRank==horses.length){
				break;
			}
			
			for(int i=1; i<=15; i++){
				System.out.println();
			}
			for(int i=0; i<horses.length; i++){
				System.out.print(horses[i].getHorseName()+":");
			
				for(int j=1; j<=50; j++){
					if(horses[i].getPosition()==j){ //���� ������ġ
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




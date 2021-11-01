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
	
	//�ζ� ���� �޼���
	public void buy(){
		
		System.out.println("Lotto ���� ����. 1000���� �ζǹ�ȣ �ϳ��Դϴ�.");
		System.out.println("�ݾ� �Է� : ");
		money = sc.nextInt();
		
		if(money<1000){
			System.out.println("�Է� �ݾ��� �ʹ� �����ϴ�. �ζǹ�ȣ ���� ����!!!");
		}else if(money>=101000){
			System.out.println("�Է� �ݾ��� �ʹ� �����ϴ�. �ζǹ�ȣ ���� ����!!!");
		}else{
			System.out.println("test");
			getNum(money);
		}
		
	}
	
	//�ζ� ��ȣ ����
	public void getNum(int money){
		int buy = money/1000;
		Set<Integer> numSet = new HashSet<>();
		for(int i=1; i<=buy; i++){
			while(numSet.size()<6){
				numSet.add( (int)(Math.random() * 45 + 1) );
			}

			ArrayList<Integer> list = new ArrayList<>(numSet);

			System.out.println("�ζǹ�ȣ" +i+":" + list);
			numSet.clear();

		}
		exchange();
		startGame();

	}
	
	// �Ž����� �޼���
	
	public void exchange(){
		int ex = money%1000;
		if(ex<1000){
			System.out.println("���� �ݾ���"+money+"���̰� �Ž�������"+ex+"�� �Դϴ�.");
		}else{
			System.out.println("�Ž������� �����ϴ�.");
		}
	}
	
	public void startGame(){
		do{
			System.out.println("==========================");
			System.out.println("Lotto ���α׷�");
			System.out.println("--------------------------");
			System.out.println("1. Lotto ����");
			System.out.println("2. ���α׷� ����");
			System.out.println("==========================");
			System.out.println("�޴�����: ");
			input = sc.nextInt();
			
			if(input==1){
				// �ζ� ��ȣ�� ����� �޼��� ȣ��
				buy();
				return;
			}else if(input==2){
				System.out.println("�����մϴ�.");
				return;
			}
			
			
		}while(input==2); //3s�� �ɶ����� �ݺ�
		

	      }


	public static void main(String[] args) {
		Lotto lo = new Lotto();
		lo.startGame();

	}

}

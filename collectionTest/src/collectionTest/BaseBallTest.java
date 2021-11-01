package collectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;




/*
 ����) Set�� �̿��Ͽ� ���� �߱� ���� ���α׷��� �ۼ��Ͻÿ�
 	(��ǻ���� ���ڴ� ������ �̿��Ͽ� ���Ѵ�.)
 	(��Ʈ����ũ�� S, ���� B�� ��Ÿ����.)
 	
 ����) ��ǻ���� ������ 9 5 7
      ���� �Է�: 356
      356 = 1S 0B
      ���� �Է�: 789
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
	
	// ����ڷκ��� 3���� ������ �Է¹޾� List�� �����ϴ� �޼���
	// �Է��� ������ �ߺ����� �ʰ� �Ѵ�.
	public void inputNum(){
		int n1, n2, n3; //�Է��� ���� ����� ����
		
		do{
			System.out.println("�����Է�:");
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			n3 = sc.nextInt();
			
			if(n1==n2 || n1==n3 || n2==n3){
				System.out.println("�ߺ��Ǵ� ���ڴ� �Է��� �� �����ϴ�. �ٽ� �Է��ϼ���");
			}
		}while(n1==n2 || n1==n3 || n2==n3);
		
		// �Է¹��� �����͸� List�� �����Ѵ�.
		userList = new ArrayList<>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
		
	}
	
	//��Ʈ����ũ�� ���� �����ϰ� ����ϴ� �޼���
	public void ballCount(){
		S = 0;
		B = 0;
		
		for(int i =0; i<numList.size(); i++){
			for(int j=0; j<userList.size(); j++){
				if(numList.get(i)==userList.get(j)){
					if(i== j){ // ��ġ�� ������ Ȯ��
						S++;
					}else{
						B++;
					}
				}
			}
		}
		
		System.out.println(userList.get(0) + ", "+ userList.get(1)+"," + userList.get(2)+ " ="+S+"S"+B+"B");
		
		
	}
	
	// ������ �����ϴ� �޼���
	public void startGame(){
		// ������ ����� �޼��� ȣ��
		getNum();
		
		// Ȯ�ο� ���
		System.out.println("��ǻ�� ����: "+numList);
		
		int cnt = 0; // ������� ��������� �����ϴ� ����
		
		do{
			cnt++;
			inputNum(); // ����� �Է¿� �޼��� ȣ��
			ballCount();
			
		}while(S!=3); //3s�� �ɶ����� �ݺ�
		
		System.out.println();
		System.out.println(cnt + "��°���� ������ϴ�.");
		
	      }
	
	
	public static void main(String[] args) {
		BaseBallTest test = new BaseBallTest();
		test.startGame();

	}
	}



package kr.or.ddit.basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		// ��Ƽ ������ ���α׷�

		//Thread�� ����ϴ� ���. ������ ���ǹ�� 3���� = ��·�簣 run �޼��� ������. 
		// �� ����̿�����? ����ѹ��ۿ����ؼ� ȥ���ؼ� ����� �� �ֵ���? class MyRunner1 A implements Runnable �̷��� ������ �ִ�.

		// ���1- ThreadŬ������ ����� class�� �ۼ��� �� �� class�� �ν��Ͻ��� ������ �� �� �ν��Ͻ��� start()�޼��带 ȣ���ؼ� �����Ѵ�.

		MyThread1 th1= new MyThread1();
		th1.start(); // ������ �����ϱ�. �� run�� �ƴ϶� start()? run()���� ���������ϸ� ������ ȯ���� �ȸ�������Ŷ� ������� �����. 
		
		// start(): ������ ȯ���� ������ְ� �� �����忡�� run()�̶�� �޼��带 �ڵ����� ȣ�����ִ� ����.

		// ���2- Runnable �������̽��� ������ class�� �ۼ��Ѵ�. �� class�� �ν��Ͻ��� �����Ѵ�. 
		// ThreadŬ������ �ν��Ͻ���  ������ �� �������� �μ������� �� class�� �ν��Ͻ��� �־��ش�.
		// ThreadŬ������ �ν��Ͻ��� start()�޼��带 ȣ���ؼ� �����Ѵ�.

		//		MyRunner1 r = new MyRunner1();
		//		Thread th2 = new Thread(r);

		Thread th2 = new Thread(new MyRunner1());
		th2.start();

		// ���3- 2���� ���� �ٸ��� �ϴ� ���. �͸���ü(�̸����̱����Ҽ��̌�)�� �̿��ϴ� ���
		Thread th3 =new Thread(new Runnable() { //�������̽��� new�ȵǴµ�

			@Override
			public void run() {

				for(int i=1; i<=200; i++){
					System.out.print("@");

					try {
						Thread.sleep(100); 
					} catch (InterruptedException e) {

					}
				}


			}
		});

		th3.start();
		
		System.out.println("main() �޼��� ��"); //�������� ��µɰŰ����� �ƴ�. ���ν����峡���� ������ ���α׷��� ��� ���ư�������.
	}
}


class MyThread1 extends Thread{ // Thread ��ӹ��� Ŭ���� ����

	@Override
	public void run() {
		for(int i=1; i<=200; i++){
			System.out.print("*");

			try {
				//Thread.sleep(�ð�); : �־��� '�ð�'���� ��� �����.
				// '�ð�'�� �и������� ������ ����Ѵ�. ��, 1000�� 1�ʸ� �ǹ��Ѵ�.
				Thread.sleep(100); //0.1��
			} catch (InterruptedException e) {

			}

		}
	}
}

// ���2 - Runnable �������̽� �����ϱ�
class MyRunner1 implements Runnable{ //class MyRunner1 A implements Runnable

	@Override
	public void run() {
		for(int i=1; i<=200; i++){
			System.out.print("$");

			try {
				Thread.sleep(100); 
			} catch (InterruptedException e) {

			}


		}
	}
}

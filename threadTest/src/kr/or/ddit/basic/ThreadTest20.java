package kr.or.ddit.basic;

public class ThreadTest20 {

	public static void main(String[] args) {
		DataBox databox = new DataBox();
		
		ProducerThread thP = new ProducerThread(databox);
		ConsumerThread thC = new ConsumerThread(databox);
		
		thP.start();
		thC.start();

	}

}

// �����͸� �������� ����ϴ� Ŭ����
class DataBox{
	private String data;

	/*
	 data������ ���� null�̸� data������ ���ڿ��� ä���� ������ ��ٸ��� 
	 data������ ���� ������ �ش� ���ڿ��� ��ȯ�Ѵ�.
	 ���ڿ��� ��ȯ�� �Ŀ��� �ٽ� data������ ���� null�� �����.
	 */
	public synchronized String getData(){
		if(data==null){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		String temp =data;

		System.out.println("�����尡 ���� ������: "+ temp);
		data = null;

		notify();

		return temp;
	}

	/*
	 data������ ���� ������ data������ ����������� ��ٸ��� data������ ���� null�̸� 
	 ���ο� data���� dat������ �����Ѵ�.
	 */
	public synchronized void setData(String data){
		if(this.data!=null){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		this.data = data;
		System.out.println("Thread���� ���� ������ data: "+ data);
		notify();
	}

}

// �����͸� �־��ִ� ������
class ProducerThread extends Thread{
	private DataBox databox;

	public ProducerThread(DataBox databox) {
		super();
		this.databox = databox;
	}

	@Override
	public void run() {
		for(int i=1; i<=3; i++){
			databox.setData("���޵����� "+ i);
		}
	}
}

// �����͸� ������ ����ϴ� ������
class ConsumerThread extends Thread{
	private DataBox databox;

	public ConsumerThread(DataBox databox) {
		super();
		this.databox = databox;
	}
	
	@Override
	public void run() {
	for(int i=1; i<=3; i++){
		String data= databox.getData();
		}
	}
}


















package kr.or.ddit.basic;

// �������� ���¸� ����ϴ� ����

public class ThreadTest10 {

	public static void main(String[] args) {
		StatePrintThread th = new StatePrintThread(new TargetThread());
		th.start();

	}

}

// ������ ������ �˻� ����̵Ǵ� ������
class TargetThread extends Thread{
	@Override
	public void run() {
		
		for(long i=1L; i<=20_000_000_000L; i++){} //�ð� ������_RUNNABLE
			
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
		
		}
		
		for(long i=1L;  i<=20_000_000_000L; i++){}
			
		
	}
}

// TargetThread�� ���¸� �˻��ϰ� ����ϴ� ������
class StatePrintThread extends Thread{
	private TargetThread target;
	
	// ������ : TargetThread �ʱ�ȭ
	public StatePrintThread(TargetThread target){
		this.target = target;
	}
	
	@Override
	public void run() {
		while(true){
			// �������� ���� ���°� ���ϱ� 
			Thread.State state = target.getState();
			
			System.out.println("TargetThread�� ���� ���°�: "+ state);
			
			if(state == Thread.State.NEW){ // �����尡 new �����̸�
				target.start();
			}
			
			if(state == Thread.State.TERMINATED){ // �����尡 ���� ���¸�
				break;
			}
			
			try {
				Thread.sleep(500); 
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	}
}











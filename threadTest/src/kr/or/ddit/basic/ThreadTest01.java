package kr.or.ddit.basic;

public class ThreadTest01 {

	public static void main(String[] args) {// ���θ޼��� = ���ν�����. ���θ޼��忡�� ó���ϴ°͵� �ϳ��� �������� �� �� �ִ�. = single ������
		
		// �̱� ������ ���α׷� = ������ ó���� ������ ��->�Ʒ�. ���ÿ� ����Ȱ�ó�� �� �� ����
		for(int i=1; i<=200; i++){
			System.out.print("*");
		}
		
		System.out.println();
		System.out.println();
		
		for(int j=0; j<=200; j++){
			System.out.print("$");
			
		}
	}

}

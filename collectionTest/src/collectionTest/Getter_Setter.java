

package collectionTest;

public class Getter_Setter {
	public static void main(String[] args) {
		Value v= new Value();
		
		// Value�� �ִ� ���� ����������
		v.num1 = 200; //public�̸� ��ü������ �̿��� ������ ��������� �� �ִ�.
//		v.num2 = 200; �����߻�. private�϶��� Value Ŭ���������� ��밡���ϰ� Value Ŭ������ �����༭ = ĸ��ȭ �Ǿ �ٸ� Ŭ�������� ���� ���Ұ�
//	        �����͸� ����ϴµ� �ְ��߳�? �ܺο��� �����ϰ� ��ȣ = ������ ���� ������ . num2�� �����͸� �ְų� �����͸� �������� ������? getter/setter
//		�����͸� �ְ� ������? 
		v.setNum2(200);
		System.out.println("num1 : "+ v.num1 );
		System.out.println("num2 : "+ v.getNum2() );
		
		
	}

}

class Value{
	//getter setter �־���????????
	public int num1; //  �ƹ��������� ����
	private int num2; // �ڱ��ڽ� Ŭ�����ȿ����� ����
	
	public int getNum2() { // getter, setter�� public�̶� �ܺο��� �� �� ����. 
		return num2;
	}
	public void setNum2(int num2) { // getter, setter�� ���� �ʿ��ѵ��� ������ ����.
		if(num2<0 || num2>100){
			System.out.println("num2 �ڷ� ����");
		}else{
		this.num2 = num2;
		}
	}
	

	
}


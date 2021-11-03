package kr.or.ddit.basic.generictest;


/*
   ���׸� Ŭ������ ����� ���
  ����) class Ŭ������<���׸�Ÿ�Ա���>{
  
         ���׸�Ÿ�Ա��� ������; ���� ���� ���׸��� ����� ���
         
         ���׸�Ÿ�Ա��� �޼����(�Ű�������){  �޼����� ��ȯ����  ���׸��� ����� ���
      
       return ��;
      }
      
      ��ȯ��Ÿ�� �޼����(���׸�Ÿ�Ա��� ������){ �޼����� �Ű������� ���׸��� ����� ���
      
      return ��;
      }
      
     }
 */

class MyGeneric<T>{ // MyGeneric<T,V,E> ���׸� ������ ������ ������
	
	private T val;
	
	public void setVal(T val){
		this.val = val;
	}
	
	public T getVal(){
		return val;
	}
}


class NonGeneric{
	private Object val; //�������
	
	public void setVal(Object val){
		this.val = val;
	}
	
	public Object getVal(){
		return val;
	}
}



public class GenericTest {

	public static void main(String[] args) {
		NonGeneric ng1 = new NonGeneric();
		ng1.setVal("�����ٶ�"); // �ڽ� -> �θ� ����ȯ ���ʿ�. �ڵ� ����ȯ��

		NonGeneric ng2 = new NonGeneric();
		ng2.setVal(100); //����ڽ�
		
		String rtnNg1 = (String)ng1.getVal(); // �θ�->�ڽ� ����ȯ �ʿ�
		System.out.println("���ڿ� ��ȯ��: "+ rtnNg1);
		
		Integer rtnNg2 = (Integer)ng2.getVal();
		//int rtnNg2 = (int)ng2.getVal(); ���� ��ڽ� �Ͼ�� int�� �ᵵ��
		System.out.println("������ ��ȯ��: "+ rtnNg2);
		System.out.println();
		
		/* 
		NonGeneric ng3 = new NonGeneric();
		ng3.setVal("ȫ�浿"); 
		
		Integer rtnNg3 = (Integer)ng3.getVal(); // ����� ����. 
		System.out.println("ng3: "+ rtnNg3);
		*/
		
		System.out.println("-----------------------------");
		
		MyGeneric<String> mg1 = new MyGeneric<>();
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		
		mg1.setVal("�츮����");
		mg2.setVal(500);
		
		String rtnMg1 = mg1.getVal();
		System.out.println(rtnMg1);
		int rtnMg2 = mg2.getVal();
		System.out.println(rtnMg2);
		
//		int test = mg1.getVal(); �ٷ� �������� ������ ã�� ����
		
		
		
		
	}

}







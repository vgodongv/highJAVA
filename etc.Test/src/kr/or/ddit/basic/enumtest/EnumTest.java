package kr.or.ddit.basic.enumtest;


	/*
	 	- enum(������) : ���� �����ִ� ������� ������ ��Ÿ����. Ŭ����ó�� ���̰� �ϴ� ���
	 	                           �������� classó�� ������ java���Ͽ� ���� �� �ְ�, �ϳ��� java���Ͽ� Ŭ������ ���� ���� �� �ְ�, 
	 	              class�ȿ� ���� Ŭ����ó�� ���� �� �ִ�.
	 	- �������� �Ӽ� �� �޼���
	 	1) name() : ������ ����� �̸��� ���ڿ��� ��ȯ�Ѵ�.
	 	2) ordinal() : ������ ����� ���ǵ� ������(index)�� ��ȯ�Ѵ�. (0���� ����)
	 	3) valueOf("�����������") : ������ ���������� '�����������'�� ��ġ�ϴ� ������ ����� ��ȯ�Ѵ�.
	 	4) �������̸�.����� : valueOf("�����")�޼���� ����.
	 	
	 	- ������ �����ϱ�
	 	���1) enum �������̸� { �����1, �����2, �����3 ...}
	 	���2) enum �������̸�{
	 		�����1(����...), ������ �ڷ����� ���� ���ƾ���. 1�� ������ ������, �������̸� ������ 2,3�� �ڷ����� ������, ������
	 		�����2(����...),
	 		�����3(����...),
	 		....
	 		�����n(����...) ;
	 		
	 		// ������ ����� �������� �����ؾ���. ������ ������ŭ ������ �����Ѵ�.
	 		 private �ڷ����̸� ������ 1;
	 		 ...
	 		 
	 		 // �������� �����ڸ� �����.
	 		 // �������� �����ڴ� '���������'�� ������ �����ϴ� ������ �����Ѵ�.
	 		 // ������ �����ڴ� ���������� 'private'�̴�.
	 		  
	 		  
	 		 // '������'�� ����� ������ ����, ������ ����� �ڷ����� �¾ƾ� �Ѵ�.
	 		 private �������̸�(�ڷ����̸� ������,....){
	 		 	 ���� ����� �������� �Ű������� �̿��ؼ� �ʱ�ȭ �Ѵ�.
	 		 	 
	 		 }
	 		 
	 		 // ������ '����'�� �ܺο��� ���� �� �ֵ��� getter�޼��带 �ۼ��Ѵ�.
	 		  public �ڷ����̸� get������1(){
	 		  		return ������;
	 		  }
	 		 
	 	}
	 	
	 	
	 */
public class EnumTest {
	//���1	
	public enum Color { RED, GREEN, BLUE }; // �������̸��� Ŭ������ ����� ����
		public enum Count { ONE, TWO, THREE };
	//���2
	public enum Season{
		��("3������ 5������"),  // �����(����...)���� ����
		����("6������ 8������"), // �����ڿ� ��Ī�Ǹ� ���� ������
		����("9������ 11������"),
		�ܿ�("12������ 2������");
		
		// ���� ����� ���� ����
		private String span;
		
		// ������
		Season(String months){ // ������ private�� pruvate Season(String months){ �� ����
		span = months; //������ ���� �ʱ�ȭ�ϴ� �۾��� �����Ѵ�.
		}
		
		//getter ����
		public String getSpan(){
			return span;
		}
		
	}
			
	public static void main(String[] args) {
		/*
		System.out.println("Red : "+ ConstTest.RED);
		System.out.println("Three : "+ ConstTest.THREE);
		
		if(ConstTest.RED == ConstTest.TWO){
			System.out.println("-------");
		}else{
			System.out.println("#######");
		}
		
		*/
		
		Color mycol = Color.valueOf("GREEN"); // Color���� green���� ��ȯ�ؼ� mycol�� ����. Color.GREEN�� ����.
		Count mycnt = Count.ONE; //Count.valueOf("ONE")�� ����.
		
		System.out.println("mycol : " + mycol.name());
		System.out.println("mycnt : " + mycnt.name());
		
		System.out.println("mycol ordinal : " + mycol.ordinal());
		System.out.println("mycnt ordinal : " + mycnt.ordinal());
		
		/* if(Color.RED == Count.TWO){ ������ �̸��� �ٸ��� ����ü�� �Ұ�����
			System.out.println("...");
		} */
		
		if(mycol == Color.BLUE){
			System.out.println("����.");
		}else{
			System.out.println("���� �ʴ�.");
		}
		
		Season ss = Season.valueOf("��");
		System.out.println("name :" + ss.name());
		System.out.println("ordinal :" + ss.ordinal());
		System.out.println("span : "+ss.getSpan());
		
		// ��������.values() : ��� ������� ������ �迭�� ��ȯ�Ѵ�.
		for(Season time : Season.values()){
			System.out.println(time.name() + "==" + time + ":" + time.getSpan() );
		}
		System.out.println();
		
		for(Color col : Color.values()){
			System.out.println(col + ":"+ col.ordinal());
		}
		

	}

}

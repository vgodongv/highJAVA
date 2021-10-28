package collectionTest;

import java.util.ArrayList;

public class ArrayLlistTest01 {

	public static void main(String[] args) {
	// ArrayList�� �⺻���� ������ Vector�� ����.
		
		ArrayList list1 = new ArrayList();
		
//		 add()�޼��带 �̿��ؼ� �߰��Ѵ�. list1�� ���׸� ������ ���ؼ� ���� Ÿ���� ������ �ֱ� ������
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(false);
		list1.add(123.45);
		
		System.out.println("list1 =>" + list1);
		System.out.println("size => "+ list1.size());
		
//		get()�޼���� �����͸� �����´�.
		System.out.println("2��° ������:"+ list1.get(2));
		
//		������ �����ֱ� 
		list1.add(3,"zzz");
		System.out.println("list1 =>" + list1);
		
//		������ �����ϱ�
		String temp = (String)list1.set(3, "yyy");
		System.out.println("temp =>"+ temp); //�ٲ���� ������ ���
		System.out.println("list1 =>"+ list1);
		
//		������ ����
		list1.remove(3);
		System.out.println("list1 =>"+ list1);
		
		list1.remove("bbb");
		System.out.println("list1 =>"+ list1);
		
		System.out.println("-------------------------------------");
		
//		���׸��� ����� �� �ִ�.
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		
		for(int i=0; i<list2.size(); i++){
			System.out.println(i + "==> "+ list2.get(i));
		}
		
		for(String str : list2){
			System.out.println(str);
		}
		
		System.out.println("-------------------------------------");
		
		
//		contains(�񱳰�ü)
//		List�� �񱳰�ü�� ������ true, ������  false ��ȯ
		System.out.println("DDD�� ���� ����: "+ list2.contains("DDD"));
		System.out.println("YYY�� ���� ����: "+ list2.contains("YYY"));
		
//      indexOf(�񱳰�ü)
//		List�� �񱳰�ü�� ������ �񱳰�ü�� �ִ� ��ġ�� index���� ��ȯ�Ѵ�. ������ -1�� ��ȯ�Ѵ�.
		System.out.println("DDD�� ��ġ��: "+ list2.indexOf("DDD"));
		System.out.println("YYY�� ��ġ��: "+ list2.indexOf("YYY"));
		
//		toArray() : List���� �����͸� �迭�� ��ȯ�Ͽ� ��ȯ�Ѵ�.
//		�⺻������ Object�� �迭�� ��ȯ�Ѵ�. ������ �����͸� ������ ������ �����Ҷ� ����ȯ�� �ؾ��Ѵٴ°��� ����
		
		Object[] strArr = list2.toArray(); 
		
		System.out.println("�迭�� ����: "+ strArr.length);
		for(int i=0; i<strArr.length; i++){
			String str = (String)strArr[i];
			System.out.println(i+ "=>"+str);
		}
		
//		������ ���׸� Ÿ�Կ� �´� �迭�� ��ȯ�ϱ�
//		toArray(new ���׸� Ÿ��[0]) 
		System.out.println("-------------------------------------");
		String[] strArr2 = list2.toArray(new String[0]);
		for(int i=0; i<strArr2.length; i++){
			String str =strArr2[i];
			System.out.println(i+ "=>"+str);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

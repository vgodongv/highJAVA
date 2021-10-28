package collectionTest;

import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		// �÷��� ��ü�� ����Ǵ� �����ʹ� ��ü�� ������ �� �ִ�.
		// ���Ͱ�ü����. ��簴ü���尡��
		Vector v1 = new Vector();
		
		System.out.println("ó��ũ��: " + v1.size());
		
//		 ������ �߰�1 : add(�߰��� ������ ����)
		// ��ȯ��: �߰� ������ true, ���н� false
		v1.add("AAAA"); // ���ڿ������� AAAA��ü
		v1.add(new Integer(123)); //���ڵ����ʹ� ��üȭ�ؼ� �־����. 
		v1.add(111); //��üȭ���ص��ǰ� ������. �׳� �Ϲݵ����� �־ ���ο��� �ڵ����� ��üȭ�ؼ� �־���(=auto boxing)
		v1.add('a'); //���ڵ�����
		v1.add(true);
		boolean r = v1.add(3.14); //3.14�� ������ �����ߴ��� 
		
		System.out.println("v1�� ũ�� : "+ v1.size()); //�ڵ����� ũ�� ����
		System.out.println("��ȯ�� :" + r);//3.14�� ������ �����ߴ��� 
		System.out.println("v1 ===> " + v1); //"v1 ===> " + v1�� v1.toString()�� ����
		System.out.println("v1 ===> " + v1.toString());
		
//		 ������ �߰�2: addElement(�߰��� ������)
		// ���� ������ Vector���� ����ϴ� �޼���
		v1.addElement("KKK");
		System.out.println("v1 => " + v1);
		
//		 ������ �߰�3: add(index, ������) -> index��°�� '������'�� ���� �ִ´�. ��ȯ���� ����.
		v1.add(1, "ZZZ"); //1��° �ڸ��� ZZZ�� �߰� . ���� 1�� �ε����� �ִ� �����ʹ� �ڷ� �з���
		System.out.println("v1 => " + v1);
		
//		������ ���� : set(index, ���ο� ������)
		// ==> 'index'��° �ڷḦ '���ο����'�� �����Ѵ�
		// ��ȯ�� : ������ ������ 
		String temp = (String)v1.set(0, "YYYY"); //String���� ����ȯ �������.
		System.out.println("v1=>" + v1);
		System.out.println("������ ������:"+ temp);
		
//		 ������ ���� : remove(index)
		// ==> 'index'��°�� �����͸� �����Ѵ�.
		// ==> ��ȯ�� : ������ ������
		v1.remove(0);
		System.out.println("���� �� :"+v1);
		
		temp = (String)v1.remove(0);
		System.out.println("���� �� "+v1);
		System.out.println("������ ������:"+temp);
		
//		 ������ ����2 : remove(������ ������)
		// ==> '������ ������'�� ã�Ƽ� �����Ѵ�.
		// ==> '������ ������'�� �������� �տ������� �����ȴ�.
		// ==> ��ȯ�� : ���� �����̸� true, ���и� false
		// ==> '������ ������'�� '������'�̰ų� 'char��'�̸� '������ ������'�� ��ü�� ��ȯ�ؼ� ����ؾ� �Ѵ�.
		v1.remove("KKK");
		System.out.println("������:"+v1);
		
		
//		v1.remove(111); ���� �ȵ�. 111�� �ε����� �ν�. ������ 111�� ��üȭ ���Ѿ���
		v1.remove(new Integer(111));
		System.out.println("������:"+v1);
		
//		v1.remove('a'); ''�� ���� ���� ������ �ڵ尪���� �ٲ�� ó������. �ҹ��� a�� �ڵ尪�� 97. 97��° �ε����� �ν��ؼ� �����ȵ�
		v1.remove(new Character('a')); //��üȭ ���Ѿ���
		System.out.println("������:"+v1);
		
		v1.remove(true);
		System.out.println("������:"+v1);
		
		v1.remove(3.14);
		System.out.println("������:"+v1);
		
//		������ �������� : get(index)
		// ==> index��°�� �����͸� ��ȯ�Ѵ�.
		int data = (int)v1.get(0); //���Ϳ��� object������ ����Ǿ��ֱ⶧���� ����ȯ�������
		System.out.println("0��° �ڷ�:"+ data);
		
		/*
		 ���׸� Ÿ��(Generic Type) ==> Ŭ���� ���ο��� ����� �������� Ÿ���� �ܺο��� �����ϴ� ���
		 ��ü�� ������ ��  <> �ȿ� �� ��ü�� ����� �������� Ÿ���� �����ش�. �̷������� �����ϰ� �Ǹ� �� ������ Ÿ�� �̿���
		 �����͸� ������ �� ����. ��, ���׸����� ����� �� �ִ� ������ Ÿ����  Ŭ�������̾�� �Ѵ�.
		 ��) int ==> Integer
		    boolean => Boolean
		    char ==> Character ������ ��ü�ؼ� ����ؾ��Ѵ�.
		  ���׸� Ÿ������ �����ϰ� �Ǹ� �����͸� ������ �� ������ ����ȯ�� �ʿ����.
		 */
		
		Vector<String> v2 = new Vector<>();
		Vector<Integer> v3 = new Vector<>();
		
		v2.add("�ȳ��ϼ���");
//		v2.add(123); ���׸� Ÿ�԰� ���� ���� �ڷ����̶� ����
		
		String temp2 = v2.get(0); //���׸� String�̶� ����ȯ ���ʿ�
		Vector<Vector> vv = new Vector<>();
		Vector<Vector<Vector>> vvv = new Vector<>();
		
		System.out.println("-----------------------------");
		v2.clear(); // ��ü������ ����
		System.out.println("v2�� ũ��: "+v2.size());
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		Vector<String> v4 = new Vector<>();
		v4.add("BBB");
		v4.add("EEE");
		
		System.out.println("v2 =>"+v2);
		System.out.println("v4 =>"+v4);
		
//		������ ����3 : removeAll(Collection ��ü)
		// ==> 'Collection ��ü'�� ������ �ִ� �����͸� ��� �����Ѵ�.
		// ==> ��ȯ�� : ����(true), ����(false)
		
		v2.removeAll(v4); // v2�߿� v4�� ������ �ִ� ���� ����� ��
		System.out.println("v2 =>"+v2);
		System.out.println();
		
		System.out.println("-------------------------------");
		v2.clear();
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		// Vector�� �����͸� ó������ ���ʷ� �о�� ó���ϰ� ������ �ݺ����� ����ϸ� �ȴ�.
		for(int i=0; i<v2.size(); i++){
			System.out.println(i+"��° �ڷ�:"+ v2.get(i));
			
		}
		System.out.println("--------------------------------");
		
		//���� for��
		for(String s : v2){ //v2�� ������ŭ �ݺ��ǰ� �ݺ��Ҷ����� v2���� �����͸� �ϳ� ������ s�� �����ϰ� ���� �ݺ�
			System.out.println(s);
		}
		
		
		
		
		
		
		

		
	}

}

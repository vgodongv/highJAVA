package collectionTest;

import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
	/*
	 
	 Properties��ü�� Map���� ��ҵ� ����� ��ü��� �� �� �ִ�.
	 
	 Map�� key���� value���� ��� ������ ��ü�� ����� �� �ִ�.
	 Properties�� key���� value���� String�� ����� �� �ִ�. -> ���׸� ����
	 
	 Map�� put() �޼���� get() �޼��带 �̿��ؼ� �����͸� ����� ������
	 Properties�� setProperty()�޼���� getProperty()�޼��带 ����ؼ� ����� �Ѵ�.
	 
	 Properties�� �����͸� ���Ϸ� ������� �� �ִ�.
	 
	 */
		
		Properties prop = new Properties();

		//������ �߰�
		prop.setProperty("name", "ȫ�浿");
		prop.setProperty("age", "23");
		prop.setProperty("age2", String.valueOf(20)); // �Ǵ� ���ڸ� ���ڿ�ȭ ���Ѽ� ����־����
		prop.setProperty("tel", "010-1234-1234");
		prop.setProperty("addr", "����");
		
		//������ �о����
		String name = prop.getProperty("name");
		int age = Integer.parseInt(prop.getProperty("age"));
		String tel = prop.getProperty("tel");
		String addr = prop.getProperty("addr");
		
		System.out.println("�̸�: "+ name);
		System.out.println("����: "+ age);
		System.out.println("��ȭ��ȣ: "+ tel);
		System.out.println("�ּ�: "+ addr);
		
		
	}

}




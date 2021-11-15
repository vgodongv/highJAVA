package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOTest {

	public static void main(String[] args) {
		// Member�� �ν��Ͻ� ����
		Member mem1 = new Member("ȫ�浿", 20, "����");
		Member mem2 = new Member("ȫ�漭", 20, "�λ�");
		Member mem3 = new Member("ȫ�泲", 20, "����");
		Member mem4 = new Member("ȫ���", 20, "����");

		try {
			// ��ü�� ���Ͽ� �����ϱ�
			FileOutputStream fout = new FileOutputStream(
					"d:/d_other/memObj.bin");
			BufferedOutputStream bout = new BufferedOutputStream(fout);

			ObjectOutputStream oout = new ObjectOutputStream(bout);

			// ���� �۾� ����.
			System.out.println("��ü �����ϱ� ����.");
			oout.writeObject(mem1);
			oout.writeObject(mem2);
			oout.writeObject(mem3);
			oout.writeObject(mem4);

			System.out.println("��ü ���� �۾� ��");

			oout.close(); // ��Ʈ�� �ݱ�

			// ����� ��ü�� �о�� �� ������ ȭ�鿡 ����ϱ�

			// �Է¿� ��Ʈ�� ��ü ����

		} catch (IOException e) {
		}
		try {
			ObjectInputStream oin = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(
							"d:/d_other/memObj.bin")));

			Object obj;
			System.out.println("��ü �б� �۾�����");
			// readObject()�޼��尡 �����͸� ������ �� �о���� EOFException�� �߻���Ų��.
			while ((obj = oin.readObject()) != null) {
				Member mem = (Member) obj;

				System.out.println("�̸�: " + mem.getName());
				System.out.println("����: " + mem.getAge());
				System.out.println("�ּ�: " + mem.getAddr());
			}
		} catch (EOFException e) {
			// TODO: handle exception

		} catch(IOException e){
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}

	}
}

class Member implements Serializable {

	private static final long serialVersionUID = 562285606573703211L;

	// transient : ����ȭ�� ���� ���� ��������� �����Ѵ�. ����ȭ�� �������� ��������� �⺻������ ����ȴ�.
	// ��������: null , ������������:0
	private String name;
	private transient int age;
	private String addr;

	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
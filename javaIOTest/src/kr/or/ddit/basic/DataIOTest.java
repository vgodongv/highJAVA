package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {

	public static void main(String[] args) {
	try {
		FileOutputStream fout = new FileOutputStream("d:/d_other/testData.dat");
		
		// �ڷ��� ������ ����� ���� ��Ʈ���� DataOutputStream��ü����
		DataOutputStream dout = new DataOutputStream(fout);
		
		dout.writeInt(200);// ���������� ����Ѵ�.
		dout.writeFloat(123.45f); // �Ǽ������� ����Ѵ�.
		dout.writeBoolean(false);
		dout.writeUTF("ABCDabcd");
		
		System.out.println("��¿Ϸ�");
		dout.close(); //��Ʈ�� �ݱ�
		
		// ����� ������ �о����
		FileInputStream fin = new FileInputStream("d:/d_other/testData.dat");
		DataInputStream din = new DataInputStream(fin);
		
		// DataInputStream���� �ڷḦ �о�� ���� DataOutputStream���� ����� ������ ���� ������ �о�;��Ѵ�.
		System.out.println("������: "+ din.readInt());
		System.out.println("�Ǽ���: "+ din.readFloat());
		System.out.println("����: "+ din.readBoolean());
		System.out.println("���ڿ�: "+ din.readUTF());
		
		System.out.println("�б��۾��Ϸ�");
		
		din.close();
	} catch (IOException e) {
		// TODO: handle exception
	}

	}

}

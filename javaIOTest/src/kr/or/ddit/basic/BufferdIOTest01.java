package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferdIOTest01 {

	public static void main(String[] args) {
		// ������� ���� ����� ���ؼ� Buffered ��Ʈ���� ����Ѵ�.
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/bufferTest.txt");
			
			// ������ ũ�Ⱑ 5�� ���۽�Ʈ�� ��ü ����
			// ������ ũ�⸦ ������ ������ 8KB(8192byte)�� ũ��� �����ȴ�.
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			for(char ch='1'; ch<='9'; ch++){
				bout.write(ch);
				
			}
			bout.flush(); // �۾��� �����ϱ� ���� ���ۿ� �����ִ� �����͸� ��� ��� ��Ų��.
			System.out.println("��� �۾� ��");
			
			bout.close(); //��Ʈ�� �ݱ�: ������Ʈ���� ������ ������Ʈ���� ����ϴ� ����� �Ǵ� ��Ʈ���� ���� ������.
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}

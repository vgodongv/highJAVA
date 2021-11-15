package ByteArrayIOTest02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {
	public static void main(String[] args) {
		try {
			// ���� ������ �б� ���ؼ��� FileInputStream��ü�� �ʿ��ϴ�.
			
			// ��Ʈ�� ��ü ����
			// ���1: �о�� ���� ������ ���ڿ��� ���� ����ϴ� ���
			// FileInputStream fin = new FileInputStream("d:/d_Other/test.txt");
			
			// ���2: �о�� ������ File��ü�� ���� ����ϴ� ���
			File file = new File("d:/d_Other/test.txt");
			FileInputStream fin = new FileInputStream(file);	
			
			int c; // �о�� �����Ͱ� ����� ����
			while( (c = fin.read()) != -1 ){
				// �о�� �����͸� ȭ�鿡 ����ϱ�
				System.out.print( (char)c );
			}
			fin.close(); // �۾��� �Ϸ�Ǹ� ��Ʈ�� �ݱ�
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}

package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class FileIOTest03 {

	public static void main(String[] args) {
		
		// ���� ����� ��Ʈ���� �̿��� ���� ���� �о�� ����ϱ�
		try {
			FileReader fr = new FileReader("d:/d_other/test.txt");
			int c; //�о�� ������ ������ ����
			while( (c=fr.read()) !=-1){
				System.out.print( (char)c );
			}
			
			fr.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}

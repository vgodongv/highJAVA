package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest05 {

	public static void main(String[] args) {
		// �ѱ� ������ �ִ� ���� �о����
		// (�ѱ��� ���ڵ� ����� �����ؼ� �о����)

		try {
			// FileReader fr = new FileReader("d:/d_other/test_ansi.txt");
			// FileReader fr = new FileReader("d:/d_other/test_utf8.txt");

			FileInputStream fin = new FileInputStream("d:/d_other/test_ansi.txt");
			//FileInputStream fin = new FileInputStream("d:/d_other/test_utf8.txt");

			// �⺻ ���ڵ� ������� �о�´�.
			// InputStreamReader isr = new InputStreamReader(fin);
			
			// ���ڵ� ����� �����ؼ� �о����
			// ���ڵ� ��� ����
			// ms949 : �������� �⺻ �ѱ� ���ڵ� ���(ANSI��İ� ����.)
			// UTF-8: �����ڵ� UTF-8 ���ڵ� ���
			// US-ASCII: ���� ���� ���ڵ� ���
			
			InputStreamReader isr = new InputStreamReader(fin, "ms949");

			int c;
			while((c=isr.read())!=-1){
				System.out.print((char)c);
			}

			isr.close();

		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}

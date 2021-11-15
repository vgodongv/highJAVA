package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest04 {

	public static void main(String[] args) {
		// ����ڰ� �Է��� ������ �״�� ���Ϸ� �����ϱ�
		
		try {
			// System.in : �ܼ�(ǥ���������ġ)�� �Է���ġ�� ��Ʈ����ü
			// InputStreamReader: �Է¿� ����Ʈ ����� ��Ʈ���� ���ڱ���� ��Ʈ������ ��ȯ�ϴ� ������Ʈ���̴�.
			InputStreamReader isr = new InputStreamReader(System.in);
			
			// ���� ��¿� ���ڱ�� ��Ʈ�� ��ü ���� 
			FileWriter fw = new FileWriter("d:/d_other/testChar.txt");
			
			System.out.println("�ƹ������̳� �Է��ϼ���(�Է��� ���� Ctrl + Z �Դϴ�.");
			
			int c;
			
			//�ֿܼ��� �����͸� �Է��� �� �Է��� ���� Ctrl+Z Ű�� ������ �ȴ�.
			while((c=isr.read())!=-1){
				fw.write(c); //�ַܼ� �Է��� �����͸� ���Ϸ� ����Ѵ�.
				
			}
			
			isr.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}

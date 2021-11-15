package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest01 {

	public static void main(String[] args) {
		byte[] inSrc ={0,1,2,3,4,5,6,7,8,9}; //�Է��ҵ�����
		byte[] outSrc = null; //����ҵ�����
		
		 ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		 ByteArrayOutputStream output = new ByteArrayOutputStream();

		 int data; // �о�� �����Ͱ� ����� ����
		 
		 //read()�޼��� : �Է��� �����Ϳ��� �� �̻� �о�� �����Ͱ� ������ -1�� ��ȯ�Ѵ�.
		 while( (data = input.read()) != -1 ){ //1����Ʈ�� �о��
			 output.write(data); //�о�� ������ �״�� ����Ѵ�.	 
			 
		 }
		 
		 // ����� ��Ʈ�� ������ �迭�� ��ȯ�ؼ� �����ϱ�
		 outSrc = output.toByteArray();
		 
		 try {
			input.close(); // ��볡���� �ݾ���ߵ�
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 System.out.println(" inSrc : "+ Arrays.toString(inSrc));
		 System.out.println(" outSrc : "+ Arrays.toString(outSrc));
	}

}

package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {
	
	public static void main(String[] args) {
		byte[] inSrc ={0,1,2,3,4,5,6,7,8,9}; //�Է��ҵ�����
		byte[] outSrc = null; //����ҵ�����
		
		byte[] temp = new byte[4]; //4��¥�� �迭����
		
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		try {
			
			while(input.available() > 0){ //�о�õ����Ͱ� 0����ũ��
//				input.read(temp);
//				output.write(temp);
				
				// ���� �о�� byte���� ��ȯ�Ѵ�.
				int len = input.read(temp);
				
				// temp �迭�� �����߿��� 0��°���� len������ŭ ����Ѵ�.
				output.write(temp, 0, len);
				
				
				System.out.println("�ݺ��� �ȿ��� temp : "+ Arrays.toString(temp));
			}
			outSrc = output.toByteArray();
			 System.out.println(" inSrc : "+ Arrays.toString(inSrc));
			 System.out.println(" outSrc : "+ Arrays.toString(outSrc));
			 
			 input.close();
			 output.close();
					
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
	}
}

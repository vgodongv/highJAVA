package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {
	
	public static void main(String[] args) {
		byte[] inSrc ={0,1,2,3,4,5,6,7,8,9}; //입력할데이터
		byte[] outSrc = null; //출력할데이터
		
		byte[] temp = new byte[4]; //4개짜리 배열생성
		
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		try {
			
			while(input.available() > 0){ //읽어올데이터가 0보다크면
//				input.read(temp);
//				output.write(temp);
				
				// 실제 읽어온 byte수를 반환한다.
				int len = input.read(temp);
				
				// temp 배열의 내용중에서 0번째부터 len개수만큼 출력한다.
				output.write(temp, 0, len);
				
				
				System.out.println("반복문 안에서 temp : "+ Arrays.toString(temp));
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

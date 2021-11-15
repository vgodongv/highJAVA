package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class FileIOTest03 {

	public static void main(String[] args) {
		
		// 문자 기반의 스트림을 이용한 파일 내용 읽어와 출력하기
		try {
			FileReader fr = new FileReader("d:/d_other/test.txt");
			int c; //읽어올 데이터 저장할 변수
			while( (c=fr.read()) !=-1){
				System.out.print( (char)c );
			}
			
			fr.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}

package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 	문제)
 		'd:/d_other' 폴더에 저장되어 있는 '툐끼.jpg' 파일을 'd:/d_other/연습용' 폴더에 '복사본_툐끼.jpg' 파일로 복사하는 프로그램을 작성하시오
 */
public class FileCopyTest {

	public static void main(String[] args) {
		
		
		try {
			
			File file = new File("d:/d_Other/툐끼.jpg");
			FileInputStream f = new FileInputStream(file);
			FileOutputStream fo = new FileOutputStream("d:/d_Other/연습용/복사본_툐끼.jpg");
			
			int c;
			
			while((c=f.read())!=-1){
				fo.write(c);
			}
			
			fo.close();
			f.close();
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}

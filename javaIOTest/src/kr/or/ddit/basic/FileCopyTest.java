package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 	����)
 		'd:/d_other' ������ ����Ǿ� �ִ� '����.jpg' ������ 'd:/d_other/������' ������ '���纻_����.jpg' ���Ϸ� �����ϴ� ���α׷��� �ۼ��Ͻÿ�
 */
public class FileCopyTest {

	public static void main(String[] args) {
		
		
		try {
			
			File file = new File("d:/d_Other/����.jpg");
			FileInputStream f = new FileInputStream(file);
			FileOutputStream fo = new FileOutputStream("d:/d_Other/������/���纻_����.jpg");
			
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

package FileIOTest01;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/out.txt");
			
			for(char ch = 'A'; ch<='Z'; ch++){
				
				fout.write(ch); //ch변수의 데이터를 파일로 출력한다.
			}
			
			System.out.println("출력작업 완료");
			fout.close(); // 쓰기 작업 완료 후 스트림 닫기
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}

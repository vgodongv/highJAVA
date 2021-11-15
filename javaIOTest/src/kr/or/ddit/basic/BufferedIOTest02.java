package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIOTest02 {

	public static void main(String[] args) {
		// ���� ����� Buffered��Ʈ�� ��뿹��
		try {
			// ��Ŭ���������� �ڹ� ���α׷��� ����Ǵ� ���� ��ġ�� �ش� ������Ʈ ������ ���� ��ġ�� �ȴ�.
			FileReader fr = new FileReader("./src/kr/or/ddit/basic/FileTest01.java");
			BufferedReader br = new BufferedReader(fr);
			String temp ="";
			for(int i=1; (temp=br.readLine()) != null; i++){
				System.out.printf("%4d : %s\n",i,temp);
				
			}
			br.close();
		} catch (IOException e) {
			
		}

	}

}

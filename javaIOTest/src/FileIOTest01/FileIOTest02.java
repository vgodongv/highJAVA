package FileIOTest01;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/out.txt");
			
			for(char ch = 'A'; ch<='Z'; ch++){
				
				fout.write(ch); //ch������ �����͸� ���Ϸ� ����Ѵ�.
			}
			
			System.out.println("����۾� �Ϸ�");
			fout.close(); // ���� �۾� �Ϸ� �� ��Ʈ�� �ݱ�
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}

package kr.or.ddit.basic;

import java.io.File;

public class CurrentPathTest {

	public static void main(String[] args) {
		
		// �ڹ� ���α׷��� ����Ǵ� ���� ��ġ ���ϱ�
		
		// ���1) File ��ü �̿�
		File file = new File("");
		System.out.println("������ġ: "+ file.getAbsolutePath());
		System.out.println();
		
		
		// ���2) System.getProperty("user.dir") ����̿��ϱ�
		String path1 = System.getProperty("user.dir");
		System.out.println("������ġ: "+ path1);
		
		
	}

}

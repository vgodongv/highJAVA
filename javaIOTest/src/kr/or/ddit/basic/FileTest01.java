package kr.or.ddit.basic;

import java.io.File;

public class FileTest01 {

	public static void main(String[] args) {
		// File��ü ����� ����

		// 1. new File(String �����̸� �Ǵ� ���)
		// ���丮�� ���丮 ���� �Ǵ� ���丮�� ���ϸ� ������ ���� ���ڴ� '\'�� ����ϰų� '/'�� ����� �� �ִ�.

		// File file1 = new File("d:/d_other/test.txt"); //���й��ڷ� '/'���
		File file1 = new File("D:\\D_other\\test.txt"); //���й��ڷ� '\'���
		System.out.println("���ϸ�: "+ file1.getName());
		System.out.println("���丮 ����: "+ file1.isDirectory());
		System.out.println("���Ͽ���: "+ file1.isFile());
		System.out.println();

		File file2 = new File("d:/D_Other");
		System.out.println("������: "+ file2.getName());
		System.out.println("���丮 ����: "+ file2.isDirectory());
		System.out.println("���Ͽ���: "+file2.isFile());
		System.out.println();

		// 2-1 new File(File parent, String child)
		// 2-2 new File(String parent, String child)
		// 'parent' ����(���丮)�ȿ� �ִ� 'child'������ ��Ÿ����.

		//File file3 = new File(file2, "test.txt");
		File file3 = new File("d:/D_Other", "test.txt");
		System.out.println("���ϸ�: "+ file3.getName());
		System.out.println("���丮 ����: "+ file3.isDirectory());
		System.out.println("���Ͽ���: "+ file3.isFile());
		System.out.println();
		
		// ���丮(����) �����
		/*
		 - mkdir():  File��ü�� ��� �� ������ ��ġ�� ���丮�� �����. ����� ������ true, ���н� false
		                          �߰� �κ��� ��ΰ� ��� ������� �־�� ������ ��ġ�� ���丮�� ���� �� �ִ�.
		 - mkdirs(): �߰� �κ��� ��ΰ� ������ �߰� �κ��� ��ε� ���� ������ش�.
		 */
		File file4 = new File("D:/d_other/������");
		System.out.println(file4.getName()+"�� ���翩��: "+ file4.exists());
		
		if(!file4.exists()){
		if(file4.mkdir()){
			System.out.println(file4.getName()+"����� ����!");
		}else{
			
			System.out.println(file4.getName()+"����� ����");
		}
		
		}else{
			System.out.println(file4.getName()+"�̹������մϴ�.");
		}
		
		System.out.println();
		
		File file5 = new File("d:/d_other/test/java/src");
		if(!file5.exists()){
			if(file5.mkdirs()){
				System.out.println(file5.getName()+"����� ����");
			}else{
				System.out.println(file5.getName()+"����� ����");
			}
		}else{
			System.out.println(file5.getName() + "�� �̹� �����մϴ�.");
		}
		
	}

}

package kr.or.ddit.basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest03 {

	public static void main(String[] args) {
		FileTest03 test = new FileTest03();
		
		File file = new File("d:/d_other");
		test.displayFileList(file);
		

	}
	//���丮�� ���� File��ü�� �μ� ������ �޾Ƽ� �ش� ���丮�� �ִ� ��� ���ϰ� ���丮 ���� ����ϴ� �޼���
	public void displayFileList(File dir){
		if(!dir.isDirectory()){
			System.out.println("��� ���丮(����)�� ���ų�, ���丮(����)�� �����մϴ�.");
			return;
		}
		System.out.println("["+dir.getAbsolutePath()+"] ���丮 ����");
		System.out.println();
		
		// �ش� ���丮 �ȿ� �ִ� ��� ���ϰ� ���丮 ����� ���ؿ´�.
		File[] files = dir.listFiles();
		// String[] filestr = dir.list();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		// ������ ���ϰ� ���丮 ��� ������ŭ �ݺ� ó��
		for(int i=0; i<files.length; i++){
			String fileName = files[i].getName();
			
			String attr = ""; //���� �Ӽ�(�б�, ����, ����, ���丮����)
			String size ="";  //���� ũ��
			
			if(files[i].isDirectory()){
				attr ="<DIR>";
				
			}else{
				size = files[i].length() +"";
				attr = files[i].canRead()?"R" : "";
				attr += files[i].canWrite() ? "W":"";
				attr += files[i].isHidden() ? "H" : "";
				
			}
			System.out.printf("%s %5s %12s %s\n",df.format(new Date(files[i].lastModified()) )
					, attr, size, fileName);
			
		}
		
	}

}



package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogFileCopyTest {

	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser();
		
		FileNameExtensionFilter img = new FileNameExtensionFilter("Image File", new String[]{"png","jpg","gif"});
		FileNameExtensionFilter txt = new FileNameExtensionFilter("text����(.txt)", "txt");

		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(txt);
		
		chooser.setCurrentDirectory(new File("d:/d_other"));
		
		int result = chooser.showOpenDialog(new Panel());

		if(result == JFileChooser.APPROVE_OPTION){ //'����'
			// ������ ���� ���� ���ϱ�
			File selectedFile = chooser.getSelectedFile();
			System.out.println("���� ����: "+ selectedFile.getAbsolutePath());
			result = chooser.showSaveDialog(new Panel());
			
			File savedFile = chooser.getSelectedFile();
			try {
				
				
				FileInputStream f = new FileInputStream(selectedFile);
				FileOutputStream fo = new FileOutputStream(savedFile);
				
				int c;
				
				while((c=f.read())!=-1){
					fo.write(c);
				}
				System.out.println("�����");
				fo.close();
				f.close();
				
				
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
			
		}
		
	
	}



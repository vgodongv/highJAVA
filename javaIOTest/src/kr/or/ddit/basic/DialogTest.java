package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogTest {

	public static void main(String[] args) {
		// SWING�� ���Ͽ���, ���� â ����
		JFileChooser chooser = new JFileChooser();

		// ������ ������ Ȯ���� ����
		FileNameExtensionFilter doc = new FileNameExtensionFilter("Word File", "docx", "doc");
		FileNameExtensionFilter img = new FileNameExtensionFilter("Image File", new String[]{"png","jpg","gif"});
		FileNameExtensionFilter txt = new FileNameExtensionFilter("text����(.txt)", "txt");
		
		chooser.addChoosableFileFilter(doc);
		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(txt);
		
		chooser.setFileFilter(txt); // Ȯ���� ��� �� �⺻������ ���õ� Ȯ���� ����
		
		chooser.setAcceptAllFileFilterUsed(false); // ��� ���� ��� ǥ�� ���� ����(true: ����, false: ����)
		
		// Dialog�� ��Ÿ�� �⺻ ��� �����ϱ�
		chooser.setCurrentDirectory(new File("d:/d_other"));
		//����â
		int result = chooser.showOpenDialog(new Panel());
		//����Ī
		// int result = chooser.showSaveDialog(new Panel());
		
		//'���� â' �Ǵ� '���� â'���� ������ ���� ���� ��������
		
		//'����'�Ǵ�'����'��ư�� ������ ���
		if(result == JFileChooser.APPROVE_OPTION){ //'����'
			// ������ ���� ���� ���ϱ�
			File selectedFile = chooser.getSelectedFile();
			System.out.println("���� ����: "+ selectedFile.getAbsolutePath());
			
			
		}
		
		
	}

}

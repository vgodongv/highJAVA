package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogTest {

	public static void main(String[] args) {
		// SWING의 파일열기, 저장 창 연습
		JFileChooser chooser = new JFileChooser();

		// 선택한 파일의 확장자 설정
		FileNameExtensionFilter doc = new FileNameExtensionFilter("Word File", "docx", "doc");
		FileNameExtensionFilter img = new FileNameExtensionFilter("Image File", new String[]{"png","jpg","gif"});
		FileNameExtensionFilter txt = new FileNameExtensionFilter("text파일(.txt)", "txt");
		
		chooser.addChoosableFileFilter(doc);
		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(txt);
		
		chooser.setFileFilter(txt); // 확장자 목록 중 기본적으로 선택될 확장자 지정
		
		chooser.setAcceptAllFileFilterUsed(false); // 모든 파일 목록 표시 여부 설정(true: 설정, false: 해제)
		
		// Dialog에 나타날 기본 경로 설정하기
		chooser.setCurrentDirectory(new File("d:/d_other"));
		//열기창
		int result = chooser.showOpenDialog(new Panel());
		//저장칭
		// int result = chooser.showSaveDialog(new Panel());
		
		//'열기 창' 또는 '저장 창'에서 선택한 파일 정보 가져오기
		
		//'열기'또는'저장'버튼을 눌렀을 경우
		if(result == JFileChooser.APPROVE_OPTION){ //'열기'
			// 선택한 파일 정구 구하기
			File selectedFile = chooser.getSelectedFile();
			System.out.println("선택 파일: "+ selectedFile.getAbsolutePath());
			
			
		}
		
		
	}

}

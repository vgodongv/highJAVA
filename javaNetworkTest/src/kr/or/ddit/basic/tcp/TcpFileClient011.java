package kr.or.ddit.basic.tcp;

import java.awt.Panel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

public class TcpFileClient011 {
   enum DialogChoice {open, save}
   
   public File showDialog(DialogChoice choice){
            JFileChooser chooser = new JFileChooser();
            
            chooser.setAcceptAllFileFilterUsed(true);
            
            chooser.setCurrentDirectory(new File("d:/d_other"));
            
            int result = 0;
            if(choice == DialogChoice.open){
               result = chooser.showOpenDialog(new Panel());
            }else if(choice == DialogChoice.save){
               result = chooser.showSaveDialog(new Panel()); 
            }
            
            File selectedFile = null;
            if(result == JFileChooser.APPROVE_OPTION){
               selectedFile = chooser.getSelectedFile();
            }
            return selectedFile;
   }
   
   public void fileCopyStart(){
      System.out.println("복사할 파일을 선택하세요.");
      File open = showDialog(DialogChoice.open);
      if(open == null){
         System.out.println("복사할 파일을 선택하지 않았습니다.");
         System.out.println("복사 작업 중단");
         return;
      }
      if(!open.exists()){
         System.out.println("대상 파일이 존재하지 않습니다.");
         System.out.println("복사 작업 중단");
         return;
      }
      
      System.out.println("저장 경로를 선택하세요.");
      System.out.println("확장자도 같이쓸것");
      File save = showDialog(DialogChoice.save);
      if(save == null){
         System.out.println("복사 경로를 선택하지 않았습니다.");
         System.out.println("복사 작업 중단");
         return;
      }
      
      try {
         FileInputStream fis = new FileInputStream(open);
         FileOutputStream fos = new FileOutputStream(save);
         
         System.out.println("복사 시작");
         System.out.println("복사 중...");
         int c;
         while((c = fis.read()) != -1){
            fos.write(c);
         }
         System.out.println("복사 완료!!");
      } catch (IOException e) {
      }
      System.out.println("프로그램 종료");
   }

   public static void main(String[] args) {
      new TcpFileClient011().fileCopyStart();
   }

}
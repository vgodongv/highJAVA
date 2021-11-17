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
      System.out.println("������ ������ �����ϼ���.");
      File open = showDialog(DialogChoice.open);
      if(open == null){
         System.out.println("������ ������ �������� �ʾҽ��ϴ�.");
         System.out.println("���� �۾� �ߴ�");
         return;
      }
      if(!open.exists()){
         System.out.println("��� ������ �������� �ʽ��ϴ�.");
         System.out.println("���� �۾� �ߴ�");
         return;
      }
      
      System.out.println("���� ��θ� �����ϼ���.");
      System.out.println("Ȯ���ڵ� ���̾���");
      File save = showDialog(DialogChoice.save);
      if(save == null){
         System.out.println("���� ��θ� �������� �ʾҽ��ϴ�.");
         System.out.println("���� �۾� �ߴ�");
         return;
      }
      
      try {
         FileInputStream fis = new FileInputStream(open);
         FileOutputStream fos = new FileOutputStream(save);
         
         System.out.println("���� ����");
         System.out.println("���� ��...");
         int c;
         while((c = fis.read()) != -1){
            fos.write(c);
         }
         System.out.println("���� �Ϸ�!!");
      } catch (IOException e) {
      }
      System.out.println("���α׷� ����");
   }

   public static void main(String[] args) {
      new TcpFileClient011().fileCopyStart();
   }

}
package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer011 {
	
	private void serverStart(){
		// �������� �о File�� ����.
		File saveDir = new File("d:/d_other/upload");
		
		if(!saveDir.exists()){
			saveDir.mkdirs();
		}
		
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("������ �غ����Դϴ�.");
			
			Socket socket = server.accept(); // Ŭ���̾�Ʈ�� ��û�� ��ٸ���.
			
			System.out.println("���� ���� ����");
			
			// ���Ͽ� �Է� ��Ʈ�� ��ü ����.
			 DataInputStream dis = 	new DataInputStream(socket.getInputStream());
			BufferedInputStream bis = new BufferedInputStream(dis);
			 
			 // Ŭ���̾�Ʈ�� ���ӵǾ��� �� ù��°�� ������ �����̸��� �޴´�.
			String fileName = dis.readUTF();
			
			
			File saveFile = new File(saveDir, fileName);
			/*File saveFile = new File(saveDir, "���.jpg");*/
			
			// ���� ��¿� ��Ʈ�� ��ü ����
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(saveFile)
					);
			
			byte[] temp = new byte[1024];
			int length = 0;
			
			while((length = bis.read(temp))>0){
				bos.write(temp, 0, length);
			}
			bos.flush();
			
			System.out.println("���� ���� �Ϸ�");
			
			bos.close();
			bis.close();
			socket.close();
			server.close();
			
			
		} catch (Exception e) {
			System.out.println("���� ���� ����: " + e.getMessage());
		}
	}
	public static void main(String[] args) {
		new TcpFileServer011().serverStart();

	}

}

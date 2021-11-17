package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {
	
	
	public void clientStart(){
		try {
			
			String serverIp = "localhost";
			
			Socket socket = new Socket(serverIp, 7777);
			System.out.println("������ ����Ǿ����ϴ�.");
			System.out.println();
			
			// �޽����� �����ϴ� ������ ����
			ClientSender sender = new ClientSender(socket);
			
			// �޽����� �����ϴ� ������ ����
			ClientReceiver receiver = new ClientReceiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TcpMultiChatClient().clientStart();
	}
	
	// �޽��� ���ۿ� ������
	class ClientSender extends Thread{
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		private String name;
		private Scanner scan;
		
		// ������
		public ClientSender(Socket socket) { 
			this.socket = socket;
			scan = new Scanner(System.in);
			
			try {
				// ���ſ� �۽ſ� ��ü ����
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				
				if(dos!=null){
					// Ŭ���̾�Ʈ�� ó�� ����Ǹ� �ڽ��� ��ȭ��(�̸�)�� �Է¹޾� ������ �����ϰ� 
					// ��ȭ���� �ߺ� ���θ� feedBack���� �޾Ƽ� Ȯ���Ѵ�.
					
					System.out.println("��ȭ��: ");
					String name = scan.nextLine();
					
					while(true){ // ��ȭ���� �ߺ��ɶ��� ��츦���� �ݺ������� ����
					dos.writeUTF(name); // �̸��� ������ ����@@
					
					String feedBack = dis.readUTF(); // feedBack����� read�� �޾Ƽ� Ȯ���Ѵ�.##
					
					if("�̸��ߺ�".equals(feedBack)){ // ��ȭ���� �ߺ��Ǹ�
						System.out.println(name+"�� �̸��� �ߺ��˴ϴ�.");
						System.out.println("�ٸ� �̸��� �Է��ϼ���.");
						System.out.println("��ȭ��: ");
					    name = scan.nextLine();
						
					}else{ // �ߺ����� ������
						this.name = name;
						System.out.println(name+"�̸����� ��ȭ�濡 �����߽��ϴ�.");
						break;
						
					}
					
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	
			@Override
			public void run() {
			try {
				while(dos!=null){
					// Ű����� �Է��� �޽����� ������ �����Ѵ�.
					dos.writeUTF("["+name+"]: "+scan.nextLine());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
	}
	//�޽��� ���ſ� ������
	class ClientReceiver extends Thread{
		private Socket socket;
		private DataInputStream dis;
		
		// ������
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		@Override
		public void run() {
			try {
				while(dis!=null){
					// ������ ������ �޽����� �޾Ƽ� ȭ�鿡 ����Ѵ�.
					System.out.println(dis.readUTF());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}

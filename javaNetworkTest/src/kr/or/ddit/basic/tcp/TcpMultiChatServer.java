package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TcpMultiChatServer {
	// ������ Ŭ���̾�Ʈ���� ������ Map��ü ����
	// key��: ������ ����� �̸�, value�� : ������ Ŭ���̾�Ʈ�� socket��ü
	
	private Map<String, Socket> clientMap;
	
	// ������
	public TcpMultiChatServer() {
		// clientMap�� ����ȭ ó���� �ǵ��� �����Ѵ�.
		clientMap = Collections.synchronizedMap(new HashMap<String, Socket>());
		
	}
	
	// clientMap�� ����� ��ü ����ڿ��� �޽����� �����ϴ� �޼���
	private void sendToAll(String msg){
		// clientMap�� ������ ������ŭ �ݺ�
		for(String name: clientMap.keySet()){
			try {
				// �� ������� Socket�� �̿��Ͽ� OutputStream��ü�� ���Ѵ�.
				
				DataOutputStream dos = new DataOutputStream(clientMap.get(name).getOutputStream());
				dos.writeUTF(msg);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public void serverStart(){
		ServerSocket server = null;
		Socket socket = null;
		try {
			server = new ServerSocket(7777);
			System.out.println("������ ���۵Ǿ����ϴ�.");
			
			while(true){
			socket = server.accept(); // Ŭ���̾�Ʈ���� ������ ��ٸ���.
			System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+ "]���� �����߽��ϴ�.");
			
			// �޽����� �޾Ƽ� ��ü���� �����ϴ� Thread��ü�� �����Ͽ� �۵���Ų��.
			ServerReceiver serverThread = new ServerReceiver(socket);
			serverThread.start();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(server!=null)try {
				server.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TcpMultiChatServer().serverStart();
	}
	
	// Inner Class�� �������� Ŭ���̾�Ʈ�� �޽����� �����ϴ� Thread�� �����.
	class ServerReceiver extends Thread{
		private Socket socket;
		private DataInputStream dis; //����ڰ� �����޽���
		private DataOutputStream dos;
		
		//������ 
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				// ���ſ� ��ü ����
				dis = new DataInputStream(socket.getInputStream());
				
				// �۽ſ� ��ü ����
				dos = new DataOutputStream(socket.getOutputStream());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		} // ������ ��
		
		@Override
		public void run() {
			String name = "";
			try {
				while(true){
					// Ŭ���̾�Ʈ�� ������ �Ϸ�Ǹ� ���ʷ� ������� �̸��� �����ϴµ� �� �̸��� �ߺ��Ǵ��� ���θ� feedBack���� 
					// Ŭ���̾�Ʈ���� �����ش�.
					name = dis.readUTF(); // Ŭ���̾�Ʈ�� ���� name�� read�� ���� @@
					
					if(clientMap.containsKey(name)){ //�̸��� �ߺ��Ǹ� 
						dos.writeUTF("�̸��ߺ�"); //�ǵ�� ����� write�� Ŭ���̾�Ʈ���� �����ش�.##
					}else{// �̸��� �ߺ����� ���� ��
						dos.writeUTF("ok");
						break;
					}
				}
				// ��ȭ��(�̸�)�� ���� ������ �ִ� �ٸ� Ŭ���̾�Ʈ�鿡�� ��ȭ��(�̸�)�� �̿��ؼ�
				// ��ȭ�� ���� �޽����� ������.
				sendToAll("["+name+"]���� ��ȭ�濡 �����߽��ϴ�.");
				
				// ��ȭ��� Ŭ���̾�Ʈ�� Socket��ü�� Map�� �����Ѵ�.
				clientMap.put(name, socket);
				
				System.out.println("���� ���� ������ ��: "
				             + clientMap.size()+"��");
				
				// �� Ŭ���̾�Ʈ�� ���� �޽����� ��ü Ŭ���̾�Ʈ���� �������ش�.
				while(dis!=null){
					sendToAll(dis.readUTF());
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally{ // �� �����(Ŭ���̾�Ʈ)�� ������ �������� finally������ ����ȴ�.
				// ����� ��Ͽ��� �ش� Ŭ���̾�Ʈ�� �����Ѵ�.
				clientMap.remove(name);
				
				// ��ü Ŭ���̾�Ʈ���� ���� ��ȭ���� �����ٴ� �޽��� ����
				sendToAll("["+ name + "] ���� ��ȭ���� �������ϴ�.");
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+ "]���� ������ �����߽��ϴ�.");
				System.out.println("���� ���� ������ ��: "
			             + clientMap.size()+"��");
				
				
			}

		}
	}
}

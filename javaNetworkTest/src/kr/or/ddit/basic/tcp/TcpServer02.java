package kr.or.ddit.basic.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer02 {

	public static void main(String[] args) {
		// ServerSocket κ°μ²΄λ₯? λ§λ€κ³?, ?΄?Ό?΄?Έ?Έκ°? ? ??΄?€λ©? Socket? λ§λ€?΄? λ©μμ§?λ₯? λ³΄λ΄? ?΄??€?? λ©μμ§?λ₯? λ°λ ?΄??€?
		// ?΄ Socket? ?κ²¨μ??€.
		
		try {
			ServerSocket server = new ServerSocket(7777);
			
			System.out.println("?λ²κ? μ€?λΉμ€???€.");
			Socket socket = server.accept();
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (IOException e) {
		
		}
		
	
	}

}

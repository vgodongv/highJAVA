package kr.or.ddit.basic.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer02 {

	public static void main(String[] args) {
		// ServerSocket 객체�? 만들�?, ?��?��?��?��?���? ?��?��?��?���? Socket?�� 만들?��?�� 메시�?�? 보내?�� ?��?��?��?? 메시�?�? 받는 ?��?��?��?��
		// ?�� Socket?�� ?��겨�??��.
		
		try {
			ServerSocket server = new ServerSocket(7777);
			
			System.out.println("?��버�? �?비중?��?��?��.");
			Socket socket = server.accept();
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (IOException e) {
		
		}
		
	
	}

}

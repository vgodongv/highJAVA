package kr.or.ddit.basic.tcp;

import java.net.Socket;

public class TcpClient02 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.42.137", 7777);
			System.out.println("?„œë²„ì— ?—°ê²°ë˜?—ˆ?Šµ?‹ˆ?‹¤.");
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

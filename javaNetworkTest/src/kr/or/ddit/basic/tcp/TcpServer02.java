package kr.or.ddit.basic.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer02 {

	public static void main(String[] args) {
		// ServerSocket ê°ì²´ë¥? ë§Œë“¤ê³?, ?´?¼?´?–¸?Š¸ê°? ? ‘?†?•´?˜¤ë©? Socket?„ ë§Œë“¤?–´?„œ ë©”ì‹œì§?ë¥? ë³´ë‚´?Š” ?´?˜?Š¤?? ë©”ì‹œì§?ë¥? ë°›ëŠ” ?´?˜?Š¤?—
		// ?´ Socket?„ ?„˜ê²¨ì??‹¤.
		
		try {
			ServerSocket server = new ServerSocket(7777);
			
			System.out.println("?„œë²„ê? ì¤?ë¹„ì¤‘?…?‹ˆ?‹¤.");
			Socket socket = server.accept();
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (IOException e) {
		
		}
		
	
	}

}

package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.net.Socket;

// ?´ ?´?˜?Š¤?Š” Socket?„ ?†µ?•´?„œ ë©”ì‹œì§?ë¥? ë°›ì•„?„œ ?™”ë©´ì— ì¶œë ¥?•˜?Š” ?—­?• ?„ ?‹´?‹¹?•œ?‹¤.
public class Receiver extends Thread{
	private Socket socket;
	private DataInputStream dis; //?°?´?„°ë¥? ?…? ¥ ë°›ìŒ
	
	public Receiver(Socket socket) {
		this.socket = socket;
		
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		while(dis!=null){
			try {
				System.out.println(dis.readUTF());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

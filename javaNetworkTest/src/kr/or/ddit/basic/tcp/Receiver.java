package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.net.Socket;

// ?�� ?��?��?��?�� Socket?�� ?��?��?�� 메시�?�? 받아?�� ?��면에 출력?��?�� ?��?��?�� ?��?��?��?��.
public class Receiver extends Thread{
	private Socket socket;
	private DataInputStream dis; //?��?��?���? ?��?�� 받음
	
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

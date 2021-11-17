package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.net.Socket;

// ?΄ ?΄??€? Socket? ?΅?΄? λ©μμ§?λ₯? λ°μ? ?λ©΄μ μΆλ ₯?? ?­? ? ?΄?Ή??€.
public class Receiver extends Thread{
	private Socket socket;
	private DataInputStream dis; //?°?΄?°λ₯? ?? ₯ λ°μ
	
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

package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

// ?�� ?��?��?��?�� Socket?�� ?��?��?�� 메시�?�? 보내?�� ?��?���? ?��?��?��?�� ?��?��?��?��?��.
public class Sender extends Thread {
	private Socket socket; //?��켓을 ???��?�� �??��
	private DataOutputStream dos; //메시�?�? 보내?�� ?��?���?. ?��?��객체
	
	private String name; // ?���?메세�?�? 보냈?���? 구분
	private Scanner scan;
	
	// ?��?��?��
	public Sender(Socket socket) {// ?��켓객체�?? 받아?�� 초기?��
		this.socket = socket;
		scan = new Scanner(System.in);
		
		System.out.print("?���? ?��?��: ");
		name = scan.nextLine();
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() { //?��?��?���? ?��?��받아?�� ?��?��만해주면?��
		while(dos!=null){
			try {
				dos.writeUTF(name + ":"+scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

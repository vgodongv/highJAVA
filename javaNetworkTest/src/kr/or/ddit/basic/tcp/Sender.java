package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

// ?΄ ?΄??€? Socket? ?΅?΄? λ©μμ§?λ₯? λ³΄λ΄? ?­? λ§? ?΄?Ή?? ?΄??€?΄?€.
public class Sender extends Thread {
	private Socket socket; //?μΌμ ???₯?  λ³??
	private DataOutputStream dos; //λ©μμ§?λ₯? λ³΄λ΄? ?­? λ§?. ? ?‘κ°μ²΄
	
	private String name; // ?κ°?λ©μΈμ§?λ₯? λ³΄λ?μ§? κ΅¬λΆ
	private Scanner scan;
	
	// ??±?
	public Sender(Socket socket) {// ?μΌκ°μ²΄λ?? λ°μ? μ΄κΈ°?
		this.socket = socket;
		scan = new Scanner(System.in);
		
		System.out.print("?΄λ¦? ?? ₯: ");
		name = scan.nextLine();
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() { //?°?΄?°λ₯? ?? ₯λ°μ? ? ?‘λ§ν΄μ£Όλ©΄?¨
		while(dos!=null){
			try {
				dos.writeUTF(name + ":"+scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

// ?´ ?´?˜?Š¤?Š” Socket?„ ?†µ?•´?„œ ë©”ì‹œì§?ë¥? ë³´ë‚´?Š” ?—­?• ë§? ?‹´?‹¹?•˜?Š” ?´?˜?Š¤?´?‹¤.
public class Sender extends Thread {
	private Socket socket; //?†Œì¼“ì„ ???¥?•  ë³??ˆ˜
	private DataOutputStream dos; //ë©”ì‹œì§?ë¥? ë³´ë‚´?Š” ?—­?• ë§?. ? „?†¡ê°ì²´
	
	private String name; // ?ˆ„ê°?ë©”ì„¸ì§?ë¥? ë³´ëƒˆ?Š”ì§? êµ¬ë¶„
	private Scanner scan;
	
	// ?ƒ?„±?
	public Sender(Socket socket) {// ?†Œì¼“ê°ì²´ë?? ë°›ì•„?„œ ì´ˆê¸°?™”
		this.socket = socket;
		scan = new Scanner(System.in);
		
		System.out.print("?´ë¦? ?…? ¥: ");
		name = scan.nextLine();
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() { //?°?´?„°ë¥? ?…? ¥ë°›ì•„?„œ ? „?†¡ë§Œí•´ì£¼ë©´?¨
		while(dos!=null){
			try {
				dos.writeUTF(name + ":"+scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

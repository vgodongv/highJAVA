package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer01 {

	public static void main(String[] args) throws IOException {
		// TCP ?†Œì¼? ?†µ?‹ ?„ ?œ„?•´?„œ ServerSocketê°ì²´ë¥? ?ƒ?„±?•œ?‹¤.
		ServerSocket server = new ServerSocket(7777); // throws IOException
		
		System.out.println("?„œë²„ê? ? ‘?†?„ ê¸°ë‹¤ë¦½ë‹ˆ?‹¤.");
		
		
		 //accept(): ?´?¼?´?–¸?Š¸?—?„œ ?—°ê²? ?š”ì²??´ ?˜¬?•Œê¹Œì? ê¸°ë‹¤ë¦°ë‹¤. ?—°ê²? ?š”ì²??´ ?˜¤ë©? ?´?¼?´?–¸?Š¸?? ?—°ê²°ëœ Socketê°ì²´ë¥? ?ƒ?„±?•´?„œ ë°˜í™˜?•œ?‹¤. 
		
		Socket socket = server.accept();
		
		//aceept() ?´?›„?˜ ?‚´?š©?? ?—°ê²°ì´ ?™„ë£Œë˜?–´?•¼ë§? ?‹¤?–‰?œ?‹¤.
		System.out.println("?´?¼?´?–¸?Š¸?? ?—°ê²°ì´ ?™„ë£Œë˜?—ˆ?Šµ?‹ˆ?‹¤.");
		System.out.println();
		
		System.out.println("?†Œì¼“ìœ¼ë¡? ?—°ê²°ëœ ?ƒ??ë°©ì— ???•œ ? •ë³?");
		System.out.println("IPì£¼ì†Œ: "+ socket.getInetAddress().getHostAddress()); // socket.getInetAddress()-?†Œì¼“ìœ¼ë¡? ?—°ê²°ëœ ?ƒ??ë°©ì— ???•œ ? •ë³?
		// getHostAddress()-ipì£¼ì†Œ
		System.out.println("Portë²ˆí˜¸: "+ socket.getPort());
		System.out.println();
		
		System.out.println("?†Œì¼“ìœ¼ë¡? ?—°ê²°ëœ ë¡œì»¬ ì»´í“¨?„°?— ???•œ ? •ë³?");
		System.out.println("IPì£¼ì†Œ: "+ socket.getLocalAddress());
		System.out.println("Portë²ˆí˜¸: "+ socket.getLocalPort());
		
		// ?´?¼?´?–¸?Š¸?—ê²? ë©”ì‹œì§? ë³´ë‚´ê¸?
		// Socket?˜ OutputStreamê°ì²´ë¥? ?´?š©?•˜?—¬ ? „?†¡?•œ?‹¤.
		// socket.getOutputStream()ë©”ì„œ?“œë¥? ?´?š©?•˜?—¬ ì¶œë ¥?š© ?Š¤?Š¸ë¦? ê°ì²´ë¥? êµ¬í•  ?ˆ˜ ?ˆ?‹¤.
		OutputStream out = socket.getOutputStream(); //ë°”ì´?Š¸ ê¸°ë°˜ ?Š¤?Š¸ë¦¼ì„
		DataOutputStream dos = new DataOutputStream(out); //ë³??™˜
		
		// ?´?¼?´?–¸?Š¸?— ë©”ì‹œì§?ë¥? ë³´ë‚¸?‹¤. (?´?¼?´?–¸?Š¸ë¡? ì¶œë ¥?•˜?Š” ë°©ì‹?œ¼ë¡? ì²˜ë¦¬?•œ?‹¤.)
		dos.writeUTF("?•„ë°°ê³ ?ŒŒ. ?•„ì§‘ì—ê°ˆë˜");
		System.out.println("?´?¼?´?–¸?Š¸?—ê²? ë©”ì‹œì§?ë¥? ë³´ëƒˆ?Šµ?‹ˆ?‹¤.");
		
		// ?Š¤?Š¸ë¦¼ê³¼ ?†Œì¼“ë‹«ê¸?
		dos.close();
		socket.close();
		server.close();
		
	}

}

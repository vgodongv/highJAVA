package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient01 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		/*
		  ?‚´ ì»´í“¨?„°ë¥? ?‚˜???‚´?Š” ë°©ë²•
		  1) ?›?˜?˜ IPì£¼ì†Œë¡? ?‘œ?˜„?•˜?Š” ë°©ë²•. ?˜ˆ)192.168.42.138 -?ƒ?™©?—?”°?¼ ë°”ë??
		  2) ì§?? •?œ IPì£¼ì†Œ. ?˜ˆ) 127.0.0.1
		  3) ?›?˜?˜ ì»´í“¨?„° ?´ë¦?. ?˜ˆ) DESKTOP-NRJ0D4G
		  4) ì§?? •?œ ì»´í“¨?„° ?´ë¦?. ?˜ˆ) localhost
		 */
		String serverIp = "192.168.42.138"; //?œ„?— 4ê°?ì§?ì¤? ?•„ë¬´ê±°?‚˜ ?“°ë©´ë¨
		System.out.println(serverIp+"?„œë²„ì— ?—°ê²°ì¤‘?…?‹ˆ?‹¤.");
		System.out.println();
		
		// ?„œë²„ì˜ IPì£¼ì†Œ?? ?¬?Š¸ë²ˆí˜¸ë¥? ì§?? •?•˜?—¬ Socket ê°ì²´ë¥? ?ƒ?„±?•œ?‹¤.
		// Socketê°ì²´?Š” ?ƒ?„±?´ ?™„ë£Œë˜ë©? ?•´?‹¹ ?„œë²„ë¡œ ?š”ì²??‹ ?˜¸ë¥? ë³´ë‚¸?‹¤.
		Socket socket = new Socket(serverIp, 7777); // throws UnknownHostException, IOException
		
		// ?´ ë¶?ë¶? ?´?›„?Š” ?„œë²„ì? ?—°ê²°ì´ ?™„ë£Œëœ ?´?›„?— ?‹¤?–‰?˜?Š” ì½”ë“œ?´?‹¤.
		System.out.println("?„œë²„ì— ?—°ê²°ë˜?—ˆ?Šµ?‹ˆ?‹¤.");
		System.out.println();
		
		// ?„œë²„ì—?„œ ë³´ë‚´?˜¨ ë©”ì‹œì§?ë¥? ë°›ì•„?„œ ?™”ë©´ì— ì¶œë ¥?•˜ê¸?
		// ?ƒ??ë°©ì´ ë³´ë‚´?˜¨ ?°?´?„°?Š” Socket?˜ InputStreamê°ì²´ë¥? ?´?š©?•œ?‹¤.
		// socket.getInputStream()ë©”ì„œ?“œë¡? ?…? ¥?š© ?Š¤?Š¸ë¦? ê°ì²´ë¥? êµ¬í•œ?‹¤.
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		// ?„œë²„ê? ë³´ë‚´?˜¨ ?ë£Œë?? ë°›ì•„?„œ ì¶œë ¥?•œ?‹¤. (?ë£Œì˜ ?…? ¥)
		System.out.println("?„œë²„ì—?„œ ë³´ë‚´?˜¨ ë©”ì‹œì§?: "+ dis.readUTF());
		System.out.println();
		
		System.out.println("?—°ê²°ì„ ì¢…ë£Œ?•©?‹ˆ?‹¤.");
		
		//?Š¤?Š¸ë¦¼ê³¼ ?†Œì¼? ?‹«ê¸?
		dis.close();
		socket.close();

	}

}

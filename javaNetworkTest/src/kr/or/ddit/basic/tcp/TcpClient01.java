package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient01 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		/*
		  ?΄ μ»΄ν¨?°λ₯? ????΄? λ°©λ²
		  1) ??? IPμ£Όμλ‘? ???? λ°©λ². ?)192.168.42.138 -??©??°?Ό λ°λ??
		  2) μ§?? ? IPμ£Όμ. ?) 127.0.0.1
		  3) ??? μ»΄ν¨?° ?΄λ¦?. ?) DESKTOP-NRJ0D4G
		  4) μ§?? ? μ»΄ν¨?° ?΄λ¦?. ?) localhost
		 */
		String serverIp = "192.168.42.138"; //?? 4κ°?μ§?μ€? ?λ¬΄κ±°? ?°λ©΄λ¨
		System.out.println(serverIp+"?λ²μ ?°κ²°μ€???€.");
		System.out.println();
		
		// ?λ²μ IPμ£Όμ?? ?¬?Έλ²νΈλ₯? μ§?? ??¬ Socket κ°μ²΄λ₯? ??±??€.
		// Socketκ°μ²΄? ??±?΄ ?λ£λλ©? ?΄?Ή ?λ²λ‘ ?μ²?? ?Έλ₯? λ³΄λΈ?€.
		Socket socket = new Socket(serverIp, 7777); // throws UnknownHostException, IOException
		
		// ?΄ λΆ?λΆ? ?΄?? ?λ²μ? ?°κ²°μ΄ ?λ£λ ?΄?? ?€??? μ½λ?΄?€.
		System.out.println("?λ²μ ?°κ²°λ??΅??€.");
		System.out.println();
		
		// ?λ²μ? λ³΄λ΄?¨ λ©μμ§?λ₯? λ°μ? ?λ©΄μ μΆλ ₯?κΈ?
		// ???λ°©μ΄ λ³΄λ΄?¨ ?°?΄?°? Socket? InputStreamκ°μ²΄λ₯? ?΄?©??€.
		// socket.getInputStream()λ©μ?λ‘? ?? ₯?© ?€?Έλ¦? κ°μ²΄λ₯? κ΅¬ν?€.
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		// ?λ²κ? λ³΄λ΄?¨ ?λ£λ?? λ°μ? μΆλ ₯??€. (?λ£μ ?? ₯)
		System.out.println("?λ²μ? λ³΄λ΄?¨ λ©μμ§?: "+ dis.readUTF());
		System.out.println();
		
		System.out.println("?°κ²°μ μ’λ£?©??€.");
		
		//?€?Έλ¦Όκ³Ό ?μΌ? ?«κΈ?
		dis.close();
		socket.close();

	}

}

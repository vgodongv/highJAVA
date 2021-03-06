package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer01 {

	public static void main(String[] args) throws IOException {
		// TCP ?μΌ? ?΅? ? ??΄? ServerSocketκ°μ²΄λ₯? ??±??€.
		ServerSocket server = new ServerSocket(7777); // throws IOException
		
		System.out.println("?λ²κ? ? ?? κΈ°λ€λ¦½λ?€.");
		
		
		 //accept(): ?΄?Ό?΄?Έ?Έ?? ?°κ²? ?μ²??΄ ?¬?κΉμ? κΈ°λ€λ¦°λ€. ?°κ²? ?μ²??΄ ?€λ©? ?΄?Ό?΄?Έ?Έ?? ?°κ²°λ Socketκ°μ²΄λ₯? ??±?΄? λ°ν??€. 
		
		Socket socket = server.accept();
		
		//aceept() ?΄?? ?΄?©?? ?°κ²°μ΄ ?λ£λ?΄?Όλ§? ?€???€.
		System.out.println("?΄?Ό?΄?Έ?Έ?? ?°κ²°μ΄ ?λ£λ??΅??€.");
		System.out.println();
		
		System.out.println("?μΌμΌλ‘? ?°κ²°λ ???λ°©μ ??? ? λ³?");
		System.out.println("IPμ£Όμ: "+ socket.getInetAddress().getHostAddress()); // socket.getInetAddress()-?μΌμΌλ‘? ?°κ²°λ ???λ°©μ ??? ? λ³?
		// getHostAddress()-ipμ£Όμ
		System.out.println("Portλ²νΈ: "+ socket.getPort());
		System.out.println();
		
		System.out.println("?μΌμΌλ‘? ?°κ²°λ λ‘μ»¬ μ»΄ν¨?°? ??? ? λ³?");
		System.out.println("IPμ£Όμ: "+ socket.getLocalAddress());
		System.out.println("Portλ²νΈ: "+ socket.getLocalPort());
		
		// ?΄?Ό?΄?Έ?Έ?κ²? λ©μμ§? λ³΄λ΄κΈ?
		// Socket? OutputStreamκ°μ²΄λ₯? ?΄?©??¬ ? ?‘??€.
		// socket.getOutputStream()λ©μ?λ₯? ?΄?©??¬ μΆλ ₯?© ?€?Έλ¦? κ°μ²΄λ₯? κ΅¬ν  ? ??€.
		OutputStream out = socket.getOutputStream(); //λ°μ΄?Έ κΈ°λ° ?€?Έλ¦Όμ
		DataOutputStream dos = new DataOutputStream(out); //λ³??
		
		// ?΄?Ό?΄?Έ?Έ? λ©μμ§?λ₯? λ³΄λΈ?€. (?΄?Ό?΄?Έ?Έλ‘? μΆλ ₯?? λ°©μ?Όλ‘? μ²λ¦¬??€.)
		dos.writeUTF("?λ°°κ³ ?. ?μ§μκ°λ");
		System.out.println("?΄?Ό?΄?Έ?Έ?κ²? λ©μμ§?λ₯? λ³΄λ?΅??€.");
		
		// ?€?Έλ¦Όκ³Ό ?μΌλ«κΈ?
		dos.close();
		socket.close();
		server.close();
		
	}

}

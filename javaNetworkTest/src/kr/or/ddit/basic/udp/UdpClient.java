package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// �۽ſ�, ���ſ� ��Ŷ ��ü ���� ����
		DatagramPacket inpacket, outpacket;
		
		// ���� ���� �����Ͱ� ����� byte�� �迭
		byte[] bMsg = new byte[512];
		
		try {
			DatagramSocket socket = new DatagramSocket();
			
			// ������ ���� �ּҸ� �����Ѵ�.
			InetAddress address = InetAddress.getByName("localhost");
			
			while(true){
				// ������ �޽��� �Է�
				System.out.print("������ �޽��� �Է�: ");
				String msg = scan.nextLine();
				
				if("/end".equals(msg)){
					break;
				}
				// ������ ��Ŷ ��ü ����
				outpacket = new DatagramPacket(msg.getBytes("utf-8"), msg.getBytes("utf-8").length, address, 8888 );
				
				// ����
				socket.send(outpacket);
				
				// �������� ������ �޽��� �޾Ƽ� ����ϱ�
				// ���ſ� ��Ŷ��ü ����
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				// ����
				socket.receive(inpacket);
				
				System.out.println("������ ���� ������: "+ new String(bMsg, 0, inpacket.getLength()) );
			}
			
			System.out.println("��ų�");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

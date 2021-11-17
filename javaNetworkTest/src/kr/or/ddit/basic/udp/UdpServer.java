package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
  	UDP���: �񿬰� ����, �ŷڼ��� ����. �����Ͱ� ������� �����Ѵٴ� ������ ����.
  	                ������ TCP���� �ӵ��� ������. �ǽð� ���ۿ� �����ϴ�.
           	DatagramSocket ��ü�� DatagramPacket��ü�� �̿��ؼ� ����Ѵ�.
           	- DatagramSocket: �������� �ۼ��Ű� ���õ� �۾��� �����Ѵ�.(��ü�ο���)
           	- DatagramPacket: �ְ�޴� �����Ϳ� ���õ� �۾��� �����Ѵ�.(����)
           	                                    ������ ���� �����ڿ� �۽��� ���� �����ڸ� ���� �����Ѵ�.
           	                                   
 */

public class UdpServer {
	public static void main(String[] args) {
		try {
			// ����� ��Ʈ��ȣ�� ����(�������)�Ͽ� ������ �����Ѵ�.
			DatagramSocket socket = new DatagramSocket(8888);
			
			// ���ſ� ��Ŷ������ �۽ſ� ��Ŷ������ �����Ѵ�.
			DatagramPacket inpacket, outpacket;
			System.out.println("���� ������");
			
			while(true){
				// �����Ͱ� ����� byte�� �迭 ����
				byte[] bMsg = new byte[512];
				
				// ���ſ� ��Ŷ��ü ����: �����Ͱ� ����� byte���迭, �迭�� ���̸� �̿��Ͽ� �����Ѵ�.
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				// �����͸� �����Ѵ�. �� �޼���� �����Ͱ� �� ������ ��ٸ���.
				// ���ŵ� �������� ��Ŷ������ ������ ��Ŷ������ ����ȴ�.
				socket.receive(inpacket); //receive: ������ ���� �޽����� �޾�(����) ����
				
				// ���Ź��� ��Ŷ���� ������ IP�ּ�, ��Ʈ��ȣ ���� �� �� �ִ�.
				InetAddress address = inpacket.getAddress();
				int port = inpacket.getPort();
				
				System.out.println("������ IP����: "+ address);
				System.out.println("������ port��ȣ: "+ port);
				
				// ������ ���� �޽��� ȭ�鿡 ����ϱ�
				// inpacket.getLength() : ���� �о�� ����
				// inpacket.getData() : ���� �о�� �����͸� byte�迭�� ��ȯ�Ѵ�.
				// ���� �����ʹ� ���ſ� ��Ŷ��ü�� ������ byte�� �迭���� ����ȴ�.
				
				// ���1
				// String msg = new String(bMsg, 0, inpacket.getLength());
				
				// ���2
				String msg = new String(inpacket.getData(), 0, inpacket.getLength());
				
				System.out.println("������ ���� �޽���: "+ msg);
				System.out.println();
				
				// ���濡�� �޽��� ������(���Ź��� �޽��� �״�� �۽��Ѵ�.)
				// �۽��� �޽����� byte�� �迭�� ��ȯ�Ѵ�.
				byte[] sendMsg = msg.getBytes("utf-8");
				
				// �۽ſ� ��Ŷ ��ü ����: 
				// ������ �����Ͱ� ����� byte�� �迭, ������ �ڷ��� ����(�迭�Ǳ���), �����ּ�����, ������Ʈ��ȣ�� �ʿ��ϴ�.
				outpacket = new DatagramPacket(sendMsg, sendMsg.length, address, port);
				
				// �۽��ϱ�: send �޼��� �̿�
				socket.send(outpacket);
				System.out.println("�۽ſϷ�");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

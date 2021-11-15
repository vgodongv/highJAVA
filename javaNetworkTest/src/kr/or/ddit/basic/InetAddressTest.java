package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException { //throws�� ����ó�� �˾Ƽ���.
		// InetAddress Ŭ����: IP�ּҸ� �ٷ�� ���� Ŭ����
		
		// www.naver.com�� IP������ ��������
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		
		System.out.println("Host Name : "+ naverIp.getHostName()); // ������ ȣ��Ʈ���� www.naver.com ���
		System.out.println("Host Address: "+ naverIp.getHostAddress()); //���������� �ٿ��ֱ� �ϸ� ���̹� ���ӵ�~����ó���س����� ����
		System.out.println("toString: "+ naverIp.toString()); //ip�ּҿ� ȣ��Ʈ������ �Բ� �����ش�.
		System.out.println();
		
		// �ڽ��� ��ǻ���� IP���� ��������
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("�� ��ǻ���� Host Name: "+ localIp.getHostName());
		System.out.println("�� ���� Host Address: "+ localIp.getHostAddress());
		System.out.println();
		
		// IP�ּҰ� �������� ȣ��Ʈ�� ���� ��������. �������ϱ�迭�� ��Ƽ�
		InetAddress[] ips = InetAddress.getAllByName("www.naver.com");
		for(InetAddress ip : ips){
			System.out.println(ip.toString());
			
		}
		
		
	}

}

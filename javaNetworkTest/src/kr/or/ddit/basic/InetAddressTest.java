package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException { //throws가 예외처리 알아서함.
		// InetAddress 클래스: IP주소를 다루기 위한 클래스
		
		// www.naver.com의 IP정보를 가져오기
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		
		System.out.println("Host Name : "+ naverIp.getHostName()); // 지정한 호스트네임 www.naver.com 출력
		System.out.println("Host Address: "+ naverIp.getHostAddress()); //웹브라우저에 붙여넣기 하면 네이버 접속됨~보안처리해놨으면 못봄
		System.out.println("toString: "+ naverIp.toString()); //ip주소와 호스트네임을 함께 보여준다.
		System.out.println();
		
		// 자신의 컴퓨터의 IP정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 Host Name: "+ localIp.getHostName());
		System.out.println("내 컴의 Host Address: "+ localIp.getHostAddress());
		System.out.println();
		
		// IP주소가 여러개인 호스트의 정보 가져오기. 여러개니까배열에 담아서
		InetAddress[] ips = InetAddress.getAllByName("www.naver.com");
		for(InetAddress ip : ips){
			System.out.println(ip.toString());
			
		}
		
		
	}

}

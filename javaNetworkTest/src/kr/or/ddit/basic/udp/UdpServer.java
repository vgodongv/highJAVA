package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
  	UDP방식: 비연결 지향, 신뢰성이 없다. 데이터가 순서대로 도착한다는 보장이 없다.
  	                하지만 TCP보다 속도가 빠르다. 실시간 전송에 유리하다.
           	DatagramSocket 객체와 DatagramPacket객체를 이용해서 통신한다.
           	- DatagramSocket: 데이터의 송수신과 관련된 작업을 수행한다.(우체부역할)
           	- DatagramPacket: 주고받는 데이터와 관련된 작업을 수행한다.(소포)
           	                                    수신을 위한 생성자와 송신을 위한 생성자를 따로 제공한다.
           	                                   
 */

public class UdpServer {
	public static void main(String[] args) {
		try {
			// 통신할 포트번호를 지정(내맘대로)하여 소켓을 생성한다.
			DatagramSocket socket = new DatagramSocket(8888);
			
			// 수신용 패킷변수와 송신용 패킷변수를 선언한다.
			DatagramPacket inpacket, outpacket;
			System.out.println("서버 실행중");
			
			while(true){
				// 데이터가 저장될 byte형 배열 선언
				byte[] bMsg = new byte[512];
				
				// 수신용 패킷객체 생성: 데이터가 저장될 byte형배열, 배열의 길이를 이용하여 생성한다.
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				// 데이터를 수신한다. 이 메서드는 데이터가 올 때까지 기다린다.
				// 수신된 데이터의 패킷정보는 지정한 패킷변수에 저장된다.
				socket.receive(inpacket); //receive: 상대방이 보낸 메시지를 받아(수신) 저장
				
				// 수신받은 패킷에서 상대방의 IP주소, 포트번호 등을 알 수 있다.
				InetAddress address = inpacket.getAddress();
				int port = inpacket.getPort();
				
				System.out.println("상대방의 IP정보: "+ address);
				System.out.println("상대방의 port번호: "+ port);
				
				// 상대방이 보낸 메시지 화면에 출력하기
				// inpacket.getLength() : 실제 읽어온 길이
				// inpacket.getData() : 실제 읽어온 데이터를 byte배열로 반환한다.
				// 실제 데이터는 수신용 패킷객체에 지정한 byte형 배열에도 저장된다.
				
				// 방법1
				// String msg = new String(bMsg, 0, inpacket.getLength()),"utf-8");
				
				// 방법2
				String msg = new String(inpacket.getData(), 0, inpacket.getLength(),"utf-8");
				
				if("/end".equals(msg)){
					break;
				}
				
				System.out.println("상대방이 보낸 메시지: "+ msg);
				System.out.println();
				
				// 상대방에게 메시지 보내기(수신받은 메시지 그대로 송신한다.)
				// 송신할 메시지를 byte형 배열로 변환한다.
				byte[] sendMsg = msg.getBytes("utf-8");
				
				// 송신용 패킷 객체 생성: 
				// 전송할 데이터가 저장된 byte형 배열, 전송할 자료의 길이(배열의길이), 상대방주소정보, 상대방포트번호가 필요하다.
				outpacket = new DatagramPacket(sendMsg, sendMsg.length, address, port);
				
				// 송신하기: send 메서드 이용
				socket.send(outpacket);
				System.out.println("송신완료");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

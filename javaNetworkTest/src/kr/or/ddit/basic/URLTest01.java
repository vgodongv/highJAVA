package kr.or.ddit.basic;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest01 {

	public static void main(String[] args) throws MalformedURLException {
		// URL 클래스: 인터넷에 존재하는 서버들의 자원에 접근할 수 있는 주소를 다루는 클래스
		
		// http://www.ddit.or.kr:80/index.html?ttt=123
		
		URL url = new URL("http", "www.ddit.or.kr", 80, "index.html?ttt=123");
		
		System.out.println("Protocol : "+ url.getProtocol());
		System.out.println("Host: "+ url.getHost());
		System.out.println("Port: "+ url.getPort());
		System.out.println("File: "+ url.getFile());   // 파일이름+쿼리string
		System.out.println("Path: "+ url.getPath());   // 파일이름까지
		System.out.println("Query: "+ url.getQuery()); //쿼리string
		System.out.println();
		
		System.out.println(url.toExternalForm());
	}

}

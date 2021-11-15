package kr.or.ddit.basic;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest01 {

	public static void main(String[] args) throws MalformedURLException {
		// URL Ŭ����: ���ͳݿ� �����ϴ� �������� �ڿ��� ������ �� �ִ� �ּҸ� �ٷ�� Ŭ����
		
		// http://www.ddit.or.kr:80/index.html?ttt=123
		
		URL url = new URL("http", "www.ddit.or.kr", 80, "index.html?ttt=123");
		
		System.out.println("Protocol : "+ url.getProtocol());
		System.out.println("Host: "+ url.getHost());
		System.out.println("Port: "+ url.getPort());
		System.out.println("File: "+ url.getFile());   // �����̸�+����string
		System.out.println("Path: "+ url.getPath());   // �����̸�����
		System.out.println("Query: "+ url.getQuery()); //����string
		System.out.println();
		
		System.out.println(url.toExternalForm());
	}

}

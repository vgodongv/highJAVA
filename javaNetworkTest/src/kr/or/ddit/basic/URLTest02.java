package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLTest02 {

	public static void main(String[] args) throws IOException {
		// URLConnection : ���ø����̼ǰ� url���� ��� ������ ���� Ŭ����
		
		// Ư�� ������ ������ ���� ������ ������ ����ϴ� ����
		
		URL url = new URL("https://www.naver.com");
		
		URLConnection urlCon = url.openConnection();
		
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();
		for(String headerKey: headerMap.keySet()){
			System.out.println(headerKey+":"+headerMap.get(headerKey));
		}
		
		System.out.println();
		
		// �ش� ������ ������ ������ ȭ�鿡 ����ϱ�
		// (index.html���� ���� ��������)
		
		/* ���1) URLConnection��ü�� �̿��ϴ� ���
		// ������ �о���� ���� ��Ʈ�� ��ü�� ����
		InputStream is = urlCon.getInputStream(); // ������ �о�´� =�Է¹޴´�.
		InputStreamReader isr = new InputStreamReader(is, "utf-8"); //byte����� ���ڱ������ ��ȯ
		BufferedReader br = new BufferedReader(isr);
		
		// �ڷḦ �о�ͼ� ����ϱ�
		while(true){
			String str = br.readLine(); // InputStreamReader ���پ� �б�
			if(str==null){ // ���̻� �о�� �����Ͱ� ������
				break;
			}
			System.out.println(str);
			
		}
		br.close(); //��Ʈ�� �ݱ�*/
		
		// ���2) URL��ü�� �̿��ؼ� ��Ʈ�� ��ü�� ���Ѵ�.
		// URL��ü�� oepnStream()�޼��� �̿�
		InputStream is2 = url.openStream(); //openStreamdms: url ��ü�� InputStream������
		BufferedReader br2 = new BufferedReader(new InputStreamReader(is2, "utf-8")); 
		
		while(true){
			String str = br2.readLine(); // InputStreamReader ���پ� �б�
			if(str==null){ // ���̻� �о�� �����Ͱ� ������
				break;
			}
			System.out.println(str);
		}
		
	}

}






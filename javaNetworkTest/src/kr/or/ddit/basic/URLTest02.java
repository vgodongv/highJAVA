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
		// URLConnection : 애플리케이션과 url간의 통신 연결을 위한 클래스
		
		// 특정 서버의 정보와 파일 내용을 가져와 출력하는 예제
		
		URL url = new URL("https://www.naver.com");
		
		URLConnection urlCon = url.openConnection();
		
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();
		for(String headerKey: headerMap.keySet()){
			System.out.println(headerKey+":"+headerMap.get(headerKey));
		}
		
		System.out.println();
		
		// 해당 문서의 내용을 가져와 화면에 출력하기
		// (index.html문서 내용 가져오기)
		
		/* 방법1) URLConnection객체를 이용하는 방법
		// 파일을 읽어오기 위한 스트림 객체를 생성
		InputStream is = urlCon.getInputStream(); // 파일을 읽어온다 =입력받는다.
		InputStreamReader isr = new InputStreamReader(is, "utf-8"); //byte기반을 문자기반으로 변환
		BufferedReader br = new BufferedReader(isr);
		
		// 자료를 읽어와서 출력하기
		while(true){
			String str = br.readLine(); // InputStreamReader 한줄씩 읽기
			if(str==null){ // 더이상 읽어올 데이터가 없으면
				break;
			}
			System.out.println(str);
			
		}
		br.close(); //스트림 닫기*/
		
		// 방법2) URL객체를 이용해서 스트림 객체를 구한다.
		// URL객체의 oepnStream()메서드 이용
		InputStream is2 = url.openStream(); //openStreamdms: url 객체의 InputStream구해줌
		BufferedReader br2 = new BufferedReader(new InputStreamReader(is2, "utf-8")); 
		
		while(true){
			String str = br2.readLine(); // InputStreamReader 한줄씩 읽기
			if(str==null){ // 더이상 읽어올 데이터가 없으면
				break;
			}
			System.out.println(str);
		}
		
	}

}






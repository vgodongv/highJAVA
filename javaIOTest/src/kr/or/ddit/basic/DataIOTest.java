package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {

	public static void main(String[] args) {
	try {
		FileOutputStream fout = new FileOutputStream("d:/d_other/testData.dat");
		
		// 자료형 단위로 출력할 보조 스트림인 DataOutputStream객체생성
		DataOutputStream dout = new DataOutputStream(fout);
		
		dout.writeInt(200);// 정수형으로 출력한다.
		dout.writeFloat(123.45f); // 실수형으로 출력한다.
		dout.writeBoolean(false);
		dout.writeUTF("ABCDabcd");
		
		System.out.println("출력완료");
		dout.close(); //스트림 닫기
		
		// 출력한 데이터 읽어오기
		FileInputStream fin = new FileInputStream("d:/d_other/testData.dat");
		DataInputStream din = new DataInputStream(fin);
		
		// DataInputStream으로 자료를 읽어올 때는 DataOutputStream으로 출력한 순서와 같은 순서를 읽어와야한다.
		System.out.println("정수형: "+ din.readInt());
		System.out.println("실수형: "+ din.readFloat());
		System.out.println("논리형: "+ din.readBoolean());
		System.out.println("문자열: "+ din.readUTF());
		
		System.out.println("읽기작업완료");
		
		din.close();
	} catch (IOException e) {
		// TODO: handle exception
	}

	}

}

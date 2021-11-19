package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CopyOfJdbcTest04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JHY990208","java");

			System.out.println("계좌번호 정보 추가하기");
			
			String bankNo ="";
			int count =0;
			do{
			System.out.print("계좌번호: ");
		    bankNo =  scan.next();
		    String sql2 = "select count(*) cnt from bankinfo where bank_no = ? ";
		    pstmt2 = conn.prepareStatement(sql2);
		    pstmt2.setString(1, bankNo);
		    
		    rs = pstmt2.executeQuery();
		    
		    if(rs.next()){ // select문의 결과가 1개의레코드일 경우 if문 사용가능
		   /* 	count = rs.getInt(1);
		    	count = rs.getInt("count(*)");*/
		    	count = rs.getInt("cnt"); // 컬럼의 alias로 설정하기
		    }
		    if(count>0){
		    	System.out.println("중복입니돵");
		    }
			}while(count>0);
			
			System.out.print("은행명: ");
			String bankName = scan.next();
			System.out.print("예금주명: ");
			String bankUser = scan.next();

			// PreparedStatement를 이용하는 방법
			// SQL문을 작성할 때 데이터가 들어갈 자리를 물음표(?)로 표시한다.
			String sql = "insert into bankinfo values( ? , ? , ? , sysdate)";

			// PreparedStatement 객체를 생성한다. 이때 실행할 SQL문을 매개변수에 넘겨준다.
			// 미리 쿼리문을 컴파일해서 해석하기때문에  속도가 빠르다
			pstmt = conn.prepareStatement(sql);
			// SQL문의 물음표(?)자리에 들어갈 데이터를 세팅한다.
			// 사용법) pstmt.set자료형(물음표번호, 세팅할데이터)
			// 물음표 번호는 1번부터 시작
			pstmt.setString(1, bankNo);
			pstmt.setString(2, bankName);
			pstmt.setString(3, bankUser);

			// 데이터의 세팅이 완료되면 쿼리문을 실행한다.
			int cnt =pstmt.executeUpdate();

			System.out.println("반환값: "+ cnt);
			if(cnt>0){
				System.out.println("insert 성공");
			}else{
				System.out.println("insert 실패");
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//자원 반납 : 만들어진 순의 역순으로

			if(rs!=null) try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(pstmt!=null) try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(pstmt2!=null) try {
				pstmt2.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}

			if(conn!=null) try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}



}

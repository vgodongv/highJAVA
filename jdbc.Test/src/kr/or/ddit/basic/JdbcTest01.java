package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// JDBC(Java DataBase Connectivity) 라이브러리를 이용한 DB자료 처리하기

/*
- JDBC 처리 순서
1. 드라이버 로딩 : 라이브러리를 사용할 수 있게 메모리로 읽어들이는 작업. (라이브러리에는 DB와 JAVA를 연동해주는 클래스가 있다.)
  Class.forName("oracle.jdbc.driver.OracleDriver");
2. DB시스템에 접속하기 : 접속이 완료되면 Connection객체가 생성된다.
  DriverManager.getConnection()메서드를 이용한다.
  
  DriverManager.getConnection("jdbc:oracle:thin:@오라클서버IP주소:포트번호:SID값",user,password)
  
3. 질의 : 쿼리를 처리한다. SQL문장을 DB서버로 보내서 결과를 얻어온다.
  (Statement객체 또는 PreparedStatemnet객체를 이용하여 작업한다.)
4. 결과 처리 : 질의 결과를 받아서 원하는 작업을 수행한다.
   1) SQL문이 SELECT문일 경우: SELECT한 결과가 ResultSet객체에 저장되어 반환된다.
   2) SQL문이 INSERT, UPDATE, DELETE문일 경우: 정수값이 반횐된다. (이 정수값은 실행에 성공한 레코드 수를 의미한다.)
5. 사용자가 사용한 자원을 반납한다.
  close() 메서드를 이용한다.
*/

public class JdbcTest01 {


	public static void main(String[] args) {
	// DB작업에 필요한 객체변수 선언
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
		//1. 드라이버 로딩
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	
    	//2. DB연결: Connection객체 생성
    	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JHY990208","java");
    	
    	//3. 질의
    	//3-1) 실행할 SQL문 작성
    	String sql = "select * from lprod";
    	//3-2) Statement객체 또는 PreparedStatement객체를 생성한다. (Connection객체를 이용하여 생성한다.)
    	stmt = conn.createStatement();
    	//3-3) SQL문을 DB서버로 보내서 실행한 결과를 얻어온다. 지금은 실행한 SQL문이 SELECT문이라 결과가  ResultSet객체에 저장되어 반환된다.
    	rs = stmt.executeQuery(sql);
    	
    	//4. 결과 처리
    	// rs.next(): ResultSet객체의 데이터를 가리키는 포인터를 다음위치로 이동하고 그 곳에 데이터가 있으면 true를 반환한다.
    	// 데이터하나가 레코드
    	while(rs.next()){
    		// 포인터가 가리키는 곳의 자료 가져오기
    		// 형식1) rs.get가져올데이터의자료형("컬럼명")
    		// 형식2) rs.get가져올데이터의자료형(컬럼번호) : 컬럼번호는 1부터 시작한다. 0부터아님
    		// 형식3) rs.get가져올데이터의자료형("컬럼의 alias명")
    		System.out.println("lprod_id: "+rs.getInt("lprod_id"));
    		System.out.println("lprod_gu: "+rs.getString(2));
    		System.out.println("lprod_nm: "+rs.getString("lprod_nm"));
    		System.out.println();
    	
    	}
    			
	} catch (SQLException e) {
		// TODO: handle exception
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally{
		// 5. 자원 반납 : 만들어진 순의 역순으로
		if(rs!=null) try {
			rs.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		if(stmt!=null) try {
			stmt.close();
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

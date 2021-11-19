package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JHY990208","java");

			System.out.println("계좌번호 정보 추가하기");

			String sql2 = "select bank_no from bankinfo";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql2);


			String bankNo="";

			while(true){
				System.out.print("계좌번호: ");
				bankNo =  scan.next();
				boolean flag = true;

				while(rs.next()){

					if(rs.getString("bank_no").equals(bankNo)){
						System.out.println("중복입니다.");
						flag = false;
						break;
					}
				}
				if(flag){
					break;
				}
			}
			
			System.out.print("은행명: ");
			String bankName = scan.next();
			System.out.print("예금주명: ");
			String bankUser = scan.next();

			// '"사이에 공백 x
			String sql = "insert into bankinfo values('" + bankNo + "', '" + bankName+ "', '" + bankUser+"', sysdate)";

			// select문을 실행할때는 executeQuery()메서드를 사용하고
			// insert, update, delete문과 같이 select문이 아닌 쿼리문을 실행할때는 executeUpdate()메서드를 사용한다.
			// executeUpdate()메서드의 반환값은 작업에 성공한 레코드 수를 반환한다.
			int cnt = stmt.executeUpdate(sql);

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

package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 	LPROD 테이블에 새로운 데이터를 추가하기
 	lprod_gu와 lprod_nm은 직접 입력받아서 처리하고, lprod_id는 현재의 lprod_id값 중에서 제일 큰 값보다 1 크게한다.
 	
 	입력받은 lprod_gu가 이미 등록되어 있으면 다시 입력받아서 처리한다.
 	
 */
public class JdbcTest05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JHY990208","java");
			
			String sql2 = "select lprod_gu from lprod";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql2);
			
			String gu = "";
			
			while(true){
				System.out.println("lprod_gu를 입력하세요");
				gu = scan.nextLine();
				boolean flag = true;

				while(rs.next()){

					if(rs.getString("lprod_gu").equals(gu)){
						System.out.println("중복입니다.");
						flag = false;
						break;
					}
				}
				if(flag){
					break;
				}
			}
			
			System.out.println("lprod_nm를 입력하세요");
			String nm = scan.nextLine();
			
			
			String sql3 = "select nvl(MAX(lprod_id),0) MAX from lprod";
			rs =  stmt.executeQuery(sql3);
			int id = 0;
			if(rs.next()){
			id = rs.getInt("MAX")+1; // 컬럼의 alias로 설정하기
			 }
			
			String sql = " insert into lprod values(?, ? , ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
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
			if(conn!=null) try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

	}

}

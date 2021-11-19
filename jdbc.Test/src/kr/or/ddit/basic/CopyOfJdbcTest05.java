package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 	LPROD 테이블에 새로운 데이터를 추가하기
 	lprod_gu와 lprod_nm은 직접 입력받아서 처리하고, lprod_id는 현재의 lprod_id값 중에서 제일 큰 값보다 1 크게한다.
 	
 	입력받은 lprod_gu가 이미 등록되어 있으면 다시 입력받아서 처리한다.
 	
 */
public class CopyOfJdbcTest05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		Statement stmt = null;
		
		try {
			
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","JHY990208","java");*/
			
			conn = DBUtil.getConnection();
			
			// lprod_id 구하기
			String sql3 = "select nvl(MAX(lprod_id),0)+1 MAX from lprod";
			stmt = conn.createStatement();
			rs =  stmt.executeQuery(sql3);
			
			int id = 0;
			if(rs.next()){
			id = rs.getInt("MAX"); // 컬럼의 alias로 설정하기
			 }
			
			// gu 구하기
			String gu = "";
			int count = 0;
			
			do{
				System.out.println("상품 분류코드(gu)입력");
				gu = scan.nextLine();
				
				String sql2 = "select count(*) cnt from lprod where lprod_gu=?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, gu);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					count = rs.getInt("cnt");
				}
				
				if(count > 0){
					System.out.println("중복입니다.");
					
				}
				
			}while(count>0);
			
			System.out.println("lprod_nm를 입력하세요");
			String nm = scan.nextLine();
	
			String sql = " insert into lprod values(?, ? , ?)";
			
			// 왜 pstmt2? 걍 pstmt쓰면 안되는이유눙? 쿼리마다 prepareStatement만드는 이유는? 한쿼리마다 새로운 pstmt2 만들어주는게 좋다고 합니다~
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, id);
			pstmt2.setString(2, gu);
			pstmt2.setString(3, nm);
			
			int cnt =pstmt2.executeUpdate();
			
			System.out.println("반환값: "+ cnt);
			if(cnt>0){
				System.out.println("insert 성공");
			}else{
				System.out.println("insert 실패");
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		} /*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/finally{
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

package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 	LPROD ���̺� ���ο� �����͸� �߰��ϱ�
 	lprod_gu�� lprod_nm�� ���� �Է¹޾Ƽ� ó���ϰ�, lprod_id�� ������ lprod_id�� �߿��� ���� ū ������ 1 ũ���Ѵ�.
 	
 	�Է¹��� lprod_gu�� �̹� ��ϵǾ� ������ �ٽ� �Է¹޾Ƽ� ó���Ѵ�.
 	
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
			
			// lprod_id ���ϱ�
			String sql3 = "select nvl(MAX(lprod_id),0)+1 MAX from lprod";
			stmt = conn.createStatement();
			rs =  stmt.executeQuery(sql3);
			
			int id = 0;
			if(rs.next()){
			id = rs.getInt("MAX"); // �÷��� alias�� �����ϱ�
			 }
			
			// gu ���ϱ�
			String gu = "";
			int count = 0;
			
			do{
				System.out.println("��ǰ �з��ڵ�(gu)�Է�");
				gu = scan.nextLine();
				
				String sql2 = "select count(*) cnt from lprod where lprod_gu=?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, gu);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					count = rs.getInt("cnt");
				}
				
				if(count > 0){
					System.out.println("�ߺ��Դϴ�.");
					
				}
				
			}while(count>0);
			
			System.out.println("lprod_nm�� �Է��ϼ���");
			String nm = scan.nextLine();
	
			String sql = " insert into lprod values(?, ? , ?)";
			
			// �� pstmt2? �� pstmt���� �ȵǴ�������? �������� prepareStatement����� ������? ���������� ���ο� pstmt2 ������ִ°� ���ٰ� �մϴ�~
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, id);
			pstmt2.setString(2, gu);
			pstmt2.setString(3, nm);
			
			int cnt =pstmt2.executeUpdate();
			
			System.out.println("��ȯ��: "+ cnt);
			if(cnt>0){
				System.out.println("insert ����");
			}else{
				System.out.println("insert ����");
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		} /*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/finally{
			//�ڿ� �ݳ� : ������� ���� ��������

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

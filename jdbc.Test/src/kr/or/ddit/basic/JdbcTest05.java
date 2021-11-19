package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 	LPROD ���̺� ���ο� �����͸� �߰��ϱ�
 	lprod_gu�� lprod_nm�� ���� �Է¹޾Ƽ� ó���ϰ�, lprod_id�� ������ lprod_id�� �߿��� ���� ū ������ 1 ũ���Ѵ�.
 	
 	�Է¹��� lprod_gu�� �̹� ��ϵǾ� ������ �ٽ� �Է¹޾Ƽ� ó���Ѵ�.
 	
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
				System.out.println("lprod_gu�� �Է��ϼ���");
				gu = scan.nextLine();
				boolean flag = true;

				while(rs.next()){

					if(rs.getString("lprod_gu").equals(gu)){
						System.out.println("�ߺ��Դϴ�.");
						flag = false;
						break;
					}
				}
				if(flag){
					break;
				}
			}
			
			System.out.println("lprod_nm�� �Է��ϼ���");
			String nm = scan.nextLine();
			
			
			String sql3 = "select nvl(MAX(lprod_id),0) MAX from lprod";
			rs =  stmt.executeQuery(sql3);
			int id = 0;
			if(rs.next()){
			id = rs.getInt("MAX")+1; // �÷��� alias�� �����ϱ�
			 }
			
			String sql = " insert into lprod values(?, ? , ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
			int cnt =pstmt.executeUpdate();
			
			System.out.println("��ȯ��: "+ cnt);
			if(cnt>0){
				System.out.println("insert ����");
			}else{
				System.out.println("insert ����");
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
			if(conn!=null) try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

	}

}

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

			System.out.println("���¹�ȣ ���� �߰��ϱ�");
			
			String bankNo ="";
			int count =0;
			do{
			System.out.print("���¹�ȣ: ");
		    bankNo =  scan.next();
		    String sql2 = "select count(*) cnt from bankinfo where bank_no = ? ";
		    pstmt2 = conn.prepareStatement(sql2);
		    pstmt2.setString(1, bankNo);
		    
		    rs = pstmt2.executeQuery();
		    
		    if(rs.next()){ // select���� ����� 1���Ƿ��ڵ��� ��� if�� ��밡��
		   /* 	count = rs.getInt(1);
		    	count = rs.getInt("count(*)");*/
		    	count = rs.getInt("cnt"); // �÷��� alias�� �����ϱ�
		    }
		    if(count>0){
		    	System.out.println("�ߺ��Դω�");
		    }
			}while(count>0);
			
			System.out.print("�����: ");
			String bankName = scan.next();
			System.out.print("�����ָ�: ");
			String bankUser = scan.next();

			// PreparedStatement�� �̿��ϴ� ���
			// SQL���� �ۼ��� �� �����Ͱ� �� �ڸ��� ����ǥ(?)�� ǥ���Ѵ�.
			String sql = "insert into bankinfo values( ? , ? , ? , sysdate)";

			// PreparedStatement ��ü�� �����Ѵ�. �̶� ������ SQL���� �Ű������� �Ѱ��ش�.
			// �̸� �������� �������ؼ� �ؼ��ϱ⶧����  �ӵ��� ������
			pstmt = conn.prepareStatement(sql);
			// SQL���� ����ǥ(?)�ڸ��� �� �����͸� �����Ѵ�.
			// ����) pstmt.set�ڷ���(����ǥ��ȣ, �����ҵ�����)
			// ����ǥ ��ȣ�� 1������ ����
			pstmt.setString(1, bankNo);
			pstmt.setString(2, bankName);
			pstmt.setString(3, bankUser);

			// �������� ������ �Ϸ�Ǹ� �������� �����Ѵ�.
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

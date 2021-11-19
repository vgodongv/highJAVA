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

			System.out.println("���¹�ȣ ���� �߰��ϱ�");

			String sql2 = "select bank_no from bankinfo";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql2);


			String bankNo="";

			while(true){
				System.out.print("���¹�ȣ: ");
				bankNo =  scan.next();
				boolean flag = true;

				while(rs.next()){

					if(rs.getString("bank_no").equals(bankNo)){
						System.out.println("�ߺ��Դϴ�.");
						flag = false;
						break;
					}
				}
				if(flag){
					break;
				}
			}
			
			System.out.print("�����: ");
			String bankName = scan.next();
			System.out.print("�����ָ�: ");
			String bankUser = scan.next();

			// '"���̿� ���� x
			String sql = "insert into bankinfo values('" + bankNo + "', '" + bankName+ "', '" + bankUser+"', sysdate)";

			// select���� �����Ҷ��� executeQuery()�޼��带 ����ϰ�
			// insert, update, delete���� ���� select���� �ƴ� �������� �����Ҷ��� executeUpdate()�޼��带 ����Ѵ�.
			// executeUpdate()�޼����� ��ȯ���� �۾��� ������ ���ڵ� ���� ��ȯ�Ѵ�.
			int cnt = stmt.executeUpdate(sql);

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

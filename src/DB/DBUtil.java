package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {

	
public Connection getConnection(){
		
		//�������ӵ����ݿ⡮�û���������
		 String url="jdbc:mysql://localhost:3306/cn_sk";
		 String username="root";
		 String password="123456";		
		try {
			Class.forName("com.mysql.jdbc.Driver");		//������	??	�ɷ��ô˴�һ����
			return  DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();	
			} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	//�ر����ݿ�*******************************************************************************************
	public void closeConnection(Connection conn){		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//�������ݿ��������*********************************************************************************
	public void update(String table,String device,String data) { // ���±�()�е���һ����������ֵ�͵�ʱ��
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();

		String sql = "update "+table+" set " + device + "=" + data;
		
		try {
			conn.setAutoCommit(false); // �Զ��ύ�ر�
			Statement stmt = conn.createStatement();

			stmt.executeUpdate(sql); // ִ��SQL���
			
			conn.commit(); // �ύ
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback(); // �ع���֮���״̬
			} catch (SQLException e1) {

				e1.printStackTrace();
			} finally {
				util.closeConnection(conn);
			}
		}

	}

	//ʵʱ�洢���ݿ��ub������*********************************************************************************	
	
/*	
	public boolean insert_ub(String table, String device){
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		ResultSet rs = null;
		boolean ss = false;
		//String queryrs2 = null;
		try {	
			String sql = "insert into vote_vote(uid, ip, votedate) values ('" + uid + "','" + ip + "','" + new java.sql.Date(System.currentTimeMillis()) + "')";;		
			//String sql="select*from StuTbl where id=4;"
			Statement stmt =conn.createStatement();
			rs=stmt.executeQuery(sql);		//�����ҵ��Ľ������������
			//rs.next();
			boolean flag = false;
			String sql = "insert into vote_vote(uid, ip, votedate) values ('" + uid + "','" + ip + "','" + new java.sql.Date(System.currentTimeMillis()) + "')";
			try {
				controlDB.executeUpdate(sql);
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return flag;
			
			rs.close();			
			conn.close();
			util.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return queryrs;
	}
	*/




public String query(String table, String device){
	DBUtil util = new DBUtil();
	Connection conn = util.getConnection();
	ResultSet rs = null;
	String queryrs = null;
	//String queryrs2 = null;
	try {	
		String sql="select "+device+" from "+table+";";		
		//String sql="select*from StuTbl where id=4;"
		Statement stmt =conn.createStatement();
		rs=stmt.executeQuery(sql);		//�����ҵ��Ľ������������
		//rs.next();
		while(rs.next()){		//	����ָ���豸��һ�����µ�ֵ������
			 queryrs=rs.getString(device);
			 //queryrs2=rs.getString(timer);
			 //qd.setQuerydate(rs.getString(device));
			 //qd.setQuerytime(rs.getString(timer));
			}
		
		//System.err.println(qd.getQuerydate());
		//System.err.println(queryrs);
		rs.close();			
		conn.close();
		util.closeConnection(conn);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return queryrs;
}
}
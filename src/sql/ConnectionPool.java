package sql;
import java.beans.PropertyVetoException;
import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class ConnectionPool {
	private static ComboPooledDataSource cpd = null;
//	 String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	 String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=NewCentury";
//	  String user = "sa";
//	  String password = "IBMSsmarthome";
	 String className ="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/wia-pa";
	 String user="root";
	 String password="123456";		
	
   private ConnectionPool(){
	   cpd = new ComboPooledDataSource();
	   cpd.setUser(user);
	   cpd.setPassword(password);
	   cpd.setJdbcUrl(url);
	   try {
		cpd.setDriverClass(className);
	} catch (PropertyVetoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   //�������ӳ�
	cpd.setInitialPoolSize(20);
	cpd.setMaxPoolSize(10);
	cpd.setMinPoolSize(5);
   }
   
   private static ConnectionPool instance = null;
   public synchronized static ConnectionPool getInstance(){
	   if(instance == null){
		    instance = new ConnectionPool();
	   }
	return instance;
   }
  
  
   
   public Connection getConnection() throws SQLException{
	 
	return cpd.getConnection();
   }
	public static void main(String[] args) throws Exception{
		long begin = System.currentTimeMillis();//ϵͳ��ʼ��֮���ʱ�䣬Ϊ��ǰϵͳʱ��ת��Ϊ����
		System.out.println("��ǰʱ�䣺"+begin+"����");
		for (int i = 0; i < 100; i++){//ͨ�����ݿ����ӳأ�����100�����ݿ�����
 		Connection conn = ConnectionPool.getInstance().getConnection();
 		conn.close();
		}
		long end = System.currentTimeMillis();//�����������ʱ�䣬ת��Ϊ����
		System.out.println("����ʱ�䣺"+end+"����");
		//����ʱ���ȥ��ʼʱ�䣬Ϊ������Ӧʱ��
		System.out.println("ͨ�����ݿ����ӳأ�100�����������ʱ��"+(end - begin)+"����");}}
	








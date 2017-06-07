package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBUtileAll {
	public static void main(String[] args) {
		DBUtileAll DBall=new DBUtileAll();
		ArrayList<String[]> list = new ArrayList<String[]>();
		list=DBall.qurey();
		String[] i=list.get(0);			//�õ�list��list[0]��temperature[]���飻
		for(String j:i){				//����temperature[]����
			System.out.println(j);
		}

		
	}
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
	//�����ݿ�������Ӵ���������*********************************************************************************
	public boolean insert(String temp,String humidity,String infrared,String smoke) { // ���±�()�е���һ����������ֵ�͵�ʱ��
		
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		ResultSet rs = null;
		
		 int maxId=0;
		  String sql1="select max(id) as maxId from sensor";
		try {
			conn.setAutoCommit(false); // �Զ��ύ�ر�
			Statement stmt = conn.createStatement();
			
		  rs=stmt.executeQuery(sql1);
		 
		  if(rs.next()){
			maxId=rs.getInt("maxId");
		  }
		  Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String da = sdf.format(date);
		/////   String sql = "insert into sensor(id,time,temp,humidity,infrared,smoke)values('"
		////		+(++maxId)+"',to_date('"+da+"','yyyy-mm-dd hh24:mi:ss'),'"+temp+"',,'"+humidity+"'," +
		///				"'"+infrared+"','"+smoke+"')";
		//String sql = "insert into sensor values('"+ now() +"'=" + data+","+timer+"=now() where id="+id+";");
		String sql = "insert into sensor(id,time,temp,humidity,infrared,smoke)values(?,?,?,?,?,?)";
		   PreparedStatement ps=conn.prepareStatement(sql);
		   
           ps.setInt(1, maxId);
           ps.setString(2, da);
           ps.setString(3, temp);
           ps.setString(4, humidity);
           ps.setString(5, infrared);
           ps.setString(6, smoke);
           
           int result=ps.executeUpdate();
           //ps.executeUpdate();�޷��ж��Ƿ��Ѿ�����
           if(result>0)
               return true;
         
		   
		   
		   
		   
//			stmt.executeUpdate(sql); // ִ��SQL���
//			
//			conn.commit(); // �ύ
//			conn.close();
///			return true;
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
		return false;

	}
	
	

	//�����ݿ�����������*********************************************************************************
	public void update(String item,int id,String data) { // ���±�()�е���һ����������ֵ�͵�ʱ��
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();

		String sql = "update en_tabal set " + item + "=" + data+" where id="+id+";";
		
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
	
/*	
	//�����ݿ�����������*********************************************************************************
	public void update(String device,String timer,int id,String data) { // ���±�()�е���һ����������ֵ�͵�ʱ��
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();

		String sql = "update wia_pa set " + device + "=" + data+","+timer+"=now() where id="+id+";";
		
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
	
	*/
	public String query(String device,int id){
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		ResultSet rs = null;
		String queryrs = null;
		//String queryrs2 = null;
		try {	
			String sql="select "+device+" from wia_pa where id ="+id+";";		
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
	@SuppressWarnings("null")
	public ArrayList<String[]> qurey(){
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		ResultSet rs = null;
		ArrayList<String[]> list = new ArrayList<String[]>();

		try {	
			String sql="select*from en_tabal;";		
			Statement stmt =conn.createStatement();
			rs=stmt.executeQuery(sql);		//�����ҵ��Ľ������������	
			
			String i[] = new String[9];
			String v[] = new String[9];
			String w[] = new String[9];
			String kwh[] = new String[9];
			String tag[] = new String[9];
			
			
			int j=0;
			while(rs.next()){	
				/*******����ѯ����ֵ�ֱ�����Ӧ������  9������**********/
				i[j]=rs.getString("i");
				v[j]=rs.getString("v");
				w[j]=rs.getString("w");
				kwh[j]=rs.getString("kwh");
				tag[j]=rs.getString("tag");
								
				j++;
				}
			/*******��������뼯����**********/
			list.add(i);
			list.add(v);
			list.add(w);
			list.add(kwh);
			list.add(tag);
			
			rs.close();	
			conn.close();
			util.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
}

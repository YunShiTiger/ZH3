package UDPServer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Arrays;

import websocket.WebSocketServer;



import DB.DBUtileAll;

import com.ub.beans.Sensor;
import com.ub.beans.Ub;
import com.ub.dao.UbDao;
import com.ub.dao.impl.UbDaoImpl;

public class udpServer {
	
	//static dataModel dm=new dataModel();
	static byte[] buf_tv ={0x68,(byte) 0xcc,0x31,0x02,0x01,0x01,0x01,0x16};
	//anylsys als = new anylsys();

	
	
	public static void main(String[] args)  throws Exception{
		
		anylsys als = new anylsys();
		udpServer us =new udpServer();
		WebSocketServer ws=new WebSocketServer();
		/*byte[] d = {0x68,0x57,0x77,0x55,0x00,0x00,0x00,0x68,0x11,0x04,0x33,0x33,0x34,0x33,(byte) 0xd5,0x16};
		byte[] c = {0x68,(byte) 0x83,(byte) 0x85,0x42,0x00,0x00,0x00,0x68,0x11,0x04,0x33,0x33,0x34,0x33,(byte) 0xfc,0x16};
		us.SendUDP(c,3);*/
		System.out.println("�����յ�"+":ON");
		
		while(true){
			byte[] b =RecwUDP();	
			
			
			 
			 for (int i = 0; i < b.length; i++)
		        {
		            String hex = Integer.toHexString(b[i] & 0xFF);
		            if (hex.length() == 1)
		            {
		                hex = '0' + hex;
		            }
		        //  System.out.print(hex.toUpperCase() + " ");
		        }
			//////System.out.println("");		
			
			// System.out.println(Arrays.toString(b));
			 //System.out.println(b.length);
		als.anys(b);

		 String temp=anylsys.sensor.getTemp();	
		 String humidity=anylsys.sensor.getHumidity();	
		 String infrared=anylsys.sensor.getInfrared();
		 String smoke=anylsys.sensor.getSmoke();
		//System.out.println("WENSHIDU/////////"+temp);
		if(temp!=null){
			//DBUtileAll db = new DBUtileAll();						
			//boolean flag=db.insert(temp, humidity, infrared, smoke);
			
			//System.out.println("WENSHIDU/////////"+flag);
			
			Sensor s=new Sensor();
			s.setTemp(temp);
			s.setHumidity(humidity);
			s.setInfrared(infrared);
			s.setSmoke(smoke);
		
			//System.out.println(smoke);
			UbDao u=new UbDaoImpl();
			
			Thread.sleep(30000);
					
			if (u.insertSensor(s)) {
			//	System.out.println("���������ݼ�¼�ɹ�");
			} else {
				//System.out.println("���������ݼ�¼ʧ��");
			}				
			
			
			
			
		}
			
		}
		
		
	}
	
	public static byte[] RecwUDP() {
		byte[] b=new byte[37];
		try {
			DatagramSocket ds=new DatagramSocket(6530);	//����˼����������ݶ˿�	
			//System.out.println(ds.toString().getBytes().length);
			DatagramPacket d=new DatagramPacket(b,b.length); 
			
			ds.receive(d);
			ds.close();
			Thread.sleep(100);			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return b;
	}
	
	public void SendUDP(byte[] x,int i) {
		byte[] buf=x;
		DatagramSocket ds = null;
		if(i==1){					//1��ʾ�к���IP��ַ113
			try {
				ds = new DatagramSocket(8899);
				DatagramPacket dp=new DatagramPacket(buf,0,buf.length,
						new InetSocketAddress("172.22.140.113",6530));	//	����һ�����ݱ�������������Ϊbuf�������ݴ������ص�IP��PORT
				ds.send(dp);	//�������ݱ���	
				ds.close();		//�ر�Socket
				//Thread.sleep(200);
			} catch (Exception e) {
					
				e.printStackTrace();
			}
			
		}
		if(i==2){					//2��ʾ�Ҿ������ص�IP��ַ
			try {
				ds = new DatagramSocket(8801);
				DatagramPacket dp=new DatagramPacket(buf,0,buf.length,
						new InetSocketAddress("172.22.140.133",8300));	//	����һ�����ݱ�������������Ϊbuf�������ݴ������ص�IP��PORT
				ds.send(dp);	//�������ݱ���
				
				ds.close();		//�ر�Socket
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		if(i==3){					//3��ʾ������ص�IP��ַ
			try {
				ds = new DatagramSocket(8888);
				DatagramPacket dp=new DatagramPacket(buf,0,buf.length,
						new InetSocketAddress("172.22.140.2",6531));	//	����һ�����ݱ�������������Ϊbuf�������ݴ������ص�IP��PORT
				ds.send(dp);	//�������ݱ���
				System.out.println("�������ط������ݳɹ�");
				ds.close();		//�ر�Socket
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
	}
//	public void updateUb(){
//		Sensor sensor1=new Sensor();
//		Ub ub=new Ub();
//		ub.setTemp(sensor1.getTemp());
//		ub.setHumidity(sensor1.getHumidity());
//		ub.setInfrared(sensor1.getInfrared());
//		ub.setSmoke(sensor1.getSmoke());
//		ub.setPeriod("winter");
//		ub.setLocation("living_room");
//		ub.setDevice("light");
//		ub.setDI("1");
//		ub.setStatus("ON");
//		
//		UbDao u=new UbDaoImpl();
//		if (u.insertUb(ub)) {
//			System.out.println("���Ƽ�¼�ɹ�");
//		} else {
//			System.out.println("���Ƽ�¼ʧ��");
//		}
//	}
}

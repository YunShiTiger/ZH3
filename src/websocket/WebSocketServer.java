package websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.db.util.DButil;
import com.ub.beans.Sensor;
import com.ub.beans.Ub;
import com.ub.beans.Ub3;
import com.ub.dao.UbDao;
import com.ub.dao.impl.UbDaoImpl;

import UDPServer.anylsys;
import UDPServer.udpServer;

//import java
//��ע������ָ��һ��URI���ͻ��˿���ͨ�����URI�����ӵ�WebSocket������Servlet��ע��mapping
@ServerEndpoint(value="/websocketS")
public class WebSocketServer {
 
  @OnMessage
  public void onMessage(String message, Session session)
    throws IOException, InterruptedException {
   
    // Print the client message for testing purposes
    System.out.println("Received: " + message);
    
    // Send the first message to the client
    udpServer udp=new udpServer();
   // anylsys anylsys = new anylsys();
    
	if(message.equals("openlight")) {
		byte[] data={0x66,(byte) 0xad,0x0a,0x31,0x01,0x11,0x31,(byte) 0xa0,0x00,(byte) 0xa1};
		udp.SendUDP(data,2);
		System.out.println("����");
		//Sensor anylsys.sensor=new Sensor();
		
		//anylsys anylsys = new anylsys();
		Ub ub=new Ub();
		//anylsys.sensor.getTemp();
		
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("light");
		ub.setDI("1");
		ub.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("�������Ƽ�¼�ɹ�");
		} else {
			System.out.println("�������Ƽ�¼ʧ��");
		}	
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("light");
		ub3.setDI("1");
		ub3.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			System.out.println("�������Ƽ�¼�ɹ�");
		} else {
			System.out.println("�������Ƽ�¼ʧ��");
		}	
	}
	if(message.equals("closelight")) {
		System.out.println("�ص�");
		byte[] data={0x66,(byte) 0xad,0x0a,0x31,0x01,0x11,0x31,(byte) 0xa0,0x00,(byte) 0xa2};
		udp.SendUDP(data,2);
		
		//anylsys anylsys = new anylsys();
		
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("light");
		ub.setDI("1");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("�صƵƼ�¼�ɹ�");
		} else {
			System.out.println("�صƼ�¼ʧ��");
		}		
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("light");
		ub3.setDI("1");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("�ؿ����Ƽ�¼�ɹ�");
		} else {
			//System.out.println("�������Ƽ�¼ʧ��");
		}			
		
		
		
		
		
	}
	if(message.equals("openfan")) {
		System.out.println("������");
		byte[] data={0x58,0x58,0x58,0x43,0x49,0x44,0x2e,0x01,0x53,0x30,0x30,0x30,0x31,0x30,0x31,0x30,0x31,0x30,0x33,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x3f,0x02};
		udp.SendUDP(data,2);
		
		//anylsys anylsys = new anylsys();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("fan");
		ub.setDI("2");
		ub.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("�����ȼ�¼�ɹ�");
		} else {
			System.out.println("�����ȼ�¼ʧ��");
		}	
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("fan");
		ub3.setDI("2");
		ub3.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("�ؿ����Ƽ�¼�ɹ�");
		} else {
			//System.out.println("�������Ƽ�¼ʧ��");
		}				
		
		
	}
	if(message.equals("closefan")) {
		System.out.println("�ط���");
		byte[] data={0x58,0x58,0x58,0x43,0x49,0x44,0x2e,0x01,0x53,0x30,0x30,0x30,0x31,0x30,0x31,0x30,0x31,0x30,0x33,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x3f,0x01};
		udp.SendUDP(data,2);
		
		//Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("fan");
		ub.setDI("2");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("�ط��ȼ�¼�ɹ�");
		} else {
			System.out.println("�ط��ȼ�¼ʧ��");
		}	
		
		
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("fan");
		ub3.setDI("2");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("�ؿ����Ƽ�¼�ɹ�");
		} else {
			//System.out.println("�������Ƽ�¼ʧ��");
		}
		
		
	}
	if(message.equals("openair")) {
		System.out.println("���յ�");
		byte[] data={0x66,(byte) 0xad,0x0d,0x31,0x01,0x11,0x31,(byte) 0xc0,(byte) 0xff,0x55,0x02,0x2e,0x33};
		udp.SendUDP(data,2);
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("air_conditioner");
		ub.setDI("3");
		ub.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("���յ���¼�ɹ�");
		} else {
			System.out.println("���յ���¼ʧ��");
		}	
		
		
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("air_conditioner");
		ub3.setDI("3");
		ub3.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("�ؿ����Ƽ�¼�ɹ�");
		} else {
			//System.out.println("�������Ƽ�¼ʧ��");
		}	
		
	}
	if(message.equals("closeair")) {
		System.out.println("�ؿյ�");
		byte[] data={0x66,(byte) 0xad,0x0d,0x31,0x01,0x11,0x31,(byte) 0xc0,(byte) 0xff,0x55,0x02,0x2d,0x33};
		udp.SendUDP(data,2);
		
	///	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("air_conditioner");
		ub.setDI("3");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("�ؿյ���¼�ɹ�");
		} else {
			System.out.println("�ؿյ���¼ʧ��");
		}	
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("air_conditioner");
		ub3.setDI("3");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("�ؿ����Ƽ�¼�ɹ�");
		} else {
			//System.out.println("�������Ƽ�¼ʧ��");
		}	
	}
	if(message.equals("opencurtain")) {
		System.out.println("������");
		byte[] data={0x58, 0x58, 0x58 ,0x43, 0x49, 0x44, 0x2e, 0x01, 0x53, 0x30, 0x30, 0x30, 0x31, 0x30, 0x31, 0x30, 0x31, 0x30, 0x33, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x3d, 0x01};
		udp.SendUDP(data,2);
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("study");
		ub.setDevice("curtain");
		ub.setDI("4");
		ub.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("��������¼�ɹ�");
		} else {
			System.out.println("��������¼ʧ��");
		}	
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("study");
		ub3.setDevice("curtain");
		ub3.setDI("4");
		ub3.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("�ؿ����Ƽ�¼�ɹ�");
		} else {
			//System.out.println("�������Ƽ�¼ʧ��");
		}	
		
		
		
	}
	if(message.equals("stopcurtain")) {
		System.out.println("ͣ����");
		byte[] data={0x58, 0x58, 0x58 ,0x43, 0x49, 0x44, 0x2e, 0x01, 0x53, 0x30, 0x30, 0x30, 0x31, 0x30, 0x31, 0x30, 0x31, 0x30, 0x33, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x3d, 0x02};
		udp.SendUDP(data,2);
		

	}
	
	if(message.equals("closecurtain")) {
		System.out.println("�ش���");
		byte[] data={0x58, 0x58, 0x58 ,0x43, 0x49, 0x44, 0x2e, 0x01, 0x53, 0x30, 0x30, 0x30, 0x31, 0x30, 0x31, 0x30, 0x31, 0x30, 0x33, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x3d, 0x00};
		udp.SendUDP(data,2);
		
		//Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("study");
		ub.setDevice("curtain");
		ub.setDI("4");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("�ش�����¼�ɹ�");
		} else {
			System.out.println("�ش�����¼ʧ��");
		}	
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("study");
		ub3.setDevice("curtain");
		ub3.setDI("4");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("�ؿ����Ƽ�¼�ɹ�");
		} else {
			//System.out.println("�������Ƽ�¼ʧ��");
		}		
		
		
		
	}
	/**********�ܺļƿ��Ʋ���**********************/
	if(message.equals("en_tv_open")) {
		System.out.println("�������ܺļ�");
		byte[] data={0x68,(byte) 0xcc,0x31,0x01,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//��ʱ20ms�·��ɼ�ָ��
		byte[] data_caiji={0x68,(byte) 0xcc,0x31,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);
		System.out.println("�����˲�ѯ����");*/
		
		/**
		 * ��������
		 */
		//		Sensor anylsys.sensor=new Sensor();
				Ub ub=new Ub();
				ub.setTemp(anylsys.sensor.getTemp());
				ub.setHumidity(anylsys.sensor.getHumidity());
				ub.setInfrared(anylsys.sensor.getInfrared());
				ub.setSmoke(anylsys.sensor.getSmoke());
				ub.setPeriod("winter");
				ub.setLocation("living_room");
				ub.setDevice("TV");
				ub.setDI("5");
				ub.setStatus("ON");
				System.out.println(ub.getDevice());
				UbDao u=new UbDaoImpl();
				if (u.insertUb(ub)) {
					System.out.println("���������ӵƼ�¼�ɹ�");
				} else {
					System.out.println("���������Ӽ�¼ʧ��");
				}	
		
				Ub3 ub3=new Ub3();
				ub3.setPeriod("winter");
				ub3.setLocation("living_room");
				ub3.setDevice("TV");
				ub3.setDI("5");
				ub3.setStatus("ON");
				System.out.println(ub.getDevice());
				UbDao u1=new UbDaoImpl();
				if (u1.insertUb3(ub3)) {
					//System.out.println("�ؿ����Ƽ�¼�ɹ�");
				} else {
					//System.out.println("�������Ƽ�¼ʧ��");
				}	
									
	}
	if(message.equals("en_tv_close")) {
		System.out.println("�ص����ܺļ�");
		byte[] data={0x68,(byte) 0xcc,0x31,0x00,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//��ʱ20ms�·��ɼ�ָ��
		byte[] data_caiji={0x68,(byte) 0xcc,0x31,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
		
		/**
		 * �رտ�������
		 */
			///	Sensor anylsys.sensor=new Sensor();
				Ub ub=new Ub();
				ub.setTemp(anylsys.sensor.getTemp());
				ub.setHumidity(anylsys.sensor.getHumidity());
				ub.setInfrared(anylsys.sensor.getInfrared());
				ub.setSmoke(anylsys.sensor.getSmoke());
				ub.setPeriod("winter");
				ub.setLocation("living_room");
				ub.setDevice("TV");
				ub.setDI("5");
				ub.setStatus("OFF");
				System.out.println(ub.getDevice());
				UbDao u=new UbDaoImpl();
				if (u.insertUb(ub)) {
					System.out.println("���������Ӽ�¼�ɹ�");
				} else {
					System.out.println("�ؿ������Ӽ�¼ʧ��");
				}		
		
				
				Ub3 ub3=new Ub3();
				ub3.setPeriod("winter");
				ub3.setLocation("living_room");
				ub3.setDevice("TV");
				ub3.setDI("5");
				ub3.setStatus("OFF");
				System.out.println(ub.getDevice());
				UbDao u1=new UbDaoImpl();
				if (u1.insertUb3(ub3)) {
					//System.out.println("�ؿ����Ƽ�¼�ɹ�");
				} else {
					//System.out.println("�������Ƽ�¼ʧ��");
				}			
				
				
		
	}
	
	if(message.equals("en_fan_open")) {
		System.out.println("�������ܺļơ�������������");
		byte[] data={0x68,(byte) 0xcc,0x32,0x01,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//��ʱ20ms�·��ɼ�ָ��
		byte[] data_caiji={0x68,(byte) 0xcc,0x32,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);
		System.out.println("�����˲�ѯ����");*/
		
		/**
		 * ������
		 */
			///	Sensor anylsys.sensor=new Sensor();
				Ub ub=new Ub();
				ub.setTemp(anylsys.sensor.getTemp());
				ub.setHumidity(anylsys.sensor.getHumidity());
				ub.setInfrared(anylsys.sensor.getInfrared());
				ub.setSmoke(anylsys.sensor.getSmoke());
				ub.setPeriod("winter");
				ub.setLocation("living_room");
				ub.setDevice("soft_music");
				ub.setDI("6");
				ub.setStatus("ON");
				System.out.println(ub.getDevice());
				UbDao u=new UbDaoImpl();
				if (u.insertUb(ub)) {
					System.out.println("�����������ּ�¼�ɹ�");
				} else {
					System.out.println("�����������ּ�¼ʧ��");
				}	
		
				
				Ub3 ub3=new Ub3();
				ub3.setPeriod("winter");
				ub3.setLocation("living_room");
				ub3.setDevice("soft_music");
				ub3.setDI("6");
				ub3.setStatus("ON");
				System.out.println(ub.getDevice());
				UbDao u1=new UbDaoImpl();
				if (u1.insertUb3(ub3)) {
					//System.out.println("�ؿ����Ƽ�¼�ɹ�");
				} else {
					//System.out.println("�������Ƽ�¼ʧ��");
				}		
				
				
		
	}
	if(message.equals("en_fan_close")) {
		System.out.println("�ط����ܺļơ�������������");
		byte[] data={0x68,(byte) 0xcc,0x32,0x00,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//��ʱ20ms�·��ɼ�ָ��
		byte[] data_caiji={0x68,(byte) 0xcc,0x32,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
		/**
		 * �ر�����
		 */
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("living_room");
		ub.setDevice("soft_music");
		ub.setDI("6");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("�رտ��������ּ�¼�ɹ�");
		} else {
			System.out.println("�رտ��������ּ�¼ʧ��");
		}	
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("living_room");
		ub3.setDevice("soft_music");
		ub3.setDI("6");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("�ؿ����Ƽ�¼�ɹ�");
		} else {
			//System.out.println("�������Ƽ�¼ʧ��");
		}
		
	}
	if(message.equals("en_light_open")) {
		System.out.println("���ƹ��ܺļ�");
		byte[] data={0x68,(byte) 0xcc,0x33,0x01,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//��ʱ20ms�·��ɼ�ָ��
		byte[] data_caiji={0x68,(byte) 0xcc,0x33,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
		/**
		 * �����ҵ�
		 */
		//		Sensor anylsys.sensor=new Sensor();
				Ub ub=new Ub();
				ub.setTemp(anylsys.sensor.getTemp());
				ub.setHumidity(anylsys.sensor.getHumidity());
				ub.setInfrared(anylsys.sensor.getInfrared());
				ub.setSmoke(anylsys.sensor.getSmoke());
				ub.setPeriod("winter");
				ub.setLocation("bedroom");
				ub.setDevice("light");
				ub.setDI("7");
				ub.setStatus("ON");
				System.out.println(ub.getDevice());
				UbDao u=new UbDaoImpl();
				if (u.insertUb(ub)) {
					System.out.println("�����ҵƼ�¼�ɹ�");
				} else {
					System.out.println("�����ҵƼ�¼ʧ��");
				}	
		
				
				Ub3 ub3=new Ub3();
				ub3.setPeriod("winter");
				ub3.setLocation("bedroom");
				ub3.setDevice("light");
				ub3.setDI("7");
				ub3.setStatus("ON");
				System.out.println(ub.getDevice());
				UbDao u1=new UbDaoImpl();
				if (u1.insertUb3(ub3)) {
					//System.out.println("�ؿ����Ƽ�¼�ɹ�");
				} else {
					//System.out.println("�������Ƽ�¼ʧ��");
				}
		
	}
	if(message.equals("en_light_close")) {
		System.out.println("�صƹ��ܺļ�");
		byte[] data={0x68,(byte) 0xcc,0x33,0x00,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//��ʱ20ms�·��ɼ�ָ��
		byte[] data_caiji={0x68,(byte) 0xcc,0x33,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
		/**
		 * �����ҵ�
		 */
			//	Sensor anylsys.sensor=new Sensor();
				Ub ub=new Ub();
				ub.setTemp(anylsys.sensor.getTemp());
				ub.setHumidity(anylsys.sensor.getHumidity());
				ub.setInfrared(anylsys.sensor.getInfrared());
				ub.setSmoke(anylsys.sensor.getSmoke());
				ub.setPeriod("winter");
				ub.setLocation("bedroom");
				ub.setDevice("light");
				ub.setDI("7");
				ub.setStatus("OFF");
				System.out.println(ub.getDevice());
				UbDao u=new UbDaoImpl();
				if (u.insertUb(ub)) {
					System.out.println("�����ҵƼ�¼�ɹ�");
				} else {
					System.out.println("�����ҵƼ�¼ʧ��");
				}	
		
				
				Ub3 ub3=new Ub3();
				ub3.setPeriod("winter");
				ub3.setLocation("bedroom");
				ub3.setDevice("light");
				ub3.setDI("7");
				ub3.setStatus("OFF");
				System.out.println(ub.getDevice());
				UbDao u1=new UbDaoImpl();
				if (u1.insertUb3(ub3)) {
					//System.out.println("�ؿ����Ƽ�¼�ɹ�");
				} else {
					//System.out.println("�������Ƽ�¼ʧ��");
				}		
				
	}
	if(message.equals("en_hotwater_open")) {
		System.out.println("����ˮ���ܺļ�");
		byte[] data={0x68,(byte) 0xcc,0x34,0x01,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//��ʱ20ms�·��ɼ�ָ��
		byte[] data_caiji={0x68,(byte) 0xcc,0x34,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("Washroom");
		ub.setDevice("heater");
		ub.setDI("8");
		ub.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("����ˮ����¼�ɹ�");
		} else {
			System.out.println("����ˮ����¼ʧ��");
		}	
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("Washroom");
		ub3.setDevice("heater");
		ub3.setDI("8");
		ub3.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("�ؿ����Ƽ�¼�ɹ�");
		} else {
			//System.out.println("�������Ƽ�¼ʧ��");
		}		
		
		
		
	}
	if(message.equals("en_hotwater_close")) {
		System.out.println("����ˮ���ܺļ�");
		byte[] data={0x68,(byte) 0xcc,0x34,0x00,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//��ʱ20ms�·��ɼ�ָ��
		byte[] data_caiji={0x68,(byte) 0xcc,0x34,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("Washroom");
		ub.setDevice("heater");
		ub.setDI("8");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("����ˮ����¼�ɹ�");
		} else {
			System.out.println("����ˮ����¼ʧ��");
		}	
		
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("Washroom");
		ub3.setDevice("heater");
		ub3.setDI("8");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("�ؿ����Ƽ�¼�ɹ�");
		} else {
			//System.out.println("�������Ƽ�¼ʧ��");
		}	
		
	}
	if(message.equals("en_dianfanbao_open")) {
		System.out.println("���緹���ܺļ�");
		byte[] data={0x68,(byte) 0xcc,0x35,0x01,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//��ʱ20ms�·��ɼ�ָ��
		byte[] data_caiji={0x68,(byte) 0xcc,0x35,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("kitchen");
		ub.setDevice("electric_cookers");
		ub.setDI("9");
		ub.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("���緹�Ҽ�¼�ɹ�");
		} else {
			System.out.println("���緹�Ҽ�¼ʧ��");
		}	
	
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("kitchen");
		ub3.setDevice("electric_cookers");
		ub3.setDI("9");
		ub3.setStatus("ON");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("�ؿ����Ƽ�¼�ɹ�");
		} else {
			//System.out.println("�������Ƽ�¼ʧ��");
		}			
		
	}
	if(message.equals("en_dianfanbao_close")) {
		System.out.println("�ص緹���ܺļ�");
		byte[] data={0x68,(byte) 0xcc,0x35,0x00,0x01,0x01,0x01,0x16};
		udp.SendUDP(data,1);
		/*Thread.sleep(300);			//��ʱ20ms�·��ɼ�ָ��
		byte[] data_caiji={0x68,(byte) 0xcc,0x35,0x02,0x01,0x01,0x01,0x16};
		udp.SendUDP(data_caiji,1);*/
		
	//	Sensor anylsys.sensor=new Sensor();
		Ub ub=new Ub();
		ub.setTemp(anylsys.sensor.getTemp());
		ub.setHumidity(anylsys.sensor.getHumidity());
		ub.setInfrared(anylsys.sensor.getInfrared());
		ub.setSmoke(anylsys.sensor.getSmoke());
		ub.setPeriod("winter");
		ub.setLocation("kitchen");
		ub.setDevice("electric_cookers");
		ub.setDI("9");
		ub.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u=new UbDaoImpl();
		if (u.insertUb(ub)) {
			System.out.println("�ص緹�Ҽ�¼�ɹ�");
		} else {
			System.out.println("�ص緹�Ҽ�¼ʧ��");
		}	
		
		
		Ub3 ub3=new Ub3();
		ub3.setPeriod("winter");
		ub3.setLocation("kitchen");
		ub3.setDevice("electric_cookers");
		ub3.setDI("9");
		ub3.setStatus("OFF");
		System.out.println(ub.getDevice());
		UbDao u1=new UbDaoImpl();
		if (u1.insertUb3(ub3)) {
			//System.out.println("�ؿ����Ƽ�¼�ɹ�");
		} else {
			//System.out.println("�������Ƽ�¼ʧ��");
		}			
		
	}
	if(message.equals("dianbiao")) {
		System.out.println("��ѯ���xx");
		byte[] d = {0x68,0x57,0x77,0x55,0x00,0x00,0x00,0x68,0x11,0x04,0x33,0x33,0x34,0x33,(byte) 0xd5,0x16};
		byte[] c = {0x68,(byte) 0x83,(byte) 0x85,0x42,0x00,0x00,0x00,0x68,0x11,0x04,0x33,0x33,0x34,0x33,(byte) 0xfc,0x16};
		udp.SendUDP(d,3);
		Thread.sleep(1000);
		//udp.SendUDP(c,3);
		
	}
	
  }
   
  @OnOpen
  public void onOpen() {
    System.out.println("Client connected");
  }
 
  @OnClose
  public void onClose() {
    System.out.println("Connection closed");
  }
}

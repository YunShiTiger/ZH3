package UDPServer;

import com.ub.beans.Sensor;

import DB.DBUtileAll;

public class anylsys {
	
	public static Sensor sensor=new Sensor();

	public void anys(byte[] B){
		DBUtileAll db = new DBUtileAll();
		int[] b= new int[37];
		for (int i = 0; i < b.length; i++) {
			b[i]=B[i];
			if(b[i]<0){				//�Ը������д���
				b[i]=B[i]+256;		//BYTE�ķ�Χ��-127��128����Ӧ��λ��ʮ����������ʮλ��8��8�Ժ�Ķ��Ǹ���
			}
			
		}
		/*
		if(b[0]==104&&b[1]==87){
			////System.out.println("�յ��������");
			//System.out.println("b[18]:"+b[18]+"b[19]:"+b[19]+"b[20]:"+b[20]+"b[21]:"+b[21]);
			if(b[1]==87){        //87==0X57
				System.out.println("�յ����NO.1����");
				String x1=change(b[14]);
				String x2=change(b[15]);
				String x3=change(b[16]);
				String x4=change(b[17]);
				String str=x4+x3+x2+"."+x1;
				db.update("i", 8, str);
				System.out.println(str);
				////System.out.println("�������Ϊ��"+x4+""+x3+x2+"."+x1+"Kw/h");
			}
			if(b[1]==131){        //131==0X83
				System.out.println("�յ����NO.2����");
				String x1=change(b[14]);
				String x2=change(b[15]);
				String x3=change(b[16]);
				String x4=change(b[17]);
				String str=x4+x3+x2+"."+x1;
				db.update("i", 9, str);
				////System.out.println(str);
				////System.out.println("�������Ϊ��"+x4+""+x3+x2+"."+x1+"Kw/h");
			}
						
		}
	*/	
	
	if(b[0]==104){
			////System.out.println("�յ��������");
			//System.out.println("b[18]:"+b[18]+"b[19]:"+b[19]+"b[20]:"+b[20]+"b[21]:"+b[21]);
		if(b[1]==170){
			
			if(b[2]==87&&b[3]==6){        //�����б�
								
			  //  String str=change(b[11]);
			//	System.out.println(str);
				String device="infrared";
				String status=String.valueOf(b[11]);
				sensor.setInfrared(status);
				if(b[11]>0){
					System.out.println("�յ���������----��������");
				}
			}
			
		}
		
  if(b[1]==221){
	  	  	 	
	  if(b[2]==01){ 
		  System.out.println("�յ�������ʪ������");
		  int tempg=b[8];
		  int temopd=b[9];
		  int humg=b[10];
		  int humd=b[11];
		  
		  String temp=tempg+"."+temopd;
		  String hum=humg+"."+humd;
		  sensor.setTemp(temp);
		  sensor.setHumidity(hum);
		//  System.out.println("�����¶�ֵ��"+temp);
		//  System.out.println("����ʪ��ֵ��"+hum);
		  
	}
	  if(b[2]==02||b[2]==03||b[2]==07){ 
		  System.out.println("�յ�������������");
		  int smogg=b[10];
		  int smogd=b[11];
		  
		  String smog=smogg+"."+smogg;
		  sensor.setHumidity(smog);
		  System.out.println("��������ֵ��"+smog);
		  
	}
	  	    
	  
			if(b[2]==87){        //87==0X57
				System.out.println("�յ����NO.1����");
				String x1=change(b[14]);
				String x2=change(b[15]);
				String x3=change(b[16]);
				String x4=change(b[17]);
				String str=x4+x3+x2+"."+x1;
				db.update("i", 8, str);
				System.out.println(str);
				////System.out.println("�������Ϊ��"+x4+""+x3+x2+"."+x1+"Kw/h");
			}
			
			if(b[2]==37){
				////System.out.println("�ܺļ�");
				/*String str="";
				for(int k=0;k<B.length;k++){
					str = str+"-"+Integer.toHexString(B[k]);
				}*/
				
				switch (b[3]) {
				case 49:				//�ܺļ�0x31  ����
					
					////System.err.println("�յ������ܺļ�����");
					toData(B, 1);
					break;
				case 50:                   //�ܺļ�0x32 ����
					////System.err.println("�յ������ܺļ�����");
					toData(B, 2);
					break;
				case 51:				//�ܺļ�0x33 �ƹ�
						
					////System.err.println("�յ��ƹ��ܺļ�����");
					toData(B, 3);	
					break;
				case 52:				//�ܺļ�0x34 ��ˮ��
						
					/////System.err.println("�յ���ˮ���ܺļ�����");
					toData(B, 4);	
					break;
				case 53:			//�ܺļ�0x34 �緹��
							
					/////System.err.println("�յ��緹���ܺļ�����");
					toData(B, 5);
					break;

				default:
					break;
				}
			}
									
        }		
			
			if(b[1]==131){        //131==0X83
				////System.out.println("�յ����NO.2����");
				String x1=change(b[14]);
				String x2=change(b[15]);
				String x3=change(b[16]);
				String x4=change(b[17]);
				String str=x4+x3+x2+"."+x1;
				db.update("i", 9, str);
				////System.out.println(str);
				////System.out.println("�������Ϊ��"+x4+""+x3+x2+"."+x1+"Kw/h");
			}
						
		}		
			
		
		

	}
	
	public static String change(int i){
		if(i<51||i>=211){
			System.out.println("��С��0X33��0xD2������");
			return "00";    //����С��0X33ʱ���쳣����
		}
		//String str = ""+Integer.toHexString((i-51));
		String str =Integer.toHexString((i-51));
		str = str.replaceAll("[a-zA-Z]","0" );				//ȥ���ַ����е���ĸ
		int i4=Integer.parseInt(str.trim().trim());
		if(i4>=0&&i4<=9){
			str="0"+i4;
		}
		//System.out.println(str);
		return str;
	}
	
	
	public static void toData(byte[] B,int i){
		DBUtileAll db = new DBUtileAll();
		int[] b= new int[37];
		for (int j = 0; j < b.length; j++) {
			b[j]=B[j];
			if(b[j]<0){				//�Ը������д���
				b[j]=B[j]+256;		//BYTE�ķ�Χ��-127��128����Ӧ��λ��ʮ����������ʮλ��8��8�Ժ�Ķ��Ǹ���
			}
		}
		/**�ۼƵ���**/
		String w1 = change(b[14]);
		String w2 = change(b[15]);
		String w3 = change(b[16]);
		String w4 = change(b[17]);
		String dianliang = w4+w3+w2+"."+w1;
		db.update("kwh", i, dianliang);
		/////System.out.println("�ۼƵ���Ϊ��"+dianliang);
		/**������ѹ****/
		String v1 = change(b[18]);
		String v2 = change(b[19]);
		String v =v2+""+v1;
		StringBuilder sbv=new StringBuilder(v);   
		sbv.insert(3,".");                         //���ַ���ָ��λ�ò���Ԫ��
		db.update("v", i, sbv.toString());
		////System.out.println("��ѹΪ��"+sbv);
		/**��������****/
		String i1 = change(b[20]);
		String i2 = change(b[21]);
		String i3 = change(b[22]);
		String I = ""+i3+i2+i1;
		StringBuilder sbi = new StringBuilder(I);
		sbi.insert(3, ".");
		db.update("i", i, sbi.toString());
		////System.out.println("����Ϊ��"+sbi);
		/**���ع���***/
		String g1 = change(b[23]);
		String g2 = change(b[24]);
		String g3 = change(b[25]);
		String g = ""+g3+g2+g1;
		StringBuilder sbg=new StringBuilder(g);   
		sbg.insert(5,".");                         //���ַ���ָ��λ�ò���Ԫ��
		db.update("w", i, sbg.toString());
		/////System.out.println("����Ϊ��"+sbg);
		/**״̬***/
		String t = change(b[34]);
		db.update("tag", i, t);
		/////System.out.println("�ܺļ�״̬Ϊ��"+t);
		
	}
}

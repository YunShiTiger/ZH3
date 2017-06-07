package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DB.DBUtileAll;


public class SHServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SHServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control","no-cache");
		PrintWriter out = response.getWriter();
		
		DBUtileAll DBall=new DBUtileAll();
		ArrayList<String[]> list = new ArrayList<String[]>();
		list=DBall.qurey();			//�Ӻ�̨��ȡ����
		String[] i=list.get(0);			//�õ���������
		String[] v=list.get(1);			//�õ���ѹ����
		String[] w=list.get(2);			//�õ���������
		String[] kwh=list.get(3);			//�õ���������
		String[] tag=list.get(4);			//�õ�״̬����

		/* ��ȡ��������*/
		String tv_i=i[0];
		String fan_i=i[1];
		String light_i=i[2];
		String hotwater_i=i[3];
		String dianfanbao_i=i[4];
		String air_i=i[5];
		//���ݿ�����i�ֶδ�ˮ������ֵ
		String shuibiao =i[6];
		String dianbiao =i[7];
		String qibiao=i[8];
		
		
		/* ��ȡ��ѹ����*/
		String tv_v=v[0];
		String fan_v=v[1];
		String light_v=v[2];
		String hotwater_v=v[3];
		String dianfanbao_v=v[4];
		String air_v=v[5];
		
		/* ��ȡ��������*/
		String tv_w=w[0];
		String fan_w=w[1];
		String light_w=w[2];
		String hotwater_w=w[3];
		String dianfanbao_w=w[4];
		String air_w=w[5];
		
		/* ��ȡ��������*/
		String tv_kwh=kwh[0];
		String fan_kwh=kwh[1];
		String light_kwh=kwh[2];
		String hotwater_kwh=kwh[3];
		String dianfanbao_kwh=kwh[4];
		String air_kwh=kwh[5];
		
		/* ��ȡ״̬����*/
		String tv_tag=tag[0];
		String fan_tag=tag[1];
		String light_tag=tag[2];
		String hotwater_tag=tag[3];
		String dianfanbao_tag=tag[4];
		String air_tag=tag[5];
		
		StringBuffer sb = new StringBuffer(
				 "<?xml version=\"1.0\" encoding=\"utf-8\"?>"); 
		
		sb.append("<type>");
		sb.append("<i>"+tv_i+"</i>");
		sb.append("<i>"+fan_i+"</i>");
		sb.append("<i>"+light_i+"</i>");
		sb.append("<i>"+hotwater_i+"</i>");
		sb.append("<i>"+dianfanbao_i+"</i>");
		sb.append("<i>"+air_i+"</i>");
		sb.append("<i>"+shuibiao+"</i>");
		sb.append("<i>"+dianbiao+"</i>");
		sb.append("<i>"+qibiao+"</i>");
		
		
		sb.append("<v>"+tv_v+"</v>");
		sb.append("<v>"+fan_v+"</v>");
		sb.append("<v>"+light_v+"</v>");
		sb.append("<v>"+hotwater_v+"</v>");
		sb.append("<v>"+dianfanbao_v+"</v>");
		sb.append("<v>"+air_v+"</v>");
		
		sb.append("<w>"+tv_w+"</w>");
		sb.append("<w>"+fan_w+"</w>");
		sb.append("<w>"+light_w+"</w>");
		sb.append("<w>"+hotwater_w+"</w>");
		sb.append("<w>"+dianfanbao_w+"</w>");
		sb.append("<w>"+air_w+"</w>");
		
		
		sb.append("<kwh>"+tv_kwh+"</kwh>");
		sb.append("<kwh>"+fan_kwh+"</kwh>");
		sb.append("<kwh>"+light_kwh+"</kwh>");
		sb.append("<kwh>"+hotwater_kwh+"</kwh>");
		sb.append("<kwh>"+dianfanbao_kwh+"</kwh>");
		sb.append("<kwh>"+air_kwh+"</kwh>");
		
		sb.append("<tag>"+tv_tag+"</tag>");
		sb.append("<tag>"+fan_tag+"</tag>");
		sb.append("<tag>"+light_tag+"</tag>");
		sb.append("<tag>"+hotwater_tag+"</tag>");
		sb.append("<tag>"+dianfanbao_tag+"</tag>");
		sb.append("<tag>"+air_tag+"</tag>");
		
		sb.append("</type>");     
		out.write(sb.toString());  //ע��������jsp�����������script�еĽػ񷽷�
		
		out.flush();
		out.close();
		sb.delete(0, sb.length());
	
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

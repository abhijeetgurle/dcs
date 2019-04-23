import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	static int count=0;
	public static void main(String[] args) throws Exception
	{
	       	ServerSocket ss=new ServerSocket(5041);
	       	System.out.println("Server Started.........");
	       	while(true)
	       	{
	    	   	Socket s=null;
	    	   	s=ss.accept();
	    	   	count++;
	    	   	System.out.println("A new client is connected: "+count);
	    	   	DataInputStream dis=new DataInputStream(s.getInputStream());
	    	   	DataOutputStream dio=new DataOutputStream(s.getOutputStream());
	    	   	System.out.println("Assigning new thread for this client ");
	    	   	Thread t =new ClientHandler(dis, dio, s,count);
	    	   	t.start();
	       }
	}
}
class ClientHandler extends Thread{
	DataInputStream dis=null;
	DataOutputStream dio=null;
	Socket s=null;
	int c;
	public ClientHandler(DataInputStream dis, DataOutputStream dio, Socket s,int c){
		//super();
		this.dis = dis;
		this.dio = dio;
		this.s = s;
		this.c=c;
	}
	public void run(){
		String rec;
		while(true){
		try{
			rec=dis.readUTF();
			if(rec.equals("close"))
			{
				System.out.println("Client "+c+" sends close....");
				System.out.println("Closing this connection. ");
				this.s.close();
				System.out.println("Connection Closed");
				break;
			}
			char a[]=rec.toCharArray();
			char[] b;
			char[] c;
			int bNum, cNum;
			int cnt1=0;
			int cnt2=0;
			for(int i=0; i<a.length; i++)
			{
			if(a[i] == ' ')
				break;
				cnt1++;
			}
			b = new char[cnt1];
			for(int i=0; i<cnt1; i++)
				b[i] = a[i];
				cnt1++;
			for(int i=cnt1; i<a.length; i++)
				cnt2++;
				c = new char[cnt2];
			for(int i=0; i<cnt2; i++)
				c[i] = a[cnt1++];
			bNum = Integer.parseInt(new String(b));
			cNum = Integer.parseInt(new String(c));
			System.out.println(bNum);
			System.out.println(cNum);
			double mult = Math.pow(bNum, cNum);
			System.out.println("Sending echo msg with data "+mult);
			String m=String.valueOf(mult);
			dio.writeUTF(m);	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try{
			s.close();
			dis.close();
			dio.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}

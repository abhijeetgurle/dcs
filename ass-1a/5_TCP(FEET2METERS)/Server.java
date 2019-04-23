import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

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
class ClientHandler extends Thread
{
	DataInputStream dis=null;
	DataOutputStream dio=null;
	Socket s=null;
	
	int c;
	public ClientHandler(DataInputStream dis, DataOutputStream dio, Socket s,int c)
	{
		//super();
		this.dis = dis;
		this.dio = dio;
		this.s = s;
		this.c=c;
	}
	public void run()
	{
		String rec;
		
		while(true)
		{
		
		try {
	
			rec=dis.readUTF();
			
			if(rec.equals("close"))
			{
				System.out.println("Client "+c+" sends close....");
				System.out.println("Closing this connection. ");
				this.s.close();
				System.out.println("Connection Closed");
				this.dis.close();
				this.dio.close();
				break;
			}
	
			//rec=dis.readUTF();
		    double m=Double.parseDouble(rec);
		    m=m*0.305;
		    String m1= Double.toString(m);
			dio.writeUTF(m1);
		}	
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		try {
			s.close();
			dis.close();
			dio.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

      }
}

/*
$ javac ./*.java
$ java Server 
Server Started.........
A new client is connected: 1
Assigning new thread for this client 
A new client is connected: 2
Assigning new thread for this client 


*/

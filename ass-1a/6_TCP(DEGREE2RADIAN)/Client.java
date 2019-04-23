import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client
{

	public static void main(String[] args) throws Exception 
	{
		  Scanner sc=new Scanner(System.in);
		  InetAddress ip=InetAddress.getByName("localhost");
		  Socket s=new Socket(ip,5041);
		  
		  DataInputStream dis=new DataInputStream(s.getInputStream());
		  DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		 // sc.nextLine();
		  while(true)
		  {
			  System.out.println("Enter String: ");
			  String str=sc.nextLine();
			  if(str.equals("close"))
			  {
				  dos.writeUTF(str);
				  System.out.println("Closing this connection......");
				  s.close();
				  System.out.println("Connection closed");
				  break;
			  }
			  System.out.println("Send data to server....");
			  dos.writeUTF(str);
			  System.out.println("Data Received from Server is(Degree to Radian :"+dis.readUTF());

     	}
		    s.close();
			dis.close();
			dos.close();


	}

}



/*
$ java Client
Enter String: 
90
Send data to server....
Data Received from Server is(Degree to Radian :1.5707963267948966


$ java Client
Enter String: 
60
Send data to server....
Data Received from Server is(Degree to Radian :1.0471975511965976

*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

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
			  System.out.println("ENTER THE VALUE IN FEET ");
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
			  System.out.println("Data Received from Server is ( FEET TO METER CONVERSION) "+dis.readUTF());

		 }
			dis.close();
			dos.close();

	}

}




/*
$ java Client
ENTER THE VALUE IN FEET 
12
Send data to server....
Data Received from Server is ( FEET TO METER CONVERSION) 3.66


$ java Client
ENTER THE VALUE IN FEET 
25
Send data to server....
Data Received from Server is ( FEET TO METER CONVERSION) 7.625


*/

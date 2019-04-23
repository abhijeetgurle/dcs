import java.rmi.*;
import java.util.Scanner;
//program for client application(ClientRequest.java) import java.rmi.*;
public class ClientRequest
{
public static void main(String args[])
{	
	String answer;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter 2 Strings");
	String str1=sc.nextLine();
	CharSequence seq=sc.nextLine();
try
{	
	// lookup method to find reference of remote object 
	Substring access =(Substring)Naming.lookup("rmi://localhost:8090/answer");
 if(access.findSubstring(str1, seq))
 {
	 System.out.println("substring"+" "+seq+" "+"is present");
 }
 else
	 System.out.println("substring"+" "+seq+" "+"is not present");
}

catch(Exception ae)
{
System.out.println(ae);	
}	
}	
}

/*
$ java ClientRequest
Enter 2 Strings
INFORMATION
TECHNOLOGY
substring TECHNOLOGY is not present


$ java ClientRequest
Enter 2 Strings
INFORMATION
INFORM
substring INFORM is present



*/

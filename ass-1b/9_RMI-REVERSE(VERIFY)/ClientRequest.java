

import java.rmi.*;
import java.util.Scanner;
//program for client application	(ClientRequest.java) import java.rmi.*;
public class ClientRequest
{
public static void main(String args[])
{	
	boolean answer;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter 2 Strings");
	String str1=sc.nextLine();
	String str2=sc.nextLine();
	try
	{	
		// lookup method to find reference of remote object 
		Reverse access =(Reverse)Naming.lookup("rmi://localhost:8090/answer");
		answer = access.findReverse(str1, str2);
		if(answer)
		{
			System.out.println("String 2 is reverse of string1");
		}
		else
			System.out.println("String 2 is not reverse of string1");	
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
BEIT
TIEB
String 2 is reverse of string1


*/

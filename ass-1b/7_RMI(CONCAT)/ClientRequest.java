import java.rmi.*;
import java.util.Scanner;
//program for client application	(ClientRequest.java) import java.rmi.*;
public class ClientRequest
{
public static void main(String args[])
{	
	String answer;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter 2 Strings");
	String str1=sc.nextLine();
	String str2=sc.nextLine();
	try
	{	
		// lookup method to find reference of remote object 
		Concat access =(Concat)Naming.lookup("rmi://localhost:8090/answer");
		answer = access.query(str1,str2);
		System.out.println("Concatenation of strings" +" " + answer+"-->answer");
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
BE
IT
Concatenation of strings BEIT-->answer



*/

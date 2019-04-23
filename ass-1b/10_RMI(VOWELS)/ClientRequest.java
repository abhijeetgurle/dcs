import java.rmi.*;
import java.util.Scanner;
//program for client application	(ClientRequest.java) import java.rmi.*;
public class ClientRequest
{
	public static void main(String args[])
	{	
		int answer;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 2 Strings");
		String str1=sc.nextLine();
		String str2=sc.nextLine();
		try
		{	
			// lookup method to find reference of remote object 
			Vowelcount access =(Vowelcount)Naming.lookup("rmi://localhost:8090/answer");
			answer = access.findCount(str1, str2);
			if(answer==1)
				System.out.println("Strings contain same no.of vowels");

			if(answer==2)
				System.out.println("Strings do not contain same no. of vowels");
			if(answer==0)
				System.out.println("Strings don't contain vowels");
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
Information
Technology
Strings do not contain same no. of vowels


$ java ClientRequest
Enter 2 Strings
Information
Information
Strings contain same no.of vowels


*/


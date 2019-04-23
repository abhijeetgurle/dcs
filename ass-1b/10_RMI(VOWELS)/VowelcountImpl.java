


 
	

//Java program to implement the Search interface (SearchQuery.java)
import java.rmi.*; 
import java.rmi.server.*;
public class VowelcountImpl extends UnicastRemoteObject implements Vowelcount
{	
protected VowelcountImpl() throws RemoteException
 {
		super();
		// TODO Auto-generated constructor stub
	}

//Implementation of the query interface 
public int findCount(String str1,String str2) throws RemoteException
{	
	int count1=0,count2=0;
for(int i=0;i<str1.length();i++)

{
	char ch=str1.charAt(i);
	if(ch=='a' || ch=='e' || ch=='i'|| ch=='o'|| ch=='u')
	
	count1++;	
	
}
for(int i=0;i<str2.length();i++)

{
	char ch=str2.charAt(i);
	if(ch=='a' || ch=='e' || ch=='i'|| ch=='o'|| ch=='u')
	
	count2++;
	
		
		
	
}
if(count1==0&&count2==0)

return 0;

if(count1==count2)

return 1;	

else

return 2;


}
}






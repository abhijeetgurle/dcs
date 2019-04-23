


//Java program to implement the Search interface (SearchQuery.java)
import java.rmi.*; 
import java.rmi.server.*;
public class ReverseImpl extends UnicastRemoteObject implements Reverse
{	
protected ReverseImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

//Implementation of the  interface 
public boolean findReverse(String str1,String str2) throws RemoteException
{
int	length=str2.length();

String str3="";
	

for(int i=length-1;i>=0;i--)
{
	str3=str3+str1.charAt(i);

}
if(str2.equalsIgnoreCase(str3))
{
	return true;
}
else
	return false;
}
}

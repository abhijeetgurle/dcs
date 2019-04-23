//Java program to implement the Search interface (SearchQuery.java)
import java.rmi.*; 
import java.rmi.server.*;
public class ConcatImpl extends UnicastRemoteObject implements Concat
{	
protected ConcatImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

//Implementation of the query interface 
public String query(String str1,String str2) throws RemoteException
{	
String result;
result=str1.concat(str2);
return result;


}
}


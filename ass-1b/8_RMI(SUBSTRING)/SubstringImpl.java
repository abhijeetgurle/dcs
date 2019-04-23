

//Java program to implement the Search interface (SearchQuery.java)
import java.rmi.*; 
import java.rmi.server.*;
public class SubstringImpl extends UnicastRemoteObject implements Substring
{	
protected SubstringImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

//Implementation of the  interface 
public boolean findSubstring(String str1,CharSequence seq) throws RemoteException
{	

boolean bool=str1.contains(seq);
return bool;

}

}


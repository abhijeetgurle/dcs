import java.rmi.Remote;
import java.rmi.RemoteException;
	public interface Concat extends Remote
	{
	// Declaring the method prototype
	public String query(String str1,String str2) throws RemoteException;
	}



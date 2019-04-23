



import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Vowelcount extends Remote
{
// Declaring the method prototype
public int findCount(String str1,String str2) throws RemoteException;
}




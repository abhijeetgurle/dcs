


import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Reverse extends Remote
{
// Declaring the method prototype
public boolean findReverse(String str1,String str2) throws RemoteException;
}




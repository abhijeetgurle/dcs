

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Substring extends Remote
{
// Declaring the method prototype
public boolean findSubstring(String str1,CharSequence seq) throws RemoteException;
}



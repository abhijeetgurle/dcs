
//program for server application (SearchServer.java) import java.rmi.*;
import java.rmi.Naming;
import java.rmi.registry.*; 
public class Server
{
public static void main(String args[])
{
try
{// Create an object of the interface
//implementation class
Vowelcount obj = new VowelcountImpl();
//rmiregistry within the server JVM with port number 1900 
LocateRegistry.createRegistry(8090);
//Binds the remote object
Naming.rebind("rmi://localhost:8090"+"/answer",obj);
}
catch(Exception ae)
{
System.out.println(ae);
}
}
}


/*
$ javac ./*.java
$ rmic VowelcountImpl
$ rmiregistry

$ java Server

*/

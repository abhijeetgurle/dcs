import java.rmi.Naming;
public class Server{
   	public static void main(String a[])throws Exception{
	try{
      		powerimpl obj= new powerimpl();
      		Naming.rebind("POWER",obj);
      		System.out.println("Started Sever");
	}catch(Exception ae){
		System.out.println(ae);
	}
    	}
}

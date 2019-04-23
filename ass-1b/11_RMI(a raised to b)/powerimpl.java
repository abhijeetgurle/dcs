import java.rmi.server.*;
public class powerimpl extends UnicastRemoteObject implements powerInterface{
	public powerimpl() throws Exception
    	{
         	super();
     	}
    	public int power(int x,int y) 
    	{
       		int result=1;
        	for(;y!=0;--y)
         	{
           		result *=x;
          	}
         	return result;
     	}
} 

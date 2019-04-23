import java.rmi.*;
public interface powerInterface extends Remote
{
     public int power(int x,int y) throws Exception;
}
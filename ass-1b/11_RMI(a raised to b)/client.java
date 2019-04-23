import java.rmi.*;
import java.util.Scanner;
public class client{
   	public static void main(String a[])throws Exception{
		int x,y;
     		powerInterface obj=(powerInterface)Naming.lookup("POWER");
		System.out.println("Now Enter the numbers: ");
		Scanner in = new Scanner(System.in);
     		
      		x = in.nextInt();
      		y = in.nextInt();
      		int n= obj.power(x,y);
      		System.out.println("Power of Number is " + n );
    	}
}

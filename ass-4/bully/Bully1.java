import java.util.*;
import java.io.*;

public class Bully1 {

	public static boolean state[] = new boolean[5];


	public static void up(int up) {

		if(state[up-1]) {

			System.out.println("process" + up + " is already up.");
		}
		else {

			state[up-1] = true;
			System.out.println("process" + up + " is now up.");
		}
	}


	public static void down(int down) {

		if(state[down-1]) {

			state[down-1] = false;
			System.out.println("process" + down + " is now down.");
		}
		else {

			System.out.println("process" + down + " is already down.");
		}
	}


	public static void election(int ele) {

		if(state[ele-1]) {

			int cord = ele-1;
			for(int i=ele-1;i<5;i++) {

				if(state[i]) {
				
					for(int j=i+1;j<5;j++) {

						if(state[j]) {

							System.out.println("process" + (i+1) + " sent message to process" + (j+1));
							cord = j;
						}
					}
				}
			}

			System.out.println("Co-ordinator is process" + (cord+1));
		}
		else {

			System.out.println("Process" + ele + " is already down");
		}
	}


	public static void main(String[] args) {

		int choice;
		Scanner sc = new Scanner(System.in);

		for(int i=0;i<5;i++) {

			System.out.println("process" + (i+1) + " is up.");
			state[i] = true;
		}

		do {

			System.out.println("=============");
			System.out.println("1. Up a process");
			System.out.println("2. Down a process");
			System.out.println("3. Start Election");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch(choice) {

				case 1:
				System.out.print("Enter process number to up: ");
				int up = sc.nextInt();
				Bully1.up(up);
				break;

				case 2:
				System.out.print("Enter process number to down: ");
				int down = sc.nextInt();
				Bully1.down(down);
				break;

				case 3:
				System.out.print("Enter process number start election: ");
				int ele = sc.nextInt();
				Bully1.election(ele);
				break;
			}
		}while(choice!=4);
	}
}
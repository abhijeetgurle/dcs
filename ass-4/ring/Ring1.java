import java.util.*;
import java.io.*;


class Process {

	int processId;
	boolean state;
}

class Token {

	int cordId;
	int cordNo;
}

public class Ring1 {

	static Process proc[] = new Process[5];
	static Token tok = new Token();


	public static void up(int up) {

		if(proc[up-1].state) {

			System.out.println("process" + up + " is already up.");
		}
		else {

			proc[up-1].state = true;
			System.out.println("process" + up + " is now up.");
		}
	}


	public static void down(int down) {

		if(proc[down-1].state) {

			proc[down-1].state = false;
			System.out.println("process" + down + " is now down.");
		}
		else {

			System.out.println("process" + down + " is already down.");
		}
	}


	public static void election(int ele) {

		int proc1 = ele-1;
		int proc2 = ele%5;
		tok.cordId = proc[proc1].processId;
		tok.cordNo = proc1;

		if(proc[proc1].state) {

			while((proc2+1)!=ele) {

				if(proc[proc2].state) {

					System.out.println("process" + (proc1+1) + " send token to proc" + (proc2+1));
					if(proc[proc2].processId > tok.cordId) {

						tok.cordId = proc[proc2].processId;
						tok.cordNo = proc2; 
					}

					proc1 = proc2;
					proc2 = (proc2+1)%5;
				}
				else
					proc2 = (proc2+1)%5;
			}

			System.out.println("process" + tok.cordNo + " with id " + tok.cordId + " is co-ordinator");
		}
		else {

			System.out.println("process" + ele + " is down.");
		}
	}


	public static void main(String[] args) {

		int choice;
		Scanner sc = new Scanner(System.in);


		for(int i=0;i<5;i++) {

			proc[i] = new Process();
			System.out.println("Enter process id for process" + (i+1) + ": ");
			proc[i].processId = sc.nextInt();
			proc[i].state = true;
			System.out.println("Process" + (i+1) + " with id " + proc[i].processId + " is up");
		}

		do{
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
				Ring1.up(up);
				break;

				case 2:
				System.out.print("Enter process number to down: ");
				int down = sc.nextInt();
				Ring1.down(down);
				break;

				case 3:
				System.out.print("Enter process number start election: ");
				int ele = sc.nextInt();
				Ring1.election(ele);
				break;
			}
		}while(choice!=4);
	}
}
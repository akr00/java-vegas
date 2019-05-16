// Made By: Aiden Ridgeway
// Created on 3/29/19
// Purpose is to use all skills learned so far in a single project




import java.util.Scanner;

public class TestClass {

	static int[][] slotArray;
	static int slotCount = 3, playerCount = 1;
	
	static Player players[];
	static Name names[];
	static Date birthdays[];
	static int[][] slotCounter;
	static int slotChoice, playingPlayer;
	public static void main(String[] args){
		char choice;
		
		
		slotArraySetUp();
		
		do {
			choice = getChoice();
			switch (choice) {

			case 'P':
				slotChoice = slotChoice();
				playingPlayer = playerChoice();
				slotPlay(slotChoice, playingPlayer);
				break;
			case 'N':
				playerMaker();
				
				break;
			case 'C':
				slotCreator();
				
				break;
			case 'Q':
				
				System.out.println("Thank you for using, have a great day!");
				break;
			default:
				System.out.println("Invalid selection... try again");
				break;
			}

		} while (choice != 'Q');
		
		
	}
	
	public static char getChoice() {
		char result;
		Scanner scan = new Scanner(System.in);

		System.out.println("[P] = Play a slot");
		System.out.println("[N] = Make a new player");
		System.out.println("[C] = Create a new slot");
		System.out.println("[Q] = Quit the program");

		result = scan.nextLine().toUpperCase().charAt(0);
		return result;
	}

	public static int slotChoice() {
		int result;

		
		Scanner scan = new Scanner(System.in);

		System.out.println("[1] = Lucky 7");
		System.out.println("[2] = Lucky Lotto");
		System.out.println("[3] = Purple people eater");
		for (int i = 3; i < slotArray.length; i++) {
			if(slotArray[i] != null && slotArray[i][4] != 0) {
				System.out.println("[" + (i+1) + "] = Custom slot " + (i -2));
			}
			
		}
		System.out.println("[Q] = Quit the program");

		result = (scan.nextInt() - 1);
		return result;
	}
	
	
	public static void slotPlay(int slotChoice, int playingPlayer) {
		int balance, slotBalance;
		balance = players[playingPlayer].getbalance();
		slotBalance = slotArray[slotChoice][0];
		System.out.println("The slot machine's balance is: " + slotBalance);
		if(balance > 0) {
			
			int winnings = 0;
			
			if(slotCounter[slotChoice][0] == slotArray[slotChoice][1]) {
				winnings += slotArray[slotChoice][2];
				slotCounter[slotChoice][0] = -1;
				System.out.println("OMG, YOU WON THE JACKPOT");
				slotBalance -= winnings;
			}
			if(slotCounter[slotChoice][1] == slotArray[slotChoice][3]) {
				winnings += slotArray[slotChoice][4];
				slotCounter[slotChoice][1] = -1;
				System.out.println("Congrats, you won the regular prize");
				slotBalance -= winnings;
			}
			
			balance--;
			if(winnings <= slotBalance) {
				balance += winnings;
			}
			else {
				System.out.println("Sorry, the slot is out of money");
			}
			slotCounter[slotChoice][0]++;
			slotCounter[slotChoice][1]++;
			if(winnings == 0) {
				System.out.println("Sorry, you did not win");
			}
			
			System.out.println("Balance : " + balance);
			players[playingPlayer].setBalance(balance);
			slotArray[slotChoice][0] = slotBalance;
			subChoice();
		}
		else {
			System.out.println("Sorry, you dont have enough money to play");
		}
		
		
		
	}
	
	public static void slotArraySetUp() {
		slotArray = new int[50][5];
		names = new Name[50];
		birthdays = new Date[50];
		players = new Player[50];
		//Lucky 7
		slotArray[0][0] = 5000;    
		slotArray[0][1] = 10000;
		slotArray[0][2] = 5000;
		slotArray[0][3] = 10;
		slotArray[0][4] = 5;		
		//Lucky Lotto
		slotArray[1][0] = 55000;
		slotArray[1][1] = 100000;
		slotArray[1][2] = 75000;
		slotArray[1][3] = 50;
		slotArray[1][4] = 25;
		//Purple People
		slotArray[2][0] = 1000;
		slotArray[2][1] = 50;
		slotArray[2][2] = 40;
		slotArray[2][3] = 5;
		slotArray[2][4] = 2;
		
		//Uncle Charlie
		names[0] = new Name("Uncle",'G', "Charlie");
		birthdays[0] = new Date(20, 9, 1940);
		players[0] = new Player(names[0], birthdays[0], 200 );
		
		slotCounter = new int[slotCount][2];
		slotCounter[0][0] = 0;
		slotCounter[1][0] = 0;
		slotCounter[2][0] = 0;
		slotCounter[0][1] = 0;
		slotCounter[1][1] = 0;
		slotCounter[2][1] = 0;
		
	}

	public static void slotCreator() {
		int slotBalance, whenWinJackpot, jackpot, whenWinReg, reg;
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the Slot's starting balance?");
		slotBalance = scan.nextInt();
		System.out.println("How often does the slot hit the jackpot?");
		whenWinJackpot = scan.nextInt();
		System.out.println("What is the Slot's winning jackpot ammount?");
		jackpot = scan.nextInt();
		System.out.println("How often does the slot win the regualr prize?");
		whenWinReg = scan.nextInt();
		System.out.println("What is the Slot's winning regular ammount?");
		reg = scan.nextInt();
		
		slotArray[slotCount][0] = slotBalance;
		slotArray[slotCount][1] = whenWinJackpot;
		slotArray[slotCount][2] = jackpot;
		slotArray[slotCount][3] = whenWinReg;
		slotArray[slotCount][4] = reg;
		
		slotCount++;
		slotCounter = new int[slotCount][2];
		slotCounter[(slotCount - 1)][0]= 0;
		slotCounter[(slotCount - 1)][1]= 0;
		
	}

	public static void playerMaker() {
		Scanner scan = new Scanner(System.in);

		String first, last;
		char mid;
		int day, month, year, startBalance;
		
		
		System.out.println("What is the player's first name?");
		first = scan.nextLine();
		first = first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase();
		System.out.println("What is the player's  middle initial?");
		mid = scan.nextLine().toUpperCase().charAt(0);
		System.out.println("What is the player's last name?");
		last = scan.nextLine();
		last = last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase();
		
		System.out.println("What is the player's birthday (day only)?");
		day = scan.nextInt();
		System.out.println("What is the player's birthday (month only)?");
		month = scan.nextInt();
		System.out.println("What is the player's birthday (year only)?");
		year = scan.nextInt();
		
		System.out.println("What is the player's starting balance?");
		startBalance = scan.nextInt();
		
		names[playerCount] = new Name(first, mid, last);
		birthdays[playerCount] = new Date(day, month, year);
		players[playerCount] = new Player(names[playerCount], birthdays[playerCount], startBalance);
		
	}
	
	public static int playerChoice() {
		int result;
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < players.length; i++) {
			
			if(players[i] != null) {
				System.out.println("Player #" + (i+1) + " --- " + players[i].toString());
			}
			
				
		}
		System.out.println("--Enter a player # to play with that player--");
		result = ((scan.nextInt()) -1);
		
			
		return result;
		
	}
	
	public static void subChoice() {
		char result;
		Scanner scan = new Scanner(System.in);
		System.out.println("[P] = Play again");
		System.out.println("[G] = Go Back");
		result = scan.nextLine().toUpperCase().charAt(0);
		
		if(result == 'P') {
			slotPlay(slotChoice, playingPlayer);
		}
		else {
			
		}
		
	}
}

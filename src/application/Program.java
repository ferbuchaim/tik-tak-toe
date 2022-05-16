package application;

import java.util.Scanner;

import entities.Player;
import entities.TikTakToe;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of the two players:");
		String name1 = input.next();
		String name2 = input.next();
		
		Player player1 = new Player(name1, 0);
		Player player2 = new Player(name2, 0);
		
		TikTakToe match = new TikTakToe();
		
		int play = 1;
		
		System.out.printf("%s plays with 'X', %s plays with 'O'%n", player1.getName(), player2.getName() );
		while (play == 1) { 
			while (match.checkWinner()== false) {	
				if (match.getRoundsPlayed() == 0 || match.getRoundsPlayed() %2 ==0) {
					System.out.printf("Type the place of your move and your simbol, %s%n", player1.getName());
				} else {
					System.out.printf("Type the place of your move and your simbol, %s %n", player2.getName());
				}
				int line = input.nextInt();
				int column = input.nextInt();
				char simbol = input.next().charAt(0);
				match.makesMove(line, column, simbol);
				System.out.println("Current board: "); 
				match.showBoard();
				match.checkWinner();
				if (match.checkX() == true) {
					player1.addPoints();
				} else if (match.checkO() == true) {
					player2.addPoints();
				}
			}System.out.println("Game Ended");
			System.out.println("Another match? 1- Yes  2-No");
			play = input.nextInt();	
			if (play == 2) {
				if (player1.getPoints()> player2.getPoints()) { 
					System.out.println("The winner is:");
					System.out.println(player1.toString()); 	
				} else if (player2.getPoints()> player1.getPoints()) {
					System.out.println("The winner is:");
					System.out.println(player2.toString());	
				} else {
					System.out.printf("%s and %s are tied with %d points.%n",player1.getName(),player2.getName(), player1.getPoints());
				}
				System.out.println("Final board: "); 
				match.showBoard();
			} else {
				match = new TikTakToe();
			}
		}
	}
}
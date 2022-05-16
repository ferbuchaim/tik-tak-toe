package entities;

import java.util.Arrays;

public class TikTakToe {
	
	public int getRoundsPlayed() {
		return roundsPlayed;
	}

	public void setRoundsPlayed(int roundsPlayed) {
		this.roundsPlayed = roundsPlayed;
	}

	private char[][] board;

	public TikTakToe() {
		
		board = new char[3][3];
	}
	
	int roundsPlayed = 0;
	public boolean makesMove(int line, int column, char simbol) { 
		if (board[line][column] == '\0'){							
			board[line][column] = simbol;							
			roundsPlayed++;
			return true;
		} else {
			System.out.println("Place already taken.");
			return false;
		}
	}
	
	public boolean checkMainDiagonal(char simbol) {
		for (int i=0; i<board.length; i++) {
			if (board[i][i] != simbol) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkAntiDiagonal(char simbol) {
		for (int i=0; i<board.length; i++) {
			if (board[i][board.length -1-i] != simbol) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkLines(char simbol) {  
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board.length; j++) {
				if (board[i][j] != simbol) {
					break;								
				} if (j == board.length-1) {      
					return true;                    
				}								
			}
		}
		return false;			
	}
	
	public boolean checkColumns(char simbol) {  
		for (int i=0; i<board.length; i++) {	
			for (int j=0; j<board.length; j++) { 
				int cont = 0;
				if (board[j][i] != simbol) {
					break;
				} if (j == board.length-1) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkO() {		
		if (checkMainDiagonal('O')) {	
			return true;
		}  if (checkLines('O')) {
			return true;
		} if (checkColumns('O')) {
			return true;
		} if (checkAntiDiagonal('O')) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkX() {		
		if (checkMainDiagonal('X')) {	
			return true;
		}  if (checkLines('X')) {
			return true;
		} if (checkColumns('X')) {
			return true;
		} if (checkAntiDiagonal('X')) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkWinner() {		
		if (roundsPlayed <board.length) {	
			return false; 					
		} else if (roundsPlayed == board.length*board.length) {
			return true;
		}
		if (checkX()) { 
			return true;
		} else if (checkO()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void showBoard() {					
		for (int i=0; i<board.length;i++) {
			for(int j=0; j<board.length; j++) {
				System.out.printf("%c ",board[i][j]);
				if (board[i][j] == '\0') {
					System.out.print("");
				}
				if (j == board.length-1) {
					System.out.println();
				}
			}
		}
	}
}
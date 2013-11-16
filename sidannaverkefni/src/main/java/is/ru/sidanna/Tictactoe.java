package is.ru.sidanna;

import java.util.Scanner;
import java.io.Console;

public class Tictactoe
{
	public static void main(String[] args)
	{
		// ============= Initialization ============	
		boolean gameOver = false;
		boolean quit = false;
		Console console = System.console();
		Board board = new Board();
		Player p1 = new HumanPlayer("Player1", 'X');
		Player p2 = null;
		Player currentPlayer = p1; 	// Player1 is the first to take a turn. Maybe add random selection of first player?
		System.out.println("Type 'h' to play against a human, 'c' to play against computer");
		String opponant = console.readLine();
		if(opponant.equals("c"))
		{
			System.out.println("What difficulty? 1 for Easy. 2 for Medium. 3 for Hard.");
			String diffic = console.readLine();
			p2 = new CPUPlayer("Player2", 'O', diffic);
		}
		else if(opponant.equals("h"))
		{
			System.out.println("Playing against human..");
			p2 = new HumanPlayer("Player2", 'O');
		}
		board.printBoard();
		do
		{
			// We make the players take turns until either wins or they draw

			// Make the current player do a turn
			System.out.println(currentPlayer.getName() + "'s move..");
			currentPlayer.makeAmove(board);
			board.printBoard();
			System.out.println("");
			if(board.hasWon(currentPlayer.getSymbol()))
			{
				System.out.println("Omg, " + currentPlayer.getName() + " has won! What a genius!");
				gameOver = true;
				if(p1 == currentPlayer)
					board.incP1();
				else if(p2 == currentPlayer)
					board.incP2();
			}
			else if(board.isBoardFull())
			{
				System.out.println("Aww, the game ended in a draw...");
				gameOver = true;
				board.incTies();
			}

			// Toggle the current player 
			if(p2 == currentPlayer)
				currentPlayer = p1;
			else if(p1 == currentPlayer)
				currentPlayer = p2;

			if(gameOver)
			{
				System.out.println(p1.getName() + ": " + board.getScoreP1() + ", ties: " + board.getTies() + ", " + p2.getName() + ": " + board.getScoreP2());
				System.out.println("Type 'Y' if you want a rematch: ");
				String rem = console.readLine();
				if(rem.equals("Y"))
				{
					board.resetBoard();
					gameOver = false;
					System.out.println("");
					board.printBoard();
				}
				else
					quit = true;
			}

			
		}while(!quit); // Need to allow players to rematch
	}
}

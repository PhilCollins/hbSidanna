package is.ru.sidanna;

import java.util.Scanner;
import java.io.Console;

public class Tictactoe
{
	public static void main(String[] args)
	{
		// ============= Initialization ============		
		Console console = System.console();
		Board board = new Board();
		Player p1 = new HumanPlayer("Player1", 'X');
		Player p2 = null;
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
			System.out.println(p1.getName() + "'s move..");
			p1.makeAmove(board);
			board.printBoard();
			System.out.println("");
			if(board.hasWon(p1.getSymbol()))
			{
				System.out.println("Omg, " + p1.getName() + " has won! What a genius!");
				break;
			}
			else if(board.isBoardFull())
			{
				System.out.println("Aww, the game ended in a draw...");
				break;
			}
			System.out.println(p2.getName() + "'s move..");
			p2.makeAmove(board);
			board.printBoard();
			System.out.println("");
			if(board.hasWon(p2.getSymbol()))
			{
				System.out.println("Omg, " + p2.getName() + " has won! What a genius!");
				break;
			}
			else if(board.isBoardFull())
			{
				System.out.println("Aww, the game ended in a draw...");
				break;
			}
		}while(1 == 1); // Need to allow players to rematch
	}
}

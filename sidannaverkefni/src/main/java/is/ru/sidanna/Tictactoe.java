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
		if(opponant == "c")
		{
			System.out.println("What difficulty? 1 for Easy. 2 for Medium. 3 for Hard.");
			String diffic = console.readLine();
			p2 = new CPUPlayer("Player2", 'O', diffic);
		}
		else if(opponant == "h")
			p2 = new HumanPlayer("Player2", 'O');

		do
		{
			p1.makeAmove();
			if(board.hasWon(p1.getSymbol()))
				break;
			
			p2.makeAmove();
			if(board.hasWon(p2.getSymbol()))
				break;
		}while(1 == 1);
	}
}

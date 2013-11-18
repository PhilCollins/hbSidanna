package is.ru.sidanna;

import java.util.Scanner;

public class HumanPlayer extends Player
{
	// Constructor
	HumanPlayer(String name, char symbol)
	{
		super(name, symbol);
	}

	// Make the player make a move
	void makeAmove(Board b)
	{
		Scanner reader = new Scanner(System.in);
		boolean error = false;
		do
		{
			System.out.println("Type a cell to fill");
			int cell = reader.nextInt();
			error = false;
			if(cell < 0 || cell > 8)
			{
				System.out.println("### Cell number has to be in the range of 0-8! ###");
				error = true;
			}
			else if(b.isOccupied(cell))
			{
				System.out.println("### Cell already occupied, choose another! ###");
				error = true;
			
			}
			else
				b.fillCell(cell, symbol);
		}while(error == true); // We ask the player again and again to select a new cell if his previous pick was erronious
	}
}

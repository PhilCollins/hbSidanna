package is.ru.sidanna;

import java.util.Random;

public class CPUPlayer extends Player
{
	String difficulty;

	CPUPlayer(String name, char symbol, String diffic)
	{
		super(name, symbol);
		difficulty = diffic;
	}

	void makeAmove(Board b)
	{
		Random rand = new Random();
		boolean error = false;
		do
		{
			error = false;
			int cell = rand.nextInt(9);
			if(b.isOccupied(cell))
				error = true;
			else
				b.fillCell(cell, symbol);
		}while(error == true);
	}

	void setDifficulty(String diff)
	{
		difficulty = diff;
	}
}

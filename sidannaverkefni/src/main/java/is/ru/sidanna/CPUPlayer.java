package is.ru.sidanna;

import java.util.Random;

public class CPUPlayer extends Player
{
	String difficulty;
	
	// Constructor
	CPUPlayer(String name, char symbol, String diffic)
	{
		super(name, symbol);
		difficulty = diffic;
	}

	// Makes a move for the CPU. This function pretty much just calls the corresponding difficulty function to decide a cell.
	void makeAmove(Board b)
	{
		int cell = -1;
		switch(Integer.parseInt(difficulty))
		{
			case 1:
				cell = easyMakeAmove(b);
				break;
			case 2:
				cell = mediumMakeAmove(b);
				break;
			case 3:
				cell = hardMakeAmove(b);
				break;
		}
		b.fillCell(cell, symbol);
	}

	// Generate a cell for easy difficulty
	int easyMakeAmove(Board b)
	{
		// For this difficulty we just randomly select an unoccupied cell
		Random rand = new Random();
		int cell;
		do
		{
			cell = rand.nextInt(9);
		}
		while(b.isOccupied(cell));
		return cell;
	}

	// Generate a cell for medium difficulty
	int mediumMakeAmove(Board b)
	{
		int cell = -1;
		// We first check whether the CPU can win
		cell = b.isAbleToWin(symbol);

		// We then check whether the opponant can win
		if(cell == -1)
			cell = b.isAbleToWin('X'); // Need to fix hardcoding here

		// Pick the middle cell if it's unoccupied
		if(!b.isOccupied(4) && cell == -1)
			cell = 4;

		// Finally we just randomly select an unoccupied cell
		if(cell == -1)
		{
			Random rand = new Random();
			do
			{
				cell = rand.nextInt(9);
			}while(b.isOccupied(cell));
		}
		return cell;
	}

	// Generate a cell for hard difficulty
	int hardMakeAmove(Board b)
	{
		System.out.println("hardMakeAmove()");
		int cell = -1;
		// Check whether CPU can win
		cell = b.isAbleToWin(symbol);

		// Check whether opponant can win
		if(cell == -1)
			cell = b.isAbleToWin('X'); // Need to fix hardcoding here

		// Check if CPU can create a fork
		if(cell == -1)
			cell = b.checkForFork(symbol);

		// Check if opponant can create a fork
		if(cell == -1)
			cell = b.checkForFork('X'); // Need to fix hardcoding

		// Select middle cell if it's unoccupied
		if(!b.isOccupied(4) && cell == -1)
			cell = 4;

		// Select one of the corner cells following some criteria
		if(cell == -1)
		{
			// Array containing all the corner cells
			int[] corners = {0, 2, 4, 8};
			// Array containing the opposite corners of the one before
			int[] oppCorners = {8, 4, 2, 0};

			// If opponant has selected one of the corners, we select the opposite corner if it's unoccupied
			for(int i = 0; i < corners.length; i++)
			{
				if(b.boardCells[corners[i]] == 'X' && b.boardCells[oppCorners[i]] == ' ')
					cell = oppCorners[i];
			}

			// We select a random corner, if it's unoccupied
			if(cell == -1)
			{
				for(int i = 0; i < corners.length; i++)
				{
					if(b.boardCells[corners[i]] == ' ')
					{
						cell = corners[i];
					}
				}
			}
		}
		
		// Finally we select a random cell
		if(cell == -1)
		{
			Random rand = new Random();
			do
			{
				cell = rand.nextInt(9);
			}while(b.isOccupied(cell));
		}
		return cell;
	}

	void setDifficulty(String diff)
	{
		difficulty = diff;
	}
}

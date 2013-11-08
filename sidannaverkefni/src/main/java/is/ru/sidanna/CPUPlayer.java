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

	int easyMakeAmove(Board b)
	{
		Random rand = new Random();
		int cell;
		do
		{
			cell = rand.nextInt(9);
		}
		while(b.isOccupied(cell));
		return cell;
	}

	int mediumMakeAmove(Board b)
	{
		int cell = -1;
		cell = b.isAbleToWin(symbol);

		if(cell == -1)
			cell = b.isAbleToWin('X'); // Need to fix hardcoding here

		if(!b.isOccupied(4) && cell == -1)
			cell = 4;

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

	int hardMakeAmove(Board b)
	{
		System.out.println("hardMakeAmove()");
		int cell = -1;
		cell = b.isAbleToWin(symbol);

		if(cell == -1)
			cell = b.isAbleToWin('X'); // Need to fix hardcoding here

		if(cell == -1)
			cell = b.checkForFork(symbol);

		if(cell == -1)
			cell = b.checkForFork('X'); // Need to fix hardcoding

		if(!b.isOccupied(4) && cell == -1)
			cell = 4;

		if(cell == -1)
		{
			int[] corners = {0, 2, 4, 8};
			int[] oppCorners = {8, 4, 2, 0};

			for(int i = 0; i < corners.length; i++)
			{
				if(b.boardCells[corners[i]] == 'X' && b.boardCells[oppCorners[i]] == ' ')
					cell = oppCorners[i];
			}
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

package is.ru.sidanna;

public class Board
{
	char[] boardCells = new char[9];
	int p1wins;
	int p2wins;
	int ties;

	int[][] winningConditions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

	Board()
	{
		p1wins = 0;
		p2wins = 0;
		ties = 0;
		resetBoard();
	}

	boolean fillCell(int cellNumber, char symbol)
	{
		if(cellNumber < 0 || cellNumber > 8)
			return false;
		else if(boardCells[cellNumber] == ' ')
			return false;
		boardCells[cellNumber] = symbol;
		return true;
	}

	boolean hasWon(char symbol)
	{
		for(int i = 0; i < winningConditions.length; i++)
		{
			if(boardCells[winningConditions[i][0]] == symbol &&  boardCells[winningConditions[i][1]] == symbol && boardCells[winningConditions[i][2]] == symbol)
				return true;
		}
		return false;
	}

	void resetBoard()
	{
		for(int i = 0; i < boardCells.length; i++)
			boardCells[i] = ' ';
	}
}

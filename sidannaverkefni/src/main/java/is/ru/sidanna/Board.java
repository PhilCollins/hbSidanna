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

	void fillCell(int cellNumber, char symbol)
	{
		boardCells[cellNumber] = symbol;
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
	
	boolean isBoardFull()
	{
		int counter = 0;
		for(int i = 0; i < boardCells.length; i++)
		{
			if(boardCells[i] != ' ')
				counter++;
		}
		if(counter == boardCells.length)
			return true;
		return false;
	}

	void resetBoard()
	{
		for(int i = 0; i < boardCells.length; i++)
			boardCells[i] = ' ';
	}

	void printBoard()
	{
		System.out.println(" " + boardCells[0] + " | " + boardCells[1] + " | " + boardCells[2]);
		System.out.println("---+---+---");
		System.out.println(" " + boardCells[3] + " | " + boardCells[4] + " | " + boardCells[5]);
		System.out.println("---+---+---");
		System.out.println(" " + boardCells[6] + " | " + boardCells[7] + " | " + boardCells[8]);
	}

	boolean isOccupied(int cell)
	{
		if(boardCells[cell] != ' ')
			return true;
		return false;
	}

	int isAbleToWin(char symbol)
	{
		int cell = -1;
		for(int i = 0; i < winningConditions.length; i++)
		{
			if (boardCells[winningConditions[i][0]] == symbol && boardCells[winningConditions[i][1]] == symbol && boardCells[winningConditions[i][2]] == ' ') 
				cell = winningConditions[i][2];
        		else if (boardCells[winningConditions[i][0]] == symbol && boardCells[winningConditions[i][2]] == symbol && boardCells[winningConditions[i][1]] == ' ') 
           			cell = winningConditions[i][1];
        		else if (boardCells[winningConditions[i][1]] == symbol && boardCells[winningConditions[i][2]] == symbol && boardCells[winningConditions[i][0]] == ' ') 
            			cell = winningConditions[i][0];
		}
		return cell;
	}

	int checkForFork(char symbol)
	{
		for(int i = 0; i < boardCells.length; i++)
		{
			if(boardCells[i] == ' ')
			{
				if(this.winningScenarios(i, symbol) > 1)
					return i;
			}
		}
		return -1;
	}

	int winningScenarios(int cell, char symbol)
	{
		int counter = 0;
		char[] newBoard = new char[boardCells.length];
		System.arraycopy(boardCells, 0, newBoard, 0, boardCells.length);
		newBoard[cell] = symbol;
		for(int i = 0; i < winningConditions.length; i++)
		{
			        if (newBoard[winningConditions[i][0]] == symbol && newBoard[winningConditions[i][1]] == symbol && newBoard[winningConditions[i][2]] == ' ')
            				counter++;
        			else if (newBoard[winningConditions[i][0]] == symbol && newBoard[winningConditions[i][2]] == symbol && newBoard[winningConditions[i][1]] == ' ')
            				counter++;
        			else if (newBoard[winningConditions[i][1]] == symbol && newBoard[winningConditions[i][2]] == symbol && newBoard[winningConditions[i][0]] == ' ')
            				counter++;
		}
		return counter;
	}
}

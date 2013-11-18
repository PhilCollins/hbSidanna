package is.ru.sidanna;

public class Board
{
	char[] boardCells = new char[9]; // Holds information about our current board. If a cell is empty(' ') it is unoccupied.
	int p1wins;			 // How many times player1 has won
	int p2wins;			 // How many times player2 has won
	int ties;			 // How many times the game has ended in a draw

	// Multi-array with all possible combinations of winning conditions. We use this to easily check if a player has won, or can win etc.
	int[][] winningConditions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

	// Constructor
	Board()
	{
		p1wins = 0;
		p2wins = 0;
		ties = 0;
		resetBoard();	// We make sure all cells on the board is what we considered empty, i.e: ' '
	}


	void incP1()
	{
		p1wins++;
	}

	void incP2()
	{
		p2wins++;
	}

	void incTies()
	{
		ties++;
	}

	int getScoreP1()
	{
		return p1wins;
	}

	int getScoreP2()
	{
		return p2wins;
	}

	int getTies()
	{
		return ties;
	}

	// Fill a specific cell of our board with a specific symbol
	void fillCell(int cellNumber, char symbol)
	{
		boardCells[cellNumber] = symbol;
	}

	// Check whether this symbol has won
	boolean hasWon(char symbol)
	{
		for(int i = 0; i < winningConditions.length; i++) // We iterate through all the possible winning conditions
		{
			if(boardCells[winningConditions[i][0]] == symbol &&  boardCells[winningConditions[i][1]] == symbol && boardCells[winningConditions[i][2]] == symbol) // If all 3 cells of this winning conditions are filled with our symbol, he has won
				return true;
		}
		return false;
	}
	
	// Checks whether all cells on the Board are full, possibly because the game ended in a draw
	boolean isBoardFull()
	{
		int counter = 0;
		for(int i = 0; i < boardCells.length; i++)
		{
			if(boardCells[i] != ' ') // We simply count all the cells that are occupied
				counter++;
		}
		if(counter == boardCells.length)
			return true;
		return false;
	}

	// Reset the board to our empty state, i.e. so cells are ' '
	void resetBoard()
	{
		for(int i = 0; i < boardCells.length; i++)
			boardCells[i] = ' ';
	}

	// We nicely print the current status of our board out
	void printBoard()
	{
		System.out.println(" " + boardCells[0] + " | " + boardCells[1] + " | " + boardCells[2]);
		System.out.println("---+---+---");
		System.out.println(" " + boardCells[3] + " | " + boardCells[4] + " | " + boardCells[5]);
		System.out.println("---+---+---");
		System.out.println(" " + boardCells[6] + " | " + boardCells[7] + " | " + boardCells[8]);
	}

	// Checks whether a specific cell is already occupied
	boolean isOccupied(int cell)
	{
		if(boardCells[cell] != ' ')
			return true;
		return false;
	}

	// Checks whether a specific symbol can win with one move
	int isAbleToWin(char symbol)
	{
		int cell = -1;
		for(int i = 0; i < winningConditions.length; i++) // We iterate through all the possible winning conditions
		{
			// We check all permutations of this winning condition whether 2 cells are occupied with our symbol, while the 3rd cell is empty
			if (boardCells[winningConditions[i][0]] == symbol && boardCells[winningConditions[i][1]] == symbol && boardCells[winningConditions[i][2]] == ' ') 
				cell = winningConditions[i][2];
        		else if (boardCells[winningConditions[i][0]] == symbol && boardCells[winningConditions[i][2]] == symbol && boardCells[winningConditions[i][1]] == ' ') 
           			cell = winningConditions[i][1];
        		else if (boardCells[winningConditions[i][1]] == symbol && boardCells[winningConditions[i][2]] == symbol && boardCells[winningConditions[i][0]] == ' ') 
            			cell = winningConditions[i][0];
		}
		return cell;
	}

	// Checks whether a specific symbol can create a fork
	int checkForFork(char symbol)
	{
		for(int i = 0; i < boardCells.length; i++)
		{
			if(boardCells[i] == ' ') // We check every empty cell whether it can possible create fork
			{
				if(this.winningScenarios(i, symbol) > 1) // We hypothetically fill this cell with our symbol. If the amount of winning scenarios that we created by this are 2 or more, we can creata fork
					return i;
			}
		}
		return -1;
	}

	// Counts the amount of winning scenarios with this hypothetical board
	int winningScenarios(int cell, char symbol)
	{
		int counter = 0;
		// We create a new 'hypothetical' board and fill it with the cell we are checking
		char[] newBoard = new char[boardCells.length];
		System.arraycopy(boardCells, 0, newBoard, 0, boardCells.length);
		newBoard[cell] = symbol;

		for(int i = 0; i < winningConditions.length; i++) // We then simply iterate through all the winning ocnditions
		{
				// Similar to the isAbleToWin function, we check all permutations of this winning conditions if it has a winning scenario.
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

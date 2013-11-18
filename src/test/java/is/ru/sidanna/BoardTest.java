package is.ru.sidanna;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoardTest {

	int[][] winningConditions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

        @Test
        public void initialization() {

		// Check that all cells in the board are instantiated as empty(' ')
                Board b = new Board();
		for(int i = 0; i < b.boardCells.length; i++)
		{
			assertEquals(' ', b.boardCells[i]);
		}
        }

	@Test
	public void isOcc() {
		// Tests for the isOccupied function

		Board b = new Board();
		for(int i = 0; i < b.boardCells.length; i++)
		{
			assertEquals(false, b.isOccupied(i));
		}
		b.fillCell(2, 'X');
		assertEquals(true, b.isOccupied(2));
		
		b.fillCell(5, 'O');
		assertEquals(true, b.isOccupied(5));
	}

        @Test
        public void hasWon() {
		// Checks for the hasWon function
                Board b = new Board();
		assertEquals(false, b.hasWon('X'));
		assertEquals(false, b.hasWon('O'));
		
		b.fillCell(0, 'X');
		b.fillCell(1, 'X');
		b.fillCell(2, 'X');
		assertEquals(true, b.hasWon('X'));
		assertEquals(false, b.hasWon('O'));
		
		b.fillCell(0, 'O');
		b.fillCell(4, 'O');
		b.fillCell(8, 'O');
		assertEquals(true, b.hasWon('O'));
		}

        @Test
        public void boardFull()
	{	
		// Tests for the isBoardFull function
		Board b = new Board();
		for(int i = 0; i < b.boardCells.length; i++)
		{
			assertEquals(false, b.isBoardFull());
			b.fillCell(i, 'X');
		}
		assertEquals(true, b.isBoardFull());
	}

	@Test
	public void resetBoard()
	{
		// Tests for the resetBoard function
		Board b = new Board();
		for(int i = 0; i < b.boardCells.length; i++)
			b.fillCell(i, 'X');

		b.resetBoard();
		
		for(int i = 0; i < b.boardCells.length; i++)
			assertEquals(false, b.isOccupied(i));
	}

	@Test
	public void isAbleToWin()
	{
		// Tests for the isAbleToWin function
		Board b = new Board();
		assertEquals(-1, b.isAbleToWin('X'));

		b.fillCell(0, 'X');
		b.fillCell(2, 'X');
		assertEquals(1, b.isAbleToWin('X'));
	}

	public void checkForFork()
	{
		// Tests for the checkForFork function
		Board b = new Board();
		assertEquals(-1, b.checkForFork('X'));
		b.fillCell(1, 'X');
		b.fillCell(5, 'X');

		assertEquals(2, b.checkForFork('X'));
	}
}


package is.ru.sidanna;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CPUPlayerTest {
	
	@Test
	public void instantiation()
	{
		Board b = new Board();	// Unfortunately the CPUPlayer class is kind of dependent on the Board class, so we have to create an instance of it
		CPUPlayer c = new CPUPlayer("CPU", 'O', "1");

		assertEquals("CPU", c.getName());
		assertEquals('O', c.getSymbol());
		assertEquals("1", c.difficulty);
	}

	@Test
	public void easyDifficulty()
	{
		// It's kind of difficult to do tests on this difficulty since it just chooses a random non-occupied cell, but we'll do our best
		
		Board b = new Board();
		CPUPlayer c = new CPUPlayer("CPU", 'O', "1");

		// Check whether the index of the cell the function randomly chose is in the range of 0-8
		assertEquals(true, c.easyMakeAmove(b) >= 0);
		assertEquals(true, c.easyMakeAmove(b) <= 8);

		// We fill all but one cell of the board and make sure the easyMakeAmove functions returns the index of the only cell that is not occupied	
		Board b2 = new Board();
		for(int i = 0; i < 8; i++)
		{
			b2.fillCell(i, 'X');
		}
		assertEquals(8, c.easyMakeAmove(b2));
	}

	@Test
	public void mediumDifficulty()
	{
		CPUPlayer c = new CPUPlayer("CPU", 'O', "2");
		Board b = new Board();

		assertEquals(4, c.mediumMakeAmove(b));	// Since board is empty, we make sure the computer always selects the middle cell

		b.fillCell(0, 'O');
		b.fillCell(1, 'O');
		assertEquals(2, c.mediumMakeAmove(b));	// If the computer has a winnable game we make sure it detects so

		Board b2 = new Board();
		b2.fillCell(3, 'X');
		b2.fillCell(4, 'X');
		assertEquals(5, c.mediumMakeAmove(b2));	// If the opponant has a winnable game we make sure it blocks it
	}

	@Test
	public void hardDifficulty()
	{
		// Fork tests
		Board b = new Board();
		CPUPlayer c = new CPUPlayer("CPU", 'O', "3");

                b.fillCell(1, 'O');
                b.fillCell(5, 'O');

                assertEquals(2, c.hardMakeAmove(b)); 	// We make sure the CPU capitalizes when a fork is possible
	}
}

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

	void makeAmove()
	{
		Random rand = new Random();
		int cell = rand.nextInt(9);
	}

	void setDifficulty(String diff)
	{
		difficulty = diff;
	}
}

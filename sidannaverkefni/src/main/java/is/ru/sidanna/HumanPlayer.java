package is.ru.sidanna;

import java.util.Scanner;

public class HumanPlayer extends Player
{
	HumanPlayer(String name, char symbol)
	{
		super(name, symbol);
	}

	void  makeAmove()
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Type a cell to fill");
		int cell = reader.nextInt();
	}
}

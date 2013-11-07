package is.ru.sidanna;

public abstract class Player
{
	String playerName;
	char symbol;

	Player(String name, char symb)
	{
		playerName = name;
		symbol = symb;
	}

	char getSymbol()
	{
		return symbol;
	}
	
	abstract void makeAmove(Board b);

	String getName()
	{
		return playerName;
	}
}

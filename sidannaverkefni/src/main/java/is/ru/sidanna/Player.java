package is.ru.sidanna;

// Parent class for HumanPlayer and CPUPlayer
public abstract class Player
{
	String playerName;
	char symbol;

	// Constructor
	Player(String name, char symb)
	{
		playerName = name;
		symbol = symb;
	}

	// Returns the sumbol of this player
	char getSymbol()
	{
		return symbol;
	}
	
	// Force the childs to implement this function
	abstract void makeAmove(Board b);

	// Return the name of of this player
	String getName()
	{
		return playerName;
	}
}

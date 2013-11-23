package is.ru.sidanna;

import java.util.Scanner;
import java.io.Console;

public class Tictactoe
{
    public static void main(String[] args)
    {
	// ============= Initialization ============
	boolean gameOver = false;
	boolean quit = false;
	Console console = System.console();
	Board board = new Board();
	Player p1 = new HumanPlayer("Player1", 'X');
	Player p2 = null;
	Game game;
	int[] gameState = new int[2];
	String in = "r";
                do
                    {
                        board.resetBoard();
                        p2 = setupPlayers();
                        board.printBoard();
                        game = new Game(board, p1, p2, gameState);
                        game.play();
                        System.out.println("Press r for rematch, anything else to return to main menu.");
                        in = console.readLine();
                    }
                while(in.equals("r"));
    }
    public static Player setupPlayers()
    {
        System.out.println("Press 'h' to play against a fellow human being, 'c' to play against a computer");
        String opp = System.console().readLine();
        return  setPlayer(opp);
    }

    public static Player setPlayer(String opponent)
    {
        if(opponent.equals("c"))
            {
                System.out.println("What difficulty? 1 for Easy. 2 for Medium. 3 for Hard.");
                String diffic = System.console().readLine();
                return new CPUPlayer("Player2", 'O', diffic);
	    }
	else if(opponent.equals("h"))
	    {
		System.out.println("Playing against human.");
		return new HumanPlayer("Player2", 'O');
	    }
	return new HumanPlayer("Player2", 'O');
    }
}
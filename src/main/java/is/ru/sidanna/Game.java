package is.ru.sidanna;

import java.util.Scanner;
import java.io.Console;

public class Game {

    Board board;
    Player player1;
    Player player2;
    Player currPlayer;
    int[] gameState;

    Game(Board nboard, Player nplayer1, Player nplayer2, int[] ngameState)
    {
        board = nboard;
        player1 = nplayer1;
        player2 = nplayer2;
        gameState = ngameState;
    }
    public void play()
    {
        currPlayer = player1;
        //Game on
        gameState[0] = 1;
        while (gameState[0] != 2)
            {
		// We make the players take turns until either wins or they draw
		// Make the current player do a turn
		System.out.println(currPlayer.getName() + "'s move..");
		currPlayer.makeAmove(board);
		board.printBoard();
		System.out.println("");
		if(board.hasWon(currPlayer.getSymbol()))
		    {
			System.out.println("Omg, " + currPlayer.getName() + " has won! What a wizard!");
			gameState[0] = 2;
			if(player1 == currPlayer)
			    board.incP1();
			else if(player2 == currPlayer)
			    board.incP2();
		    }
		else if(board.isBoardFull())
		    {
			System.out.println("Aww, the game ended in a draw...");
			gameState[0] = 2;
			board.incTies();
		    }
		// Toggle the current player
		if(player2 == currPlayer)
		    {
			currPlayer = player1;
		    }
		else
		    {
			currPlayer = player2;
		    }
            }
    }
    public static void main(String args[])
    {
        return;
    }

}

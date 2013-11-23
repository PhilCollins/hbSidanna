package is.ru.sidanna;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Scanner;
import java.io.InputStream;
import java.io.ByteArrayInputStream;


public class GameTest
{
    @Test
        public void constructorTest()
    {
        HumanPlayer p1 = new HumanPlayer("Player1", 'X');
        HumanPlayer p2 = new HumanPlayer("Player2", 'O');
        int[] gameState = new int[2];
        Board board = new Board();
        Game g = new Game(board, p1, p2, gameState);
        assertEquals("Player1", g.player1.getName());
        assertEquals('X', g.player1.getSymbol());
        assertEquals("Player2", g.player2.getName());
        assertEquals('O', g.player2.getSymbol());
        assertEquals(false, g.board.isBoardFull());
    }
    /*
    play() needs to be modularized some more

    @Test
    public void playTest()
    {
        HumanPlayer p1 = new HumanPlayer("Player1", 'X');
        HumanPlayer p2 = new HumanPlayer("Player2", 'O');
        int[] gameState = new int[2];
        Board board = new Board();
        Game g = new Game(board, p1, p2, gameState);
        String data = "0\r\n3\r\n4\r\n6\r\n8\r\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        g.play();
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());


        assertEquals(2, g.gameState[0]);

    }
    */

}

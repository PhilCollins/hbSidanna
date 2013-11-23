package is.ru.sidanna;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TictactoeTest
{
    @Test
        public void setPlayerTest()
    {
        Tictactoe t = new Tictactoe();
        Player p = t.setPlayer("h");
        assertEquals("Player2", p.playerName);
    }
}
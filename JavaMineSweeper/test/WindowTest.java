import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WindowTest {

    @Test
    public void isOpenedTest() {
        Board boardStart = new Board(10,1, 10 , 10);
        boardStart.buildBoard();
        boardStart.fields[0][0].setOpened(true);

        assertEquals(true, boardStart.fields[0][0].isOpened());
    }
}

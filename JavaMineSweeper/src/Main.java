import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Board boardStart = new Board(10,1, 10 , 10);

        try {
            Window frame = new Window(boardStart);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

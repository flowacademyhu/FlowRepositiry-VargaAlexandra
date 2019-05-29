import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int hard = 15;
        Board boardHard = new Board(hard,0, hard*hard );

        try {
            Window frame = new Window(boardHard);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

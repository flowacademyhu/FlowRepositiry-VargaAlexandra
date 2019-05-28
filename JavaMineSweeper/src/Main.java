import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        try {
            Window frame = new Window(10);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

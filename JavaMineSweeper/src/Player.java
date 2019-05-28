import javax.swing.*;

public class Player extends JLabel {
    int life;

    public Player(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public String toString() {
        return "life points: " + life;
    }
}

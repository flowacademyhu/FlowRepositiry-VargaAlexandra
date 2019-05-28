import javax.swing.*;
import java.awt.*;

public class Field extends JLabel {
    private boolean hasBomb;
    private boolean hasHp;
    private boolean hasFlag;
    private int fieldValue;
    private boolean isOpened;
    Icon flagIcon, bombIcon, hpIcon;
    private int cordinateX;
    private int cordinateY;

    public int getCordinateX() {
        return cordinateX;
    }

    public void setCordinateX(int cordinateX) {
        this.cordinateX = cordinateX;
    }

    public int getCordinateY() {
        return cordinateY;
    }

    public void setCordinateY(int cordinateY) {
        this.cordinateY = cordinateY;
    }


    public Field() {

        setText("");
        setFocusable(false);
        setSize(50, 50);

        ImageIcon icon = new ImageIcon("images/flag4.png");
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        flagIcon = new ImageIcon(newImg);

        ImageIcon icon2 = new ImageIcon(getClass().getResource("bomb.png"));
        Image img2 = icon2.getImage();
        Image newImg2 = img2.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        bombIcon = new ImageIcon(newImg2);

        ImageIcon icon3 = new ImageIcon(getClass().getResource("care.png"));
        Image img3 = icon3.getImage();
        Image newImg3 = img3.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        hpIcon = new ImageIcon(newImg3);

        this.hasBomb = false;
        this.hasHp = false;
        this.hasFlag = false;
        this.isOpened = false;

    }

    public boolean hasBomb() {
        return hasBomb;
    }

    public void setBomb(boolean bomb) {
        hasBomb = bomb;
    }

    public boolean hasHp() {
        return hasHp;
    }

    public void setHp(boolean hp) {
        hasHp = hp;
    }

    public boolean hasFlag() {
        return hasFlag;
    }

    public void setFlagged(boolean hasFlag) {

        this.hasFlag = hasFlag;
        if (hasFlag) {
            setIcon(flagIcon);
        } else {
            setIcon(null);
        }
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean revealed) {

        if (hasBomb) {
            if (!hasFlag) {
                setIcon(bombIcon);
                setBackground(null);
            }
            setIcon(bombIcon);
            setBackground(null);
        }
        else if (hasHp) {
            if(!hasFlag) {
               setIcon(hpIcon);
               setBackground(null);
        }
        }
        else {
            setBackground(null);
            setIcon(null);
            if (fieldValue >= 0) {
                setText("" + fieldValue);
            }
        }
        this.isOpened = true;

    }


    public int getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(int fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public String toString() {
        return "" + String.valueOf(fieldValue);
    }


}

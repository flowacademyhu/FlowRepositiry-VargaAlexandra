import java.awt.*;

public class Board{

    private int factor;
    private int hpFactor;
    private int numberOfBomb;

    Field fields[][];

    int i= 0;
    int j = 0;

    public Board(int factor, int hpFactor, int numberOfBomb) {
        this.factor = factor;
        this.hpFactor = hpFactor;
        this.numberOfBomb = numberOfBomb;
        this.fields = new Field[factor][factor];
    }

    public void generateBoard() {
        for (int i = 0; i < fields.length ; i++) {
            for (int j = 0; j < fields.length ; j++) {
                fields[i][j]= new Field();
                fields[i][j].setCordinateX(j);
                fields[i][j].setCordinateY(i);
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length ; j++) {
                if(!fields[i][j].hasBomb() && !fields[i][j].hasHp()) {
                    System.out.print(fields[i][j] + "#");
                } else if(fields[i][j].hasBomb() && !fields[i][j].hasHp()) {
                    System.out.print(fields[i][j] + "!");
                } else if(fields[i][j].hasHp() && !fields[i][j].hasBomb()) {
                    System.out.print(fields[i][j] + "@");
                }

            } System.out.println("");
        }
    }

    public void generateBombFieldsOnBoard() {
        int numberOfBombs = 2 * factor;
        while(numberOfBombs > 0 ) {
            int j = (int) (Math.random() * factor);
            int i = (int) (Math.random() * factor);
            if ( !fields[i][j].hasBomb() && !fields[i][j].hasHp()) {
                fields[i][j].setBomb(true);
                numberOfBombs--;
            }
        }
    }

    public void generateHpFieldsOnBoard() {
        int numberOfHpFactor = hpFactor;
        while(numberOfHpFactor > 0 ) {
            int j = (int) (Math.random() * 5);
            int i = (int) (Math.random() * 5);
            if ( !fields[i][j].hasHp() && !fields[i][j].hasBomb()) {
                fields[i][j].setHp(true);
                numberOfHpFactor--;
            }
        }
    }
    public void countFieldValue() {
        for (int i = 0; i < factor; i++) {
            for (int j = 0; j < factor; j++) {
                //down
                if ( i - 1 >= 0) {
                    if (i >= 0 && i < factor && fields[i - 1][j].hasBomb()) {
                        fields[i][j].setFieldValue(fields[i][j].getFieldValue() + 1);
                    }
                }
                //up
                if ( i + 1 < factor) {
                    if (i >= 0 && i < factor && fields[i + 1][j].hasBomb()) {
                        fields[i][j].setFieldValue(fields[i][j].getFieldValue() + 1);
                    }
                }
                //right
                if ( j - 1 >= 0) {
                    if (j >= 0 && j < factor && fields[i][j - 1].hasBomb()) {
                        fields[i][j].setFieldValue(fields[i][j].getFieldValue() + 1);
                    }
                }
                //left
                if ( j + 1 < factor) {
                    if (j >= 0 && j < factor && fields[i][j + 1].hasBomb()) {
                        fields[i][j].setFieldValue(fields[i][j].getFieldValue() + 1);
                    }
                }
                //up and right
                if ( i + 1 < factor && j - 1 >= 0) {
                    if (i >= 0 && i < factor && j >= 0 && j < factor && fields[i + 1][j - 1].hasBomb()) {
                        fields[i][j].setFieldValue(fields[i][j].getFieldValue() + 1);
                    }
                }
                //down and right
                if ( i - 1 >= 0 && j - 1 >= 0) {
                    if (i >= 0 && i < factor && j >= 0 && j < factor && fields[i - 1][j - 1].hasBomb()) {
                        fields[i][j].setFieldValue(fields[i][j].getFieldValue() + 1);
                    }
                }
                //down and left
                if ( i - 1 >= 0 && j + 1 < factor) {
                    if (i >= 0 && i < factor && j >= 0 && j < factor && fields[i - 1][j + 1].hasBomb()) {
                        fields[i][j].setFieldValue(fields[i][j].getFieldValue() + 1);
                    }
                }
                //up and left
                if ( i + 1 < factor && j + 1 < factor) {
                    if (i >= 0 && i < factor && j >= 0 && j < factor && fields[i + 1][j + 1].hasBomb()) {
                        fields[i][j].setFieldValue(fields[i][j].getFieldValue() + 1);
                    }
                }
            }
        }
    }


    public Board buildBoard(){
        this.generateBoard();
        this.generateHpFieldsOnBoard();
        this.generateBombFieldsOnBoard();
        return this;
    }
    public Board buildBoardAndCountValue(){
        this.buildBoard();
        this.countFieldValue();
        this.printBoard();
        return this;
    }


}


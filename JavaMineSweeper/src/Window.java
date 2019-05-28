import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Window extends JFrame implements MouseListener{
    private JFrame jFrame;
    private Field[][] fields;
    private JPanel panelBoard;
    private JPanel panelMenu;
    int factor;
    private Player player;
    Board board;
    boolean gameover;

    Window(int factor) throws IOException {
        this.factor = factor;

        jFrame=new JFrame();
        jFrame.setTitle("MineSweeper");
        jFrame.setSize(400, 400);

        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelMenu=new JPanel();
        panelBoard=new JPanel();
        
        GridLayout gridLayout = new GridLayout(factor, factor);

        jFrame.add(panelMenu,BorderLayout.NORTH);
        jFrame.add(panelBoard,BorderLayout.CENTER);
        panelBoard.setLayout(gridLayout);

        player = new Player(1);
        panelMenu.add(player);

        player.setOpaque(true);
        player.setText(player.toString());

        board = new Board(factor, 2, 10);
        board.buildBoardAndCountValue();
        fields = board.fields;

        colorBoard();

        jFrame.setVisible(true);
    }

    private void colorBoard() {


        for (int i = 0; i < factor; i++) {
            for (int j = 0; j < factor; j++) {
                panelBoard.add(fields[i][j]);
                fields[i][j].setOpaque(true);
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        fields[i][j].setBackground(new java.awt.Color(50, 205, 50));

                    } else {
                        fields[i][j].setBackground(new java.awt.Color(0, 128, 0));
                    }
                } else {
                    if (j % 2 != 0) {
                        fields[i][j].setBackground(new java.awt.Color(50, 205, 50));
                    } else {
                        fields[i][j].setBackground(new java.awt.Color(0, 128, 0));
                    }

                }
                fields[i][j].setBorder(new LineBorder(Color.darkGray));
                fields[i][j].addMouseListener(this);
            }

        }

    }


    private void findEmptyFields(int valueX, int valueY) {
        int i = valueX;
        int j = valueY;

        if (!fields[i][j].hasFlag() && !fields[i][j].hasBomb()) {
            fields[i][j].setOpened(true);
            //down
            if (i + 1 < factor) {
                if (fields[i + 1][j].getFieldValue() >= 0 && !fields[i + 1][j].isOpened()) {
                    fields[i + 1][j].setOpened(true);
                    if (fields[i + 1][j].getFieldValue() == 0) {
                        findEmptyFields(i + 1, j);
                    }
                }
            }
            //down and left
            if ((i + 1 < factor) && (j + 1 < factor)) {
                if (fields[i + 1][j + 1].getFieldValue() >= 0 && !fields[i + 1][j + 1].isOpened()) {
                    fields[i + 1][j + 1].setOpened(true);
                    if (fields[i + 1][j + 1].getFieldValue() == 0 ) {
                        findEmptyFields(i + 1, j + 1);
                    }
                }
            }
            //down and right
            if ((i + 1 < factor) && (j - 1 >= 0)) {
                if (fields[i + 1][j - 1].getFieldValue() >= 0 && !fields[i + 1][j - 1].isOpened()) {
                    fields[i + 1][j - 1].setOpened(true);
                    if (fields[i + 1][j - 1].getFieldValue() == 0) {
                        findEmptyFields(i + 1, j - 1);
                    }
                }
            }
//            //right
            if (j + 1 < factor) {
                if (fields[i][j + 1].getFieldValue() >= 0 && !fields[i][j + 1].isOpened()) {
                    fields[i][j + 1].setOpened(true);
                    if (fields[i][j + 1].getFieldValue() == 0 ) {
                        findEmptyFields(i, j + 1);
                    }
                }
            }
//            //left
            if ((j - 1 >= 0) && (j - 1 < factor)) {
                if (fields[i][j - 1].getFieldValue() >= 0 && !fields[i][j - 1].isOpened()) {
                    fields[i][j - 1].setOpened(true);
                    if (fields[i][j - 1].getFieldValue() == 0 ) {
                        findEmptyFields(i, j - 1);
                    }
                }
            }
//            //up
            if ((i - 1 >= 0) && (i -1 < factor)) {
                if (fields[i - 1][j].getFieldValue() >= 0 && !fields[i - 1][j].isOpened()) {
                    fields[i - 1][j].setOpened(true);
                    if (fields[i - 1][j].getFieldValue() == 0 ) {
                        findEmptyFields(i - 1, j);
                    }
                }
            }
//            //up and left
            if ((i - 1 >= 0) && (i -1 < factor) && (j - 1 > 0) && (j -1 < factor)) {
                if (fields[i - 1][j - 1].getFieldValue() >= 0 && !fields[i - 1][j - 1].isOpened()) {
                    fields[i - 1][j - 1].setOpened(true);
                    if (fields[i - 1][j - 1].getFieldValue() == 0 ) {
                        findEmptyFields(i - 1, j - 1);
                    }
                }
            }

//            //up and right
            if (i - 1 > 0 && i - 1 < factor && j + 1 > 0 && j + 1 < factor) {
                if (fields[i - 1][j + 1].getFieldValue() >= 0 && !fields[i - 1][j + 1].isOpened()) {
                    fields[i - 1][j + 1].setOpened(true);
                    if (fields[i - 1][j + 1].getFieldValue() == 0 ) {
                        findEmptyFields(i - 1, j + 1);
                    }
                }
            }
        }
    }
    public void gameOver() {
        for (int i = 0; i < factor; i++) {
            for (int j = 0; j < factor; j++) {
                fields[i][j].setOpened(true);
            }
        }
    }

//    private void findEmptyFields2(int valueX, int valueY) {
//        int i = valueX;
//        int j = valueY;
//
//        if (!fields[i][j].hasFlag() && !fields[i][j].hasBomb()) {
//            fields[i][j].setOpened(true);
//            if (fields[i + 1][j].getFieldValue() >= 0) {
//                fields[i + 1][j].setOpened(true);
//            }
//            if (i + 1 < factor) {
//                if (fields[i + 1][j].getFieldValue() == 0) {
//                    findEmptyFields(i + 1, j);
//                }
//            }
//            //up and left
//            if (i + 1 < factor && j + 1 < factor) {
//                if (fields[i + 1][j + 1].getFieldValue() >= 0) {
//                    fields[i + 1][j + 1].setOpened(true);
//                    if (fields[i + 1][j + 1].getFieldValue() == 0) {
//                        findEmptyFields(i + 1, j + 1);
//                    }
//                }
//            }
//            //left
//            if (j + 1 > 0 && j + 1 < factor) {
//                if (fields[i][j + 1].getFieldValue() >= 0) {
//                    fields[i][j + 1].setOpened(true);
//                    if (fields[i][j + 1].getFieldValue() == 0) {
//                        findEmptyFields(i, j + 1);
//                    }
//                }
//            }
//            //right
//            if (j - 1 > 0 && j - 1 < factor) {
//                if (fields[i][j - 1].getFieldValue() >= 0) {
//                    fields[i][j - 1].setOpened(true);
//                    if (fields[i][j - 1].getFieldValue() == 0) {
//                        findEmptyFields(i, j - 1);
//                    }
//                }
//            }
//            //down
//            if (i - 1 > 0 && i -1 < factor) {
//                if (fields[i - 1][j].getFieldValue() >= 0) {
//                    fields[i - 1][j].setOpened(true);
//                    if (fields[i - 1][j].getFieldValue() == 0) {
//                        findEmptyFields(i - 1, j);
//                    }
//                }
//            }
//            //down and right
//            if (i - 1 > 0 && i -1 < factor && j - 1 > 0 && j -1 < factor) {
//                if (fields[i - 1][j - 1].getFieldValue() >= 0) {
//                    fields[i - 1][j - 1].setOpened(true);
//                    if (fields[i - 1][j - 1].getFieldValue() == 0) {
//                        findEmptyFields(i - 1, j - 1);
//                    }
//                }
//            }
//            //down and left
//            if (i - 1 > 0 && i -1 < factor && i + 1 > 0 && i + 1 < factor) {
//                if (fields[i - 1][j + 1].getFieldValue() >= 0) {
//                    fields[i - 1][j + 1].setOpened(true);
//                    if (fields[i - 1][j + 1].getFieldValue() == 0) {
//                        findEmptyFields(i - 1, j + 1);
//                    }
//                }
//            }
//            //up and right
//            if (i + 1 > 0 && i -1 < factor && j - 1 > 0 && j -1 < factor) {
//                if (fields[i + 1][j - 1].getFieldValue() >= 0) {
//                    fields[i + 1][j - 1].setOpened(true);
//                    if (fields[i + 1][j - 1].getFieldValue() == 0) {
//                        findEmptyFields(i + 1, j - 1);
//                    }
//                }
//            }
////        }
//    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
//        ImageIcon icon = new ImageIcon("images/flag5.png");
//        Field a = ((Field) e.getSource());
//        Image dimg = icon.getImage().getScaledInstance(a.getWidth()-3, a.getHeight()-5,
//                Image.SCALE_SMOOTH);
//        ImageIcon newIcon = new ImageIcon(dimg);


        if(e.getSource() instanceof Field && e.getButton() == MouseEvent.BUTTON3) {
            if (((Field) e.getSource()).getIcon() == null) {
                ((Field) e.getSource()).setFlagged(true);
                System.out.println("R");
            } else {
                ((Field) e.getSource()).setIcon(null);
                ((Field) e.getSource()).setFlagged(false);
                System.out.println("R");
            }
        }
        else if(e.getSource() instanceof Field && e.getButton() == MouseEvent.BUTTON1) {
            if ( !((Field) e.getSource()).hasFlag() && !((Field) e.getSource()).hasHp()) {

                if ( ((Field) e.getSource()).hasBomb()) {
                    ((Field) e.getSource()).setOpened(true);
                    player.setLife(player.getLife() - 1);
                    player.setText(player.toString());
                    if (player.getLife() == 0) {
                        System.out.println("cica");
                        gameOver();
                    }

                    System.out.println(Integer.valueOf(player.getLife()));
                }


                else if (((Field) e.getSource()).getFieldValue() > 0) {
                    ((Field) e.getSource()).setOpened(true);
                }
                else if (((Field) e.getSource()).getFieldValue() == 0) {
                    int valueX = ((Field) e.getSource()).getCordinateX();
                    int valueY = ((Field) e.getSource()).getCordinateY();

                    findEmptyFields(valueY, valueX);


                }
                ((Field) e.getSource()).removeMouseListener(this);
                if (((Field) e.getSource()).hasHp()) {
                    ((Field) e.getSource()).addMouseListener(this);
                }

            }
             else if ( ((Field) e.getSource()).hasHp() && !((Field) e.getSource()).isOpened()) {
                ((Field) e.getSource()).setOpened(true);

            } else if (((Field) e.getSource()).isOpened() && ((Field) e.getSource()).hasHp()) {
                ((Field) e.getSource()).setIcon(null);
                ((Field) e.getSource()).setText(""+ ((Field) e.getSource()).getFieldValue());
                player.setLife(player.getLife() + 1);
                player.setText(player.toString());
                System.out.println(Integer.valueOf(player.getLife()));
                if (((Field) e.getSource()).getFieldValue() == 0) {
                    int valueX = ((Field) e.getSource()).getCordinateX();
                    int valueY = ((Field) e.getSource()).getCordinateY();

                    findEmptyFields(valueY, valueX);
                    ((Field) e.getSource()).setIcon(null);

                }
                ((Field) e.getSource()).removeMouseListener(this);
            }

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
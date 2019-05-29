import java.awt.*;
import java.awt.event.ActionEvent;
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
    private JPanel panelMenuGame;
    int factor;
    private Player player;
    private int numberOfFlags;
    Board board = new Board(factor, 2, numberOfFlags);
    JLabel gameState;

    Window(Board board) throws IOException {

        factor= board.getFactor();

        jFrame=new JFrame();
        jFrame.setTitle("MineSweeper");
        jFrame.setSize(500, 500);

        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelMenu=new JPanel();
        panelBoard=new JPanel();
        panelMenuGame = new JPanel();

        GridLayout gridLayout = new GridLayout(factor, factor);
        GridLayout gridLayoutForMenu = new GridLayout(2, 1);
        GridLayout gridLayoutForMenuGame = new GridLayout(1, 3);

        jFrame.add(panelMenu,BorderLayout.NORTH);
        jFrame.add(panelBoard,BorderLayout.CENTER);
        jFrame.add(panelMenuGame,BorderLayout.SOUTH);

        panelBoard.setLayout(gridLayout);
        panelMenu.setLayout(gridLayoutForMenu);
        panelMenuGame.setLayout(gridLayoutForMenuGame);

        buttonSettings();
        gameMenuSettings();

        board.buildBoardAndCountValue();
        fields = board.fields;

        colorBoard();

        jFrame.setVisible(true);
    }

    private void buttonSettings() {
        panelBoard.setSize(400,200);

        JRadioButton easy = new JRadioButton("small");
        JRadioButton medium = new JRadioButton("medium");
        JRadioButton hard = new JRadioButton("large");
        panelMenu.add(easy);
        panelMenu.add(medium);
        panelMenu.add(hard);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(easy);
        buttonGroup.add(medium);
        buttonGroup.add(hard);

        JRadioButton smallDifficulty = new JRadioButton("easy");
        JRadioButton mediumDifficulty = new JRadioButton("medium");
        JRadioButton largeDifficulty = new JRadioButton("hard");

        JButton jButton = new JButton("New Game");
        panelMenu.add(jButton);

        panelMenu.add(smallDifficulty);
        panelMenu.add(mediumDifficulty);
        panelMenu.add(largeDifficulty);

        ButtonGroup buttonGroupSize = new ButtonGroup();
        buttonGroupSize.add(easy);
        buttonGroupSize.add(medium);
        buttonGroupSize.add(hard);

        ButtonGroup buttonGroupDifficulty = new ButtonGroup();
        buttonGroupDifficulty.add(smallDifficulty);
        buttonGroupDifficulty.add(mediumDifficulty);
        buttonGroupDifficulty.add(largeDifficulty);

        jButton.addActionListener((ActionEvent e) -> {
            jFrame.dispose();
            int size = board.getNumberOfBomb();
            Board board = new Board(size,0, size*size/2 );
            if (easy.isSelected()) {
                size = 5;
            }
            if (medium.isSelected()) {
                size = 10;
            }
            if (hard.isSelected()) {
                size = 15;
            }
            if (smallDifficulty.isSelected()) {
                board = new Board(size,size/2, 2*size );
            }
            if (mediumDifficulty.isSelected()) {
                board = new Board(size,size/3, size*size/3 );
            }
            if (largeDifficulty.isSelected()) {
                board = new Board(size,0, size*size/2 );
            }
            try {

                Window window = new Window(board);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        setVisible(true);
    }

    private void gameMenuSettings() {
        player = new Player(1);
        panelMenuGame.add(player);
        player.setOpaque(true);
        player.setText(player.toString());

        gameState = new JLabel("Game in progress");
        panelMenuGame.add(gameState);

        panelMenuGame.add(board);
        numberOfFlags = board.getNumberOfFlag();
        board.setText(board.toString());
        board.setOpaque(true);
        System.out.println(numberOfFlags);



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
                if (fields[i + 1][j].getFieldValue() >= 0 && !fields[i + 1][j].isOpened() ) {
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
                    if (fields[i + 1][j + 1].getFieldValue() == 0) {
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
                    if (fields[i][j + 1].getFieldValue() == 0) {
                        findEmptyFields(i, j + 1);
                    }
                }
            }
//            //left
            if ((j - 1 >= 0) && (j - 1 < factor) ) {
                if (fields[i][j - 1].getFieldValue() >= 0 && !fields[i][j - 1].isOpened()) {
                    fields[i][j - 1].setOpened(true);
                    if (fields[i][j - 1].getFieldValue() == 0) {
                        findEmptyFields(i, j - 1);
                    }
                }
            }
//            //up
            if ((i - 1 >= 0) && (i -1 < factor)) {
                if (fields[i - 1][j].getFieldValue() >= 0 && !fields[i - 1][j].isOpened()) {
                    fields[i - 1][j].setOpened(true);
                    if (fields[i - 1][j].getFieldValue() == 0) {
                        findEmptyFields(i - 1, j);
                    }
                }
            }
//            //up and left
            if ((i - 1 >= 0) && (i -1 < factor) && (j - 1 > 0) && (j -1 < factor) ) {
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
                    if (fields[i - 1][j + 1].getFieldValue() == 0) {
                        findEmptyFields(i - 1, j + 1);
                    }
                }
            }
        }
    }
    public void gameOver() {
        gameState.setText("You lost!");
        for (int i = 0; i < factor; i++) {
            for (int j = 0; j < factor; j++) {
                fields[i][j].setOpened(true);
                fields[i][j].removeMouseListener(this);
            }
        }
    }
    public void gameWin() {
        int counter = board.getNumberOfBomb();
        if (board.getNumberOfFlag() == board.getNumberOfBomb()) {
            for (int i = 0; i < factor; i++) {
                for (int j = 0; j < factor; j++) {
                    if (fields[i][j].isOpened() && fields[i][j].hasBomb() && fields[i][j].hasFlag()) {
                        counter--;
                    }
                }
            }
        }
        if (counter == 0) {
            gameState.setText("You won!");
        } else {
            gameState.setText("looser!");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(e.getSource() instanceof Field && e.getButton() == MouseEvent.BUTTON3) {
            if (((Field) e.getSource()).getIcon() == null) {
                ((Field) e.getSource()).setFlagged(true);
                board.setNumberOfFlag(board.getNumberOfFlag() - 1);
                board.setText(board.toString());
                if (board.getNumberOfFlag() == 0) {
                    gameWin();
                }
            } else {
                ((Field) e.getSource()).setIcon(null);
                ((Field) e.getSource()).setFlagged(false);
                board.setNumberOfFlag(board.getNumberOfFlag() + 1);
                board.setText(board.toString());
            }
        }
        else if(e.getSource() instanceof Field && e.getButton() == MouseEvent.BUTTON1) {
            if ( !((Field) e.getSource()).hasFlag() && !((Field) e.getSource()).hasHp()) {

                if ( ((Field) e.getSource()).hasBomb()) {
                    ((Field) e.getSource()).setOpened(true);
                    player.setLife(player.getLife() - 1);
                    player.setText(player.toString());
                    if (player.getLife() == 0) {
                        gameOver();
                    }
                    System.out.println(Integer.valueOf(player.getLife()));
                }

                else if (((Field) e.getSource()).getFieldValue() > 0) {
                    ((Field) e.getSource()).setOpened(true);
                }
                else if (((Field) e.getSource()).getFieldValue() == 0 ) {
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
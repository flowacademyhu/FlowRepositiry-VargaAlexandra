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
    private int factor;
    private Player player;
    private int numberOfBombs;
    private int numberOfFlags;
    private int counter;
    private boolean gameWin = false;
    int startNumberOfFlags;
    int didYouWinCounter = 0;

    private Board board = new Board(factor, 2, numberOfBombs, numberOfFlags );
    private JLabel gameState;

    Window(Board board) throws IOException {

        factor= board.getFactor();
        numberOfFlags = board.getNumberOfFlag();

        counter = numberOfFlags;
        startNumberOfFlags = numberOfFlags;

        System.out.println(numberOfFlags);

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
        numberOfFlags = board.getNumberOfFlag();
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
            int size = 10;

            if ( (!easy.isSelected() && !medium.isSelected() && !hard.isSelected()) || (!smallDifficulty.isSelected() && !mediumDifficulty.isSelected() && !largeDifficulty.isSelected())) {
                Board boardStart = new Board(10,1, 10 , 10);

                try {
                    Window frame = new Window(boardStart);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }

            Board board;
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
                board = new Board(size,size/2, 2*size , 2*size);
                try {

                    Window window = new Window(board);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (mediumDifficulty.isSelected()) {
                board = new Board(size,size/3, size*size/3, size*size/3);
                try {

                    Window window = new Window(board);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (largeDifficulty.isSelected()) {
                board = new Board(size,0, size*size/2 , size*size/2);
                try {

                    Window window = new Window(board);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
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
        board.setText("flags: " + numberOfFlags);
        board.setOpaque(true);
    }

    private void colorBoard() {

        for (int i = 0; i < factor; i++) {
            for (int j = 0; j < factor; j++) {
                panelBoard.add(fields[i][j]);
                fields[i][j].setOpaque(true);
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        fields[i][j].setBackground(new java.awt.Color(169, 169, 169));

                    } else {
                        fields[i][j].setBackground(new java.awt.Color(128, 128, 128));
                    }
                } else {
                    if (j % 2 != 0) {
                        fields[i][j].setBackground(new java.awt.Color(169, 169, 169));
                    } else {
                        fields[i][j].setBackground(new java.awt.Color(128, 128, 128));
                    }

                }
                fields[i][j].setBorder(new LineBorder(Color.darkGray));
                fields[i][j].addMouseListener(this);
            }

        }

    }
    private void colorOpenBoard() {

        for (int i = 0; i < factor; i++) {
            for (int j = 0; j < factor; j++) {
                fields[i][j].setOpaque(true);
                if ( fields[i][j].isOpened()) {
                    if (i % 2 == 0) {
                        if (j % 2 == 0) {
                            fields[i][j].setBackground(new java.awt.Color(220, 220, 220));

                        } else {
                            fields[i][j].setBackground(new java.awt.Color(211, 211, 211));
                        }
                    } else {
                        if (j % 2 != 0) {
                            fields[i][j].setBackground(new java.awt.Color(220, 220, 220));
                        } else {
                            fields[i][j].setBackground(new java.awt.Color(211, 211, 211));
                        }

                    }
                }
                if( !fields[i][j].hasHp() && fields[i][j].isOpened()) {
                    fields[i][j].removeMouseListener(this);

                }

                fields[i][j].setBorder(new LineBorder(Color.darkGray));
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
                colorOpenBoard();
            }
        }
        JOptionPane.showMessageDialog(panelBoard, "You lost!");
    }
    public void gameWin() {
        for (int i = 0; i < factor; i++) {
            for (int j = 0; j < factor; j++) {
                if (!fields[i][j].isOpened()) {
                    if (fields[i][j].hasBomb() && fields[i][j].hasFlag()) {
                        didYouWinCounter++;
                    }
                }
            }
        }
        if (didYouWinCounter == (startNumberOfFlags -counter)) {
            gameState.setText("You won!");
            JOptionPane.showMessageDialog(panelBoard, "You won!");
        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(e.getSource() instanceof Field && e.getButton() == MouseEvent.BUTTON3) {
            if( numberOfFlags > 0) {
                if (((Field) e.getSource()).getIcon() == null) {
                    ((Field) e.getSource()).setFlagged(true);
                    numberOfFlags--;
                    counter--;
                    board.setText("flags: " + numberOfFlags);
                    gameState.setText("Game in progress");
                    if (counter == 0) {
                        gameWin();
                    }
                }
                else {
                    ((Field) e.getSource()).setIcon(null);
                    ((Field) e.getSource()).setFlagged(false);
                    gameState.setText("Game in progress");
                    numberOfFlags++;
                    counter++;
                    board.setText("flags: " + numberOfFlags);
                }
            }
            else if( numberOfFlags == 0 && ((Field) e.getSource()).hasFlag() ) {
                ((Field) e.getSource()).setIcon(null);
                ((Field) e.getSource()).setFlagged(false);
                gameState.setText("Game in progress");
                numberOfFlags++;
                board.setText("flags: " + numberOfFlags);
            }
            else {
                gameState.setText("Out of flags");
            }
        }
        else if(e.getSource() instanceof Field && e.getButton() == MouseEvent.BUTTON1) {
            if ( !((Field) e.getSource()).hasFlag() && !((Field) e.getSource()).hasHp()) {

                if ( ((Field) e.getSource()).hasBomb()) {
                    ((Field) e.getSource()).setOpened(true);
                    player.setLife(player.getLife() - 1);
                    didYouWinCounter++;
                    counter--;

                    player.setText(player.toString());
                    colorOpenBoard();


                    if (player.getLife() == 0) {
                        gameOver();
                    }
                }

                else if (((Field) e.getSource()).getFieldValue() > 0) {
                    ((Field) e.getSource()).setOpened(true);
                    colorOpenBoard();

                }
                else if (((Field) e.getSource()).getFieldValue() == 0 ) {
                    int valueX = ((Field) e.getSource()).getCordinateX();
                    int valueY = ((Field) e.getSource()).getCordinateY();

                    findEmptyFields(valueY, valueX);
                    colorOpenBoard();

                }
                ((Field) e.getSource()).removeMouseListener(this);
                if (((Field) e.getSource()).hasHp()) {
                    colorOpenBoard();
                    ((Field) e.getSource()).addMouseListener(this);

                }

            }
             else if ( ((Field) e.getSource()).hasHp() && !((Field) e.getSource()).isOpened()) {
                ((Field) e.getSource()).setOpened(true);
                colorOpenBoard();


            } else if (((Field) e.getSource()).isOpened() && ((Field) e.getSource()).hasHp()) {
                ((Field) e.getSource()).setIcon(null);
                ((Field) e.getSource()).setText(""+ ((Field) e.getSource()).getFieldValue());
                player.setLife(player.getLife() + 1);
                player.setText(player.toString());
                if (((Field) e.getSource()).getFieldValue() == 0) {
                    int valueX = ((Field) e.getSource()).getCordinateX();
                    int valueY = ((Field) e.getSource()).getCordinateY();

                    findEmptyFields(valueY, valueX);
                    ((Field) e.getSource()).setIcon(null);
                    colorOpenBoard();


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
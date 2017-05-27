/*
 *                         DartScore
 *                 A DartScoring application by
 *                        Joseph Polen
 */
package dartscore;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Joe
 */
public class Window extends JFrame {

    Window() throws IOException, URISyntaxException {
        //create dartBoard and ScoreBoard objects

        setPreferredSize(new Dimension(950, 650));
        setResizable(false);

        //title
        JTextField title = new JTextField("DartScore by Joseph Polen");
        this.setTitle(title.getText());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create menu
        JMenuBar menuBar;
        JMenu fileMenu, gameMenu;
        JMenuItem exit, setScores, cricket, three01, five01,
                seven01, countUp, allFives, newGame;
        JPanel mainPanel = new JPanel();
        Color darkGreen = Color.decode("#00802b");
        mainPanel.setBackground(darkGreen);
        //create menu bar
        menuBar = new JMenuBar();

        //create file menu
        fileMenu = new JMenu("File");

        //create game menu
        gameMenu = new JMenu("Game");

        //add menuItems
        exit = new JMenuItem("Exit");

        setScores = new JMenuItem("Set Scores");

        //create exit menu entry and add action listener
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });

        //create new game menu entry and add action listener
        newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                reset();
            }
        });

        setScores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                setScores set = new setScores();
                set.setVisible(true);

            }
        });

        fileMenu.add(newGame);
        fileMenu.add(setScores);
        fileMenu.add(exit);

        //create cricket menu entry and add action listener
        cricket = new JMenuItem("Cricket");
        cricket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                gameFlag.gameType = 1;
                reset();
            }
        });

        gameMenu.add(cricket);

        //create 301 menu entry and add action listener
        three01 = new JMenuItem("301");
        three01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                gameFlag.gameType = 2;
                reset();

            }
        });
        gameMenu.add(three01);

        //create 501 menu entry and add action listener
        five01 = new JMenuItem("501");
        five01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                gameFlag.gameType = 4;
                reset();
            }
        });

        gameMenu.add(five01);

        //create 701 menu entry and add action listener
        seven01 = new JMenuItem("701");
        seven01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                gameFlag.gameType = 5;
                reset();
            }
        });

        gameMenu.add(seven01);

        //create Count Up menu entry and add action listener
        countUp = new JMenuItem("Count Up");
        countUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                gameFlag.gameType = 3;
                reset();
            }
        });
        gameMenu.add(countUp);

        //create All Fives menu entry and add action listener
        allFives = new JMenuItem("All Fives");
        allFives.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                gameFlag.gameType = 6;
                reset();
            }
        });
        gameMenu.add(allFives);

        //add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(gameMenu);

        //add board and scoreboard to the window
        mainPanel.add(DartBoard.board);
        mainPanel.add(ScoreBoard.scoreBoard);
        add(mainPanel);
        setJMenuBar(menuBar);
        pack();
        setVisible(true);

    }

    //Method for clearing the thrown dart labels and dartcount
    public void clearDarts() {
        ScoreBoard.scoreBoard.dart1Label.setText("");
        ScoreBoard.scoreBoard.dart2Label.setText("");
        ScoreBoard.scoreBoard.dart3Label.setText("");
        DartBoard.board.dartCount = 0;
        DartBoard.board.p1Turn = true;
    }

    //method resets the entire scoreboard based on current gametype
    public void reset() {
        ScoreBoard.scoreBoard.p1ScoreLabel.setForeground(Color.RED);
        ScoreBoard.scoreBoard.p2ScoreLabel.setForeground(Color.BLACK);
        ScoreBoard.scoreBoard.dart1Label.setText("");
        ScoreBoard.scoreBoard.dart2Label.setText("");
        ScoreBoard.scoreBoard.dart3Label.setText("");
        DartBoard.board.dartCount = 0;
        DartBoard.board.p1Turn = true;
        DartBoard.board.clearCricketBoard();
        if (gameFlag.gameType == 1) {
            DartBoard.board.p1Total = 0;
            DartBoard.board.p2Total = 0;
            ScoreBoard.scoreBoard.p1ScoreLabel.setText(String.valueOf("0"));
            ScoreBoard.scoreBoard.p2ScoreLabel.setText(String.valueOf("0"));
        }
        if (gameFlag.gameType == 2) {
            DartBoard.board.p1Total = 301;
            DartBoard.board.p2Total = 301;
            ScoreBoard.scoreBoard.p1ScoreLabel.setText(String.valueOf("301"));
            ScoreBoard.scoreBoard.p2ScoreLabel.setText(String.valueOf("301"));
        }
        if (gameFlag.gameType == 3) {
            DartBoard.board.p1Total = 0;
            DartBoard.board.p2Total = 0;
            ScoreBoard.scoreBoard.p1ScoreLabel.setText(String.valueOf("0"));
            ScoreBoard.scoreBoard.p2ScoreLabel.setText(String.valueOf("0"));
        }

        if (gameFlag.gameType == 4) {
            DartBoard.board.p1Total = 501;
            DartBoard.board.p2Total = 501;
            ScoreBoard.scoreBoard.p1ScoreLabel.setText(String.valueOf("501"));
            ScoreBoard.scoreBoard.p2ScoreLabel.setText(String.valueOf("501"));
        }

        if (gameFlag.gameType == 5) {
            DartBoard.board.p1Total = 701;
            DartBoard.board.p2Total = 701;
            ScoreBoard.scoreBoard.p1ScoreLabel.setText(String.valueOf("701"));
            ScoreBoard.scoreBoard.p2ScoreLabel.setText(String.valueOf("701"));
        }

        if (gameFlag.gameType == 6) {
            DartBoard.board.p1Total = 0;
            DartBoard.board.p2Total = 0;
            ScoreBoard.scoreBoard.p1ScoreLabel.setText(String.valueOf("0"));
            ScoreBoard.scoreBoard.p2ScoreLabel.setText(String.valueOf("0"));
        }
    }

}

/*
 *                         DartScore
 *                 A DartScoring application by
 *                        Joseph Polen
 */
package dartscore;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Joe
 */
public class ScoreBoard extends JPanel {

    public static ScoreBoard scoreBoard = new ScoreBoard();

    //label for showing player scores
    JLabel p1ScoreLabel = new JLabel();
    JLabel p2ScoreLabel = new JLabel();
    //label for displaying game type
    JLabel gameTypeLabel = new JLabel();

    //panels for displaying the thrown darts values
    JPanel dartPanel = new JPanel(new GridLayout());

    JLabel dart1Label = new JLabel();
    JLabel dart2Label = new JLabel();
    JLabel dart3Label = new JLabel();

    //panels for the player 1 marks in cricket
    JPanel p1scores20 = new JPanel(new CardLayout());
    JPanel p1scores19 = new JPanel(new CardLayout());
    JPanel p1scores18 = new JPanel(new CardLayout());
    JPanel p1scores17 = new JPanel(new CardLayout());
    JPanel p1scores16 = new JPanel(new CardLayout());
    JPanel p1scores15 = new JPanel(new CardLayout());
    JPanel p1scoresB = new JPanel(new CardLayout());

    //panels for player 2 marks in cricket
    JPanel p2scores20 = new JPanel(new CardLayout());
    JPanel p2scores19 = new JPanel(new CardLayout());
    JPanel p2scores18 = new JPanel(new CardLayout());
    JPanel p2scores17 = new JPanel(new CardLayout());
    JPanel p2scores16 = new JPanel(new CardLayout());
    JPanel p2scores15 = new JPanel(new CardLayout());
    JPanel p2scoresB = new JPanel(new CardLayout());

    //layered pane so cricket board can have overlapping elements
    JLayeredPane lpane = new JLayeredPane();
    //panel for the scoreboard
    JPanel background = new JPanel();

    //panels to display player scores
    JPanel p1ScorePanel = new JPanel();
    JPanel p2ScorePanel = new JPanel();
    JPanel gameTypePanel = new JPanel();

    //ScoreBoard constructor
    public ScoreBoard() {

        setPreferredSize(new Dimension(304, 564));
        setLayout(new BorderLayout());
        add(lpane, BorderLayout.CENTER);
        lpane.setBounds(0, 0, 304, 564);

        //sets score to zero initially
        p1ScoreLabel.setText(String.valueOf("0"));
        p2ScoreLabel.setText(String.valueOf("0"));

        //sets score font to size 28
        p1ScoreLabel.setFont(p1ScoreLabel.getFont().deriveFont(28.0f));
        p2ScoreLabel.setFont(p2ScoreLabel.getFont().deriveFont(28.0f));

        //add score labels to panels
        p1ScorePanel.add(p1ScoreLabel);
        p2ScorePanel.add(p2ScoreLabel);
        p1ScorePanel.setOpaque(false);
        p2ScorePanel.setOpaque(false);

        //add dart labels to dart panel for displaying thrown darts
        dartPanel.add(dart1Label);
        dartPanel.add(dart2Label);
        dartPanel.add(dart3Label);
        dartPanel.setOpaque(false);

        //Panel for showing current game being played
        gameTypePanel.setOpaque(false);
        gameTypePanel.add(gameTypeLabel);
        gameTypePanel.setBounds(200, 0, 100, 20);

        //setting location and size of panels
        p1ScorePanel.setBounds(30, 30, 65, 40);
        p2ScorePanel.setBounds(215, 30, 65, 40);
        dartPanel.setBounds(0, 0, 80, 20);

        background.setBounds(0, 0, 304, 564);
        //image of scoreboard
        BufferedImage img;
        JLabel scoreboard = new JLabel();
        ImageIcon scoreIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/scoreboard.png"));
        background.add(scoreboard);
        scoreboard.setIcon(scoreIcon);
        background.setOpaque(false);

        //image indicating no scores
        JLabel p1ScoreNone = new JLabel();
        JLabel p1ScoreNone19 = new JLabel();
        JLabel p1ScoreNone18 = new JLabel();
        JLabel p1ScoreNone17 = new JLabel();
        JLabel p1ScoreNone16 = new JLabel();
        JLabel p1ScoreNone15 = new JLabel();
        JLabel p1ScoreNoneB = new JLabel();
        JLabel p2ScoreNone = new JLabel();
        JLabel p2ScoreNone19 = new JLabel();
        JLabel p2ScoreNone18 = new JLabel();
        JLabel p2ScoreNone17 = new JLabel();
        JLabel p2ScoreNone16 = new JLabel();
        JLabel p2ScoreNone15 = new JLabel();
        JLabel p2ScoreNoneB = new JLabel();

        ImageIcon noneIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/none.png"));
        p1ScoreNone.setIcon(noneIcon);
        p1ScoreNone19.setIcon(noneIcon);
        p1ScoreNone18.setIcon(noneIcon);
        p1ScoreNone17.setIcon(noneIcon);
        p1ScoreNone16.setIcon(noneIcon);
        p1ScoreNone15.setIcon(noneIcon);
        p1ScoreNoneB.setIcon(noneIcon);
        p2ScoreNone.setIcon(noneIcon);
        p2ScoreNone19.setIcon(noneIcon);
        p2ScoreNone18.setIcon(noneIcon);
        p2ScoreNone17.setIcon(noneIcon);
        p2ScoreNone16.setIcon(noneIcon);
        p2ScoreNone15.setIcon(noneIcon);
        p2ScoreNoneB.setIcon(noneIcon);

        //image indicating one mark
        JLabel p1ScoreOne = new JLabel();
        JLabel p1ScoreOne19 = new JLabel();
        JLabel p1ScoreOne18 = new JLabel();
        JLabel p1ScoreOne17 = new JLabel();
        JLabel p1ScoreOne16 = new JLabel();
        JLabel p1ScoreOne15 = new JLabel();
        JLabel p1ScoreOneB = new JLabel();
        JLabel p2ScoreOne = new JLabel();
        JLabel p2ScoreOne19 = new JLabel();
        JLabel p2ScoreOne18 = new JLabel();
        JLabel p2ScoreOne17 = new JLabel();
        JLabel p2ScoreOne16 = new JLabel();
        JLabel p2ScoreOne15 = new JLabel();
        JLabel p2ScoreOneB = new JLabel();
        ImageIcon oneIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/one.png"));
        p1ScoreOne.setIcon(oneIcon);
        p1ScoreOne19.setIcon(oneIcon);
        p1ScoreOne18.setIcon(oneIcon);
        p1ScoreOne17.setIcon(oneIcon);
        p1ScoreOne16.setIcon(oneIcon);
        p1ScoreOne15.setIcon(oneIcon);
        p1ScoreOneB.setIcon(oneIcon);
        p2ScoreOne.setIcon(oneIcon);
        p2ScoreOne19.setIcon(oneIcon);
        p2ScoreOne18.setIcon(oneIcon);
        p2ScoreOne17.setIcon(oneIcon);
        p2ScoreOne16.setIcon(oneIcon);
        p2ScoreOne15.setIcon(oneIcon);
        p2ScoreOneB.setIcon(oneIcon);

        //image indicating 2 marks
        JLabel p1ScoreTwo = new JLabel();
        JLabel p1ScoreTwo19 = new JLabel();
        JLabel p1ScoreTwo18 = new JLabel();
        JLabel p1ScoreTwo17 = new JLabel();
        JLabel p1ScoreTwo16 = new JLabel();
        JLabel p1ScoreTwo15 = new JLabel();
        JLabel p1ScoreTwoB = new JLabel();
        JLabel p2ScoreTwo = new JLabel();
        JLabel p2ScoreTwo19 = new JLabel();
        JLabel p2ScoreTwo18 = new JLabel();
        JLabel p2ScoreTwo17 = new JLabel();
        JLabel p2ScoreTwo16 = new JLabel();
        JLabel p2ScoreTwo15 = new JLabel();
        JLabel p2ScoreTwoB = new JLabel();
        ImageIcon twoIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/two.png"));
        p1ScoreTwo.setIcon(twoIcon);
        p1ScoreTwo19.setIcon(twoIcon);
        p1ScoreTwo18.setIcon(twoIcon);
        p1ScoreTwo17.setIcon(twoIcon);
        p1ScoreTwo16.setIcon(twoIcon);
        p1ScoreTwo15.setIcon(twoIcon);
        p1ScoreTwoB.setIcon(twoIcon);
        p2ScoreTwo.setIcon(twoIcon);
        p2ScoreTwo19.setIcon(twoIcon);
        p2ScoreTwo18.setIcon(twoIcon);
        p2ScoreTwo17.setIcon(twoIcon);
        p2ScoreTwo16.setIcon(twoIcon);
        p2ScoreTwo15.setIcon(twoIcon);
        p2ScoreTwoB.setIcon(twoIcon);

        //image indicating 3 marks
        JLabel p1ScoreThree = new JLabel();
        JLabel p1ScoreThree19 = new JLabel();
        JLabel p1ScoreThree18 = new JLabel();
        JLabel p1ScoreThree17 = new JLabel();
        JLabel p1ScoreThree16 = new JLabel();
        JLabel p1ScoreThree15 = new JLabel();
        JLabel p1ScoreThreeB = new JLabel();
        JLabel p2ScoreThree = new JLabel();
        JLabel p2ScoreThree19 = new JLabel();
        JLabel p2ScoreThree18 = new JLabel();
        JLabel p2ScoreThree17 = new JLabel();
        JLabel p2ScoreThree16 = new JLabel();
        JLabel p2ScoreThree15 = new JLabel();
        JLabel p2ScoreThreeB = new JLabel();
        ImageIcon threeIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/three.png"));
        p1ScoreThree.setIcon(threeIcon);
        p1ScoreThree19.setIcon(threeIcon);
        p1ScoreThree18.setIcon(threeIcon);
        p1ScoreThree17.setIcon(threeIcon);
        p1ScoreThree16.setIcon(threeIcon);
        p1ScoreThree15.setIcon(threeIcon);
        p1ScoreThreeB.setIcon(threeIcon);
        p2ScoreThree.setIcon(threeIcon);
        p2ScoreThree19.setIcon(threeIcon);
        p2ScoreThree18.setIcon(threeIcon);
        p2ScoreThree17.setIcon(threeIcon);
        p2ScoreThree16.setIcon(threeIcon);
        p2ScoreThree15.setIcon(threeIcon);
        p2ScoreThreeB.setIcon(threeIcon);

        //adding labels to player 1 20 position
        p1scores20.add(p1ScoreNone, "none");
        p1scores20.add(p1ScoreOne, "one");
        p1scores20.add(p1ScoreTwo, "two");
        p1scores20.add(p1ScoreThree, "three");
        p1scores20.setBounds(50, 80, 45, 38);

        //adding labels to player 2 20 position
        p2scores20.add(p2ScoreNone, "none");
        p2scores20.add(p2ScoreOne, "one");
        p2scores20.add(p2ScoreTwo, "two");
        p2scores20.add(p2ScoreThree, "three");
        p2scores20.setBounds(200, 80, 45, 38);

        //adding labels to player 1 19 position
        p1scores19.add(p1ScoreNone19, "none");
        p1scores19.add(p1ScoreOne19, "one");
        p1scores19.add(p1ScoreTwo19, "two");
        p1scores19.add(p1ScoreThree19, "three");
        p1scores19.setBounds(50, 130, 45, 38);

        //adding labels to player 2 19 position
        p2scores19.add(p2ScoreNone19, "none");
        p2scores19.add(p2ScoreOne19, "one");
        p2scores19.add(p2ScoreTwo19, "two");
        p2scores19.add(p2ScoreThree19, "three");
        p2scores19.setBounds(200, 130, 45, 38);

        //adding labels to player 1 18 position
        p1scores18.add(p1ScoreNone18, "none");
        p1scores18.add(p1ScoreOne18, "one");
        p1scores18.add(p1ScoreTwo18, "two");
        p1scores18.add(p1ScoreThree18, "three");
        p1scores18.setBounds(50, 180, 45, 38);

        //adding labels to player 2 18 position
        p2scores18.add(p2ScoreNone18, "none");
        p2scores18.add(p2ScoreOne18, "one");
        p2scores18.add(p2ScoreTwo18, "two");
        p2scores18.add(p2ScoreThree18, "three");
        p2scores18.setBounds(200, 180, 45, 38);

        p1scores17.add(p1ScoreNone17, "none");
        p1scores17.add(p1ScoreOne17, "one");
        p1scores17.add(p1ScoreTwo17, "two");
        p1scores17.add(p1ScoreThree17, "three");
        p1scores17.setBounds(50, 237, 45, 38);

        p2scores17.add(p2ScoreNone17, "none");
        p2scores17.add(p2ScoreOne17, "one");
        p2scores17.add(p2ScoreTwo17, "two");
        p2scores17.add(p2ScoreThree17, "three");
        p2scores17.setBounds(200, 237, 45, 38);

        p1scores16.add(p1ScoreNone16, "none");
        p1scores16.add(p1ScoreOne16, "one");
        p1scores16.add(p1ScoreTwo16, "two");
        p1scores16.add(p1ScoreThree16, "three");
        p1scores16.setBounds(50, 280, 45, 38);

        p2scores16.add(p2ScoreNone16, "none");
        p2scores16.add(p2ScoreOne16, "one");
        p2scores16.add(p2ScoreTwo16, "two");
        p2scores16.add(p2ScoreThree16, "three");
        p2scores16.setBounds(200, 280, 45, 38);

        p1scores15.add(p1ScoreNone15, "none");
        p1scores15.add(p1ScoreOne15, "one");
        p1scores15.add(p1ScoreTwo15, "two");
        p1scores15.add(p1ScoreThree15, "three");
        p1scores15.setBounds(50, 335, 45, 38);

        p2scores15.add(p2ScoreNone15, "none");
        p2scores15.add(p2ScoreOne15, "one");
        p2scores15.add(p2ScoreTwo15, "two");
        p2scores15.add(p2ScoreThree15, "three");
        p2scores15.setBounds(200, 335, 45, 38);

        p1scoresB.add(p1ScoreNoneB, "none");
        p1scoresB.add(p1ScoreOneB, "one");
        p1scoresB.add(p1ScoreTwoB, "two");
        p1scoresB.add(p1ScoreThreeB, "three");
        p1scoresB.setBounds(50, 383, 45, 38);

        p2scoresB.add(p2ScoreNoneB, "none");
        p2scoresB.add(p2ScoreOneB, "one");
        p2scoresB.add(p2ScoreTwoB, "two");
        p2scoresB.add(p2ScoreThreeB, "three");
        p2scoresB.setBounds(200, 383, 45, 38);

        //adding panels to the layered pane
        lpane.add(background, 0, 0);
        lpane.add(p1scores20, 1, 0);
        lpane.add(p1scores19, 1, 0);
        lpane.add(p1scores18, 1, 0);
        lpane.add(p1scores17, 1, 0);
        lpane.add(p1scores16, 1, 0);
        lpane.add(p1scores15, 1, 0);
        lpane.add(p1scoresB, 1, 0);
        lpane.add(p2scores20, 1, 0);
        lpane.add(p2scores19, 1, 0);
        lpane.add(p2scores18, 1, 0);
        lpane.add(p2scores17, 1, 0);
        lpane.add(p2scores16, 1, 0);
        lpane.add(p2scores15, 1, 0);
        lpane.add(p2scoresB, 1, 0);
        lpane.add(p1ScorePanel, 1, 0);
        lpane.add(p2ScorePanel, 1, 0);
        lpane.add(dartPanel, 1, 0);
        lpane.add(gameTypePanel, 1, 0);

        //adding layered pane to main panel
        add(lpane);
        setVisible(true);
    }
}

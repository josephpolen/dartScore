/*
 *                         DartScore
 *                 A DartScoring application by
 *                        Joseph Polen
 */
package dartscore;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Joe
 */
public class DartBoard extends JPanel {

    String hit;
    int dartCount = 0;
    boolean p1Turn = true;
    boolean p120IsClosed = false;
    boolean p119IsClosed = false;
    boolean p118IsClosed = false;
    boolean p117IsClosed = false;
    boolean p116IsClosed = false;
    boolean p115IsClosed = false;
    boolean p1BIsClosed = false;

    boolean p220IsClosed = false;
    boolean p219IsClosed = false;
    boolean p218IsClosed = false;
    boolean p217IsClosed = false;
    boolean p216IsClosed = false;
    boolean p215IsClosed = false;
    boolean p2BIsClosed = false;

    static int[][] cricketArray;
    int p1Total = 0;
    int p2Total = 0;
    int roundTotal;
    int score;

    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores20.getLayout();
    public static DartBoard board = new DartBoard();

    DartBoard() {

        //array for keeping track of scores in cricket
        cricketArray = new int[7][2];
        
        ScoreBoard.scoreBoard.p1ScoreLabel.setForeground(Color.RED);

        //initial scores based on gametype
        if (gameFlag.gameType == 1) {
            p1Total = 0;
            p2Total = 0;
        }
        if (gameFlag.gameType == 2) {
            p1Total = 301;
            p2Total = 301;
        }
        if (gameFlag.gameType == 3) {
            p1Total = 0;
            p2Total = 0;
        }

        //Load dartboard image
        ImageIcon boardIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/dartboard.png"));
        JLabel dartBoard = new JLabel();
        dartBoard.setIcon(boardIcon);
        dartBoard.addMouseListener(new MouseAdapter() {
            @Override
            //mouse listener for clicking on dartboard
            public void mouseClicked(MouseEvent e) {
                score = 0;
                dartCount++;
                
                //set origin of dartboard at bullseye
                double xOrigin = 278;
                double yOrigin = 278;
                double x = e.getX();
                double y = e.getY();
                //   System.out.println("x:" + x + " y:"+ y);
                
                //get angle of click relative to bullseye
                double delta_x = x - xOrigin;
                double delta_y = y - yOrigin;
                double angle = Math.atan2(delta_y, delta_x);
                // System.out.println("Angle: " + angle);
                
                //get distance of click from bullseye
                double dist = Math.abs(Math.sqrt((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
                //  System.out.println("Distance: " + dist);
                
                //its player ones turn
                if (p1Turn) {
                    
                    //highlight current players score
                    ScoreBoard.scoreBoard.p1ScoreLabel.setForeground(Color.RED);
                    ScoreBoard.scoreBoard.p2ScoreLabel.setForeground(Color.BLACK);
                    
                    //Player 1 throw 1
                    if (dartCount == 1) {
                        clearDarts();
                        score = score(angle, dist);
                        
                        //gameType All Fives
                        if (gameFlag.gameType == 6) {
                            ScoreBoard.scoreBoard.gameTypeLabel.setText("All Fives");
                            allFives();
                            ScoreBoard.scoreBoard.dart1Label.setText(hit);
                        }
                        
                        //gameType 701
                        if (gameFlag.gameType == 5) {
                            ScoreBoard.scoreBoard.gameTypeLabel.setText("701");
                            x01();
                            ScoreBoard.scoreBoard.dart1Label.setText(hit);
                        }
                        
                        //gameType 501
                        if (gameFlag.gameType == 4) {
                            ScoreBoard.scoreBoard.gameTypeLabel.setText("501");
                            x01();
                            ScoreBoard.scoreBoard.dart1Label.setText(hit);
                        }
                        
                        //gameType Count Up
                        if (gameFlag.gameType == 3) {
                            ScoreBoard.scoreBoard.gameTypeLabel.setText("Count Up");
                            countUp();
                            ScoreBoard.scoreBoard.dart1Label.setText(hit);
                        }
                        
                        //gameType 301
                        if (gameFlag.gameType == 2) {
                            ScoreBoard.scoreBoard.gameTypeLabel.setText("301");
                            x01();
                            ScoreBoard.scoreBoard.dart1Label.setText(hit);
                        }
                        
                        //gameType Cricket
                        if (gameFlag.gameType == 1) {
                            ScoreBoard.scoreBoard.gameTypeLabel.setText("Cricket");
                            cricketThrow();
                            ScoreBoard.scoreBoard.dart1Label.setText(hit);
                        }
                    }
                    
                    //Player 1 throw 2
                    if (dartCount == 2) {
                        score = score(angle, dist);
                        if (gameFlag.gameType == 6) {
                            allFives();
                            ScoreBoard.scoreBoard.dart2Label.setText(hit);
                        }
                        if (gameFlag.gameType == 5) {
                            x01();
                            ScoreBoard.scoreBoard.dart2Label.setText(hit);
                        }
                        
                        if (gameFlag.gameType == 4) {
                            x01();
                            ScoreBoard.scoreBoard.dart2Label.setText(hit);
                        }
                        if (gameFlag.gameType == 3) {
                            countUp();
                            
                            ScoreBoard.scoreBoard.dart2Label.setText(hit);
                        }
                        
                        if (gameFlag.gameType == 2) {
                            x01();
                            ScoreBoard.scoreBoard.dart2Label.setText(hit);
                        }
                        if (gameFlag.gameType == 1) {
                            cricketThrow();
                            ScoreBoard.scoreBoard.dart2Label.setText(hit);
                        }
                        
                    }
                    
                    //Player 1 throw 3
                    if (dartCount == 3) {
                        score = score(angle, dist);
                        if (gameFlag.gameType == 6) {
                            allFives();
                            if (roundTotal % 5 == 0) {
                                p1Total += (roundTotal / 5);
                                
                            }
                            ScoreBoard.scoreBoard.p1ScoreLabel.setText(String.valueOf(p1Total));
                            ScoreBoard.scoreBoard.dart3Label.setText(hit);
                            dartCount = 0;
                            roundTotal = 0;
                            p1Turn = false;
                        }
                        if (gameFlag.gameType == 5) {
                            x01();
                            ScoreBoard.scoreBoard.dart3Label.setText(hit);
                            dartCount = 0;
                            
                            p1Turn = false;
                        }
                        
                        if (gameFlag.gameType == 4) {
                            x01();
                            ScoreBoard.scoreBoard.dart3Label.setText(hit);
                            dartCount = 0;
                            
                            p1Turn = false;
                        }
                        if (gameFlag.gameType == 3) {
                            countUp();
                            
                            ScoreBoard.scoreBoard.dart3Label.setText(hit);
                            dartCount = 0;
                            
                            p1Turn = false;
                            
                        }
                        
                        if (gameFlag.gameType == 2) {
                            x01();
                            
                            ScoreBoard.scoreBoard.dart3Label.setText(hit);
                            dartCount = 0;
                            
                            p1Turn = false;
                            
                        }
                        if (gameFlag.gameType == 1) {
                            cricketThrow();
                            ScoreBoard.scoreBoard.dart3Label.setText(hit);
                            dartCount = 0;
                            p1Turn = false;
                            
                        }
                        
                    }
                }
                
                //Player 2 turn
                if (!p1Turn) {
                    
                    //highlight player 2 score
                    ScoreBoard.scoreBoard.p2ScoreLabel.setForeground(Color.RED);
                    ScoreBoard.scoreBoard.p1ScoreLabel.setForeground(Color.BLACK);
                    
                    //Player 2 throw 1
                    if (dartCount == 1) {
                        clearDarts();
                        score = score(angle, dist);
                        if (gameFlag.gameType == 6) {
                            allFives();
                            ScoreBoard.scoreBoard.dart1Label.setText(hit);
                        }
                        if (gameFlag.gameType == 5) {
                            x01();
                            ScoreBoard.scoreBoard.dart1Label.setText(hit);
                        }
                        
                        if (gameFlag.gameType == 4) {
                            x01();
                            ScoreBoard.scoreBoard.dart1Label.setText(hit);
                        }
                        if (gameFlag.gameType == 3) {
                            countUp();
                            ScoreBoard.scoreBoard.dart1Label.setText(hit);
                        }
                        
                        if (gameFlag.gameType == 2) {
                            x01();
                            ScoreBoard.scoreBoard.dart1Label.setText(hit);
                        }
                        if (gameFlag.gameType == 1) {
                            cricketThrow();
                            ScoreBoard.scoreBoard.dart1Label.setText(hit);
                        }
                    }
                    
                    //Player 2 throw 2
                    if (dartCount == 2) {
                        score = score(angle, dist);
                        if (gameFlag.gameType == 6) {
                            allFives();
                            ScoreBoard.scoreBoard.dart2Label.setText(hit);
                        }
                        if (gameFlag.gameType == 5) {
                            x01();
                            ScoreBoard.scoreBoard.dart2Label.setText(hit);
                        }
                        
                        if (gameFlag.gameType == 4) {
                            x01();
                            ScoreBoard.scoreBoard.dart2Label.setText(hit);
                        }
                        if (gameFlag.gameType == 3) {
                            countUp();
                            ScoreBoard.scoreBoard.dart2Label.setText(hit);
                        }
                        
                        if (gameFlag.gameType == 2) {
                            x01();
                            ScoreBoard.scoreBoard.dart2Label.setText(hit);
                        }
                        if (gameFlag.gameType == 1) {
                            cricketThrow();
                            ScoreBoard.scoreBoard.dart2Label.setText(hit);
                        }
                        
                    }
                    
                    //Player 2 throw 3
                    if (dartCount == 3) {
                        
                        score = score(angle, dist);
                        if (gameFlag.gameType == 6) {
                            allFives();
                            if (roundTotal % 5 == 0) {
                                p2Total += (roundTotal / 5);
                            }
                            ScoreBoard.scoreBoard.p2ScoreLabel.setText(String.valueOf(p2Total));
                            ScoreBoard.scoreBoard.dart3Label.setText(hit);
                            dartCount = 0;
                            roundTotal = 0;
                            p1Turn = true;
                            ScoreBoard.scoreBoard.p1ScoreLabel.setForeground(Color.RED);
                            ScoreBoard.scoreBoard.p2ScoreLabel.setForeground(Color.BLACK);
                        }
                        if (gameFlag.gameType == 5) {
                            x01();
                            ScoreBoard.scoreBoard.dart3Label.setText(hit);
                            dartCount = 0;
                            p1Turn = true;
                            ScoreBoard.scoreBoard.p1ScoreLabel.setForeground(Color.RED);
                            ScoreBoard.scoreBoard.p2ScoreLabel.setForeground(Color.BLACK);
                            
                        }
                        
                        if (gameFlag.gameType == 4) {
                            x01();
                            ScoreBoard.scoreBoard.dart3Label.setText(hit);
                            dartCount = 0;
                            p1Turn = true;
                            ScoreBoard.scoreBoard.p1ScoreLabel.setForeground(Color.RED);
                            ScoreBoard.scoreBoard.p2ScoreLabel.setForeground(Color.BLACK);
                        }
                        if (gameFlag.gameType == 3) {
                            countUp();
                            ScoreBoard.scoreBoard.dart3Label.setText(hit);
                            p1Turn = true;
                            ScoreBoard.scoreBoard.p1ScoreLabel.setForeground(Color.RED);
                            ScoreBoard.scoreBoard.p2ScoreLabel.setForeground(Color.BLACK);
                            dartCount = 0;
                            
                        }
                        
                        if (gameFlag.gameType == 2) {
                            x01();
                            ScoreBoard.scoreBoard.dart3Label.setText(hit);
                            dartCount = 0;
                            p1Turn = true;
                            ScoreBoard.scoreBoard.p1ScoreLabel.setForeground(Color.RED);
                            ScoreBoard.scoreBoard.p2ScoreLabel.setForeground(Color.BLACK);
                            
                        }
                        if (gameFlag.gameType == 1) {
                            cricketThrow();
                            ScoreBoard.scoreBoard.dart3Label.setText(hit);
                            dartCount = 0;
                            p1Turn = true;
                            ScoreBoard.scoreBoard.p1ScoreLabel.setForeground(Color.RED);
                            ScoreBoard.scoreBoard.p2ScoreLabel.setForeground(Color.BLACK);
                            
                        }
                        
                    }
                }
            }
        }
        );
        add(dartBoard);

    }

    //method determines value of current dart from board click
    public int score(double ang, double dist) {

        int score = 0;
        String t = "T";
        String d = "D";
        double angle = ang;
        double distance = dist;

        if ((angle >= -1.72) && (angle < -1.415)) {
            hit = "20";
            score = 20;
        } else if ((angle >= -1.415) && (angle < -1.11)) {
            hit = "1";
            score = 1;
        } else if ((angle >= -1.11) && (angle < -0.79)) {
            hit = "18";
            score = 18;
        } else if ((angle >= -0.79) && (angle < -0.47)) {
            hit = "4";
            score = 4;
        } else if ((angle >= -0.47) && (angle < -0.165)) {
            hit = "13";
            score = 13;
        } else if (((angle >= -0.165) && (angle <= 0)) || ((angle >= 0) && (angle < 0.16))) {
            hit = "6";
            score = 6;
        } else if ((angle >= 0.16) && (angle < 0.46)) {
            hit = "10";
            score = 10;
        } else if ((angle >= 0.46) && (angle < 0.79)) {
            hit = "15";
            score = 15;
        } else if ((angle >= 0.79) && (angle < 1.08)) {
            hit = "2";
            score = 2;
        } else if ((angle >= 1.08) && (angle < 1.41)) {
            hit = "17";
            score = 17;
        } else if ((angle >= 1.41) && (angle < 1.72)) {
            hit = "3";
            score = 3;
        } else if ((angle >= 1.72) && (angle < 2.045)) {
            hit = "19";
            score = 19;
        } else if ((angle >= 2.045) && (angle < 2.35)) {
            hit = "7";
            score = 7;
        } else if ((angle >= 2.35) && (angle < 2.675)) {
            hit = "16";
            score = 16;
        } else if ((angle >= 2.675) && (angle < 2.975)) {
            hit = "8";
            score = 8;
        } else if (((angle >= 2.975) && (angle <= 3.14159265358979323846)) || ((angle >= -3.14159265358979323846) && (angle < -2.97))) {
            hit = "11";
            score = 11;
        } else if ((angle >= -2.97) && (angle < -2.68)) {
            hit = "14";
            score = 14;
        } else if ((angle >= -2.68) && (angle < -2.35)) {
            hit = "9";
            score = 9;
        } else if ((angle >= -2.35) && (angle < -2.045)) {
            hit = "12";
            score = 12;
        } else if ((angle >= -2.045) && (angle < -1.72)) {
            hit = "5";
            score = 5;
        }

        if ((distance >= 0) && (distance < 9)) {
            hit = "DB";
            score = 50;
        } else if ((distance >= 9) && (distance <= 19)) {
            hit = "B";
            score = 25;
        } else if ((distance >= 111) && (distance <= 130)) {
            t += hit;
            hit = t;
            score *= 3;
        } else if ((distance >= 186) && (distance <= 209)) {
            d += hit;
            hit = d;
            score *= 2;
        } else if (distance >= 210) {
            hit = "X";
            score = 0;
        }

        return score;
    }

    //method keeps track of cricket score and updates cricket scoreboard
    public void cricket(String h) {
        String hit = h;

        if (h.equals("20")) {

            if (p1Turn) {
                if ((!p120IsClosed) || (!p220IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[6][0] += 1;
                        if (cricketArray[6][0] >= 3) {
                            cricketArray[6][0] = 3;
                        }

                    } else {
                        cricketArray[6][0] += 1;
                    }
                }
                if (cricketArray[6][0] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores20.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores20, "one");

                }

                if (cricketArray[6][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores20.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores20, "two");

                }
                if (cricketArray[6][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores20.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores20, "three");
                    p120IsClosed = true;

                }
            }

            if (!p1Turn) {
                if ((!p120IsClosed) || (!p220IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[6][1] += 1;
                        if (cricketArray[6][1] >= 3) {
                            cricketArray[6][1] = 3;
                        }

                    } else {
                        cricketArray[6][1] += 1;
                    }
                }
                if (cricketArray[6][1] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores20.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores20, "one");

                }

                if (cricketArray[6][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores20.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores20, "two");

                }
                if (cricketArray[6][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores20.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores20, "three");
                    p220IsClosed = true;

                }
            }

        }

        if (h.equals("D20")) {

            if (p1Turn) {
                if ((!p120IsClosed) || (!p220IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[6][0] += 2;
                        if (cricketArray[6][0] >= 3) {
                            cricketArray[6][0] = 3;
                        }

                    } else {
                        cricketArray[6][0] += 2;
                    }
                }
                if (cricketArray[6][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores20.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores20, "two");
                }
                if (cricketArray[6][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores20.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores20, "three");
                    p120IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p120IsClosed) || (!p220IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[6][1] += 2;
                        if (cricketArray[6][1] >= 3) {
                            cricketArray[6][1] = 3;
                        }

                    } else {
                        cricketArray[6][1] += 2;
                    }
                }
                if (cricketArray[6][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores20.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores20, "two");
                }
                if (cricketArray[6][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores20.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores20, "three");
                    p220IsClosed = true;
                }
            }
        }
        if (h.equals("T20")) {

            if (p1Turn) {
                if ((!p120IsClosed) || (!p220IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[6][0] += 3;
                        if (cricketArray[6][0] >= 3) {
                            cricketArray[6][0] = 3;
                        }

                    } else {
                        cricketArray[6][0] += 3;
                    }
                }
                if (cricketArray[6][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores20.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores20, "three");
                    p120IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p120IsClosed) || (!p220IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[6][1] += 3;
                        if (cricketArray[6][1] >= 3) {
                            cricketArray[6][1] = 3;
                        }

                    } else {
                        cricketArray[6][1] += 3;
                    }
                }
                if (cricketArray[6][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores20.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores20, "three");
                    p220IsClosed = true;
                }
            }
        }

        if (h.equals("19")) {

            if (p1Turn) {
                if ((!p119IsClosed) || (!p219IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[5][0] += 1;
                        if (cricketArray[5][0] >= 3) {
                            cricketArray[5][0] = 3;
                        }

                    } else {
                        cricketArray[5][0] += 1;
                    }
                }
                if (cricketArray[5][0] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores19.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores19, "one");
                }

                if (cricketArray[5][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores19.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores19, "two");
                }
                if (cricketArray[5][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores19.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores19, "three");
                    p119IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p119IsClosed) || (!p219IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[5][1] += 1;
                        if (cricketArray[5][1] >= 3) {
                            cricketArray[5][1] = 3;
                        }

                    } else {
                        cricketArray[5][1] += 1;
                    }
                }
                if (cricketArray[5][1] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores19.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores19, "one");
                }

                if (cricketArray[5][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores19.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores19, "two");
                }
                if (cricketArray[5][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores19.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores19, "three");
                    p219IsClosed = true;
                }
            }
        }

        if (h.equals("D19")) {

            if (p1Turn) {
                if ((!p119IsClosed) || (!p219IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[5][0] += 2;
                        if (cricketArray[5][0] >= 3) {
                            cricketArray[5][0] = 3;
                        }

                    } else {
                        cricketArray[5][0] += 2;
                    }
                }
                if (cricketArray[5][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores19.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores19, "two");
                }
                if (cricketArray[5][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores19.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores19, "three");
                    p119IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p119IsClosed) || (!p219IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[5][1] += 2;
                        if (cricketArray[5][1] >= 3) {
                            cricketArray[5][1] = 3;
                        }

                    } else {
                        cricketArray[5][1] += 2;
                    }
                }
                if (cricketArray[5][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores19.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores19, "two");
                }
                if (cricketArray[5][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores19.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores19, "three");
                    p219IsClosed = true;
                }
            }
        }

        if (h.equals("T19")) {

            if (p1Turn) {
                if ((!p119IsClosed) || (!p219IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[5][0] += 3;
                        if (cricketArray[5][0] >= 3) {
                            cricketArray[5][0] = 3;
                        }

                    } else {
                        cricketArray[5][0] += 3;
                    }
                }
                if (cricketArray[5][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores19.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores19, "three");
                    p119IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p119IsClosed) || (!p219IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[5][1] += 3;
                        if (cricketArray[5][1] >= 3) {
                            cricketArray[5][1] = 3;
                        }

                    } else {
                        cricketArray[5][1] += 3;
                    }
                }
                if (cricketArray[5][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores19.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores19, "three");
                    p219IsClosed = true;
                }
            }
        }

        if (h.equals("18")) {

            if (p1Turn) {
                if ((!p118IsClosed) || (!p218IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[4][0] += 1;
                        if (cricketArray[4][0] >= 3) {
                            cricketArray[4][0] = 3;
                        }

                    } else {
                        cricketArray[4][0] += 1;
                    }
                }
                if (cricketArray[4][0] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores18.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores18, "one");
                }

                if (cricketArray[4][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores18.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores18, "two");
                }
                if (cricketArray[4][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores18.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores18, "three");
                    p118IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p118IsClosed) || (!p218IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[4][1] += 1;
                        if (cricketArray[4][1] >= 3) {
                            cricketArray[4][1] = 3;
                        }

                    } else {
                        cricketArray[4][1] += 1;
                    }
                }
                if (cricketArray[4][1] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores18.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores18, "one");
                }

                if (cricketArray[4][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores18.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores18, "two");
                }
                if (cricketArray[4][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores18.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores18, "three");
                    p218IsClosed = true;
                }
            }
        }

        if (h.equals("D18")) {

            if (p1Turn) {
                if ((!p118IsClosed) || (!p218IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[4][0] += 2;
                        if (cricketArray[4][0] >= 3) {
                            cricketArray[4][0] = 3;
                        }

                    } else {
                        cricketArray[4][0] += 2;
                    }
                }
                if (cricketArray[4][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores18.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores18, "two");
                }
                if (cricketArray[4][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores18.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores18, "three");
                    p118IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p118IsClosed) || (!p218IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[4][1] += 2;
                        if (cricketArray[4][1] >= 3) {
                            cricketArray[4][1] = 3;
                        }

                    } else {
                        cricketArray[4][1] += 2;
                    }
                }
                if (cricketArray[4][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores18.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores18, "two");
                }
                if (cricketArray[4][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores18.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores18, "three");
                    p218IsClosed = true;
                }
            }
        }

        if (h.equals("T18")) {

            if (p1Turn) {
                if ((!p118IsClosed) || (!p218IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[4][0] += 3;
                        if (cricketArray[4][0] >= 3) {
                            cricketArray[4][0] = 3;
                        }

                    } else {
                        cricketArray[4][0] += 3;
                    }
                }
                if (cricketArray[4][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores18.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores18, "three");
                    p118IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p118IsClosed) || (!p218IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[4][1] += 3;
                        if (cricketArray[4][1] >= 3) {
                            cricketArray[4][1] = 3;
                        }

                    } else {
                        cricketArray[4][1] += 3;
                    }
                }
                if (cricketArray[4][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores18.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores18, "three");
                    p218IsClosed = true;
                }
            }
        }

        if (h.equals("17")) {

            if (p1Turn) {
                if ((!p117IsClosed) || (!p217IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[3][0] += 1;
                        if (cricketArray[3][0] >= 3) {
                            cricketArray[3][0] = 3;
                        }

                    } else {
                        cricketArray[3][0] += 1;
                    }
                }
                if (cricketArray[3][0] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores17.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores17, "one");
                }

                if (cricketArray[3][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores17.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores17, "two");
                }
                if (cricketArray[3][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores17.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores17, "three");
                    p117IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p117IsClosed) || (!p217IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[3][1] += 1;
                        if (cricketArray[3][1] >= 3) {
                            cricketArray[3][1] = 3;
                        }

                    } else {
                        cricketArray[3][1] += 1;
                    }
                }
                if (cricketArray[3][1] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores17.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores17, "one");
                }

                if (cricketArray[3][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores17.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores17, "two");
                }
                if (cricketArray[3][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores17.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores17, "three");
                    p217IsClosed = true;
                }
            }
        }

        if (h.equals("D17")) {

            if (p1Turn) {
                if ((!p117IsClosed) || (!p217IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[3][0] += 2;
                        if (cricketArray[3][0] >= 3) {
                            cricketArray[3][0] = 3;
                        }

                    } else {
                        cricketArray[3][0] += 2;
                    }
                }
                if (cricketArray[3][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores17.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores17, "two");
                }
                if (cricketArray[3][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores17.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores17, "three");
                    p117IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p117IsClosed) || (!p217IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[3][1] += 2;
                        if (cricketArray[3][1] >= 3) {
                            cricketArray[3][1] = 3;
                        }

                    } else {
                        cricketArray[3][1] += 2;
                    }
                }
                if (cricketArray[3][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores17.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores17, "two");
                }
                if (cricketArray[3][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores17.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores17, "three");
                    p217IsClosed = true;
                }
            }
        }

        if (h.equals("T17")) {

            if (p1Turn) {
                if ((!p117IsClosed) || (!p217IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[3][0] += 3;
                        if (cricketArray[3][0] >= 3) {
                            cricketArray[3][0] = 3;
                        }

                    } else {
                        cricketArray[3][0] += 3;
                    }
                }
                if (cricketArray[3][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores17.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores17, "three");
                    p117IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p117IsClosed) || (!p217IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[3][1] += 3;
                        if (cricketArray[3][1] >= 3) {
                            cricketArray[3][1] = 3;
                        }

                    } else {
                        cricketArray[3][1] += 3;
                    }
                }
                if (cricketArray[3][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores17.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores17, "three");
                    p217IsClosed = true;
                }
            }
        }

        if (h.equals("16")) {

            if (p1Turn) {
                if ((!p116IsClosed) || (!p216IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[2][0] += 1;
                        if (cricketArray[2][0] >= 3) {
                            cricketArray[2][0] = 3;
                        }

                    } else {
                        cricketArray[2][0] += 1;
                    }
                }
                if (cricketArray[2][0] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores16.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores16, "one");
                }

                if (cricketArray[2][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores16.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores16, "two");
                }
                if (cricketArray[2][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores16.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores16, "three");
                    p116IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p116IsClosed) || (!p216IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[2][1] += 1;
                        if (cricketArray[2][1] >= 3) {
                            cricketArray[2][1] = 3;
                        }

                    } else {
                        cricketArray[2][1] += 1;
                    }
                }
                if (cricketArray[2][1] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores16.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores16, "one");
                }

                if (cricketArray[2][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores16.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores16, "two");
                }
                if (cricketArray[2][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores16.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores16, "three");
                    p216IsClosed = true;
                }
            }
        }

        if (h.equals("D16")) {

            if (p1Turn) {
                if ((!p116IsClosed) || (!p216IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[2][0] += 2;
                        if (cricketArray[2][0] >= 3) {
                            cricketArray[2][0] = 3;
                        }

                    } else {
                        cricketArray[2][0] += 2;
                    }
                }
                if (cricketArray[2][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores16.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores16, "two");
                }
                if (cricketArray[2][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores16.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores16, "three");
                    p116IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p116IsClosed) || (!p216IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[2][1] += 2;
                        if (cricketArray[2][1] >= 3) {
                            cricketArray[2][1] = 3;
                        }

                    } else {
                        cricketArray[2][1] += 2;
                    }
                }
                if (cricketArray[2][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores16.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores16, "two");
                }
                if (cricketArray[2][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores16.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores16, "three");
                    p216IsClosed = true;
                }
            }
        }

        if (h.equals("T16")) {

            if (p1Turn) {
                if ((!p116IsClosed) || (!p216IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[2][0] += 3;
                        if (cricketArray[2][0] >= 3) {
                            cricketArray[2][0] = 3;
                        }

                    } else {
                        cricketArray[2][0] += 3;
                    }
                }
                if (cricketArray[2][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores16.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores16, "three");
                    p116IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p116IsClosed) || (!p216IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[2][1] += 3;
                        if (cricketArray[2][1] >= 3) {
                            cricketArray[2][1] = 3;
                        }

                    } else {
                        cricketArray[2][1] += 3;
                    }
                }
                if (cricketArray[2][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores16.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores16, "three");
                    p216IsClosed = true;
                }
            }
        }

        if (h.equals("15")) {

            if (p1Turn) {
                if ((!p115IsClosed) || (!p215IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[1][0] += 1;
                        if (cricketArray[1][0] >= 3) {
                            cricketArray[1][0] = 3;
                        }

                    } else {
                        cricketArray[1][0] += 1;
                    }
                }
                if (cricketArray[1][0] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores15.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores15, "one");
                }

                if (cricketArray[1][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores15.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores15, "two");
                }
                if (cricketArray[1][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores15.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores15, "three");
                    p115IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p115IsClosed) || (!p215IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[1][1] += 1;
                        if (cricketArray[1][1] >= 3) {
                            cricketArray[1][1] = 3;
                        }

                    } else {
                        cricketArray[1][1] += 1;
                    }
                }
                if (cricketArray[1][1] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores15.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores15, "one");
                }

                if (cricketArray[1][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores15.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores15, "two");
                }
                if (cricketArray[1][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores15.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores15, "three");
                    p215IsClosed = true;
                }
            }
        }

        if (h.equals("D15")) {

            if (p1Turn) {
                if ((!p115IsClosed) || (!p215IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[1][0] += 2;
                        if (cricketArray[1][0] >= 3) {
                            cricketArray[1][0] = 3;
                        }

                    } else {
                        cricketArray[1][0] += 2;
                    }
                }
                if (cricketArray[1][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores15.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores15, "two");
                }
                if (cricketArray[1][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores15.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores15, "three");
                    p115IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p115IsClosed) || (!p215IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[1][1] += 2;
                        if (cricketArray[1][1] >= 3) {
                            cricketArray[1][1] = 3;
                        }

                    } else {
                        cricketArray[1][1] += 2;
                    }
                }
                if (cricketArray[1][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores15.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores15, "two");
                }
                if (cricketArray[1][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores15.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores15, "three");
                    p215IsClosed = true;
                }
            }
        }

        if (h.equals("T15")) {

            if (p1Turn) {
                if ((!p115IsClosed) || (!p215IsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[1][0] += 3;
                        if (cricketArray[1][0] >= 3) {
                            cricketArray[1][0] = 3;
                        }

                    } else {
                        cricketArray[1][0] += 3;
                    }
                }
                if (cricketArray[1][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores15.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scores15, "three");
                    p115IsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p115IsClosed) || (!p215IsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[1][1] += 3;
                        if (cricketArray[1][1] >= 3) {
                            cricketArray[1][1] = 3;
                        }

                    } else {
                        cricketArray[1][1] += 3;
                    }
                }
                if (cricketArray[1][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores15.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scores15, "three");
                    p215IsClosed = true;
                }
            }
        }

        if (h.equals("B")) {

            if (p1Turn) {
                if ((!p1BIsClosed) || (!p2BIsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[0][0] += 1;
                        if (cricketArray[0][0] >= 3) {
                            cricketArray[0][0] = 3;
                        }

                    } else {
                        cricketArray[0][0] += 1;
                    }
                }
                System.out.println(cricketArray[0][0]);
                if (cricketArray[0][0] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scoresB.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scoresB, "one");
                }

                if (cricketArray[0][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scoresB.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scoresB, "two");
                }
                if (cricketArray[0][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scoresB.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scoresB, "three");
                    p1BIsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p1BIsClosed) || (!p2BIsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[0][1] += 1;
                        if (cricketArray[0][1] >= 3) {
                            cricketArray[0][1] = 3;
                        }

                    } else {
                        cricketArray[0][1] += 1;
                    }
                }
                //System.out.println(cricketArray[0][0]);
                if (cricketArray[0][1] == 1) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scoresB.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scoresB, "one");
                }

                if (cricketArray[0][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scoresB.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scoresB, "two");
                }
                if (cricketArray[0][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scoresB.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scoresB, "three");
                    p2BIsClosed = true;
                }
            }
        }
        if (h.equals("DB")) {

            if (p1Turn) {
                if ((!p1BIsClosed) || (!p2BIsClosed)) {
                    if (p220IsClosed) {
                        cricketArray[0][0] += 2;
                        if (cricketArray[0][0] >= 3) {
                            cricketArray[0][0] = 3;
                        }

                    } else {
                        cricketArray[0][0] += 2;
                    }
                }
                System.out.println(cricketArray[0][0]);
                if (cricketArray[0][0] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scoresB.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scoresB, "two");
                }
                if (cricketArray[0][0] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scoresB.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p1scoresB, "three");
                    p1BIsClosed = true;
                }
            }

            if (!p1Turn) {
                if ((!p1BIsClosed) || (!p2BIsClosed)) {
                    if (p120IsClosed) {
                        cricketArray[0][1] += 2;
                        if (cricketArray[0][1] >= 3) {
                            cricketArray[0][1] = 3;
                        }

                    } else {
                        cricketArray[0][1] += 2;
                    }
                }
                System.out.println(cricketArray[0][0]);
                if (cricketArray[0][1] == 2) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scoresB.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scoresB, "two");
                }
                if (cricketArray[0][1] >= 3) {
                    CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scoresB.getLayout();
                    cardLayout.show(ScoreBoard.scoreBoard.p2scoresB, "three");
                    p2BIsClosed = true;
                }
            }

        }
    }
    //method resets the dartLabels to null

    public void clearDarts() {
        ScoreBoard.scoreBoard.dart1Label.setText("");
        ScoreBoard.scoreBoard.dart2Label.setText("");
        ScoreBoard.scoreBoard.dart3Label.setText("");
    }

    //method resets the cricketArray to zeros and clears the scoreboard
    public static void clearCricketBoard() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                cricketArray[i][j] = 0;
            }
        }
        CardLayout cardLayout = (CardLayout) ScoreBoard.scoreBoard.p1scores20.getLayout();
        cardLayout.show(ScoreBoard.scoreBoard.p1scores20, "none");

        CardLayout cardLayout2 = (CardLayout) ScoreBoard.scoreBoard.p1scores19.getLayout();
        cardLayout2.show(ScoreBoard.scoreBoard.p1scores19, "none");

        CardLayout cardLayout3 = (CardLayout) ScoreBoard.scoreBoard.p1scores18.getLayout();
        cardLayout3.show(ScoreBoard.scoreBoard.p1scores18, "none");

        CardLayout cardLayout4 = (CardLayout) ScoreBoard.scoreBoard.p1scores17.getLayout();
        cardLayout4.show(ScoreBoard.scoreBoard.p1scores17, "none");

        CardLayout cardLayout5 = (CardLayout) ScoreBoard.scoreBoard.p1scores16.getLayout();
        cardLayout5.show(ScoreBoard.scoreBoard.p1scores16, "none");

        CardLayout cardLayout6 = (CardLayout) ScoreBoard.scoreBoard.p1scores15.getLayout();
        cardLayout6.show(ScoreBoard.scoreBoard.p1scores15, "none");

        CardLayout cardLayout7 = (CardLayout) ScoreBoard.scoreBoard.p1scoresB.getLayout();
        cardLayout7.show(ScoreBoard.scoreBoard.p1scoresB, "none");

        CardLayout p2CardLayout = (CardLayout) ScoreBoard.scoreBoard.p2scores20.getLayout();
        p2CardLayout.show(ScoreBoard.scoreBoard.p2scores20, "none");

        CardLayout p2CardLayout2 = (CardLayout) ScoreBoard.scoreBoard.p2scores19.getLayout();
        p2CardLayout2.show(ScoreBoard.scoreBoard.p2scores19, "none");

        CardLayout p2CardLayout3 = (CardLayout) ScoreBoard.scoreBoard.p2scores18.getLayout();
        p2CardLayout3.show(ScoreBoard.scoreBoard.p2scores18, "none");

        CardLayout p2CardLayout4 = (CardLayout) ScoreBoard.scoreBoard.p2scores17.getLayout();
        p2CardLayout4.show(ScoreBoard.scoreBoard.p2scores17, "none");

        CardLayout p2CardLayout5 = (CardLayout) ScoreBoard.scoreBoard.p2scores16.getLayout();
        p2CardLayout5.show(ScoreBoard.scoreBoard.p2scores16, "none");

        CardLayout p2CardLayout6 = (CardLayout) ScoreBoard.scoreBoard.p2scores15.getLayout();
        p2CardLayout6.show(ScoreBoard.scoreBoard.p2scores15, "none");

        CardLayout p2CardLayout7 = (CardLayout) ScoreBoard.scoreBoard.p2scoresB.getLayout();
        p2CardLayout7.show(ScoreBoard.scoreBoard.p2scoresB, "none");

        DartBoard.board.p120IsClosed = false;
        DartBoard.board.p119IsClosed = false;
        DartBoard.board.p118IsClosed = false;
        DartBoard.board.p117IsClosed = false;
        DartBoard.board.p116IsClosed = false;
        DartBoard.board.p115IsClosed = false;
        DartBoard.board.p1BIsClosed = false;

        DartBoard.board.p220IsClosed = false;
        DartBoard.board.p219IsClosed = false;
        DartBoard.board.p218IsClosed = false;
        DartBoard.board.p217IsClosed = false;
        DartBoard.board.p216IsClosed = false;
        DartBoard.board.p215IsClosed = false;
        DartBoard.board.p2BIsClosed = false;
    }

    //method calculates the players current score in cricket
    public static void cricketScore() {
        int[][] temp;
        temp = new int[7][2];

        if (cricketArray[6][0] > 3) {

            temp[6][0] = ((cricketArray[6][0] - 3) * 20);

        }
        if (cricketArray[6][1] > 3) {
            temp[6][1] = ((cricketArray[6][1] - 3) * 20);
        }

        if (cricketArray[5][0] > 3) {
            temp[5][0] = ((cricketArray[5][0] - 3) * 19);
        }
        if (cricketArray[5][1] > 3) {
            temp[5][1] = ((cricketArray[5][1] - 3) * 19);
        }

        if (cricketArray[4][0] > 3) {
            temp[4][0] = ((cricketArray[4][0] - 3) * 18);
        }
        if (cricketArray[4][1] > 3) {
            temp[4][1] = ((cricketArray[4][1] - 3) * 18);
        }

        if (cricketArray[3][0] > 3) {
            temp[3][0] = ((cricketArray[3][0] - 3) * 17);
        }
        if (cricketArray[3][1] > 3) {
            temp[3][1] = ((cricketArray[3][1] - 3) * 17);
        }

        if (cricketArray[2][0] > 3) {
            temp[2][0] = ((cricketArray[2][0] - 3) * 16);
        }
        if (cricketArray[2][1] > 3) {
            temp[2][1] = ((cricketArray[2][1] - 3) * 16);
        }

        if (cricketArray[1][0] > 3) {
            temp[1][0] = ((cricketArray[1][0] - 3) * 15);
        }
        if (cricketArray[1][1] > 3) {
            temp[1][1] = ((cricketArray[1][1] - 3) * 15);
        }

        if (cricketArray[0][0] > 3) {
            temp[0][0] = ((cricketArray[0][0] - 3) * 25);
        }
        if (cricketArray[0][1] > 3) {
            temp[0][1] = ((cricketArray[0][1] - 3) * 25);
        }

        DartBoard.board.p1Total = temp[6][0] + temp[5][0] + temp[4][0] + temp[3][0]
                + temp[2][0] + temp[1][0] + temp[0][0];
        DartBoard.board.p2Total = temp[6][1] + temp[5][1] + temp[4][1] + temp[3][1]
                + temp[2][1] + temp[1][1] + temp[0][1];

    }

    public void allFives() {
        if (p1Turn) {
            roundTotal += score;
            ScoreBoard.scoreBoard.p1ScoreLabel.setText(String.valueOf(p1Total));
        }

        if (!p1Turn) {
            roundTotal += score;
            ScoreBoard.scoreBoard.p2ScoreLabel.setText(String.valueOf(p2Total));
        }
    }

    public void x01() {

        if (p1Turn) {
            p1Total -= score;
            ScoreBoard.scoreBoard.p1ScoreLabel.setText(String.valueOf(p1Total));
        }

        if (!p1Turn) {
            p2Total -= score;
            ScoreBoard.scoreBoard.p2ScoreLabel.setText(String.valueOf(p2Total));
        }
    }

    public void countUp() {
        if (p1Turn) {
            p1Total += score;
            ScoreBoard.scoreBoard.p1ScoreLabel.setText(String.valueOf(p1Total));
        }

        if (!p1Turn) {
            p2Total += score;
            ScoreBoard.scoreBoard.p2ScoreLabel.setText(String.valueOf(p2Total));
        }
    }

    public void cricketThrow() {
        if (p1Turn) {
            cricket(hit);
            cricketScore();
            ScoreBoard.scoreBoard.p1ScoreLabel.setText(String.valueOf(p1Total));
        }

        if (!p1Turn) {
            cricket(hit);
            cricketScore();
            ScoreBoard.scoreBoard.p2ScoreLabel.setText(String.valueOf(p2Total));
        }
    }
}

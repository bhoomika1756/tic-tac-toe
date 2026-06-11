import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {
    int boardWidth = 500;
    int boardHeight = 550;
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JButton[][] board = new JButton[3][3];
    String playerx= "X";
    String playero="O";
    String currentPlayer=playerx;
    boolean gameOver=false;
    int turns=0;
    public TicTacToe() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null); // center on screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        textLabel.setBackground(new Color(64, 224, 208));
        textLabel.setForeground(new Color(255, 20, 147));
        textLabel.setFont(new Font("Courier New",Font.BOLD,50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel,BorderLayout.NORTH);
        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(new Color(64, 224, 208));
        frame.add(boardPanel);

        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                JButton title = new JButton();
                board[r][c]=title;
                boardPanel.add(title);
                title.setBackground(new Color(255, 255, 102));
                title.setForeground(new Color(255, 20, 147));
                title.setFont(new Font("Courier New",Font.BOLD,100));
                title.setFocusable(false);
                //title.setText(currentPlayer);
            title.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    if(gameOver) return;
                    JButton title = (JButton)e.getSource();
                    if (title.getText()=="") {
                        title.setText(currentPlayer);
                        turns++;
                        checkWinner();
                            if(!gameOver){
                                currentPlayer = currentPlayer == playerx ? playero : playerx;
                                textLabel.setText(currentPlayer + "'s turn!");
                            }
                    }
                }
              });
            }
        }
    }
    public static void main(String[] args) {
        new TicTacToe();
    }
    void checkWinner(){
        for(int r=0;r<3;r++){
            if(board[r][0].getText()=="") continue;
            if(board[r][0].getText()== board[r][1].getText() && board[r][1].getText()==board[r][2].getText()){
                for(int i=0;i<3;i++){
                    setWinner(board[r][i]);
                }
                gameOver=true;
                return;
            }

            }
        for(int c=0;c<3;c++){
            if(board[0][c].getText()=="") continue;
            if(board[0][c].getText()==board[1][c].getText() && board[1][c].getText()==board[2][c].getText()){
                for(int i=0;i<3;i++){
                    setWinner(board[i][c]);
                }
                gameOver=true;
                return;
            }
        }
         if((board[0][0].getText()==board[1][1].getText())&&(board[1][1].getText()==board[2][2].getText())&& board[0][0].getText()!=""){
             for(int i=0;i<3;i++){
                 setWinner(board[i][i]);
             }
             gameOver=true;
             return;
         }
         if(board[0][2].getText()==board[1][1].getText() && board[1][1].getText()==board[2][0].getText() && board[0][2].getText()!=""){{
                 setWinner(board[0][2]);
                 setWinner(board[1][1]);
                 setWinner(board[2][0]);
             }
             gameOver=true;
             return;
         }
        if(turns==9){
            for(int r=0;r<3;r++){
                for(int c=0;c<3;c++){
                    setTie(board[r][c]);
                }
            }
            gameOver = true;
        }
        }
      void setWinner(JButton tile){
        tile.setForeground(new Color(148, 0, 211));
        tile.setBackground(new Color(199, 232, 216));
        textLabel.setText(currentPlayer + " WON!!");
          Timer blinkTimer = new Timer(500, new ActionListener() {
              boolean visible = true;
              public void actionPerformed(ActionEvent e) {
                  textLabel.setForeground(visible ? new Color(255, 20, 147) : Color.YELLOW);
                  visible = !visible;
              }
          });
          blinkTimer.start();
      }
    void setTie(JButton tile){
        tile.setForeground(new Color(255, 235, 240));
        tile.setBackground(new Color(255, 105, 180));
        textLabel.setText("It's a Tie!");
    }
}




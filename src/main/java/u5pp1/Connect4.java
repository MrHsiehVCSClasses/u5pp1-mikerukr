package u5pp1;

public class Connect4 {
//declarin instance variables
    public static final int RED_WIN = 0;
    public static final int BLACK_WIN = 1;
    public static final int NO_WINNER = 2;
    public static final int BOTH_WIN = 3;

    public static final int RED = 1;
    public static final int BLACK = -1;
    public static final int EMPTY = 0;
//return true if the entire board is occupied
   public static boolean isFull(int[][]board){
    for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[i].length;j++){
            if(board[i][j] == EMPTY){
                return false;
            }
        }
    }
    return true;
   }
//returns true if all pieces on board are grounded
public static boolean isBoardValid(int[][]board){
    for(int j = 0; j < board[0].length; j++){
        for(int i = 0; i < board.length;i++){
            boolean noSpace = false;
            if(i+1<6){
            noSpace=true;
            }if(noSpace && board[i+1][j]==EMPTY && (board[i][j]==RED|| board[i][j]==BLACK)){
                return false;
            }
        }
    }
    return true;
}
//Returns outcome of game whether someone won or no one did
public static int getWinner(int[][]board){
    boolean redWin=false;
    boolean blackWin=false;
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[i].length;j++){
            if(j+3>=7){
                return NO_WINNER;
            }
            if(board[i][j]==RED && board[i][j+1]==RED && board[i][+2]==RED && board[i][j+3]==RED){
                redWin=true;
            }
            if(board[i][j]==BLACK && board[i][j+1]==BLACK && board[i][+2]==BLACK && board[i][j+3]==BLACK){
                blackWin=true;
            }
        }
    }
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[i].length;j++){
            if(j+3>=7){
                return NO_WINNER;
            }
            if(board[i][j]==RED && board[i+1][j]==RED && board[i+2][j]==RED && board[i+3][j]==RED){
                redWin=true;
            }
            if(board[i][j]==BLACK && board[i+1][j]==BLACK && board[i+2][j]==BLACK && board[i+3][j]==BLACK){
                blackWin=true;
            }
        }
    }
    for (int i = 0;i < board.length;i++){
        for (int j= 0;j < board[i].length;j++){
            if (i+3>= 7||i+3 >= 6){
                return NO_WINNER;
            } 
            if (board[i][j] == RED && board [i + 1][j+ 1] == RED && board [i+ 2][j+ 2] == RED && board [i+ 3][j+ 3] == RED){
                redWin = true;
            }
            else if (board [i][j] == BLACK && board [i+ 1][j+ 1] == BLACK && board [i+ 2][j+ 2] == BLACK && board [i+ 3][j+ 3] == BLACK){
                blackWin = true;
            }
            if (i- 3 < 0 ||j+ 3 > 6){
                return NO_WINNER;
            }
            if (board [i][j] == RED && board [i- 1][j+ 1] == RED && board [i- 2][j+ 2] == RED && board [i- 3][j+ 3] == RED){
                redWin = true;
            }
            else if (board [i][j] == BLACK && board [i- 1][j+ 1] == BLACK && board [i- 2][j+ 2] == BLACK && board [i- 3][j+ 3] == BLACK){
                blackWin = true;
            }
        }
    }
    if(redWin==true && blackWin==true){
        return BOTH_WIN;
    }else if(redWin==true){
        return RED_WIN;
    }else if(blackWin==true){
        return BLACK_WIN;
    }else{
        return NO_WINNER;}
}
}

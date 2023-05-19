/**
 * This is the board class.
 * This is the 3 x 3 game-board for the Tic Tac Toe game.
 */
public class Board {
    private String[][] board = new String[][]{
            {"","",""},
            {"","",""},
            {"","",""}
    };

    /**
     * This method is used to make the new move on the board.
     * @param gridNum It is the number of grid going to be marked
     * @param sign It is the sign of the new move.
     */
    public void newMove(int gridNum, String sign){
        int n = gridNum;
        int y = n / 3;
        int x = n % 3;
        board[y][x] = sign;
    }

    /**
     * This method check whether the game is drawn.
     * @return The truth value of the game is drawn.
     */
    public boolean isDraw(){
        int count = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j].equals(""))
                    count++;
        return count == 0;
    }

    /**
     * This method check whether a player is won.
     * @param sign This represents the player.
     * @return The truth value of thw owner of the sign is won.
     */
    public boolean isWon(String sign){
        int count = 0;
        int i;
        int j;
        for (i = 0; i<3; i++){
            count = 0;
            for (j=0; j<3; j++) {
                if (board[i][j].equals(sign)) {
                    count++;
                }
            }
            if (count==3)
                return true;
        }
        for (i = 0; i<3; i++){
            count = 0;
            for (j=0; j<3; j++) {
                if (board[j][i].equals(sign)) {
                    count++;
                }
            }
            if (count==3)
                return true;
        }
        count = 0;
        for (i=0; i<3; i++){
            if (board[i][i].equals(sign))
                count++;
        }
        if (count==3)
            return true;
        count = 0;
        for (i=0; i<3; i++){
            if (board[i][2-i].equals(sign))
                count++;
        }
        if (count==3)
            return true;
        return false;
    }
}

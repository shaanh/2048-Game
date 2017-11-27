
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Shaan on 4/7/2017.
 */
public class TwentyFortyEight {
    //This instance variable represents the board. Use this to make changes.
    private int[][] board;
    //This variable keeps track of the current score.
    private int score;
    int boardWidth;
    int blank = 0;
    int numBlanks;
    Stack<int[][]> stack = new Stack<>();

    //Constructor
    public TwentyFortyEight(int boardWidth){
        this.boardWidth = boardWidth;
        this.board = new int[boardWidth][boardWidth];
        this.score = 0;
        placeRandom();
    }

    //This function resets the board to its initial state
    public void reset() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = blank;
            }
        }
        this.score = 0;
        placeRandom();
    }

   /* public void undo() {
        if (stack.size() > 1) {
            stack.pop();
            this.board = stack.peek();
        }
    } */

    //This function returns the total number of blank spaces on the board
    public int numBlanks() {
        numBlanks = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == blank) {
                    this.numBlanks++;
                }
            }
        }
        return this.numBlanks;
    }

    //This function places a 2 at a random blank space on the board.
    //It does nothing if there are no blank spaces.
    public void placeRandom(){
        Random random = new Random();
        if (numBlanks() > 0) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    int first = random.nextInt(board.length);
                    int second = random.nextInt(board[i].length);
                    if (board[first][second] == blank) {
                        board[first][second] = 2;
                        this.numBlanks--;
                        return;
                    }
                }
            }
        }

      /*  for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != blank) {
                    place = board[i][j];
                }
            }
        } */
    }

    //This function attempts to move a cell at coordinates fromRow,fromCol to
    //the cell toRow,toCol. Refer to the handout for movement rules.
    public boolean moveTo(int fromRow, int fromCol, int toRow, int toCol) {

        if (fromRow >= boardWidth || fromRow < 0 || toRow >= boardWidth || toRow < 0 || fromCol >=
                boardWidth || fromCol < 0 || toCol >= boardWidth || toCol < 0) {
            return false;
        }
        if (board[fromRow][fromCol] == blank) {
            return false;
        }
        if (((fromRow == toRow) && (fromCol == toCol + 1 || fromCol == toCol - 1)) ||
                ((fromCol == toCol) && (fromRow == toRow + 1 || fromRow == toRow - 1))) {
            if (board[toRow][toCol] == blank) {
                board[toRow][toCol] = board[fromRow][fromCol];
                board[fromRow][fromCol] = blank;
                return true;
            } else
            if (board[fromRow][fromCol] == board[toRow][toCol]) {
                board[toRow][toCol] = (board[toRow][toCol]) * 2;
                board[fromRow][fromCol] = blank;
                return true;
            }
        }
        return false;

    }

    //The following four functions move the board in a single direction.
    public boolean moveUp(){
        boolean checker = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (moveTo(i, j, i - 1, j)) {
                    checker = true;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > score) {
                    score = board[i][j];
                }
            }
        }

        if (checker) {
            return true;
        }
        stack.push(this.getBoard());
        return false;
    }

    public boolean moveDown() {
        boolean checker = false;
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (moveTo(i, j, i + 1, j)) {
                    checker = true;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > score) {
                    score = board[i][j];
                }
            }
        }

        if (checker) {
            return true;
        }
        stack.push(this.getBoard());
        return false;
    }

    public boolean moveRight() {
        boolean checker = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = board[i].length - 1; j >= 0; j--) {
                if (moveTo(i, j, i, j + 1)) {
                    checker = true;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > score) {
                    score = board[i][j];
                }
            }
        }

        if (checker) {
            return true;
        }
        stack.push(this.getBoard());
        return false;
    }

    public boolean moveLeft() {
        boolean checker = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (moveTo(i, j, i, j - 1)) {
                    checker = true;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > score) {
                    score = board[i][j];
                }
            }
        }

        if (checker) {
            return true;
        }
        stack.push(this.getBoard());
        return false;
    }

    ////////////////////////////////////////////////////////////////////////
    // Do not edit the methods below, they are for testing and running the
    // program.
    ////////////////////////////////////////////////////////////////////////
    public int[][] getBoard() {
        stack.push(this.board);
        return board;
    }

    public void setBoard(int[][] newBoard) {
        board = newBoard;
    }


    /**
     * The main will allow you to play the game.
     *
     * @param args
     */
    public static void main(String args[]) {
        TwentyFortyEight tfe = new TwentyFortyEight(4);


        Scanner s = new Scanner(System.in);
        int bestScore = 0;
        boolean resetFlag = false;

        while(true) {
            System.out.println("Current score: " + tfe.getScore() + " | Best score: " + bestScore);
            tfe.showBoard();

            System.out.println("Enter up, down, left or right to move in that direction.");
            System.out.println("Enter reset to reset the game or quit to exit.");
            String line = s.nextLine();

            switch(line){
                case "up":
                    while(tfe.moveUp()){
                        // do nothing
                    }
                    break;
                case "down":
                    while(tfe.moveDown()){
                        // do nothing
                    }
                    break;
                case "left":
                    while(tfe.moveLeft()){
                        // do nothing
                    }
                    break;
                case "right":
                    while(tfe.moveRight()){
                        // do nothing
                    }
                    break;
                case "reset":
                    tfe.reset();
                    resetFlag = true;
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("Invalid move, Please try again!!!!\n");
                    continue;

            }

            bestScore = Math.max(bestScore, tfe.getScore());
            if(!resetFlag) {
                tfe.placeRandom();
            }
            resetFlag = false;
        }
    }



    public void showBoard() {
        for(int x = 0; x < boardWidth * 6 + 1; x++){
            System.out.print("-");
        }
        System.out.println();

        for(int x = 0; x < boardWidth; x++) {
            for(int y = 0; y < boardWidth; y++) {
                String square = (board[x][y] == 0)? "":board[x][y] + "";
                System.out.printf("|%5s", square);
            }
            System.out.println("|");

            for(int y = 0; y < boardWidth * 6 + 1; y++){
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public int getScore() {

        return score;
    }

}


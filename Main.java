import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Creating an empty 3x3 array
        char [][] board = new char[3][3];
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner input = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.println("Player " + player + "'s turn");
            System.out.println("Enter row: ");
            int row = input.nextInt();
            System.out.println("Enter column: ");
            int column = input.nextInt();

            //Check if the space is available for input
            if (board[row][column] == ' '){
                board[row][column] = player; //Inputs 0s or Xs if the space is empty
                gameOver = gameWon(board, player);

                //Check win condition
                if(gameOver){
                    System.out.println("Player " + player + " has won!");
                } else{
                    //Change player
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else{
                System.out.println("Invalid move. Please try again!"); //Invalid input because the space contains a value
            }
        }
        printBoard(board);
    }

    public static boolean gameWon(char[][] board, char player){
        //Check for win by row
        for(int row = 0; row < board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        //Check for win by column
        for (int col = 0; col < board.length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        //Check for win by diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }

    //Prints Board
    public static void printBoard(char[][] board) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                System.out.print(" | " + board[row][col] + " | "); // Prints the value inside the space
            }
            System.out.println();
        }
    }
}
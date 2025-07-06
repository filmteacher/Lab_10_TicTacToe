import java.util.Scanner;

//TO-DO
//write partial tie logic
//write main method

/*
 *Lab 10
 *Two-player Tic Tac Toe game
 *@author matt.bennett@uc.edu
 */

//Create a java main class called TicTacToe. This file will have all the main logic for the game.
class TicTacToe
{
    //Within the class, before main() declare the board array and the constants that define it:
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args)
    {
        //Initialize variables
        int counter = 0;
        String player = "";
        Scanner in = new Scanner(System.in);
        int rowMove = 0;
        int colMove = 0;
        boolean valid = false;
        boolean won = false;
        boolean tied = false;
        boolean again = true;

        //Clear the board
        clearBoard();

        //Set move counter to 0
        counter = 0;

        //Set the player to X (since X always moves first)
        player = "X";

        //Show the board
        displayBoard();

        //do while loop that repeats until the user gives us coordinates for a cell with a space in it
        do
        {
            System.out.println("Player " + player + ", it's your turn.");
            //get the coordinates for the move which should be 1 – 3 for the row and col
            //These we can do with our getRangedInt() from simpleInput
            //convert the player move coordinates to the array indices which are 0 – 2 by subtracting 1
            rowMove = (SafeInput.getRangedInt(in, "Enter the row number for your move", 1, 3) - 1);
            colMove = (SafeInput.getRangedInt(in, "Enter the column number for your move", 1, 3) - 1);
            valid = isValidMove(rowMove, colMove);
        } while (valid == false); //Is the player's move legal?

        //record the valid move on the board
        //We set the cell to hold the user value of either X or O.
        //We store this in a variable called player
        board[rowMove][colMove] = player;

        //increment the move counter
        counter++;

        //Did the player's move end the game (WIN or TIE)?
        //Wins:
        //Can’t have a Win before move 4.
        //There are 8 ways to win ("win vectors"):
            //3 row wins
            //3 column wins
            //2 diagonal wins
        //We can make it more efficient by only testing for the wins that use the last move coordinates instead of exhaustively testing for every possible win for the given player
        //(Clearly, only the wins from the latest move need to be tested.)

        //if counter > 4 check for a win

        won = isWin(player);

        //Ties:
        //If we have 9 moves (which fills the board) and we don’t have a win, then we have a full board TIE.
            //So after checking for a win and not getting one, if we have 9 moves then the game is over with a full board tie.
        //If after 7 moves we have not filled the board but neither player can win
            //each of the 8 win vectors (row, col, diagonal) must be eliminated.
            //If a win vector contains both and X and an O, that vector is eliminated.
            //If all are eliminated then no win is possible even though we have open cells still.

        tied = isTie();

        //If there is a win or tie announce it and then prompt the players to play again or exit.
        if(won)
        {
            System.out.println("Player " + player + " wins!");
        }
        else if(tied)
        {
            System.out.println("It's a tie!");
        }

        again = SafeInput.getYNConfirm(in, "Would you like to play again?");

        //Toggle the player (i.e. X becomes O, O becomes X)
        //We store this in a variable called player
        if (player == "X")
        {
            player = "O";
        }
        else {
            player = "X";
        }

        //Outer do while loop for play again, inner do while loop for 1-8, then 3-4 in its own do while loop.
    }

    //7.The helper methods will all go in the main file in the class and after the main() method.

    //private static void clearBoard()
    //sets all the board elements to a space
    private static void clearBoard()
    {
        for(int r = 0; r < ROW; r++)
        {
            for(int c = 0; c < COL; c++)
            {
                board[r][c] = " "; // make this cell a space
            }
        }
    }

    //Write a method displayBoard() similar to clearBoard() that displays the board.
        //Include the separators for the cells (some students add rows of dashes to make it look nicer).
    //private static void displayBoard()
    //shows the Tic Tac Toe board used as part of the prompt for the user's move choice.
    private static void displayBoard()
    {
        System.out.println("-------------");
        for(int r = 0; r < ROW; r++)
        {
            for(int c = 0; c < COL; c++)
            {
                System.out.printf("|%3s", board[r][c]);
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

    //private static boolean isValidMove(int row, int col)
    //returns true if there is a space at the given proposed move coordinates which means it is a legal move.
    private static boolean isValidMove(int row, int col)
    {
        return board[row][col].equals(" ");
    }

    //private static boolean isWin(String player)
    //calls methods to check for a win for the current player.
    private static boolean isWin(String player)
    {
        if(isColWin(player) ||
                isRowWin(player) ||
                isDiagonalWin(player))
        {
            return true; // there is a win
        }
        return false; // there is no win
    }

    //private static boolean isTie()
    //calls methods to check for a tie
    private static boolean isTie()
    {
        if(isFullTie() ||
                isPartialTie())
        {
            return true; // there is a tie
        }
        return false; // there is no tie
    }

    // private static boolean isFullTie()
    // all spaces on the board are filled
    private static boolean isFullTie() {
        int occupied = 0;
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (!board[r][c].equals(" "))
                {
                    occupied++;
                }
            }
        }

        if (occupied == 9)
        {
            return true; // there is a full tie
        } else
        {
            return false; // no full tie
        }
    }

    // private static boolean isPartialTie()
    // there is an X and an O in every win vector (i.e. all possible 8 wins are blocked by having both and X and an O in them.)
    //private static boolean isPartialTie()
    //{
        //need partial tie logic to replace below
    //
                    //board[1][c].equals() &&
                    //board[2][c].equals())
            //{
                //return true; // there is a partial tie
            //}
        //}
        //return false; // no partial tie
    //}

    //private static boolean isColWin(String player)
    //checks for a col win for specified player
    //Given the code example for isRowWin() you should be easily able to code the isColWin().
    private static boolean isColWin(String player)
    {
        for(int c = 0; c < COL; c++)
        {
            if (board[0][c].equals(player) &&
                    board[1][c].equals(player) &&
                    board[2][c].equals(player))
            {
                return true; // there is a column win
            }
        }
        return false; // no col win
    }

    //private static boolean isRowWin(String player)
    //checks for a row win for the specified player
    private static boolean isRowWin(String player)
    {
        for(int r = 0; r < ROW; r++)
        {
            if(board[r][0].equals(player) &&
                    board[r][1].equals(player) &&
                    board[r][2].equals(player))
            {
                return true; // there is a row win
            }
        }
        return false; // no row win
    }

    //private static boolean isDiagonalWin(String player)
    //checks for a diagonal win for the specified player
    //For the isDiagonalWin() you hard code the coordinates for the diagonal cells.
    private static boolean isDiagonalWin(String player)
    {
        if(board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player))
        {
            return true;
        }
        else if(board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player))
        {
            return true; // there is a diagonal win
        }
        else
            return false; // no diagonal win

    }

    //9.Need screenshots:
    //X wins
    //O wins
    //2 different ties

}
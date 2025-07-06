

//TO-DO
//write full tie logic
//write partial tie logic
//write main method

/*
 *Lab 10
 *Two-player Tic Tac Toe game
 *@author matt.bennett@uc.edu
 */

//public static int getRangedInt(Scanner console, String prompt, int low, int high)
//public static boolean getYNConfirm(Scanner console, String prompt)
//int rowMove = SafeInput.getRangedInt(…);
//int colMove = SafeInput.getRangedInt(…);

//3.Now create a java main class called TicTacToe. This file will have all the main logic for the game.
class TicTacToe
{
    //6.Within the class, before main() declare the board array and the constants that define it:
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];
    //What data can each cell store?
    //An X or an O for a player move
    //A SPACE for an empty cell that is available for a move.

    public static void main(String[] args)
    {
        //Initialize variables
        int counter = 0;
        String player = "";

        //Clear the board
        clearBoard();

        //Set move counter to 0
        counter = 0;

        //Set the player to X (since X always moves first)
        player = "X";

        //Show the board
        displayBoard();

        //do while loop that repeats until the user gives us coordinates for a valid cell which is simply one that has not yet been used
        //get the coordinates for the move which should be 1 – 3 for the row and col
        //convert the player move coordinates to the array indices which are 0 – 2 by subtracting 1
        //Is the players move legal?
        //Did the players move end the game (TIE or WIN)

        //These we can do with our getRangedInt() from simpleInput
	    //How do we determine if a move is legal?
		//Has to be on the board.  board[0-2][0-2]
            //getRangedInt() does this and we reduce user coordinates 1-3 to indices 0-2 by subtracting 1.
		//Must be an unused cell on the board
            //i.e. board[row][col] contains a SPACE
        //private static boolean isValidMove(int row, int col) // returns true if there is a space at the given proposed move coordinates
        //loop until the converted player coordinates are a valid move which is an empty space on the board

        //record the valid move on the board
        //We set the cell to hold the user value of either X or O.
        //We store this in a variable called player

        //increment the move counter

        //if appropriate check for a win or a tie (i.e. if it is possible for a win or a tie at this point in the game, check for it.)
        //Wins:
        //Can’t have a Win before move 4.
        //X, O, X, O, X is the shortest possible win move sequence.
        //So for efficiency we only check for a win after move 5
        //There are 8 ways to win ("win vectors"):
            //3 row wins
            //3 column wins
            //2 diagonal wins
        //We can make it more efficient by only testing for the wins that use the last move coordinates instead of exhaustively testing for every possible win for the given player
        //(Clearly, only the wins from the latest move need to be tested.)

        //Ties:
        //If we have 9 moves (which fills the board) and we don’t have a win, then we have a full board TIE.
            //So after checking for a win and not getting one, if we have 9 moves then the game is over with a full board tie.
        //If after 7 moves we have not filled the board but neither player can win
            //each of the 8 win vectors (row, col, diagonal) must be eliminated.
            //If a win vector contains both and X and an O, that vector is eliminated.
            //If all are eliminated then no win is possible even though we have open cells still.

        //If there is a win or tie announce it and then prompt the players to play again or exit.

        //Toggle the player (i.e. X becomes O, O becomes X)
        //We store this in a variable called player

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
    /*private static boolean isWin(String player)
    {
        if(isColWin(player) ||
                isRowWin(player) ||
                isDiagonalWin(player))
        {
            return true;
        }
        return false; // there is no win
    }*/

    //private static boolean isTie()
    //calls methods to check for a tie
    /*private static boolean isTie()
    {
        if(isFullTie() ||
                isPartialTie())
        {
            return true; // there is a tie
        }
        return false; // there is no tie
    }*/

    // private static boolean isFullTie()
    // all spaces on the board are filled
    //private static boolean isFullTie()
    //{
        //need full tie logic to replace below
        //for(int c = 0; c < COL; c++)
        //{
            //if (board[0][c].equals() &&
                    //board[1][c].equals() &&
                    //board[2][c].equals())
            //{
               //return true; // there is a full tie
            //}
        //}
        //return false; // no full tie
    //}

    // private static boolean isPartialTie()
    // there is an X and an O in every win vector (i.e. all possible 8 wins are blocked by having both and X and an O in them.)
    //private static boolean isPartialTie()
    //{
        //need partial tie logic to replace below
        //for(int c = 0; c < COL; c++)
        //{
            //if (board[0][c].equals() &&
                    //board[1][c].equals() &&
                    //board[2][c].equals())
            //{
                //return true; // there is a partial tie
            //}
        //}
        //return false; // no partial tie
    //}

    //private static boolean isColWin(String player) // checks for a col win for specified player
    //Given the code example for isRowWin() you should be easily able to code the isColWin().
    private static boolean isColWin(String player)
    {
        for( int c = 0; c < COL; c++)
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

    //private static boolean isRowWin(String player) // checks for a row win for the specified player
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

    //private static boolean isDiagonalWin(String player) // checks for a diagonal win for the specified player
    //For the isDiagonalWin() you hard code the coordinates for the diagonal cells.
    private static boolean isDiagonalWin(String player)
    {
        if (board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player))
        {
            return true;
        }
        else  if (board[0][2].equals(player) &&
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
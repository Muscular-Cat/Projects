public class TicTacToe
{
   private int turn = 0;
    public String[][] board;
   
    public TicTacToe()
    {
        board = new String[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
    }
    public int getTurn()
    {
         return turn % 2;
    }
   
   public void printBoard()
   {
       System.out.println("  0 1 2");
       
       for(int i = 0; i < board.length; i++)
       {
           System.out.print(i + " ");
           for(int x = 0; x < board[i].length; x++)
           {
               System.out.print(board[i][x] + " ");
           }
           System.out.println();
       }
   }
   
   public boolean pickLocation(int row, int col)
   {
       if(board[row][col] == "-")
       {
           return true;
       } else {
           return false;
       }
   }
   
   public void takeTurn(int row, int col)
   {
       if(turn % 2 == 0)
       {
           board[row][col] = "X";
       } else {
           board[row][col] = "O";
       }
       turn++;
   }
   

   public boolean checkRow()
   {
       boolean row = false;
       for(int i = 0; i < board.length; i++)
       {
           if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][1] != "-")
           {
               row = true;
               System.out.println("Row Match");
           }
       }
       return row;
   }
   

   public boolean checkCol()
   {
       boolean col = false;
       for(int i = 0; i < board.length; i++)
       {
           if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[1][i] != "-")
           {
               col = true;
               System.out.println("Column Match");
           }
       }
       return col;
   }
   

   public boolean checkDiag()
   {
       boolean dia = false;
       if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != "-" || board[0][2] == board[1][1] && board[1][1] == board[0][2] && board[1][1] != "-")
       {
           dia = true;
           System.out.println("Diagonal Match");
       }
       return dia;
   }
   
   public boolean checkWin()
   {
       if(checkCol() || checkRow() || checkDiag())
       {
           return true;
       } else {
           return false;
       }
   }

}

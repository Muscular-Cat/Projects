import java.util.Scanner;

public class TicTacToeGame
{
    public static void main(String[] args)
    {
        Scanner place = new Scanner(System.in);
        TicTacToe tic = new TicTacToe();
        
        while(!tic.checkCol() && !tic.checkRow() && !tic.checkDiag())
        {
            tic.printBoard();
            System.out.println("Player " + (tic.getTurn() + 1) + " type the row then column");
            int p1 = place.nextInt();
            int p2 = place.nextInt();
            if(tic.pickLocation(p1, p2))
            {
                tic.takeTurn(p1, p2);
            } else {
                while(!tic.pickLocation(p1, p2))
                {
                    System.out.println("Place is taken, try again");
                    p1 = place.nextInt();
                    p2 = place.nextInt();
                }
                tic.takeTurn(p1, p2);
            }
        }
        System.out.println("WINNER!!!");
        tic.printBoard();
    }
}

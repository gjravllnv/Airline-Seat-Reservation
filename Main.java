import java.util.*;

public class Main
{
    public static void main(String args[]) 
	{
		char[][] plane_seats = new char[20][4];
           for (int i = 0; i < 20; i++) {
            plane_seats[i][0] = 'A';
            plane_seats[i][1] = 'B';
            plane_seats[i][2] = 'C';
            plane_seats[i][3] = 'D';
        }
		Scanner input = new Scanner(System.in);
		String decision = "y";
		while (decision.equals("y") ||decision.equals("Y")&& !filledSeats( plane_seats)) 
		{

      System.out.println(" WELCOME TO NCF AIRLINE SEAT RESERVATION  ") ;
            
			displaySeats( plane_seats);
			System.out.print("Enter your airline seat reservation(e.g 2A): ");
			boolean okSeat = false;
			while (okSeat == false) {
			String seat = input.nextLine();
			int r = findRowSeat(seat);
			int c = findColumnSeat(seat);
				if ( plane_seats[r][c] == 'X')
		        System.out.println("Sorry, seat is already reserved, enter a different seat:");
				else {
					 plane_seats[r][c] = 'X';
					okSeat = true;
				}
			}
			System.out.print("Still Continue ? (y/n)");
			decision = input.nextLine();
		}
		   System.out.println("Cancel Seat Reservation");
	}
	
	public static boolean filledSeats(char[][]  plane_seats)
	{
		for (int i = 0; i <  plane_seats.length; i++) 
		{
			for (int j = 0; j <  plane_seats[0].length; j++) 
			{
				if ( plane_seats[i][j] != 'X')
					return false;
			}
		}
		return true;
	}

	public static int findRowSeat(String numSeat) 
         {
		char rowChar = numSeat.charAt(0);
		return (int) rowChar  - 48 - 1;
	}

	public static int findColumnSeat(String numSeat)
          {
		char colChar = numSeat.charAt(1);
		if (colChar == 'A')
			return 0;
		else if (colChar == 'B')
			return 1;
		else if (colChar == 'C')
			return 2;
		else if (colChar == 'D')
			return 3;
		else
			return 1;
	}

    public static void displaySeats(char[][] plane_seats) {
		for (int i = 0; i < plane_seats.length; i++) {

			System.out.print((i + 1) + " ");
			for (int j = 0; j < plane_seats[0].length; j++) {
				System.out.print(plane_seats[i][j] + " ");
		
				if (j == 1)
					System.out.print(" ");
			}

			System.out.println();
		}
	}
}

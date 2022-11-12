package Model;
import java.io.Serializable;

/**
  Represents a seat layout in the cinema.
  Each cinema will have a seat layout
  @author Emmelyn Kek 
  @version 2.0
  @since 2022-10-11
 */

public class SeatLayout implements Serializable{

    /** 
     * The number of columns of seats 
     */
    private int column; 
    /** 
     * The number of rows of seats 
     */
    private int row; 

    /** 
     * The set of seats in a cinema
     */
    private Seat[][] seats; 

    /** 
     * Creates a new set of seats of 10 rows and 10 columns
     * Seats are initialised to be available 
     */
    public SeatLayout(){ //default constructor
		row = 10;
		column = 10;
		seats = new Seat[row][column];
		initializeSeat();
	}


    /** 
     * Creates a new set of seats of of a certain number of rows and columns
     * Seats are initialised to be available 
     * @param row The number of rows of seats 
     * @param column The number of columns of seats
     */
    public SeatLayout(int row, int col) {
		this.row = row;
		this.column = col;
        seats = new Seat[row][column];
		initializeSeat();
	}

    /** 
     * Initialises all seats to be available 
     */
    private void initializeSeat() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				seats[i][j] = new Seat(true);
			}
		}
	}

    /** 
     * Shows seat layout in cinema 
     * Prints out row and column number
     * Labels seats in row 7 and 8 as premium seats
     */
    public void getSeatlayout(){ 
        System.out.println();
        System.out.println("Cinema:");
        System.out.println("    ----------------------Screen----------------------    ");
        System.out.println();

      
        System.out.print("   ");

        for (int i = 0; i < column; i++) {
            if(i==5){ 
                System.out.print("    " + (i+1) + "  ");

            }else{
            System.out.print("  " + (i+1) + "  ");}
        }

        System.out.println();

        for (int i = 0; i < row; i++) { 
            if(i != 9){ 
                System.out.print(i+1 + "   "); 

            }
            else{ 
                System.out.print(i+1 + "  "); 

            }

            if (i ==6 || i ==7 ){ 

                for (int j = 0; j < column ; j++) {
               
                    if (seats[i][j].getAvailable() == true){ 
                       if(j==4){ 
                        System.out.print("( )" + "    "); 
                       }else{ 
                        System.out.print("( )" + "  ");
                       }

                    }else{ 
                        if(j==4){ 
                            System.out.print("(x)" + "    ");
                        }
                        else {System.out.print("(x)" + "  ");} 
                    }     
                }
                System.out.println();
            }

            else if (i ==8 || i ==9 ){ 

                for (int j = 0; j < column ; j++) {
               
                    if (seats[i][j].getAvailable() == true){ 
                       if(j==4){ 
                        System.out.print("{ }" + "    "); 
                       }else{ 
                        System.out.print("{ }" + "  ");
                       }

                    }else{ 
                        if(j==4){ 
                            System.out.print("{x}" + "    ");
                        }
                        else {System.out.print("{x}" + "  ");} 
                    }     
                }
                System.out.println();
            }

            else {
            for (int j = 0; j < column ; j++) {
               
                if (seats[i][j].getAvailable() == true){ 
                   if(j==4){ 
                    System.out.print("[ ]" + "    ");
                   }else{ 
                    System.out.print("[ ]" + "  ");
                   }
                    
                }else{ 
                    if(j==4){ 
                        System.out.print("[x]" + "    ");
                    }
                    else {System.out.print("[x]" + "  ");} 
                }
            }
            System.out.println();
        }
        }
        System.out.println();
        System.out.println("                        |Entrance|                           ");
        System.out.println("-------------------------------------------------------------");
        System.out.println("LEGEND:");
        System.out.println("( ): premium seats");
        System.out.println("[ ]: standard seats");
        System.out.println("{ }: couple seats");
        System.out.println("(x) / [x] / {x}: booked seats");
        System.out.println();
    }


    /** 
     * Changes the availability of the seat
     * @param availability This seat's new availability
     * @param row The row the seat is located at
     * @param col The column the seat is located at
     */
	public void setSeatavailability(int row, int col, boolean available) {
		seats[row-1][col-1].setAvailable(available);
	}

    /** 
     * Gets the availability of the seat at a particular row and column
     * @return This seat's availability 
     */
    public boolean getSeatavailability(int row, int col) {
		return seats[row-1][col-1].getAvailable();
	}

    /** 
     * Sets the number of rows of seats 
     * @param row The rows of seats 
     */
    public void setRow(int row ) {
		this.row = row;
	}

    /** 
     * Sets the number of columns of seats 
     * @param column The columns of seats 
     */
	public void setColumn(int column) {
		this.column= column;
	}

    /** 
     * Gets the number of rows of seats 
     * @return The rows of seats 
     */
	public int getRow() {
		return row;
	}

    /** 
     * Gets the number of columns of seats 
     * @return The columns of seats 
     */
	public int getColumn() {
		return column;
	}

    /** 
     * Checks if the seats are fully booked 
     * @return Whether the seats are fully booked  
     */
    public boolean isFull() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (seats[i][j].getAvailable() == true) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){

        SeatLayout sl = new SeatLayout(); 
        sl.getSeatlayout();


    } 
}

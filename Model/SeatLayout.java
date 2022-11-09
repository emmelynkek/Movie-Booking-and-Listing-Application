package Model;
import java.io.Serializable;

public class SeatLayout implements Serializable{
    private int column; 
    private int row; 

    private Seat[][] seats; 


    public SeatLayout(){ //default constructor
		row = 10;
		column = 10;
		seats = new Seat[row][column];
		initializeSeat();
	}

    public SeatLayout(int row, int col) {
		this.row = row;
		this.column = col;
        seats = new Seat[row][column];
		initializeSeat();
	}


    private void initializeSeat() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				seats[i][j] = new Seat(true);
			}
		}
	}


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

        for (int i = 0; i < row; i++) { //for each row
            if(i != 9){ 
                System.out.print(i+1 + "   "); //if one digit row, just add two spacings

            }
            else{ 
                System.out.print(i+1 + "  "); //if two digit rows, add one spacing

            }

            if (i ==3 || i ==4 ){ //premium for rows 4 and 5 

                for (int j = 0; j < column ; j++) {
               
                    if (seats[i][j].getAvailable() == true){ 
                       if(j==4){ //for i col 5, add two spacings after
                        
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

            else {

            for (int j = 0; j < column ; j++) {
               
                if (seats[i][j].getAvailable() == true){ 
                   if(j==4){ //for i col 5, add two spacings after
                    
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


    }


	public void setSeatavailability(int row, int col, boolean available) {
		seats[row-1][col-1].setAvailable(available);
	}

    public boolean getSeatavailability(int row, int col) {
		return seats[row-1][col-1].getAvailable();
	}


    public void setRow(int row ) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column= column;
	}


	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

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


    // public static void main(String[] args){
    //     //testing methods

    //     // SeatLayout s = new SeatLayout(); 
    //     SeatLayout s = new SeatLayout();
    //     s.setSeatavailability(5, 5, false); //booking seat
    //     System.out.println(s.getSeatavailability(5, 5)); //shd return false when booked 
    //     System.out.println(s.getSeatavailability(4, 4)); //shd return true 
    //     s.getSeatlayout();
       
    // }
}
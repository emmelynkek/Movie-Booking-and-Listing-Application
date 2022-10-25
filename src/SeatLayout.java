public class SeatLayout {
    private int column; 
    private int row; 

    private Seat[][] seats; 


    public SeatLayout(){ //default constructor
		row = 9;
		column = 9;
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

      
        System.out.print(" ");

        for (int i = 0; i < column; i++) {
            System.out.print(" " + (i+1) + " ");
        }

        System.out.println();

        for (int i = 0; i < row; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < column ; j++) {
                if (seats[i][j].getAvailable() == true){ 
                    System.out.print('N' + "  ");
                    
                }else{ 
                    System.out.print('B' + "  ");
                }


                
            }
            System.out.println();
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


    public static void main(String[] args){
        //testing methods

        // SeatLayout s = new SeatLayout(); 
        SeatLayout s = new SeatLayout(5,5);
        s.setSeatavailability(5, 5, false); //booking seat
        System.out.println(s.getSeatavailability(5, 5)); //shd return false when booked 
        System.out.println(s.getSeatavailability(4, 4)); //shd return true 
        s.getSeatlayout();
       
    }
}

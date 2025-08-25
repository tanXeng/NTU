package Lab3;

public class PlaneSeat {
    // features
    private int seatID;
    private boolean assigned = false;
    private int customerId = -1; // set to an invalid id first

    // methods
    public PlaneSeat(int seat_id) {
        // class contructor
        seatID = seat_id;
    }

    public int getSeatID() {
        // a get method that returns the seat number.
        return seatID; 
    }

    public int getCustomerID() {
        //a get method that returns the customer number.
        return customerId;
    }

    public boolean isOccupied() {
       // a method that returns a boolean on whether the seat is occupied.
       return assigned;
    }

    public void assign(int cust_id){
        // a method that assigns a seat to a customer..
        customerId = cust_id;
        assigned = true;
    }   

    public void unAssign() {
        // a method that unassigns a seat.
        customerId = -1; // set customerId to some invalid id
        assigned = false;
    }
}
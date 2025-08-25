package Lab3;
import java.util.Arrays;

import Lab3.PlaneSeat;

/* TODO:
 * 1. create 12 PlaneSeat objects and assign them into the array in the constructor
 * 2. update numEmptySeat when assigning/unassigning (done)
 * 3. initialize empty seats properly
*/ 

public class Plane {
    // features
    private int maxNumSeats = 12;
    private PlaneSeat[] seat = new PlaneSeat[maxNumSeats];
    private int numEmptySeat = maxNumSeats; 

    // methods
    public Plane() {
        // a constructor for the class Plane.
        for (int i = 0; i < seat.length; i++) {
            seat[i] = new PlaneSeat(i + 1);
        }
    }

    private PlaneSeat[] sortSeats(boolean bySeatId) {
        // a method to sort the seats according to ascending order of customerID.
        PlaneSeat[] planeSeatsClone = seat.clone(); // a copy of the original seat array is used for sorting instead of the original.
        if (bySeatId) {
            Arrays.sort(planeSeatsClone, (a, b) -> Integer.compare(a.getSeatID(), b.getSeatID())); // use an anon function for this as it is an attr we want to sort
        } else {
            Arrays.sort(planeSeatsClone, (a, b) -> Integer.compare(a.getCustomerID(), b.getCustomerID())); // use an anon function for this as it is an attr we want to sort
        }
        return planeSeatsClone;
    }

    public void showNumEmptySeats() {
        // a method to display the number of empty seats.
        System.out.println("There are " + numEmptySeat + " empty seats.");
    }

    public void showEmptySeats() {
        // a method to display the list of empty seats.   
        PlaneSeat[] planeSeatsClone = sortSeats(true);
        PlaneSeat currentSeat; 
        boolean planeEmpty = true; 
        if (numEmptySeat > 0) { // check if there are any empty seats
            System.out.println("The following seats are empty: ");
        } else {
            System.out.println("The flight is fully booked!\n");
        }
        for (int i = 0; i < planeSeatsClone.length; i++) { // iterate through the seats to check if the are occupied
            currentSeat = planeSeatsClone[i];
            if (!currentSeat.isOccupied()) { // display the seat id and its corresponding customer id if the seat is empty
                System.out.println("    SeatID " + currentSeat.getSeatID());;
                planeEmpty = false; // set this flag to false
            }
            if (planeEmpty) System.out.println("There are no occupied seats!"); // display this message when the plane is empty
        }
    }

    public void showAssignedSeats(boolean bySeatId) {
        //  a method to display the assigned seats with seat ID and customer ID.
        // If bySeatId is true, the order will be by seatID, else order is by
        // customerID.
        PlaneSeat currentSeat;
        PlaneSeat[] seatClone = sortSeats(bySeatId); // sort accordingly
        if (numEmptySeat < maxNumSeats) { // check if there are even any customers assigned
            System.out.println("The seat assignments are as follow:");
        } else {
            System.out.println("There are currently no customersIDs assigned to any seat.\n");
        }
        for (int i = 0; i < seatClone.length; i++) { // iterate through the seats to display the required information
            currentSeat = seatClone[i];
            if (currentSeat.isOccupied()) {
                System.out.println("    SeatID " + currentSeat.getSeatID() + " assigned to CustomerID " + currentSeat.getCustomerID());
            }
        }
    }

    public void assignSeat(int seatId, int cust_id) {
        // a method that assigns a customer ID to an empty seat.
        for (int i = 0; i < seat.length; i++) { // iterate through the seats to find the seat with seatId
            if (seat[i].getSeatID() == seatId) {
                if (seat[i].isOccupied()) { // ensure that the seat is not already occupied before assignment
                    System.out.println("Seat already assigned to a customer.");
                } else {
                    seat[i].assign(cust_id); // assign the seat
                    numEmptySeat--; // update numEmptySeat
                    System.out.println("Seat Assigned!");
                }
            }        
        }
    }

    public void unAssignSeat(int seatId) {
        // a method that unassigns a seat.
        for (int i = 0; i < seat.length; i++) { // iterate through the seats to find the seat with seatId
            if ((seat[i].getSeatID() == seatId) && (seat[i].isOccupied())) { // check for the correct seat and check that it is unoccupied 
                seat[i].unAssign(); // unassign the seat with seatId
                numEmptySeat++; // update numEmptySeat
                System.out.println("Seat Unassigned!");
            }
        }
    }
}

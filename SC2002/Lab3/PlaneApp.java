package Lab3;

import java.util.Scanner;

import Lab3.Plane;
public class PlaneApp {
public static void main(String[] args)
{
int choice;
int seatID, customerId;
Plane plane = new Plane();
Scanner sc = new Scanner(System.in);
do {
System.out.println("Enter the number of your choice:");
System.out.println("    (1) Show the number of empty seats");
System.out.println("    (2) Show the list of empty seats");
System.out.println("    (3) Show the list of customers together with their seat numbers in the order of the seat numbers");
System.out.println("    (4) Show the list of customers together with their seat numbers in the order of the customer ID");
System.out.println("    (5) Assign a customer to a seat");
System.out.println("    (6) Remove a seat assignment");
System.out.println("    (7) Quit");
choice = sc.nextInt();
if (choice > 7) System.out.println("\nPlease choose one of the valid options!\n");
switch (choice) {
case 1: /* show number of empty seats */
plane.showNumEmptySeats();
break;
case 2: /* show the list of empty seats */
plane.showEmptySeats();
break;
case 3: /* show the list of seat assignments by seat ID */
plane.showAssignedSeats(true);
break;
case 4: /* show the list of seat assignments by customer ID */
plane.showAssignedSeats(false);
break;
case 5: /* assign a customer to a seat */
System.out.println("Assigning Seat ..");
System.out.println("    Please enter SeatID: ");
seatID = sc.nextInt(); // get the user inputted seat id
System.out.println("    Please enter Customer ID: ");
customerId = sc.nextInt(); // get the user inputted customer id

plane.assignSeat(seatID, customerId); // assigning the seat
break;
case 6: /* remove a seat assignment */
System.out.println("Enter SeatID to unassign customer from: ");
seatID = sc.nextInt();
plane.unAssignSeat(seatID);
break;
case 7: System.out.println("Program terminating ….");
}
} while (choice != 7);
sc.close();
}
}
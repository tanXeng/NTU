import java.util.Scanner; // import the Scanner

public class P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);  // initialize the scanner
        System.out.print("Salary: ");
        int salary = sc.nextInt();  // take the user inputted int
        System.out.print("Merit: ");
        int merit = sc.nextInt(); // initialize the scanner

        String grade = "";

        if (salary >= 700 && salary <= 899) {
            // check if in grade A range
            if (salary <= 799) {
                // special condition for being in grade B
                grade = (merit < 20) ? "B" : "A";
            } else {
                grade = "A";
            }
        } else if (salary >= 600 && salary <= 699) {
            // check if in grade B range
            if (salary <= 649) {
                // special condition for being in grade C
                grade = (merit < 10) ? "C" : "B";
            } else {
                grade = "B";
            }
        } else if (salary >= 500 && salary < 600) {
            // check if in grade C range
            grade = "C";
        } else {
            grade = "Invalid salary range";
        }

        System.out.println("You are in grade " + grade + "!");
        sc.close(); // close the scanner
    }
}

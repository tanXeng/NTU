import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // initialize the scanner
        System.out.println("Starting: ");
        int starting = sc.nextInt(); // take user inputted int as starting
        System.out.println("Ending: ");
        int ending = sc.nextInt(); // take user inputted int as ending

        // error for the case where ending < starting
        if (ending < starting) {
            System.err.println("Error input!!");
            System.exit(1);// exit with a non-zero status code
        }

        System.out.println("Increment: ");
        int increment = sc.nextInt(); // take user inputted int as increment
        double SGD = 0; // initialize SGD to 0 first

        // for loop solution
        System.out.println("US$         S$\n--------------");
        for (int i = starting; i < ending; i += increment){
            SGD = i * 1.82; // convert to SGD
            System.out.println(i + "           " + SGD); // print the conversion
        }
        SGD = ending * 1.82;  // convert ending 
        System.out.println(ending + "           " + SGD); // print the conversion for ending

        System.out.println("\n");

        // while loop solution
        int i = starting; // initialize i for the while loop
        System.out.println("US$         S$\n--------------");
        while (i < ending) {
            SGD = i * 1.82; // convert to SGD
            System.out.println(i + "           " + SGD); // print the conversion
            i += increment;
        }
        SGD = ending * 1.82;  // convert ending 
        System.out.println(ending + "           " + SGD); // print the conversion for ending

        System.out.println("\n");

        // do\while loop
        i = starting; // reset i for the do/while loop
        System.out.println("US$         S$\n--------------");
        do {
            SGD = i * 1.82; // convert to SGD
            System.out.println(i + "           " + SGD); // print the conversion
            i += increment;
        } while (i < ending);
        if (starting != ending) { // do/while always executes at least once so if starting == ending, it will print the same thing twice
            SGD = ending * 1.82; // convert ending 
            System.out.println(ending + "           " + SGD); // print the conversion for ending
        }
        sc.close(); // close the scanner
    }
}

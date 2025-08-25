import java.util.Scanner; // import the Scanner

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // initialize the scanner
        System.out.println("Enter a char:"); 

        char choice = sc.next().charAt(0); // take the char at index 0 of the user inputted string

        switch(Character.toLowerCase(choice)) { 
            // switch statement
            case 'a': 
                // run if user input was 'a'
                System.out.println("Action movie fan\n"); 
                break;
            case 'c':
                // run if user input was 'c'
                System.out.println("Comedy movie fan\n");
                break;
            case 'd':
                // run if user input was 'd'
                System.out.println("Drama movie fan\n");
                break;
            default:
                // run if user input was not 'a', 'b', or 'c'
                System.out.println("Invalid choice\n");
            }
        sc.close(); // close the scanner
    }
}
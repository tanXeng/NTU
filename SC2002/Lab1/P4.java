import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // initialize a scanner
        System.out.println("Height: ");
        int height = sc.nextInt(); // take user inputted int as the height
        String pattern = ""; // initialize pattern as an empty string that we will append to

        // error for the case where height == 0
        if (height == 0) {
            System.err.println("Error input!!");
            System.exit(1); // exit with a non-zero status code
        }

        // for loop for printing the pattern
        for (int i = 0; i < height; i++) {
            if (i%2 == 0) {
                pattern = "AA" + pattern; // append "AA" to the left if i is even
            } else {
                pattern = "BB" + pattern; // append "BB" to the left if i is odd
            }
            System.out.println(pattern); // print the pattern
        }

        sc.close(); // close the scanner
    }
}
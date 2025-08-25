package Lab2;

import java.util.Scanner;
public class Lab2p1 {
public static void main(String[] args)
{
int choice;
Scanner sc = new Scanner(System.in);
do {
System.out.println("Perform the following methods:");
System.out.println("1: multiplication test");
System.out.println("2: quotient using division by subtraction");
System.out.println("3: remainder using division by subtraction");
System.out.println("4: count the number of digits");
System.out.println("5: position of a digit");
System.out.println("6: extract all odd digits");
System.out.println("7: quit");
choice = sc.nextInt();
int m, n, digit;
switch (choice) {
case 1: mulTest(sc);
break;
case 2: 
System.out.print("m: ");
m = sc.nextInt();
System.out.print("n: ");
n = sc.nextInt();
System.out.println("\nThe answer is " + divide(m, n) + "!\n");
break;
case 3:
System.out.print("m: ");
m = sc.nextInt();
System.out.print("n: ");
n = sc.nextInt();
System.out.println("\nThe answer is " + modulus(m, n) + "!\n");
break;
case 4:
System.out.print("n: ");
n = sc.nextInt();
if (countDigits(n) > 0) System.out.println("\nThere are " + countDigits(n) + " digits!\n");
break;
case 5:
System.out.print("n: ");
n = sc.nextInt();
System.out.print("digit: ");
digit = sc.nextInt();
System.out.println("The position is " + position(n, digit) + "\n");
break;
case 6:
System.out.print("n: ");
n = sc.nextInt();
if (extractOddDigits((long) n) > -2) System.out.println("\nOdd digits extracted: " + extractOddDigits((long) n) + "\n");
break;
case 7: System.out.println("Program terminating ….");
}
} while (choice < 7);
}

// method to test students ability to do multiplication
public static void mulTest(Scanner sc) {
    int score = 0;

    // for loop to ask 5 questions
    for (int i = 0; i < 5; i++) {
        int num_1 = (int) (Math.random() * 10);
        int num_2 = (int) (Math.random() * 10);
        int product = num_1 * num_2;
        System.out.print(String.format("How much is %d times %d? ", num_1, num_2));
        int user_answer = sc.nextInt();
        System.out.print("\n");

        if (user_answer == product) score++;
    }
    System.out.println(String.format("%d answers out of 5 are correct.\n", score));
}

// method which does division by subtraction and returns the quotient
public static int divide(int m, int n) {
    int quotient = 0;
    while (m >= n) {
        m -= n;
        quotient++;
    }
    return quotient;
}

// method which does division by subtraction and returns the remainder
public static int modulus(int m, int n) {
    while (m >= n) {
        m -= n;
    }
    return m;
}

// method which counts the digits in a positive integer
public static int countDigits(int n) {
    // error if n < 0
    if (n < 0) {
        System.err.println("Error input!!\n");
        return -1; // return -1 if the input was not positive
    } else if (n == 0){
        return 1; // handle the special case where n is 0
    } else {
        return (int) Math.log10(n) + 1; // simply return the ceil of the log of n base 10
    }
}

// method to find the first appearance of a specified digit in a positive number n, starting from the right
public static int position(int n, int digit) {
    String stringn = String.valueOf(n); // convert n into a string so we can iterate through it
    String stringDigit; // initialize stringDigit for later use in the for loop

    // for loop to iterate through the digits in stringn starting from the right
    for (int i = stringn.length() - 1; i >= 0; i--) {
        stringDigit = String.valueOf(stringn.charAt(i)); // converting the char to a string so we can use parseInt
        if (digit == Integer.parseInt(stringDigit)) return stringn.length() - i; // return the position 
    }
    return -1; // return -1 if digit is not found
}

// method which extracts the odd digits from a number to form a new number
public static long extractOddDigits(long n) {
    // Error for n < 0
    if (n < 0) { 
        System.err.println("Error input!!\n");
        return -2;
    }
    String stringn = String.valueOf(n); // convert n into a string so we can iterate through it
    String digit; // initialize digit for use inside the for loop
    String sol = ""; // initialize sol which we will append odd digits to

    // for loop to iterate through the digits in stringn
    for (int i = 0; i < stringn.length(); i++) {
        digit = String.valueOf(stringn.charAt(i)); // ensure that the char is converted into a string so we can use Long.parse(digit)
        if (Long.parseLong(digit) % 2 == 1) { // if odd, append the digit to sol
            sol += digit;
        };
    }

    if (sol == "") return (long) -1; // check for the case where there are no odd digits
    return Long.parseLong(sol); // return sol as a long
} 
}
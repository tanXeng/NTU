package Lab4;

import java.util.Scanner;
public class Numbers
{
// --------------------------------------------
// Reads in an array of integers, sorts them,
// then prints them in sorted order.
// --------------------------------------------
public static void main(String[] args)
{
	// int[] intList;
	Integer[] intList;
	int size;
	Scanner scan = new Scanner(System.in);
	System.out.print ("\nHow many integers do you want to sort? ");
	size = scan.nextInt();
	// intList = new int[size];
	intList = new Integer[size]; // Changes made here
	System.out.println ("\nEnter the numbers...");
	for (int i = 0; i < size; i++)
		// intList[i] = scan.nextInt();
		intList[i] = Integer.valueOf(scan.nextInt()); // Changes made here
		// Sorting.selectionSort(intList);
		Sorting.insertionSort(intList); // Changes made here
		System.out.println ("\nYour numbers in sorted order...");
	for (int i = 0; i < size; i++)
		System.out.print(intList[i] + " ");
	System.out.println ();
	}
}
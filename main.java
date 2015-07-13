package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //ask user for string input & convert it into a char array (myArray)
        System.out.println("Please enter a string in uppercase: ");
        Scanner scanner = new Scanner(System.in);
        String myString = scanner.nextLine();
        char[] myArray = myString.toCharArray();

        int leftSum, rightSum; //left & right sums would equal if word is balance
        int leftCounter, rightCounter; //counters are multipliers for int values of letters

        for (int i=1; i < myArray.length; i++) {
            //initialize sums & counters
            leftSum = rightSum = 0;
            leftCounter = rightCounter = 1;

            //calculate leftSum
            for (int j=i; j > 0; j--) {
                leftSum += ((int) myArray[j-1] - 64) * leftCounter;
                leftCounter++;
            }

            //calculate rightSum
            for (int j=i; j < myArray.length - 1; j++) {
                rightSum += ((int) myArray[j+1] - 64) * rightCounter;
                rightCounter++;
            }

            //execute below if word is balanced
            if (leftSum == rightSum) {

                //print letters to the left of fulcrum
                for (int l=0; l < i; l++) {
                    System.out.print(myArray[l]);
                }

                //print fulcrum letter
                System.out.print(" " + myArray[i] + " ");

                //print letters to the right of fulcrum
                for (int l=i+1; l < myArray.length; l++) {
                    System.out.print(myArray[l]);
                }

                //print weight of each side & exit loop
                System.out.print(" - " + leftSum);
                return;
            }
        }

        //print message if word is not balanceable
        System.out.println("Word is not balanceable.");

    }
}

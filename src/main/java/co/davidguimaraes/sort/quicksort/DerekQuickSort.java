package main.java.co.davidguimaraes.sort.quicksort;

import java.util.Arrays;

/**
 * Author Derek Banas
 *
 * Class that implements the Quick Sort algorithm
 */

public class DerekQuickSort {

    private int[] theArray;

    private int arraySize;


    /**
     * Main function. Previously used for testing the algorithm itself.
     * Had it implementation commented for future reference, but the main
     * goal is to make Derek's implementation general. In other words, it
     * is not meant to be used only inside this class
     */
    public static void main(String[] args) {

//        DerekQuickSort theSort = new DerekQuickSort(10);

//        theSort.generateRandomArray();

//        System.out.println(Arrays.toString(DerekQuickSort.theArray));

//        theSort.quickSort(0, 9);

//        System.out.println(Arrays.toString(DerekQuickSort.theArray));

    }

    /**
     * Constructor method for the class. Receives the desired size for
     * the sorting array, so it can be created
     *
     * @param newArraySize size of the to be created and sorted array
     */
    public DerekQuickSort(int newArraySize) {

        arraySize = newArraySize;

        theArray = new int[arraySize];

        generateRandomArray();

    }


    public void quickSort(int left, int right) {

        if (right - left <= 0)
            return; // Everything is sorted

        else {

            // It doesn't matter what the pivot is, but it must
            // be a value in the array

            int pivot = theArray[right];    //there is a version of the quickSort that tries to find middle
            //part of the array meaning the most central value, but it's
            //questionable whether it is faster or not.
            //So for simplicity's sake, let's stick with the value in the
            //most right position of the array to be the pivot

            System.out.println("Value in right " + theArray[right]
                    + " is made the pivot");

            System.out.println("left = " + left + " right= " + right
                    + " pivot= " + pivot + " sent to be partitioned");

            int pivotLocation = partitionArray(left, right, pivot); //partition stops when the left and
            //right pointer find each other. So,
            //it returns the position where both
            //pointers met each other.
            //This is going to be made the new pivot

            System.out.println("Value in left " + theArray[left]
                    + " is made the pivot");

            quickSort(left, pivotLocation - 1); // Sorts the left side
            //breaks the vector in 2 parts. The first half is gonna be
            //from 0 up to new pivot location, which is where left and
            //right met each other

            quickSort(pivotLocation + 1, right);    //After everything is sorted on the left, does the exact
            //same thing for the second (upper) half of the array

        }

    }

    /**
     * Implementation of the Partition itself, based on the DerekPartitioning class
     *
     * @param left left pointer index
     * @param right right pointer index
     * @param pivot reference number for the partition algorithm
     */
    private int partitionArray(int left, int right, int pivot) {

        int leftPointer = left - 1;

        int rightPointer = right;

        while (true) {

            while (theArray[++leftPointer] < pivot)
                ;

            printHorzArray(leftPointer, rightPointer);

            System.out.println(theArray[leftPointer] + " in index "
                    + leftPointer + " is bigger than the pivot value " + pivot);

            while (rightPointer > 0 && theArray[--rightPointer] > pivot)
                ;

            printHorzArray(leftPointer, rightPointer);

            System.out.println(theArray[rightPointer] + " in index "
                    + rightPointer + " is smaller than the pivot value "
                    + pivot);

            printHorzArray(leftPointer, rightPointer);

            if (leftPointer >= rightPointer) {

                System.out.println("left is >= right so start again");

                break;

            }

            else {

                swapValues(leftPointer, rightPointer);

                System.out.println(theArray[leftPointer] + " was swapped for "
                        + theArray[rightPointer]);

            }

        }

        swapValues(leftPointer, right);

        return leftPointer;

    }

    /**
     * Algorithm that swaps values if one is greater than the other,
     * according to the partitioning algorithm itself
     *
     * @param indexOne one of the indexes that references the values to be swapped
     * @param indexTwo one of the indexes that references the values to be swapped
     */
    private void swapValues(int indexOne, int indexTwo) {

        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;

    }

    /**
     * Algorithm that generates a random array in order to test the
     * partitioning algorithm itself. May be used or not
     */
    private void generateRandomArray() {

        for (int i = 0; i < arraySize; i++) {

            // Generate a random array with values between
            // 10 and 59

            theArray[i] = (int) (Math.random() * 50) + 10;

        }

    }

    /**
     * Algorithm that prints out the sorting array in a pretty way
     *
     * @param i
     * @param j
     */
    private void printHorzArray(int i, int j) {

        for (int n = 0; n < 61; n++)
            System.out.print("-");

        System.out.println();

        for (int n = 0; n < arraySize; n++) {

            System.out.format("| %2s " + " ", n);

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++)
            System.out.print("-");

        System.out.println();

        for (int n = 0; n < arraySize; n++) {

            System.out.print(String.format("| %2s " + " ", theArray[n]));

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++)
            System.out.print("-");

        System.out.println();

        if (i != -1) {

            // Number of spaces to put before the F

            int spacesBeforeFront = 6 * (i + 1) - 5;

            for (int k = 0; k < spacesBeforeFront; k++)
                System.out.print(" ");

            System.out.print("L" + i);

            // Number of spaces to put before the R

            int spacesBeforeRear = 5 * (j + 1) - spacesBeforeFront;

            for (int l = 0; l < spacesBeforeRear; l++)
                System.out.print(" ");

            System.out.print("R" + j);

            System.out.println("\n");

        }

    }

}


package main.java.co.davidguimaraes.sort.quicksort;

import java.util.Arrays;

/**
 * Author Derek Banas
 *
 * Class that implements the Partitioning of Quick Sort algorithm
 */

public class DerekPartitioning {

    private static int[] theArray;

    private static int arraySize;

    public static void main(String[] args) {

        DerekPartitioning partitionArray = new DerekPartitioning(10);

        partitionArray.generateRandomArray();

        System.out.println(Arrays.toString(DerekPartitioning.theArray));

        // Every item smaller than 35 will be on the left and
        // everything bigger will be on the right

        partitionArray.partitionArray(35);

        System.out.println(Arrays.toString(DerekPartitioning.theArray));

    }

    /**
     * Constructor method for the class. Receives the desired size for
     * the sorting array, so it can be created
     *
     * @param newArraySize size of the to be created and sorted array
     */
    public DerekPartitioning(int newArraySize) {

        arraySize = newArraySize;

        theArray = new int[arraySize];

        generateRandomArray();

    }

    /**
     * Implementation of the Partition itself. Pivot is the reference
     * number for the partitioning process to start
     *
     * @param pivot reference number for the partition algorithm
     */
    public void partitionArray(int pivot) {

        // If leftPointer finds an item that is greater
        // than pivot it stops and waits for the rightPointer
        // to find a value less than pivot. Then the items
        // are switched

        // Starts at the left side of array before index 0

        int leftPointer = -1;

        // Starts at the right side of the array after the last index

        int rightPointer = arraySize;

        while (true) {

            // Cycle through array until the end is reached
            // or an item bigger than pivot is found. Then
            // wait for rightPointer to finish cycling

            while (leftPointer < (arraySize - 1)
                    && theArray[++leftPointer] < pivot)
                ;

            printHorzArray(leftPointer, rightPointer);

            System.out.println(theArray[leftPointer] + " in index "
                    + leftPointer + " is bigger than the pivot value " + pivot);

            // Cycle through array until the beginning is reached
            // or an item smaller than pivot is found.

            while (rightPointer > 0 && theArray[--rightPointer] > pivot)
                ;

            printHorzArray(leftPointer, rightPointer);

            System.out.println(theArray[rightPointer] + " in index "
                    + rightPointer + " is smaller than the pivot value "
                    + pivot);

            printHorzArray(leftPointer, rightPointer);

            // When the 2 pointers meet at the middle break
            // out of the while loop

            if (leftPointer >= rightPointer)
                break;

            else {

                // Swap the values in the pointers

                swapValues(leftPointer, rightPointer);

                System.out.println(theArray[leftPointer] + " was swapped for "
                        + theArray[rightPointer]);

            }

        }

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

            int spacesBeforeFront = 5 * i + 1;

            for (int k = 0; k < spacesBeforeFront; k++)
                System.out.print(" ");

            System.out.print("L");

            // Number of spaces to put before the R

            int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;

            for (int l = 0; l < spacesBeforeRear; l++)
                System.out.print(" ");

            System.out.print("H");

            System.out.println("\n");

        }

    }


    public static int[] getTheArray() {
        return theArray;
    }

    public static void setTheArray(int[] theArray) {
        DerekPartitioning.theArray = theArray;
    }

    public static int getArraySize() {
        return arraySize;
    }

    public static void setArraySize(int arraySize) {
        DerekPartitioning.arraySize = arraySize;
    }
}

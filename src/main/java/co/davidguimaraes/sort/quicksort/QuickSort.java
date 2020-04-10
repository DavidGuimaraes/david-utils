package main.java.co.davidguimaraes.sort.quicksort;

/**
 * Author David Guimaraes, Computer Engineer, based on the
 * implementations of Derek Banas
 *
 * Class that implements the Quick Sort algorithm
 */

public class QuickSort {

    private int[] theArray;

    /**
     * Constructor method for the class. Receives the desired arra for sorting
     *
     * @param theArray size of the to be created and sorted array
     */
    public QuickSort(int[] theArray) {
        this.theArray = theArray;
    }

    /**
     * Implementation of the sorting itself, through the Quick algorithm
     *
     * @param left left pointer index
     * @param right right pointer index
     */
    public void sort(int left, int right) {

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

            int pivotLocation = partitionArray(left, right, pivot); //partition stops when the left and
            //right pointer find each other. So,
            //it returns the position where both
            //pointers met each other.
            //This is going to be made the new pivot

            sort(left, pivotLocation - 1); // Sorts the left side
            //breaks the vector in 2 parts. The first half is gonna be
            //from 0 up to new pivot location, which is where left and
            //right met each other

            sort(pivotLocation + 1, right);    //After everything is sorted on the left, does the exact
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

            while (theArray[++leftPointer] < pivot) ;
            while (rightPointer > 0 && theArray[--rightPointer] > pivot) ;
            if (leftPointer >= rightPointer) break;
            else swapValues(leftPointer, rightPointer);
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
}

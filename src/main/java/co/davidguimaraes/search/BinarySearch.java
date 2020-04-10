package main.java.co.davidguimaraes.search;

/**
 * Author David Guimaraes, Computer Engineer, based on the
 * implementations of HackerRank.com
 *
 * Class that implements the Binary Search algorithm
 */

public class BinarySearch {

    /**
     * Iterative implementation of the Binary Search algorithm
     *
     * @param array array in which the search is going to happen on top of
     * @param x item to be searched
     * @return boolean, according to which the value has been found or not
     */
    public boolean searchIterative(int[] array, int x){
        int left = 0;
        int right = array.length - 1;

        while(left <= right){
            int mid = left + ((right - left) / 2);  //Calculating the mid this way avoids overflow in Java
            if(array[mid] == x){
                return true;
            }else if(x < array[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }

    /**
     * Recursive implementation of the Binary Search algorithm
     *
     * @param array array in which the search is going to happen on top of
     * @param x item to be searched
     * @param left left pointer for splitting the array, in order to search for the element
     * @param right right pointer for splitting the array, in order to search for the element
     * @return boolean, according to which the value has been found or not
     */
    private boolean search(int[] array, int x, int left, int right){
        if(left > right){
            return false;
        }

        int mid = left + ((right - left) / 2);  //Calculating the mid this way avoids overflow in Java
        if(array[mid] == x){
            return true;
        }else if(x < array[mid]){
            return search(array, x, left, mid - 1);
        }else{
            return search(array, x, mid + 1, right);
        }
    }

    /**
     * Calls the recursive implementation of the Binary Search algorithm
     *
     * @param array array in which the search is going to happen on top of
     * @param x item to be searched
     * @return boolean, according to which the value has been found or not
     */
    public boolean search(int[] array, int x){
        return search(array, x, 0, array.length - 1);
    }
}

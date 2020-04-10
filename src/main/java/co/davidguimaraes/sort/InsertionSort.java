package main.java.co.davidguimaraes.sort;

/**
 * Author David Guimaraes, Computer Engineer
 *
 * Class that implements the Insertion Sort algorithm
 */

public class InsertionSort {

    /**
     * Implementation of the sorting itself, through the Insertion algorithm
     * Receives the array reference as parameter and sorts it. Thus, no
     * return is necessary
     *
     * @param v vector to be sorted
     */
    public void sort(int[] v){
        int aux = 0;
        for(int i = 1; i <= v.length - 1; i++){
            for(int j = i; j > 0; j--){
                if(v[j] < v[j-1]){
                    //swap operation
                    aux = v[j-1];
                    v[j-1] = v[j];
                    v[j] = aux;
                }
            }
        }
    }
}

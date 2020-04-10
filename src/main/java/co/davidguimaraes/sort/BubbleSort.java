package main.java.co.davidguimaraes.sort;

/**
 * Author David Guimaraes, Computer Engineer
 *
 * Class that implements the Bubble Sort algorithm
 */

public class BubbleSort {

    /**
     * Implementation of the sorting itself, through the Bubble algorithm
     * Receives the array reference as parameter and sorts it. Thus, no
     * return is necessary
     *
     * @param v vector to be sorted
     */
    public void sort(int[] v){
        int aux = 0;
        for(int i = 0; i <= v.length - 1; i++){
            for(int j = 0; j <= v.length - 2; j++){
                if(v[j] > v[j+1]){
                    //swap operation
                    aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
    }
}

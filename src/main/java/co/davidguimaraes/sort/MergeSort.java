package main.java.co.davidguimaraes.sort;

/**
 * Author David Guimaraes, Computer Engineer
 *
 * Class that implements the Merge Sort algorithm
 */

public class MergeSort {

    /**
     * Implementation of the sorting itself, through the Merge algorithm
     * Receives the array reference as parameter and sorts it. Thus, no
     * return is necessary
     *
     * @param v vector to be sorted
     * @param aux helper vector
     * @param start start index of the to-be sorted vector
     * @param end end index of the to-be sorted vector
     */
    public void sort(int[] v, int[] aux, int start, int end){
        if(start < end){
            int half = (start + end) / 2;
            sort(v, aux, start, half);
            sort(v, aux, half + 1, end);
            merge(v, aux, start, half, end);
        }
    }

    /**
     *
     * Intercalation algorithm, the one responsible for joining the small
     * pieces of the vector after the recursion has broken it down. The
     * intercalation joins the small-broken down vector sorting them at
     * the same time. This is achieved through the 4 scenarios described
     * by the 4 conditionals inside the loop
     *
     * @param v vector to be sorted
     * @param aux helper vector
     * @param start start index of the to-be sorted vector
     * @param half half index of the to-be sorted vector
     * @param end end index of the to-be sorted vector
     */
    private void merge(int[] v, int[] aux, int start, int half, int end){

        if (end + 1 - start >= 0) System.arraycopy(v, start, aux, start, end + 1 - start);

        int i = start;
        int j = half + 1;

        for(int k = start; k <= end; k++){
            if(i > half){
                v[k] = aux[j++];
            } else if(j > end){
                v[k] = aux[i++];
            } else if(aux[i] < aux[j]){
                v[k] = aux[i++];
            } else{
                v[k] = aux[j++];
            }
        }
    }
}

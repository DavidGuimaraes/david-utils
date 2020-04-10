package main.java.co.davidguimaraes.datastructures;

import java.util.Arrays;

/**
 * Author Derek Banas
 *
 * Class that implements the Queue and Priority Queue algorithms
 */

public class DerekQueue {

    private String[] queueArray;
    private int queueSize;
    private int front, numberOfItems, rear = 0; // Sets stack as empty

    /**
     * Constructor method for the class. Receives the desired size for
     * the queue array, so it can be created
     *
     * @param size size of the queue
     */
    public DerekQueue(int size) {

        queueSize = size;

        queueArray = new String[size];

        // Assigns the value of -1 to every value in the array
        // so I control what gets printed to screen

        Arrays.fill(queueArray, "-1");

    }

    /**
     * Inserts new item on the queue
     *
     * @param input value to be inserted on the queue
     */
    public void insert(String input) {

        if (numberOfItems + 1 <= queueSize) {

            queueArray[rear] = input;

            rear++;

            numberOfItems++;

            System.out.println("INSERT " + input + " Was Added to the Stack\n");

        } else {

            System.out.println("Sorry But the Queue is Full");

        }

    }

    /**
     * Inserts new item on the queue, according to its priority.
     * This algorithm is going to shift values while the input value
     * is greater than the values in the queue, so it makes sure that
     * an input is inserted according to its value, or, PRIORITY!
     *
     * This is the only difference between a priority queue and a traditional
     * queue
     *
     * @param input value to be inserted on the queue
     */
    public void priorityInsert(String input) {

        int i;

        if (numberOfItems == 0) {

            insert(input);

        } else {

            //Shifts queue to the left, so it inserts the value at the rear position if it's greater
            //than the values that are in the queue already
            for (i = numberOfItems - 1; i >= 0; i--) {

                if (Integer.parseInt(input) > Integer.parseInt(queueArray[i])) {

                    queueArray[i + 1] = queueArray[i];

                } else break; // Done shifting items in queue

            }

            queueArray[i + 1] = input;

            rear++;

            numberOfItems++;

        }

    }

    /**
     * Removes item from the queue. It does not take any parameters because
     * the only possible value to be removed is the front of the queue.
     * This algorithm does not shift all the elements in the queue after the
     * front is removed
     *
     * TODO - shift elements to the left after the front item is removed
     */
    public void remove() {

        if (numberOfItems > 0) {

            System.out.println("REMOVE " + queueArray[front] + " Was Removed From the Queue\n");

            // Just like in memory an item isn't deleted, but instead is just not available

            queueArray[front] = "-1";

            front++;

            numberOfItems--;

        } else {

            System.out.println("Sorry But the Queue is Empty");


        }
    }

    /**
     * Shows the front of the queue
     */
    public void peek() {

        System.out.println("The First Element is " + queueArray[front]);

    }

    /**
     * Derek Banas' algorithm for displaying the queue on the pretty way
     */
    private void displayTheQueue() {

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        for (int n = 0; n < queueSize; n++) {

            System.out.format("| %2s " + " ", n);

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        for (int n = 0; n < queueSize; n++) {


            if (queueArray[n].equals("-1")) System.out.print("|     ");

            else System.out.print(String.format("| %2s " + " ", queueArray[n]));

        }

        System.out.println("|");

        for (int n = 0; n < 61; n++) System.out.print("-");

        System.out.println();

        // Number of spaces to put before the F

        int spacesBeforeFront = 3 * (2 * (front + 1) - 1);

        for (int k = 1; k < spacesBeforeFront; k++) System.out.print(" ");

        System.out.print("F");

        // Number of spaces to put before the R

        int spacesBeforeRear = (2 * (3 * rear) - 1) - (spacesBeforeFront);

        for (int l = 0; l < spacesBeforeRear; l++) System.out.print(" ");

        System.out.print("R");

        System.out.println("\n");

    }

    /**
     * Main function. Previously used for testing the algorithm itself.
     * Had it implementation commented for future reference, but the main
     * goal is to make Derek's implementation general. In other words, it
     * is not meant to be used only inside this class
     */
    public static void main(String[] args) {

//        DerekQueue theQueue = new DerekQueue(10);

//        theQueue.priorityInsert("16");

//        theQueue.priorityInsert("25");

//        theQueue.priorityInsert("10");

		/*
		theQueue.insert("10");

		theQueue.displayTheQueue();

		theQueue.insert("15");

		theQueue.displayTheQueue();

		theQueue.insert("25");

		theQueue.displayTheQueue();

		theQueue.insert("25");

		theQueue.displayTheQueue();

		theQueue.insert("25");
		*/

//        theQueue.displayTheQueue();

//        theQueue.remove();

//        theQueue.displayTheQueue();

//        theQueue.remove();

//        theQueue.displayTheQueue();

//        theQueue.peek();

    }
}

package main.java.co.davidguimaraes.datastructures.stack;

import java.util.Arrays;

public class DerekStack {

    private String[] stackArray;
    private int stackSize;
    private int topOfStack = -1;    // Sets stack as empty

    /**
     * Constructor method for the class. Receives the desired size for
     * the stack array, so it can be created
     *
     * @param size size of the stack
     */
    public DerekStack(int size){

        stackSize = size;

        stackArray = new String[size];

        // Assigns the value of -1 to every value in the array
        // so I control what gets printed to screen

        Arrays.fill(stackArray, "-1");

    }

    /**
     * Inserts new item on the stack
     *
     * @param input value to be inserted on the stack
     */
    public void push(String input){

        if(topOfStack+1 < stackSize){

            topOfStack++;

            stackArray[topOfStack] = input;

        } else System.out.println("Sorry But the Stack is Full");

        displayTheStack();

        System.out.println("PUSH " + input + " Was Added to the Stack\n");

    }

    /**
     * Removes item from the stack. It does not take any parameters because
     * the only possible value to be removed is the top of the stack
     *
     * @return new top of stack
     */
    public String pop(){

        if(topOfStack >= 0){

            displayTheStack();

            System.out.println("POP " + stackArray[topOfStack] + " Was Removed From the Stack\n");

            // Just like in memory an item isn't deleted, but instead is just not available

            stackArray[topOfStack] = "-1"; // Assigns -1 so the value won't appear

            return stackArray[topOfStack--];


        } else {

            displayTheStack();

            System.out.println("Sorry But the Stack is Empty");

            return "-1";
        }


    }

    /**
     * Shows the top of the stack and returns it as well
     *
     * @return top of stack
     */
    public String peek(){

        displayTheStack();

        System.out.println("PEEK " + stackArray[topOfStack] + " Is at the Top of the Stack\n");

        return stackArray[topOfStack];

    }

    /**
     * Receives many various through a String. Each value is separated by a
     * space character. Thus, it tokenizes the String and then pushes every
     * token to the stack
     *
     * @param multipleValues values to be inserted, separated by a space character
     */
    public void pushMany(String multipleValues){

        String[] tempString = multipleValues.split(" ");

        for(int i = 0; i < tempString.length; i++){

            push(tempString[i]);

        }

    }

    /**
     * Removes all values from the stack, each per time, respecting the stack's rules.
     * It iterates the stack removing the value from the top on every and each iteration
     */
    public void popAll(){

        for(int i = topOfStack; i >= 0; i--){

            pop();

        }

    }

    /**
     * Displays the stack as it reverse and then calls the popAll() method in order to
     * remove everything from the stack
     */
    public void popDisplayAll(){

        String theReverse = "";

        for(int i = topOfStack; i >= 0; i--){

            theReverse += stackArray[i];

        }

        System.out.println("The Reverse: " + theReverse);

        popAll();

    }

    /**
     * Derek Banas' algorithm for displaying the stack on the pretty way
     */
    public void displayTheStack(){

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackSize; n++){

            System.out.format("| %2s "+ " ", n);

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackSize; n++){



            if(stackArray[n].equals("-1")) System.out.print("|     ");

            else System.out.print(String.format("| %2s "+ " ", stackArray[n]));

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

    }

    /**
     * Main function. Previously used for testing the algorithm itself.
     * Had it implementation commented for future reference, but the main
     * goal is to make Derek's implementation general. In other words, it
     * is not meant to be used only inside this class
     */
    public static void main(String[] args){

//        DerekStack theStack = new DerekStack(10);

//        theStack.push("10");
//        theStack.push("17");
//        theStack.push("13");

        // Look at the top value on the stack

//        theStack.peek();

        // Remove values from the stack (LIFO)

//        theStack.pop();
//        theStack.pop();
//        theStack.pop();

        // Add many to the stack

//        theStack.pushMany("R E D R U M");

        // Remove all from the stack

        // theStack.popAll();

        // Remove all from the stack and print them

//        theStack.popDisplayAll();

//        theStack.displayTheStack();


    }

}


package main.java.co.davidguimaraes.datastructures;

import java.util.Arrays;

public class MinHeap {

    private int capacity;
    private int size;

    private int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex){ return 2 * parentIndex + 1; }
    private int getRightChildIndex(int parentIndex){ return 2 * parentIndex + 2; }
    private int getParentIndex(int childIndex){ return (childIndex - 1) / 2; }

    private boolean hasLeftChild(int index){ return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index){ return getRightChildIndex(index) < size; }
    private boolean hasParent(int index){ return getParentIndex(index) >= 0; }

    private int leftChild(int index){ return items[getLeftChildIndex(index)]; }
    private int rightChild(int index){ return items[getRightChildIndex(index)]; }
    private int parent(int index){ return items[getParentIndex(index)]; }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek(){
        if(size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll(){  //It extracts the minimum element and removes it from the array/heap
        if(size == 0) throw new IllegalStateException();
        int item = items[0];        //Gets the minimum value, which is always the root element
        items[0] = items[size - 1]; //Gets the last element and moves it to the root
        size--;                     //Shrinks the size of the array
        heapifyDown();
        return item;
    }

    public void add(int item){
        ensureExtraCapacity();
        items[size] = item;     //New element is inserted on a position that's free
        size++;
        heapifyUp();
    }

    private void heapifyUp(){
        int index = size - 1;                                       //Starts with the last item inserted
        while(hasParent(index) && parent(index) > items[index]){    //As long as I have a parent, and as long as my parent is greater than me
            swap(getParentIndex(index), index);                     //Swap my value with my parent's value
            index = getParentIndex(index);                          //Walk upwards
        }
    }

    private void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){     //We only need to check if there's a left child because if there's not left child, certainly there's no right child
            int smallerChildIndex = getLeftChildIndex(index);                   //Assigns the left child as the smaller child just for starters
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){   //Checks if the right child is smaller than the left child
                smallerChildIndex = getRightChildIndex(index);                  //If true, smaller value gets updated with the right child instead of the left one
            }
            //If not, smaller value continues to be the left child's value

            if(items[index] < items[smallerChildIndex]){                        //If I'm smaller than the smallest of my 2 children, then we're good. Break the loop
                break;
            }else {                                                             //However, if not, I need to swap my value with the smallest of my 2 children
                swap(index, smallerChildIndex);
                index = smallerChildIndex;                                      //Walk down to my new position, which is going to be my smallest child position/index
            }
        }
    }
}

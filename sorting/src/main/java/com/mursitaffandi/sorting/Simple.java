package com.mursitaffandi.sorting;

public class Simple {
    public void sort(int input[]) {
        int n = input.length;
        int counter = 0;
        for (int i = 0; i < n-1; i++) {
            int swapIndex = 0;
            while (swapIndex < n-i-1) {
                if (input[swapIndex] > input[swapIndex+1]) {
                    int temp = input[swapIndex];
                    input[swapIndex] = input[swapIndex+1];
                    input[swapIndex+1] = temp;
                    counter++;
                    System.out.print(counter + ". [" + input[swapIndex] + "," + input[swapIndex+1] + "] -> ");
                    for (int child = 0; child < input.length; child++) {
                        System.out.print(input[child]+" ");
                    }
                    System.out.print("\n");
                    swapIndex = 0;
                } else {
                    swapIndex++;
                }
            }
        }
        System.out.println("\nJumlah swap: "+counter);
    }

    public static void main(String[] args) {

        Simple simple = new Simple();
        int arr[] = {4, 9, 7, 5, 8, 9, 3};
        simple.sort(arr);

    }
}

/*
This program implements the Bubble Sort algorithm to sort an array of integers in ascending order.
The list is given by the input.txt file which gets read. sorted, then written to the output.txt file.

@author KincaidBD
@version 1.0
@since 2026-11-23
*/

// import classes for file input and output
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BubbleSort {

    public static void main(String[] args) {
        // try catch block to handle IOException (if it cant be read or written to the files)
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/vscode/ICS4UC/Unit3/Unit3-01/Unit-3-01-BubbleSort/input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/vscode/ICS4UC/Unit3/Unit3-01/Unit-3-01-BubbleSort/output.txt"))) {
            
            // read each line from the input file and process it
            String line;
            while ((line = reader.readLine()) != null) {
                // split the line into individual numbers based on whitespace
                String[] numbers = line.split("\\s+");
                // create an array to store the numbers (length equal to the number of elements in the line)
                int[] array = new int[numbers.length];

                // convert each string to an integer and store it in the array
                for (int i = 0; i < numbers.length; i++) {
                    array[i] = Integer.parseInt(numbers[i]);
                }

                // sort the array using the bubble sort algorithm
                bubbleSort(array);
                // write the sorted array to the output file
                for (int i = 0; i < array.length; i++) {
                    if (i > 0) {
                        writer.write(" ");
                    }
                    writer.write(Integer.toString(array[i]));
                }
                writer.newLine();
            }
        // catch and print any IOException that occurs during file reading or writing
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method to sort the array using the bubble sort algorithm
    private static void bubbleSort(int[] array) {
        // iterate through the array multiple times, comparing adjacent elements and swapping them if necessary
        for (int i = 0; i < array.length - 1; i++) {
            // each pass ensures the next largest element is placed in its correct position
            for (int j = 0; j < array.length - i - 1; j++) {
                // swap the elements if the current element is greater than the next element
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
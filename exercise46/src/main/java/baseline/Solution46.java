/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Detrich Lange
 */

/*
Create a program that reads in a file named `exercise46_input.txt` and counts the frequency of words in the file. Then
construct a histogram displaying the words and the frequency, and display the histogram to the screen.
    Ensure that the most used word is at the top of the report and the least used words are at the bottom.
 */

package baseline;

public class Solution46 {

    public static void main(String[] args) {
        //Make a map

        //Open the input file as a try-with-resources
            //while there is more to read:
                //Read the next word as a string
                //If that string matches one of the map keys:
                    //Increase that key's associated value by 1
                //If that string does not match one of the map keys:
                    //Add a new entry to the map with the word as key and value as 1

        //Sort the map by value

        //For each entry in the map:
            //Print the key, then repeat * a number of times equal to the value
    }
}

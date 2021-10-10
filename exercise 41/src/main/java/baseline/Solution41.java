/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Detrich Lange
 */

/*
Create a program that reads in the following list of names from a file called `exercise41_input.txt` and sorts the list
alphabetically.
Then print the sorted list to a file called `exercise41_output.txt` that looks like the following example output.
    Don't hard-code the number of names.
 */

package baseline;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Solution41 {

   public List<String> readNames(String inputFile) throws IOException {
      List<String> namesOfEmployees = new ArrayList<>();

      // open clients.txt as a try with resources
         // while there is more to read:
            // add "firstname, lastname" to list
      //return list
   }

   private void sortNameList(List<String> namesOfEmployees){

      //go through the list of names, comparing two at a time
         //if the first name is later alphabetically than the second name, swap them
            //keep going until you reach the end, the last entry is now sorted
               //do it again stopping before the sorted part, the second to last entry is now sorted
                  //repeat until everything is sorted
   }

   public String buildOutput(List<String> namesOfEmployees) throws FileNotFoundException {
      StringBuilder outputString = new StringBuilder();

      //run sortNameList to sort the list
      //Append the header, including size of namesOfEmployees, to the output string
      //For each entry in the list, append the list to the output string
      return outputString.toString();
   }

   private void printOutputToFile(String outputString, String outputFile) throws IOException{
      //Open the output file as a try with resources.
      //Print the output string to the output file.
   }

   public static void main(String[] args) throws IOException {
      Solution41 solutionApp = new Solution41();

      //Make a list of strings of the names of each employee.
      //Sort the list and build an output string out of the sorted list.
      //Print the output string to the output file.
   }
}
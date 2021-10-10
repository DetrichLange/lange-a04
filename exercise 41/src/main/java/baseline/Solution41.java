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
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Solution41 {

   public List<String> readNames(String inputFile) throws IOException {
      List<String> namesOfEmployees = new ArrayList<>();

      //open clients.txt as a try with resources
      try(Scanner input = new Scanner(Paths.get(inputFile))){

         while (input.hasNext()) {
            //while there is more to read:
            //add "firstname, lastname" to list
            namesOfEmployees.add(input.next() + " " + input.next() + "\r");
         }
      }
      //return list
      return namesOfEmployees;
   }

   private void sortNameList(List<String> namesOfEmployees){
      try {
         //go through the list of names, comparing two at a time
         for (int i=0; i < namesOfEmployees.size(); i++) {
            for (int j = 0; j < namesOfEmployees.size() - i -1; j++) {
               //if the first name is later alphabetically than the second name, swap them
               if (namesOfEmployees.get(j).compareTo(namesOfEmployees.get(j + 1)) > 0) {
                  Collections.swap(namesOfEmployees, j, j + 1);
                  //keep going until you reach the end, the last entry is now sorted
                  //do it again stopping before the sorted part, the second to last entry is now sorted
                  //repeat until everything is sorted
               }
            }
         }
      }catch(IndexOutOfBoundsException ioob){
         System.out.print("Out of bounds");
      }
   }

   public String buildOutput(List<String> namesOfEmployees){
      StringBuilder outputString = new StringBuilder();

      //run sortNameList to sort the list
      sortNameList(namesOfEmployees);

      //Append the header, including size of namesOfEmployees, to the output string
      outputString.append("Total of ").append(namesOfEmployees.size()).append(" names\r-----------------\r");

      //For each entry in the list, append the list to the output string
      for (String name : namesOfEmployees) {
         outputString.append(name);
      }

      //return the string
      return outputString.toString();
   }

   private void printOutputToFile(String outputString) throws IOException{
      //Open the output file as a try with resources.
      //Print the output string to the output file.
      try(Formatter output = new Formatter("data/exercise41_output.txt")) {
         output.format(outputString);
      }
   }


   public static void main(String[] args) throws IOException {
      Solution41 solutionApp = new Solution41();

      List<String> namesOfEmployees = solutionApp.readNames("data/exercise41_input.txt");

      String outputString = solutionApp.buildOutput(namesOfEmployees);

      solutionApp.printOutputToFile(outputString);

      //Make a list of strings of the names of each employee.
      //Sort the list and build an output string out of the sorted list.
      //Print the output string to the output file.
   }
}
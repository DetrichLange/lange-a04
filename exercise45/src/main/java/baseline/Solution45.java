/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Detrich Lange
 */

/*
Given an input file named `exercise45_input.txt`, read the file and look for all occurrences of the word utilize.
Replace each occurrence with use. Write the modified file to a new file.
    Prompt for the name of the output file.
    Write the output to a new file.
 */

package baseline;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class Solution45 {
    static final Scanner userInput = new Scanner(System.in);

    private String promptFileName(){
        System.out.println("Please enter the name of the output file you want to create:");
        return userInput.next();
    }

    public String readFile(String filePath){
        //Make a StringBuilder fileContents
        StringBuilder fileContents = new StringBuilder();

        //Open input file and output file as a try with resources
        try(Scanner fileInput = new Scanner(Paths.get(filePath))){
            //While there is more to read:
                //Add the next line from the text file to the outputString
            while(fileInput.hasNext()){
                fileContents.append(fileInput.nextLine()).append("%n");
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        return fileContents.toString();
    }

    public String replaceOneWord(String textToReplace, String oldWord, String newWord){
        //Use regex to replaceAll the word "utilize" to "use" in the outputString
        return textToReplace.replaceAll(oldWord, newWord);
    }

    public void printOutputFile(String filePath, String fileContents){
        //Print the outputString to the output file
        try(Formatter output = new Formatter(filePath)) {
            output.format(fileContents);
            //Print confirmation that the replacement is done
            System.out.println("Replaced.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Solution45 solutionApp = new Solution45();

        //Prompt for the name of the output file
        String outputFileName = solutionApp.promptFileName();

        String fileContents = solutionApp.readFile("data/exercise45_input.txt");
        //sonarlint doesn't like the method taking a parameter that's always the same, but I think it's easier to change and test this way

        String replacedText = solutionApp.replaceOneWord(fileContents, "utilize", "use");

        solutionApp.printOutputFile("data/" + outputFileName, replacedText);
    }
}

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

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Solution46 {

    public Map<String, Integer> readFileIntoMap(){
        Map<String, Integer> frequencyMap = new HashMap<>();

        //Open the input file as a try-with-resources
        try(Scanner fileInput = new Scanner(Paths.get("data/exercise46_input.txt"))){
            //while there is more to read:

            while(fileInput.hasNext()){
                //Read the next word as a string
                String nextWord = fileInput.next();
                //Compare that string to the keys of the map
                if(frequencyMap.containsKey(nextWord)){
                    //If that string matches one of the map keys:
                    //Set the value of that key to +1
                    frequencyMap.put(nextWord, frequencyMap.get(nextWord)+1);
                }
                else{
                    //If that string does not match one of the map keys:
                    //Add a new entry to the map with the word as key and value as 1
                    frequencyMap.put(nextWord, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return frequencyMap;
    }

    public Map<String, Integer> sortMapByValue(Map<String, Integer> frequencyMap){

        //Make an entry set out of the unsorted map, make a stream out of the entry set,
        // then collect a new map using the entries sorted by reverse value order.
        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static void main(String[] args) {
        Solution46 solutionApp = new Solution46();

        //Make a map
        Map<String, Integer> frequencyMap = solutionApp.readFileIntoMap();

        Map<String, Integer> sortedMap = solutionApp.sortMapByValue(frequencyMap);

        System.out.print(sortedMap.toString());

        //For each entry in the map:
            //Print the key, then repeat * a number of times equal to the value
    }
}

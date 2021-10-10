/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Detrich Lange
 */

/*
Construct a program that reads in the following data file (you will need to create this data file yourself; name it
`exercise42_input.txt`):
Process the records and display the results formatted as a table, evenly spaced, as shown in the example output.
    Write your own code to parse the data. Don't use a CSV parser.
 */

package baseline;

public class Solution42 {

    public static void main(String[] args) {
        //open exercise42_input.txt as a try with resources

        //create a list of maps

        //while there is more to read:
            //if the character is not a comma or line break:
                //append it to the stringbuilder
            //if the character is a comma or line break:
                //add a key "first name" value stringbuilder to a map
            //repeat for last name and salary
                //add the map to the list

        //sort maps alphabetically by last name

        //print table header
        //for each map:
            //print each value padded to 10 characters
    }
}

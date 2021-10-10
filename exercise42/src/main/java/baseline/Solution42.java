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

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Solution42 {
    static final String LNAME = "last name";
    static final String FNAME = "first name";

    public List<Map<String, String>> readEmployees(String inputFile) throws IOException {
        List<Map<String, String>> listOfEmployees = new ArrayList<>();

        //open clients.txt as a try with resources
        try(Scanner input = new Scanner(Paths.get(inputFile))){
            //read until you hit a comma or line break
            input.useDelimiter(",|\\r\\n");

            //while there is more to read:
            while (input.hasNext()) {
                //make a map, put first name/last name/salary, add to list
                Map<String,String> currentEmployee = new HashMap<>();
                currentEmployee.put(LNAME, input.next());
                currentEmployee.put(FNAME, input.next());
                currentEmployee.put("salary", input.next());
                listOfEmployees.add(currentEmployee);
            }
        }
        //return list
        return listOfEmployees;
    }

    public String buildOutput(List<Map<String, String>> listOfEmployees){
        StringBuilder outputString = new StringBuilder();

        outputString.append("Last      First     Salary\n--------------------------\n");

        for(Map<String, String> employee : listOfEmployees){
            outputString.append(employee.get(LNAME));
            outputString.append(" ".repeat(10 - employee.get(LNAME).length()));
            outputString.append(employee.get(FNAME));
            outputString.append(" ".repeat(10 - employee.get(FNAME).length()));
            outputString.append(employee.get("salary"));
            outputString.append("\n");
        }

        return outputString.toString();
    }

    public static void main(String[] args) throws IOException {
        Solution42 solutionApp = new Solution42();

        List<Map<String, String>> listOfEmployees = solutionApp.readEmployees("data/exercise42_input.txt");

        String outputString = solutionApp.buildOutput(listOfEmployees);

        System.out.print(outputString);

        //print table header
        //for each map:
            //print each value padded to 10 characters
    }
}

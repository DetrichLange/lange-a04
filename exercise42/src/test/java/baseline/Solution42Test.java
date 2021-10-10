package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Solution42Test {

    @Test
    void readEmployees() {
        //this method only scans and returns, so no test
    }

    @Test
    void buildOutput() {
        //this method takes a list of maps as parameter and returns a formatted table
        Solution42 testApp = new Solution42();

        List<Map<String, String>> testList = new ArrayList<>();
        Map<String, String> testEmployee1 = new HashMap<>();
        testEmployee1.put("first name", "Bob");
        testEmployee1.put("last name", "Stevens");
        testEmployee1.put("salary", "55000");
        testList.add(testEmployee1);
        Map<String, String> testEmployee2 = new HashMap<>();
        testEmployee2.put("first name", "Robert");
        testEmployee2.put("last name", "Stephen");
        testEmployee2.put("salary", "60000");
        testList.add(testEmployee2);
        Map<String, String> testEmployee3 = new HashMap<>();
        testEmployee3.put("first name", "Zobert");
        testEmployee3.put("last name", "Stefan");
        testEmployee3.put("salary", "65000");
        testList.add(testEmployee3);

        String actual = testApp.buildOutput(testList);
        String expected = "Last      First     Salary\n--------------------------\nStevens   Bob       55000\nStephen   Robert    60000\nStefan    Zobert    65000\n";

        assertEquals(expected, actual);
    }
}
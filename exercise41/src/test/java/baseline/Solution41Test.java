package baseline;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution41Test {

    @Test
    void readNames_test(){
        //This method only scans input, so no test is needed
    }

    @Test
    void sortNameList_test(){
        //This is called as a helper method by buildOutput, so it's tested there.
    }

    @Test
    void buildOutput_test() throws FileNotFoundException {
        //This method is supposed to take an ArrayList of names and return a single table sorted alphabetically.
        Solution41 testApp = new Solution41();

        List<String> testArray = new ArrayList<>();
        testArray.add("Ling, Mai\r");
        testArray.add("Zarnecki, Sabrina\r");
        testArray.add("Jones, Chris\r");
        testArray.add("Xiong, Fong\r");

        String actual = testApp.buildOutput(testArray);
        String expected = "Total of 4 names\r-----------------\rJones, Chris\rLing, Mai\rXiong, Fong\rZarnecki, Sabrina\r";

        assertEquals(expected, actual);
    }

}
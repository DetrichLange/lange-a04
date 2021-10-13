package baseline;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution41Test {

    @Test
    void readNames_test() throws IOException {
        //This method is supposed to read a file and return a list of strings.
        Solution41 testApp = new Solution41();

        List<String> testList = testApp.readNames("data/exercise41_input.txt");
        String expected = testList.toString();
        String actual = "[Ling, Mai\r" +
                ", Johnson, Jim\r" +
                ", Zarnecki, Sabrina\r" +
                ", Jones, Chris\r" +
                ", Jones, Aaron\r" +
                ", Swift, Geoffrey\r" +
                ", Xiong, Fong\r" +
                "]";

        assertEquals(expected, actual);
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
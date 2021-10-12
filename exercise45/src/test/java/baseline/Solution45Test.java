package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution45Test {

    @Test
    void promptFileName() {
        //This method only prompts for input and scans that input, no test.
    }

    @Test
    void readFile() {
        //This method is tested in the printOutputFile test below.
    }

    @Test
    void replaceOneWord() {
        //This method should take a string of text, a string-to-replace, and a string-to-replace-with and output a
        //string with the replacing done.
        Solution45 testApp = new Solution45();

        String stringToTest = "The unanimous Declaration of the thirteen united States of America, When in the Course of " +
                "human events, it becomes necessary for one people to dissolve the political bands which have " +
                "connected them with another, and to assume among the powers of the earth, the separate and equal " +
                "station to which the Laws of Nature and of Nature's God entitle them, a decent respect to the " +
                "opinions of mankind requires that they should declare the causes which impel them to the separation.\n" +
                "\n";
        //yes this is a terrible replace method because it turns "another" into "anodar" but that's what the exercise wants
        String expected = "The unanimous Declaration of da thirteen united States of America, When in da Course of " +
                "human events, it becomes necessary for one people to dissolve da political bands which have " +
                "connected dam with anodar, and to assume among da powers of da earth, da separate and equal " +
                "station to which da Laws of Nature and of Nature's God entitle dam, a decent respect to da " +
                "opinions of mankind requires that day should declare da causes which impel dam to da separation.\n" +
                "\n";

        String actual = testApp.replaceOneWord(stringToTest, "the", "da");

        assertEquals(expected, actual);
    }

    @Test
    void printOutputFile() {
        //Testing the read file and write file methods.
        Solution45 testApp = new Solution45();

        String stringToTest = testApp.readFile("data/exercise45_input.txt");
        testApp.printOutputFile("data/testreadwrite", stringToTest);
        String expected = "One should never utilize the word \"utilize\" in writing. Use \"use\" instead.%n" +
                "For example, \"She uses an IDE to write her Java programs\" instead of \"She%n" +
                "utilizes an IDE to write her Java programs\".%n";
        String actual = testApp.readFile("data/testreadwrite");

        assertEquals(expected, actual);
    }
}
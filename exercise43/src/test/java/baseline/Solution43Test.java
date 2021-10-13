package baseline;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Solution43Test {

    @Test
    void promptString() {
        //This method only prompts input and returns it, so no test.
    }

    @Test
    void promptBoolean() {
        //This method only prompts input and returns it, so no test.
    }

    @Test
    void makeDirectory() {
        //This method attempts to make directories, testing if they exist
        Solution43 testApp = new Solution43();

        testApp.makeDirectory("data/testdirectory");
        Path testPath = Paths.get("data/testdirectory");
        assertTrue(Files.exists(testPath));
    }

    @Test
    void buildFileString() {
        Solution43 testApp = new Solution43();

        String actual = testApp.buildFileString("CorpCo", "John Clientguy");
        String expected = """
                <!DOCTYPE html>
                <html>
                  <!-- an HTML comment, for reference -->
                  <head>
                    <title>CorpCo</title>
                    <meta charset="utf-8">
                    <meta name = "author" content = "John Clientguy" />
                    <!-- this is the natural place to link stylesheets and/or Javascript though there can be reasons to do it later -->
                  </head>
                  <body>
                    <!-- everything visible in the browser goes here -->
                  </body>
                </html>""";

        assertEquals(expected, actual);
    }

    @Test
    void makeHTMLFile() throws IOException {
        //This method makes a HTML file with a given string for contents and a string for path.
        Solution43 testApp = new Solution43();

        testApp.makeHTMLFile("data/testHTML", "contents go here");
        Scanner fileInput = new Scanner(Paths.get("data/testHTML"));
        String actual = fileInput.nextLine();
        String expected = "contents go here";

        assertEquals(expected, actual);
    }
}
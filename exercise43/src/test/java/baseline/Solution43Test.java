package baseline;

import org.junit.jupiter.api.Test;

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
        //This method only writes with a given parameter, so no test.
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
    void makeHTMLFile() {
        //This method only writes with a given parameter, so no test.
    }
}
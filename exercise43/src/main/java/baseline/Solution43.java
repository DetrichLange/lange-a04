/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Detrich Lange
 */

/*
Create a program that generates a website skeleton with the following specifications:
Prompt for the name of the site.
Prompt for the author of the site.
Ask if the user wants a folder for JavaScript files.
Ask if the user wants a folder for CSS files.
Generate an index.html file that contains the name of the site inside the <title> tag and the author in a <meta> tag.
The user should then find these files and directories created in the working directory of your program.
 */

package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Solution43 {
    static final String DATA = "data/";
    static final Scanner userInput = new Scanner(System.in);

    private String promptString(String whichString){
        System.out.println(whichString);
        return userInput.nextLine();
    }

    private boolean promptBoolean(String whatQuestion){
        while(true) {
            System.out.println(whatQuestion);
            String userAnswer = userInput.next();
            if(userAnswer.equalsIgnoreCase("y")||userAnswer.equalsIgnoreCase("n")){
                return(userAnswer.equals("y"));
            }
            else{
                System.out.println(userAnswer);
                System.out.println("Enter Y or N only.");
            }
        }
    }

    private void makeDirectory(String whichDirectory){
        File newDirectory = new File(whichDirectory);

        boolean bool = newDirectory.mkdir();
        if(bool){
            //Print output statements confirming the created files
            System.out.println("Created ./" + whichDirectory);
        }else{
            System.out.println("Couldn’t create ./" + whichDirectory);
        }
    }

    public String buildFileString(String siteName, String siteAuthor){
        String newFileContents;

        newFileContents = ("""
                <!DOCTYPE html>
                <html>
                  <!-- an HTML comment, for reference -->
                  <head>
                    <title>$siteName</title>
                    <meta charset="utf-8">
                    <meta name = "author" content = "$siteAuthor" />
                    <!-- this is the natural place to link stylesheets and/or Javascript though there can be reasons to do it later -->
                  </head>
                  <body>
                    <!-- everything visible in the browser goes here -->
                  </body>
                </html>""".replace("$siteName", siteName).replace("$siteAuthor", siteAuthor));

        return newFileContents;
    }

    private void makeHTMLFile(String whichFile, String outputString){
        try(Formatter output = new Formatter(whichFile)) {
            output.format(outputString);
            //Print output statements confirming the created files
            System.out.println("Created ./" + whichFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Solution43 solutionApp = new Solution43();

        //Prompt user for name, save as string
        String siteName = solutionApp.promptString("Site name:");

        //Prompt user for author, save as string
        String siteAuthor = solutionApp.promptString("Author:");

        //Save boolean true/false if the user wants JS folder
        boolean siteJSFolder = solutionApp.promptBoolean("Do you want a folder for JavaScript?");

        //Save true/false if the user wants CSS folder
        boolean siteCSSFolder = solutionApp.promptBoolean("Do you want a folder for CSS?");

        //Create docs/(websitename) directory
        solutionApp.makeDirectory(DATA + siteName);

        //create docs/(websitename)/index.html
        String newFileContents = solutionApp.buildFileString(siteName, siteAuthor);

        //Write website skeleton into index.html
        solutionApp.makeHTMLFile(DATA + siteName + "/index.html", newFileContents);

        //If JSS/CSS required, create docs/website/(websitename)/js and/or /css directories
        if(siteJSFolder) {
            solutionApp.makeDirectory(DATA + siteName + "/js");
        }
        if(siteCSSFolder) {
            solutionApp.makeDirectory(DATA + siteName + "/css");
        }
    }
}

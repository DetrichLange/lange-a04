/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Detrich Lange
 */

/*
Create a program that takes a product name as input and retrieves the current price and quantity for that product. The
product data is in a data file in the JSON format  and looks like this (you will create this file as
`exercise44_input.json`):
Print out the product name, price, and quantity if the product is found. If no product matches the search, state that
no product was found and start over.
    The file is in the JSON format. Use a JSON parser to pull the values out of the file
    (e.g. https://github.com/google/gson (Links to an external site.)).
    If no record is found, prompt again.
 */

package baseline;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Solution44 {
    static final Scanner userInput = new Scanner (System.in);

    public String promptSearchTerm(){

    }

    public Inventory readJSON() throws IOException {

    }

    public boolean printOutput(Product searchedProduct){

    }

    public static void main(String args[]) {
        Solution44 solutionApp = new Solution44();

        //Make a reader for the json file
        //Read the json file as an Inventory object containing a list of Products, each Product has a name, price, quantity
        //Return the Inventory

        //In a loop:
            //Prompt the user for a search term.
            //Compare the search term to the name value of each Product in the Inventory.
                //If you find a matching Product name:
                    //return the Product and print its attributes.
                    //Then break the loop.
                //If you don't find a matching Product name:
                    //Print that you couldn't find the product, continue the loop.


        try {
            Inventory myInventory = solutionApp.readJSON();
            while(true) {
                String searchTerm = solutionApp.promptSearchTerm();
                Product searchedProduct = myInventory.searchProductsByName(searchTerm);

                if (solutionApp.printOutput(searchedProduct)){
                    break;
                }
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Product {
    private String name = "";
    private double price;
    private int quantity;

    public Product(int quantity, double price, String name){
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity() {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        this.price = price;
    }
}

class Inventory {
    private List<Product> products = new ArrayList<>();
    public Inventory(){}

    public void setProduct(int quantity, double price, String name) {
        this.products.add(new Product(quantity, price, name));
    }

    public Product searchProductsByName(String searchTerm){

    }
}
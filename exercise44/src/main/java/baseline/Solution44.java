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
        System.out.println("What is the product name?");
        return userInput.next();
    }

    public Inventory readJSON() throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("data/exercise44_input.json"));

        Inventory inventory = gson.fromJson(bufferedReader, Inventory.class);
        bufferedReader.close();
        return inventory;
    }

    public boolean printOutput(Product searchedProduct){
        if (searchedProduct == null) {
            System.out.println("Sorry, that product was not found in our inventory.");
            return false;
        } else {
            System.out.printf("Name: %s%nPrice: %.2f%nQuantity: %d%n", searchedProduct.getName(), searchedProduct.getPrice(), searchedProduct.getQuantity());
            return true;
        }
    }

    public static void main(String[] args) {
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
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

class Product {
    //Sonarlint says these could be final, but if this was for an actual inventory system they would probably need
    //to be changeable.
    private String name;
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

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}

class Inventory {
    private List<Product> products = new ArrayList<>();

    public void setProduct(int quantity, double price, String name) {
        this.products.add(new Product(quantity, price, name));
    }

    public Product searchProductsByName(String searchTerm){
        for(Product product: products) {
            if(product.getName().equals(searchTerm)){
                return product;
            }
        }
        return null;
    }
}
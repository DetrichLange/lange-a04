package baseline;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Solution44Test {

    @Test
    void promptSearchTerm_test() {
        //Method only prompts and scans, no test.
    }

    @Test
    void readJSON_test() throws IOException {
        //Method reads a JSON file as an object and returns it.
        Solution44 testApp = new Solution44();

        Inventory testInventory = testApp.readJSON();
        String actual = testInventory.searchProductsByName("Thing").getName();
        String expected = "Thing";

        int actual2 = testInventory.searchProductsByName("Thing").getQuantity();
        int expected2 = 5;

        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }

    @Test
    void printOutput_test(){
        //Method only prints, no test.
    }

    @Test
    void inventoryConstructor_test(){
        //Testing the constructors and get(attribute) methods for Inventory and Product classes

        Inventory testInventory = new Inventory();
        testInventory.setProduct(10, 15.00, "Redthing");
        testInventory.setProduct(12, 25.50, "Bluething");
        testInventory.setProduct(11, 35.05, "Greenthing");
        testInventory.setProduct(199, 200000.01, "Purplething");

        double actual = testInventory.searchProductsByName("Redthing").getPrice();
        double expected = 15.00;
        assertEquals(expected, actual, 0.0001);

        int actual2 = testInventory.searchProductsByName("Greenthing").getQuantity();
        int expected2 = 11;
        assertEquals(expected2, actual2);
    }
}
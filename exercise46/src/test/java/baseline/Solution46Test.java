package baseline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Solution46Test {


    @Test
    void readFileIntoMap() {
        Solution46 testApp = new Solution46();
        String actual = testApp.readFileIntoMap().toString();
        String expected = "{snake=1, mushroom=2, badger=7}";

        assertEquals(expected, actual);
    }

    @Test
    void sortMapByValue() {
        Solution46 testApp = new Solution46();

        Map<String, Integer> testSortedMap = new LinkedHashMap<>();
        testSortedMap.put("badger", 7);
        testSortedMap.put("mushroom", 2);
        testSortedMap.put("snake", 1);

        Map<String, Integer> testUnsortedMap = new LinkedHashMap<>();
        testUnsortedMap.put("mushroom", 2);
        testUnsortedMap.put("badger", 7);
        testUnsortedMap.put("snake", 1);

        String expected = testSortedMap.toString();
        String actual = testApp.sortMapByValue(testUnsortedMap).toString();
    }

    @Test
    void assembleHistogram() {
        Solution46 testApp = new Solution46();

        Map<String, Integer> testSortedMap = new LinkedHashMap<>();
        testSortedMap.put("badger", 7);
        testSortedMap.put("mushroom", 2);
        testSortedMap.put("snake", 1);

        String actual = testApp.assembleHistogram(testSortedMap);
        String expected = "badger:     *******%nmushroom:   **%nsnake:      *%n";

        assertEquals(expected, actual);
    }
}
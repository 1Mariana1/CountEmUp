package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GroceryCounterTest {

    @Test
    void testInitialValue() {
        GroceryCounter counter = new GroceryCounter();
        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }

    @Test
    void testBasicIncrement() {
        GroceryCounter counter = new GroceryCounter();

        counter.tens();
        counter.tens();
        counter.hundreths();
        assertEquals("$20.01", counter.total());
        assertEquals(0, counter.overflows());
    }

    @Test
    void testOnesIncrement() {
        GroceryCounter counter = new GroceryCounter();

        for (int i = 0; i < 35; i++) {
            counter.ones();
        }
        assertEquals("$35.00", counter.total());
    }

    @Test
    void testOverFlow() {
        GroceryCounter counter = new GroceryCounter();

        for (int i = 0; i < 10000; i++) {
            counter.ones();
        }
        assertTrue(counter.overflows() >= 1);
    }

    @Test
    void testClear() {
        GroceryCounter counter = new GroceryCounter();

        counter.tens();
        counter.clear();

        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }


}

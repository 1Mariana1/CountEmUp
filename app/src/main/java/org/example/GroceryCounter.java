package org.example;

public class GroceryCounter {

    private int counter;
    private int overflowCount;

    public GroceryCounter() {
        this.counter = 0;
        this.overflowCount = 0;
    }

    public void tens() {
        add(1000);
    }

    public void ones() {
        add(100);
    }

    public void tenths() {
        add(10);
    }

    public void hundreths() {
        add(1);
    }

    private void add(int value) {
        counter += value;

        if (counter > 9999) {
            counter = counter % 10000;
            overflowCount++;
        }
    }

    public String total() {
        return String.format("$%d.%02d", counter / 100, counter % 100);
    }

    public int overflows() {
        return overflowCount;
    }

    public void clear() {
        counter = 0;
        overflowCount = 0;
    }



}

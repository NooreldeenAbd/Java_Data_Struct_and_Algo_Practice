package com.company;

import java.util.NoSuchElementException;

public class StackUsingArrays {

    private int count;
    private int [] items = new int[1];

    public void push (int item) {
        if (count == items.length) {
            var newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }

        items[count++] = item;
    }

    public int pop () {
        if (count == 0)
            throw new IllegalStateException();

        return items[--count];
    }

    public int peek () {
        if (count == 0)
            throw new IllegalStateException();

        return items[count-1];
    }

    public boolean isEmpty () {
        return count == 0;
    }

    public void print () {
        for (int i =0; i< count; i++)
            System.out.println(items[i]);
    }

}

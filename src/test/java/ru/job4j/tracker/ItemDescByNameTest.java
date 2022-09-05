package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.model.ItemDescByName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemDescByNameTest {
    @Test
    public void sort() {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item(1, "bug"),
                new Item(100, "release"),
                new Item(58, "analyst"),
                new Item(6, "development")
        ));
        List<Item> expected = new ArrayList<>(Arrays.asList(
                items.get(1),
                items.get(3),
                items.get(0),
                items.get(2)
        ));
        Collections.sort(items, new ItemDescByName());
        assertThat(items, is(expected));
    }
}
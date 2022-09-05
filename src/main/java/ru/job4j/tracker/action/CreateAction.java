package ru.job4j.tracker.action;

import ru.job4j.tracker.io.input.Input;
import ru.job4j.tracker.io.output.Output;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

public class CreateAction implements UserAction {

    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add New Item";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        memTracker.add(item);
        out.println("Добавленная заявка: " + item);
        return true;
    }
}

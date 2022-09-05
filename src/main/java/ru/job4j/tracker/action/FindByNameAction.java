package ru.job4j.tracker.action;

import ru.job4j.tracker.io.input.Input;
import ru.job4j.tracker.io.output.Output;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

import java.util.List;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = memTracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}

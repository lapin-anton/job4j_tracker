package ru.job4j.tracker.action;

import ru.job4j.tracker.io.input.Input;
import ru.job4j.tracker.io.output.Output;
import ru.job4j.tracker.store.Store;

public class ExitAction implements UserAction {

    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        out.println("=== Exit Program ===");
        return false;
    }
}

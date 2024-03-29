package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.io.input.ConsoleInput;
import ru.job4j.tracker.io.input.Input;
import ru.job4j.tracker.io.input.ValidateInput;
import ru.job4j.tracker.io.output.ConsoleOutput;
import ru.job4j.tracker.io.output.Output;
import ru.job4j.tracker.store.HbmTracker;
import ru.job4j.tracker.store.SqlTracker;
import ru.job4j.tracker.store.Store;

import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store memTracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            run = actions.get(select).execute(input, memTracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Store tracker = new SqlTracker();
        List<UserAction> actions = List.of(
            new CreateAction(output),
            new ShowAllAction(output),
            new EditAction(output),
            new DeleteAction(output),
            new FindByIdAction(output),
            new FindByNameAction(output),
            new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
    }
}

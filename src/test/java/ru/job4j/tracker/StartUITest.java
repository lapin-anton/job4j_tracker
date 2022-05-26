package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenEditItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = List.of(
                new EditAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindAllItemsTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = List.of(
                new ShowAllAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindItemsByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        String name = one.getName();
        Input in = new StubInput(
                new String[] {"0", name, "1"}
        );
        List<UserAction> actions = List.of(
                new FindByNameAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindItemByIdTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        String id = String.valueOf(one.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        List<UserAction> actions = List.of(
                new FindByIdAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"6", "0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. Exit Program" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu:" + ln
                                + "0. Exit Program" + ln
                                + "=== Exit Program ===" + ln
                )
        );
    }
}
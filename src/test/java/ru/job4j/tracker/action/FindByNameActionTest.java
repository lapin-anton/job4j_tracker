package ru.job4j.tracker.action;

import org.junit.Test;
import ru.job4j.tracker.io.input.Input;
import ru.job4j.tracker.io.output.Output;
import ru.job4j.tracker.io.output.StubOutput;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        String itemName = "Item for searching by name";
        tracker.add(new Item(itemName));
        FindByNameAction action = new FindByNameAction(out);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(itemName);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + tracker.findAll().get(0) + ln));
    }

    @Test
    public void executeInvalid() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        String itemName = "Item for searching by name";
        tracker.add(new Item(itemName));
        FindByNameAction action = new FindByNameAction(out);

        String wrongName = "abracadabra";
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("abracadabra");

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + "Заявки с именем: " + wrongName + " не найдены." + ln));
    }

}
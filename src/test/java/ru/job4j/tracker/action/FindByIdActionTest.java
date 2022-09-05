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

public class FindByIdActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        String itemName = "Item for searching by id";
        tracker.add(new Item(itemName));
        FindByIdAction action = new FindByIdAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + tracker.findAll().get(0) + ln));
    }

    @Test
    public void executeInvalid() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        FindByIdAction action = new FindByIdAction(out);

        Input input = mock(Input.class);
        int id = 1;
        when(input.askInt(any(String.class))).thenReturn(id);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + "Заявка с введенным id: " + id + " не найдена." + ln));
    }

}
package ru.job4j.tracker.action;

import org.junit.Test;
import ru.job4j.tracker.io.input.Input;
import ru.job4j.tracker.io.output.Output;
import ru.job4j.tracker.io.output.StubOutput;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DeleteActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item for deleting"));
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Заявка удалена успешно." + ln));
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void executeInvalid() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Ошибка удаления заявки." + ln));
    }

}
package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JobDescByPriorityTest {
    @Test
    public void sort() {
        List<Job> jobs = Arrays.asList(
                new Job("Release", 1),
                new Job("Fix bug", 4),
                new Job("Analyst", 2),
                new Job("X task", 0)
        );
        List<Job> expected = Arrays.asList(
                jobs.get(1),
                jobs.get(2),
                jobs.get(0),
                jobs.get(3)
        );
        Collections.sort(jobs, new JobDescByPriority());
        assertThat(jobs, is(expected));
    }
}
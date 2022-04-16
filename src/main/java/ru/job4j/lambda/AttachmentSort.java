package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator comparator =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator attachmentComp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment attachment1 = (Attachment) o1;
                Attachment attachment2 = (Attachment) o2;
                return attachment1.getName().compareTo(attachment2.getName());
            }
        };
        attachments.sort(attachmentComp);
        System.out.println(attachments);
    }
}

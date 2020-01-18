package com.cachacajambu.util;

import com.cachacajambu.entity.Users;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.Comparator;

public class LazySorter implements Comparator<Users> {

    private String sortField;

    private SortOrder sortOrder;

    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public int compare(Users livro1, Users livro2) {
        try {
            Field field = Users.class.getDeclaredField(this.sortField);
            field.setAccessible(true);
            Object value1 = field.get(livro1);
            Object value2 = field.get(livro2);
            field.setAccessible(false);
            int value = ((Comparable) value1).compareTo(value2);

            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
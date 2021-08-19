package Lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

public class PhoneBook {
    private static final Map<String, List<String>> phoneBook = new HashMap<>();

    public static void add(String name, String... phonesToAdd) {
        if (phoneBook.get(name) != null) {
            List<String> phones = new ArrayList<>(phoneBook.get(name));
            phones.addAll(Arrays.asList(phonesToAdd));
            phoneBook.put(name, phones);
        } else {
            phoneBook.put(name, Arrays.asList(phonesToAdd));
        }
    }

    public static void get(String name) {
        System.out.printf("%s: %s\n", name, phoneBook.get(name));
    }



}

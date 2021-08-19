package Lesson4;

import java.util.*;

public class Lesson4 {
    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<>(Arrays.asList("One", "Two", "Tree", "Six", "Tree", "House", "Four",
                "Five", "Six", "Ten", "Seven", "Eight", "Two", "Nine", "Ten"));
        noDuplicates(wordsList);
        duplicates(wordsList);
        anotherPhoneBook();


    }

    public static void noDuplicates(List<String> input) {
        Set<String> inputSet = new HashSet<>(input);
        System.out.println(inputSet);
    }

    public static void duplicates(List<String> input) {
        Set<String> inputSet = new HashSet<>(input);
        for (String word : inputSet) {
            int count = 0;
            for (String inner : input) {
                if (word.equals(inner)) {
                    count++;
                }
            }
            System.out.printf("%s: %d\n", word, count);
        }


    }

    private static void anotherPhoneBook() {
        PhoneBook.add("Anton", "12312412341");
        PhoneBook.add("Jack", "12312412341");
        PhoneBook.add("John", "456888825");
        PhoneBook.add("Leslie", "1231241");
        PhoneBook.add("Nick", "12312456666");
        PhoneBook.add("Tom", "12312412354");
        PhoneBook.add("Ben", "12312412374");

        PhoneBook.get("Anton");
        PhoneBook.get("Jack");
        PhoneBook.get("Nick");
        PhoneBook.get("Tom");
        PhoneBook.get("Den");
        PhoneBook.get("Max");
        PhoneBook.get("Karen");
        PhoneBook.get("Lee");
        PhoneBook.get("Anton");
        PhoneBook.get("Jack");
        PhoneBook.get("John");
        PhoneBook.get("Leslie");
        PhoneBook.get("Nick");
        PhoneBook.get("Tom");
        PhoneBook.get("Ben");


    }

}



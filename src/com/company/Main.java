package com.company;

import com.company.checker.PalindromeChecker;
import com.company.finder.Finder;
import com.company.finder.RegularFinder;
import com.company.finder.SpecialFinder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String text = "";
        Path path = Paths.get("src\\com\\company\\textFiles\\book.txt");
        try {
            text = Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MySubstring mySubstring = new MySubstring(text);
        Finder finder;

        finder = new SpecialFinder(new PalindromeChecker(text.length()));
        List<String> palindromes = mySubstring.findSubstring(finder);
        System.out.println("palindromes: " + palindromes);

        finder = new RegularFinder("\\+\\d{3}(\\(\\d\\d\\))\\d((\\d\\d-){2})\\d\\d");
        List<String> phoneNumbers = mySubstring.findSubstring(finder);
        System.out.println("phone numbers: " + phoneNumbers);

        finder = new RegularFinder("(\\w+)@(\\w+)\\.\\w{2,3}");
        List<String> mails = mySubstring.findSubstring(finder);
        System.out.println("mails: " + mails);
    }
}

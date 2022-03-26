package com.company.checker;

public class PalindromeChecker implements Checker {

    @Override
    public boolean check(String substring) {
        for (int i = 0; i < substring.length() / 2; i++) {
            if (substring.charAt(i) != substring.charAt(substring.length() - i - 1))
                return false;
        }
        return true;
    }
}

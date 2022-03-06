package com.company.checker;

public class PalindromeChecker implements Checker {

    private int maxLength;

    public PalindromeChecker(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public boolean check(String substring) {
        return substring.equals(new StringBuilder(substring).reverse().toString());
    }

    @Override
    public int getMaxLen() {
        return maxLength;
    }

    @Override
    public void nextMaxLength() {
        this.maxLength--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PalindromeChecker that = (PalindromeChecker) o;

        return maxLength == that.maxLength;
    }

    @Override
    public int hashCode() {
        return maxLength;
    }
}

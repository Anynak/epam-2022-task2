package com.company.finder;

import com.company.MySubstring;
import com.company.checker.Checker;

import java.util.ArrayList;
import java.util.List;

public class SpecialFinder implements Finder {
    private final Checker checker;
    private int maxLength;

    public SpecialFinder(Checker checker, int maxLength) {
        this.checker = checker;
        this.maxLength = maxLength;
    }

    @Override
    public List<MySubstring> find(String text) {
        long start = System.currentTimeMillis();
        List<MySubstring> result = new ArrayList<>();
        if (this.maxLength < 1) {
            return new ArrayList<>();
        }

        if (text.length() < this.maxLength) {
            this.maxLength = text.length();
        }
        StringBuilder textSB = new StringBuilder(text);
        String substring;
        for (int i = this.maxLength; i > 2; i--) {
            for (int j = 0; j < textSB.length() - i; j++) {
                substring = textSB.substring(j, j + i);
                if (this.checker.check(substring)) {
                    result.add(new MySubstring(substring));
                }
            }
            if (result.size() != 0) {
                break;
            }
        }

        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialFinder that = (SpecialFinder) o;

        return checker.equals(that.checker);
    }

    @Override
    public int hashCode() {
        return checker.hashCode();
    }
}

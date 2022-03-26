package com.company.finder;

import com.company.MySubstring;
import com.company.checker.Checker;

import java.util.ArrayList;
import java.util.List;

public class SpecialFinder implements Finder {
    private final Checker checker;
    private Integer maxLength;

    public SpecialFinder(Checker checker, Integer maxLength) {
        this.checker = checker;
        this.maxLength = maxLength;
    }

    public SpecialFinder(Checker checker) {
        this(checker, null);
    }

    @Override
    public List<MySubstring> find(String text) {
        long start = System.currentTimeMillis();
        List<MySubstring> result = new ArrayList<>();
        if (this.maxLength == null || this.maxLength > text.length()) {
            this.maxLength = text.length();
        } else if (this.maxLength < 0) {
            return new ArrayList<>();
        }

        StringBuilder textSB = new StringBuilder(text);
        String substring;
        for (int i = this.maxLength; i > 0; i--) {
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

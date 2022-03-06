package com.company.finder;

import com.company.checker.Checker;

import java.util.ArrayList;
import java.util.List;

public class SpecialFinder implements Finder {
    private final Checker checker;

    public SpecialFinder(Checker checker) {
        this.checker = checker;
    }

    public List<String> find(String text) {
        List<String> result = new ArrayList<>();
        if (this.checker.getMaxLen() < 1) {
            return new ArrayList<>();
        }
        StringBuilder textSB = new StringBuilder(text);
        String substring;
        for (int i = 0; i < textSB.length() - this.checker.getMaxLen(); i++) {
            substring = textSB.substring(i, i + this.checker.getMaxLen());
            if (checker.check(substring)) {
                result.add(substring);
            }
        }
        if (result.size() == 0) {
            this.checker.nextMaxLength();
            result = find(text);
        }
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

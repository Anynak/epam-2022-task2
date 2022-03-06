package com.company.finder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularFinder implements Finder {
    String RegEx;

    public RegularFinder(String RegEx) {
        this.RegEx = RegEx;
    }

    @Override
    public List<String> find(String string) {
        ArrayList<String> result = new ArrayList<>();
        Pattern pt = Pattern.compile(this.RegEx);
        Matcher matcher = pt.matcher(string);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegularFinder that = (RegularFinder) o;

        return RegEx.equals(that.RegEx);
    }

    @Override
    public int hashCode() {
        return RegEx.hashCode();
    }
}

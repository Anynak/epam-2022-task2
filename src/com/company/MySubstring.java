package com.company;

import com.company.finder.Finder;

import java.util.List;

public class MySubstring {
    private final String string;

    public MySubstring(String string) {
        this.string = toReduceSpacesAndTabs(string);
    }

    private String toReduceSpacesAndTabs(String string) {
        return string.replaceAll("\\s{2,}", " ");
    }

    public List<MySubstring> findSubstrings(Finder finder) {
        return finder.find(this.string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MySubstring that = (MySubstring) o;

        return string.equals(that.string);
    }

    @Override
    public int hashCode() {
        return string.hashCode();
    }

    @Override
    public String toString() {
        return string;
    }
}

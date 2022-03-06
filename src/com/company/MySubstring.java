package com.company;

import com.company.finder.Finder;

import java.util.List;

public class MySubstring {
    private final String string;

    public MySubstring(String string) {
        string = string.replaceAll("\\s{2,}", " ");
        this.string = string;
    }

    public List<String> findSubstring(Finder finder) {
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
        return "com.company.com.company.MySubstring{" +
                "string='" + string + '\'' +
                '}';
    }
}

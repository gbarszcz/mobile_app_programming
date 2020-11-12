package com.example.pam_gr1;

public class StringHelper {

    public long countChar(String string, char c) {
        return string.chars().filter(ch -> ch == c).count();
    }
}

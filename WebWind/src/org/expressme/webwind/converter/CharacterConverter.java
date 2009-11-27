package org.expressme.webwind.converter;

public class CharacterConverter implements Converter<Character> {

    public Character convert(String s) {
        if (s.length()==0)
            throw new IllegalArgumentException("Cannot convert empty string to char.");
        return s.charAt(0);
    }

}

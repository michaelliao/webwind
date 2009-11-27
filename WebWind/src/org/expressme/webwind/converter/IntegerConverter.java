package org.expressme.webwind.converter;

public class IntegerConverter implements Converter<Integer> {

    public Integer convert(String s) {
        return Integer.parseInt(s);
    }

}

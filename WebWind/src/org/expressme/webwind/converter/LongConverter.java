package org.expressme.webwind.converter;

public class LongConverter implements Converter<Long> {

    public Long convert(String s) {
        return Long.parseLong(s);
    }

}

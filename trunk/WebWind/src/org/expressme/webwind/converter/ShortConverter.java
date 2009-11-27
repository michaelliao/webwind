package org.expressme.webwind.converter;

public class ShortConverter implements Converter<Short> {

    public Short convert(String s) {
        return Short.parseShort(s);
    }

}

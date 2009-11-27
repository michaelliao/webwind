package org.expressme.webwind.converter;

public class FloatConverter implements Converter<Float> {

    public Float convert(String s) {
        return Float.parseFloat(s);
    }

}

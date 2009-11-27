package org.expressme.webwind.converter;

public class DoubleConverter implements Converter<Double> {

    public Double convert(String s) {
        return Double.parseDouble(s);
    }

}

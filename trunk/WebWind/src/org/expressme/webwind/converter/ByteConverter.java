package org.expressme.webwind.converter;

public class ByteConverter implements Converter<Byte> {

    public Byte convert(String s) {
        return Byte.parseByte(s);
    }

}

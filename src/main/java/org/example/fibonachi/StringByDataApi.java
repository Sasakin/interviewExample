package org.example.fibonachi;

import java.util.Iterator;

public class StringByDataApi {

    public <T> String getStringByData(Iterable<T> values, String separator) {
        StringBuilder stringDataSb = new StringBuilder();

        Iterator<T> iterator = values.iterator();

        stringDataSb.append(String.valueOf(iterator.next()));

        do {
            stringDataSb.append(separator);
            stringDataSb.append(String.valueOf(iterator.next()));
        } while(iterator.hasNext());


        return stringDataSb.toString();
    }
}

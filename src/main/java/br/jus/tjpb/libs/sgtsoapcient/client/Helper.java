package br.jus.tjpb.libs.sgtsoapcient.client;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

public class Helper {

    private Helper() {
        throw new UnsupportedOperationException();
    }

    public static <T, E> T getKeyByValue(java.util.Map<T, E> map, E value) {
        return map.entrySet().stream()
                .filter(value::equals)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public static SimpleDateFormat getDateFormat() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        format.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return format;
    }

}

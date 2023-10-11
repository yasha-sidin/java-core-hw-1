package ru.gb.sidin;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

/**
 * Class which help to decorate string data
 */
public class Decorator {
    /**
     * Decorating data with current date in the beginning
     *
     * @param data data which will be decorated
     * @return decorated string
     */
    public static String decorateWithDate(String data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return String.format("%s -> %s", formatter.format(new Date()), data);
    }
}

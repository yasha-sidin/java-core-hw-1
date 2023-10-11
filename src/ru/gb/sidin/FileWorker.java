package ru.gb.sidin;

import java.io.FileWriter;

/**
 * Class which help to work with the file
 */
public class FileWorker {
    /**
     * Appending data to file
     * @param fileName name of the file where data will be appended
     * @param data data which will be appended to file
     */
    public static boolean appendToFile(String fileName, String data) {
        try(FileWriter fw = new FileWriter(fileName, true)) {
            fw.append(data).append('\n');
            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }
}

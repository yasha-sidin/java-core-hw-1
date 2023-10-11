package ru.gb.sidin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;

public class App implements AppRealization {
    /**
     * Name of working file
     */
    private final String fileName;
    /**
     * Text of prompt
     */
    private String promptText = "Input note(To stop write 'EXIT'): ";

    /**
     * App constructor
     * 
     * @param fileName name of working file
     */
    public App(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Prompt data from user
     * @param promptText request tracking text
     * @param fileName name of file which will be used to writing data
     */
    private void prompt(String promptText, String fileName) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(promptText);
            String data = bf.readLine();
            if (data.equalsIgnoreCase("EXIT")) System.exit(0);
            if (FileWorker.appendToFile(fileName, Decorator.decorateWithDate(data))) {
                System.out.println("Re-writing to a file: " + data);
            }
            prompt(promptText, fileName);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            prompt(promptText, fileName);
        }
    }

    /**
     * Change default realization of prompt text
     * @param promptText new prompt's text
     */
    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }

    @Override
    public void start() {
        prompt(this.promptText, this.fileName);
    }
}

package Lesoon5;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class AppData implements Serializable {
    private final String[] headers;
    private int[][] data;

    public AppData(String[] headers, int[][] data) {
        this.headers = headers;
        this.data = data;
    }

    public AppData(String appData) {
        String[] tokens = appData.split("[\\r\\n]+");
        this.headers = tokens[0].split(";");
        int[][] data = new int[headers.length - 1][headers.length];
        for (int i = 1; i < tokens.length; i++) {
            String[] values = tokens[i].split(";");
            for (int j = 0; j < values.length; j++) {
                data[i - 1][j] = Integer.parseInt(values[j]);
            }
            this.data = data;
        }
    }

    public void writeToFile(String path) {
        File file = new File(path);
        writeToFile(file);
    }

    public void writeToFile(File file) {
        try (OutputStreamWriter outputStream = new OutputStreamWriter(
                new FileOutputStream(file), StandardCharsets.UTF_8)) {
            outputStream.write(this.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String headersToString() {
        StringBuilder result = new StringBuilder();
        for (String header : headers) {
            result.append(header).append(";");
        }
        return result.append("\n").toString().replaceFirst(";$", "");
    }

    private String dataToString() {
        StringBuilder result = new StringBuilder();
        for (int[] values : data) {
            StringBuilder resultBuilder = new StringBuilder();
            for (int value : values) {
                resultBuilder.append(value).append(";");
            }
            resultBuilder.append("\n");
            result.append(resultBuilder.toString().replaceFirst(";$", ""));
        }
        return result.append("\n").toString();
    }

    public String toString() {
        return headersToString() + dataToString();
    }

    public static AppData readFromFile(String path) {
        File file = new File(path);
        return readFromFile(file);
    }

    public static AppData readFromFile(File file) {
        StringBuilder result = new StringBuilder();
        try (InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            int count;
            while ((count = inputStream.read()) != -1) {
                result.append((char) count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AppData(result.toString());
    }
}


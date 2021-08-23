package Lesoon5;

import java.io.FileOutputStream;
import java.io.IOException;

public class Lesson5 {

    public static final String  PATH = "src/main/java/Lesoon5/File.csv";
    public static final String OTHER_PATH = "src/main/java/Lesoon5/other_File.csv";

    public static void main(String[] args) {

        String[] headers = {"Value 1", "Value 2", "Value 3"};
        int[][] data = {
                {100, 200, 123},
                {300, 400, 500}
        };
        AppData appData = new AppData(headers, data);
        appData.writeToFile(PATH);
        AppData recivedAppData = AppData.readFromFile(PATH);


    }

}

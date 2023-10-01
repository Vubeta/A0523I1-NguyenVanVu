package ss16_io_text_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    //write file
    public static void writeToCSV(String filePath, List<String> stringList, boolean append) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(filePath,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //read file
    public static List<String> readCSVFile(String filePath) {
        List<String> stringList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line=bufferedReader.readLine())!=null) {
                stringList.add(line);
            }
            bufferedReader.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}

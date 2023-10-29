package repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    //read file
    public List<String> readFile(String filePath){
        List<String> stringList = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                stringList.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringList;
    }
    //write file
    public void writeFile(String filePath, List<String> stringList, boolean append){
        try{
            FileWriter fileWriter = new FileWriter(filePath,append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String s : stringList) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
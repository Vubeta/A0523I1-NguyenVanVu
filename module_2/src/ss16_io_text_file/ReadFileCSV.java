package ss16_io_text_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileCSV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file .csv path which you want to read it: ");
        String filePath = scanner.nextLine();

        File isFilePath = new File(filePath);
        if (!isFilePath.exists()) {
            System.out.println("File path is not exist");
            return;
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = "";
            while((line=bufferedReader.readLine())!=null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

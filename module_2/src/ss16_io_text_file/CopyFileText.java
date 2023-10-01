package ss16_io_text_file;

import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the source file which you want to copy it: ");
        String sourcePath = scanner.nextLine();
        System.out.println("Enter the target file which you want to paste it: ");
        String targetPath = scanner.nextLine();

        //Do check source file is exist or not?
        File sourceReader = new File(sourcePath);
        if (!sourceReader.exists()) {
            System.out.println("Source file is not exist");
            return;
        }

        //Do check target file is exist or not?
        File targetWriter = new File(targetPath);
        if (targetWriter.exists()) {
            System.out.println("The target file is exist, you want to overwrite? Y/N");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                System.out.println("Copy file is canceled.");
                return;
            }
        }

        //Copy file
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceReader));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetWriter));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();
            System.out.println("File copied successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

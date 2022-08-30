package activities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Activity14 {
    public static void main(String[] args) throws IOException {

        File file = new File("Activity14.txt");
        boolean fStatus = file.createNewFile();
        if (fStatus) {
            System.out.println("File successfully created");
        }
        else {
            System.out.println("File not created");
        }
        File fileUtil = FileUtils.getFile("Activity14.txt");
        System.out.println(FileUtils.readFileToString(fileUtil,"UFT8"));

        File directory = new File("Demos");
        FileUtils.copyFileToDirectory(file,directory);

        File newfile = FileUtils.getFile(directory,"Activity14.txt");
        String newFileData = FileUtils.readFileToString(newfile,"UFT8");
        System.out.println(newFileData);
    }
}
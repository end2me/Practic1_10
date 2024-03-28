package com.mycompany.practicaltask1_10;

import static com.mycompany.practicaltask1_10.FileSearch.searchFiles;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите директорию: ");
        String directoryPath = scanner.nextLine();

        System.out.print("Введите расширение файла(например: .txt, .docx): ");
        String extension = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Неправильная директория.");
            return;
        }

        List<File> fileList = new ArrayList<>();
        searchFiles(directory, extension, fileList);

        if (fileList.isEmpty()) {
            System.out.println("Нет файлов с таким расширением.");
            return;
        }

        for (File file : fileList) {
            System.out.println(file.getAbsolutePath() + " " + file.length() + " bytes");
        }
    }
}

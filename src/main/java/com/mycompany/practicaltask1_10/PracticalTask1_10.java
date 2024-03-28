package com.mycompany.practicaltask1_10;

import java.io.File;

import java.util.Collections;
import java.util.List;


class FileSearch {
    

    public static void searchFiles(File directory, String extension, List<File> fileList) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFiles(file, extension, fileList);
                } else if (file.getName().toLowerCase().endsWith(extension.toLowerCase())) {
                    fileList.add(file);
                }
            }
        }

        Collections.sort(fileList, (file1, file2) -> {
            if (file1.isDirectory() && !file2.isDirectory()) {
                return -1;
            } else if (!file1.isDirectory() && file2.isDirectory()) {
                return 1;
            } else {
                return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
            }
        });
    }
}
